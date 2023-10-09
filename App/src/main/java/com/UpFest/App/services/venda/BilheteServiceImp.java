package com.UpFest.App.services.venda;

import com.UpFest.App.entities.*;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.SerieBilhetesRepository;
import com.UpFest.App.repositories.venda.BilheteRepository;
import com.UpFest.App.repositories.venda.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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


    @Override
    public Bilhete comprarBilhete(Long id_bilhete, String nome, String email, Long id_serieBilhetes) throws Exception {
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
        int referencia = gerarReferenciaPagamento();

        // 4. Criar um bilhete sem código de entrada
        Bilhete bilhete = new Bilhete( null);
        bilhete.setParticipante(participante);
        bilhete.setSerieBilhetes(serie);
        bilheteRepository.save(bilhete);

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

//        // 2. Validar se não foi já registada uma entrada no evento nesse dia, para esse bilhete
//        boolean entradaRegistrada = entradaRepository.existsByEventoAndBilheteAndData(id_evento, bilhete, LocalDate.now());
//        if (entradaRegistrada) {
//            throw new Exception("Entrada já registrada para este bilhete hoje.");
//        }
//
//        // 3. Registar a entrada no evento
//        Entrada entrada = new Entrada();
//        entrada.setEvento(eventoRepository.findById(id_evento).orElse(null));
//        entrada.setBilhete(bilhete);
//        entrada.setData(LocalDate.now());
//        entradaRepository.save(entrada);

        return bilhete;
    }

//          COMPRAR
//        "Permite a um utilizador adquirir um bilhete. Enviando o nome, o e-mail, e a série de bilhetes que quer adquirir, o servidor: " +
//            "1. Deverá validar se ainda existem bilhetes disponíveis nessa série, e se essa série ainda está disponível para venda; " +
//            "2. Verificar se já existe algum participante com esse e-mail e criar caso não exista, guardando também o nome do participante " +
//            "3. Deverá gerar uma referência de pagamento " +
//            "4. Deverá criar um bilhete, sem código de entrada, uma vez que ainda não foi pago."

//          VALIDAR ENTRADA
//        "A ser utilizado pela organização do evento para validar a entrada de um participante. " +
//        "Deverá receber o código do bilhete gerado no momento em que o bilhete foi pago. " +
//            "1. Validar se o bilhete existe e foi pago; " +
//            "2. Validar se não foi já registada uma entrada no evento nesse dia, para esse bilhete; " +
//            "3. Registar a entrada no evento."

}
