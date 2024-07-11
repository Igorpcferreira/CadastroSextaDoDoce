package br.com.application.core.regras;

public interface Regras<DOMINIO> {

        DOMINIO execute(DOMINIO dominio);

}
