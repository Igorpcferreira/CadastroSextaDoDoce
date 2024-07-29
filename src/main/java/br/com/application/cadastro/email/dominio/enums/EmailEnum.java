package br.com.application.cadastro.email.dominio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailEnum {

    EMAIL_MASCARA_REGEX ("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"),
    EMAIL_MENSAGEM("Oiii! Tuudo bem com você? Estou passando para informá-lo(a) que você será responsável pela sexta-feira da doçura no dia ");


    private final String valor;

}
