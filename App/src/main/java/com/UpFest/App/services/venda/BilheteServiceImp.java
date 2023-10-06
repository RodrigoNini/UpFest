package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Bilhete;
import com.UpFest.App.repositories.venda.BilheteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilheteServiceImp implements BilheteService {

    @Autowired
    BilheteRepository bilheteRepository;

    @Override
    public Bilhete comprarBilhete(Long id_evento, String nome, String email, Long id_serieBilhetes) throws Exception {
        return null;
    }

    @Override
    public Bilhete validarBilhete(Long id_evento, String codigo) throws Exception {
        return null;
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
