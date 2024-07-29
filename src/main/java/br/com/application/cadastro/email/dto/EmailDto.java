package br.com.application.cadastro.email.dto;

import br.com.application.cadastro.email.dominio.entidade.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailDto {

    private Long id;
    private String destinatario;

    public Email toEntity() {
        return Email.builder()
                .id(id)
                .destinatario(destinatario)
                .build();
    }
}
