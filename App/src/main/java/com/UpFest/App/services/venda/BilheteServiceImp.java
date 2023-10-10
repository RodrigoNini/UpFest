package com.UpFest.App.services.venda;

import com.UpFest.App.entities.*;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.SerieBilhetesRepository;
import com.UpFest.App.repositories.venda.BilheteRepository;
import com.UpFest.App.repositories.venda.EntradaRepository;
import com.UpFest.App.repositories.venda.PagamentoRepository;
import com.UpFest.App.repositories.venda.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class BilheteServiceImp implements BilheteService {

    @Autowired
    BilheteRepository bilheteRepository;
    @Autowired
    SerieBilhetesRepository serieBilhetesRepository;
    @Autowired
    ParticipanteRepository participanteRepository;
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    EntradaRepository entradaRepository;
    @Autowired
    PagamentoRepository pagamentoRepository;


    @Override
    public Bilhete comprarBilhete(Long id_evento, String nome, String email, Long id_serieBilhetes) throws Exception {
        // 1. Validar se ainda existem bilhetes disponíveis nessa série
        SerieBilhetes serie = serieBilhetesRepository.findById(id_serieBilhetes).orElse(null);
        if (serie == null || serie.getNumero_bilhetes() <= 0) {
            throw new Exception("Série de bilhetes inválida ou esgotada.");
        }

        // 2. Verificar se já existe algum participante com esse e-mail
        Optional<Participante> participanteOptional = participanteRepository.findByEmail(email);
        Participante participante;
        if (participanteOptional.isPresent()) {
            participante = participanteOptional.get();
        } else {
            // Se não existe, criamos um novo participante
            participante = new Participante(email, nome, new Date());
            participanteRepository.save(participante);
        }

        // 3. Gerar uma referência de pagamento
        int referencia = 12345643;

        // 5. Buscar evento
        Optional<Evento> eventoBD = eventoRepository.findById(id_evento);

        // 6. Criar um bilhete sem código de entrada
        Bilhete bilhete = new Bilhete( null);
        bilhete.setParticipante(participante);
        bilhete.setSerieBilhetes(serie);
        bilhete.setEvento(eventoBD.get());
        bilheteRepository.save(bilhete);

        // Criar pagamento
        Pagamento pagamento = new Pagamento(12345,12345643, serie.getCusto(), new Date(),null);
        pagamento.setBilhete(bilhete);
        pagamentoRepository.save(pagamento);

        // Atualizar a série de bilhetes
        serie.setNumero_bilhetes(serie.getNumero_bilhetes() - 1);
        serieBilhetesRepository.save(serie);

        return bilhete;
    }

    private int gerarReferenciaPagamento() {
        // Obtém o timestamp atual em milissegundos
        long timestamp = System.currentTimeMillis();

        // Gera um número aleatório entre 1000 e 9999
        int numeroAleatorio = (int) (Math.random() * 9000) + 1000;

        // Combina o timestamp e o número aleatório para formar a referência
        return (int) (timestamp * 10000L + numeroAleatorio);
    }

    @Override
    public Bilhete validarBilhete(Long id_evento, String codigo) throws Exception {

        // 1. Validar se o bilhete existe e foi pago
        Optional<Bilhete> bilheteOptional = bilheteRepository.findByCodigo(codigo);
        Bilhete bilhete;
        if (bilheteOptional.isPresent()) {
            bilhete = bilheteOptional.get();
        } else {
            throw new Exception("Bilhete inválido ou não foi pago.");
        }

        // 2. Validar se não foi já registada uma entrada no evento nesse dia, para esse bilhete
        Optional<Entrada> entradaOptional = entradaRepository.findById(bilhete.getId());
        if (entradaOptional.isPresent()) {
            throw new Exception("Entrada já registada para este bilhete.");
        } else {
            // 3. Registar a entrada no evento
            Entrada entrada = new Entrada(null, null);
            entrada.setBilhete(bilhete);
            entrada.setData(LocalDate.now());
            entrada.setHora(Time.valueOf(LocalTime.now())); // Obtém a hora atual

            entradaRepository.save(entrada);
        }

        return bilhete;
    }



}
