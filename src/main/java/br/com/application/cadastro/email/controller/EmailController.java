package br.com.application.cadastro.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.cadastro.email.schedule.ScheduleDataResponsavelDoce;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    @Autowired
    private ScheduleDataResponsavelDoce scheduleDataResponsavelDoce;

    @PostMapping("/enviaEmailAgora")
    public ResponseEntity<Void> executeNow() {
        scheduleDataResponsavelDoce.executeNow();
        return ResponseEntity.ok().build();
    }

}
