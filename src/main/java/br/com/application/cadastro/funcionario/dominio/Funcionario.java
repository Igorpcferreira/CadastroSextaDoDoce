package br.com.application.cadastro.funcionario.dominio;

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

    private long id;

    @Setter
    private String nome;

}
