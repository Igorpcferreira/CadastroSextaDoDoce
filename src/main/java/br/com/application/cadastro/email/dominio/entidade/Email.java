package br.com.application.cadastro.email.dominio.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private Long id;

    @Setter
    private String destinatario;

    public Email(String destinatario) {
        this.destinatario = destinatario;
    }

}
