package br.com.application.cadastro.funcionario.dto;

import br.com.application.cadastro.funcionario.dominio.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FuncionarioDto {

    private long id;
    private String nome;
    private String email;

    public FuncionarioDto(String nome) {
        this.nome = nome;
    }

    public Funcionario toEntity() {
        return Funcionario.builder()
                .id(this.id)
                .nome(this.nome)
                .build();
    }
}
