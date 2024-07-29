package br.com.application.cadastro.email.schedule;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.application.cadastro.email.aplicacao.EmailService;
import br.com.application.cadastro.email.dominio.Schedule;
import br.com.application.cadastro.funcionario.aplicacao.FuncionarioService;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScheduleDataResponsavelDoce implements Schedule {

    private static final Logger logger = LogManager.getLogger(ScheduleDataResponsavelDoce.class.getName());
    private final EmailService emailService;
    private final FuncionarioService funcionarioService;

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void execute() {
       logger.info("Iniciando a execução do schedule: " + this.getClass().getName() + " - " + new Date());
        Page<Funcionario> funcionarios = this.funcionarioService.listar();

        if(funcionarios != null && !funcionarios.isEmpty()) {
            funcionarios.forEach(emailService::enviarEmail);
        }

    }

    public void executeNow() {
        logger.info("Execução manual do schedule: " + this.getClass().getName() + " - " + new Date());
        execute();
    }
}
