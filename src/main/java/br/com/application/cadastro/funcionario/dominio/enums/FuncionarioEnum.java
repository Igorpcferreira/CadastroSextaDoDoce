package br.com.application.cadastro.funcionario.dominio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FuncionarioEnum {

    NOME_TAMANHO_MAXIMO(15);

    @Getter
    private final int valor;

}
