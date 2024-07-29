package br.com.application.cadastro.funcionario.infra.dto;

import java.time.LocalDate;

import br.com.application.cadastro.email.dto.EmailDto;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto {

    private long id;
    private String nome;
    private EmailDto email;
    private LocalDate dataResponsavelDoce;

    public Funcionario toEntity() {
        return Funcionario.builder()
                .id(this.id)
                .nome(this.nome)
                .email(email != null ? email.toEntity() : null)
                .dataResponsavelDoce(dataResponsavelDoce != null ? dataResponsavelDoce : null)
                .build();
    }
}
