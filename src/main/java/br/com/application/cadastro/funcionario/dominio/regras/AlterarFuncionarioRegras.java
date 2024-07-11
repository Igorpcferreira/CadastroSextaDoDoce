package br.com.application.cadastro.funcionario.dominio.regras;

import java.util.Optional;

import javax.inject.Named;

import br.com.application.cadastro.funcionario.aplicacao.FuncionarioService;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.dominio.enums.FuncionarioEnum;
import br.com.application.core.regras.Regras;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class AlterarFuncionarioRegras implements Regras<Funcionario>{

    FuncionarioService funcionarioService;

    @Override
    public Funcionario execute(Funcionario funcionario) {
        validarDadosFuncionario(funcionario);
        return funcionarioService.alterar(funcionario);
    }

    private void validarDadosFuncionario(Funcionario funcionario) {
        validarNomeNulo(funcionario.getNome());
        validarTamanhoNome(funcionario.getNome());
        tratarNomeComEspacosEmBranco(funcionario);
        validarNomeJaCadastrado(funcionario);
    }

    private void validarNomeNulo(String nome) {
        Optional.ofNullable(nome)
                .orElseThrow(() -> new IllegalArgumentException("Nome do funcionário não pode ser nulo"));
    }

    private void validarTamanhoNome(String nome) {
        Optional.ofNullable(nome)
                .filter(n -> n.length() <= FuncionarioEnum.NOME_TAMANHO_MAXIMO.getValor())
                .orElseThrow(() -> new IllegalArgumentException("Nome do funcionário não deve ter mais de 15 caracteres"));
    }


    private void tratarNomeComEspacosEmBranco(Funcionario funcionario) {
        funcionario.setNome(funcionario.getNome().trim());
    }

    private void validarNomeJaCadastrado(Funcionario funcionario) {
        if (funcionarioService.nomeFuncionarioJaCadastrado(funcionario)) {
            throw new IllegalArgumentException("Nome do funcionário já utilizado");
        }
    }


}
