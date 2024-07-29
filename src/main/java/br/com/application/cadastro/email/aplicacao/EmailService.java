package br.com.application.cadastro.email.aplicacao;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.application.cadastro.email.dominio.enums.EmailEnum;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public void enviarEmail(Funcionario funcionario) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(String.valueOf(funcionario.getEmail().getDestinatario()));
        mensagem.setSubject("Sexta-feira é dia de doce!");
        mensagem.setText(EmailEnum.EMAIL_MENSAGEM.getValor() + funcionario.getDataResponsavelDoce() + ".");
        emailSender.send(mensagem);
    }

}
