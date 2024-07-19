package br.com.application.cadastro.email.aplicacao;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviarEmail(String email, String mensagem) {
        System.out.println("Enviando email para " + email + " com a mensagem: " + mensagem);


    }

}
