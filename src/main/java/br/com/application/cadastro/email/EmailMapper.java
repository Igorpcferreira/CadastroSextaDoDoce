package br.com.application.cadastro.email;

import org.springframework.stereotype.Component;

import br.com.application.cadastro.email.dominio.entidade.Email;
import br.com.application.cadastro.email.infra.data.EmailData;
import br.com.application.core.BaseMapper;

@Component
public class EmailMapper extends BaseMapper<Email, EmailData>{


    @Override
    public Email toDomain(EmailData emailData) {
        if (emailData == null)  return null;

        return Email.builder()
            .id(emailData.getId())
            .email(emailData.getEmail())
            .build();
    }

    @Override
    public EmailData toData(Email email) {
        if (email == null) return null;

        return EmailData.builder()
            .id(email.getId())
            .email(email.getEmail())
            .build();
    }
}
