package br.com.application.cadastro.email.infra.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.application.cadastro.email.EmailMapper;
import br.com.application.cadastro.email.dominio.entidade.Email;
import br.com.application.cadastro.email.infra.EmailDataRepository;
import br.com.application.cadastro.email.infra.data.EmailData;
import br.com.application.cadastro.email.repository.EmailRepository;
import br.com.application.core.BaseMapper;
import br.com.application.core.infra.impl.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class EmailRepositoryImpl extends BaseRepositoryImpl<Email, EmailData> implements EmailRepository {

    private final EmailMapper emailMapper;

    private final EmailDataRepository emailDataRepository;

    @Override
    public BaseMapper<Email, EmailData> getMapper() {
        return emailMapper;
    }

    @Override
    public JpaRepository<EmailData, Long> getRepository() {
        return emailDataRepository;
    }

}
