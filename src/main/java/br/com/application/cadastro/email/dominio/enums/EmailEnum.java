package br.com.application.cadastro.email.dominio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EmailEnum {

    EMAIL_MASCARA_REGEX ("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    @Getter
    private final String regex;
}
