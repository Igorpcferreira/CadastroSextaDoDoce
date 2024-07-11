package br.com.application.cadastro.funcionario.dto;

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
    private String email;

    public Funcionario toEntity() {
        return Funcionario.builder()
                .id(this.id)
                .nome(this.nome)
                .build();
    }
}
