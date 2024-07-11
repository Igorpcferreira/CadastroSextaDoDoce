package br.com.application.cadastro.funcionario.dominio.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Setter
    private Long id;

    @Setter
    private String nome;

    public Funcionario(Long id) {
        this.id = id;
    }

}
