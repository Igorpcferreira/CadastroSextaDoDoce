package br.com.application.cadastro.email.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.application.cadastro.email.infra.data.EmailData;

@Repository
public interface EmailDataRepository extends JpaRepository<EmailData, Long>, JpaSpecificationExecutor<EmailData> {
}

