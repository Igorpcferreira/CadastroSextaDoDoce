package br.com.application.cadastro.funcionario.dominio.regras;

import java.time.LocalDate;
import java.util.Optional;

import javax.inject.Named;

import br.com.application.cadastro.email.dominio.entidade.Email;
import br.com.application.cadastro.email.dominio.enums.EmailEnum;
import br.com.application.cadastro.funcionario.aplicacao.FuncionarioService;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.dominio.enums.FuncionarioEnum;
import br.com.application.core.regras.Regras;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class IncluirFuncionarioRegras implements Regras<Funcionario> {

    private final FuncionarioService funcionarioService;

    @Override
    public Funcionario execute(Funcionario funcionario) {
        validarDadosFuncionario(funcionario);
        return funcionarioService.incluir(funcionario);
    }

    private void validarDadosFuncionario(Funcionario funcionario) {
        validarNomeNulo(funcionario.getNome());
        validarTamanhoNome(funcionario.getNome());
        validarEmailNulo(funcionario.getEmail());
        validarFormatoEmail(funcionario.getEmail());
        validarDataResponsavelDoceNula(funcionario.getDataResponsavelDoce());
        validarDataResponsavelDoceJaCadastrado(funcionario);
        tratarNomeComEspacosEmBranco(funcionario);
        validarNomeFuncionarioJaCadastrado(funcionario);
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

    private void validarEmailNulo(Email email) {
        Optional.ofNullable(email)
                .orElseThrow(() -> new IllegalArgumentException("Email do funcionário não pode ser nulo"));
    }

    private void validarFormatoEmail(Email email) {
        if (!email.getDestinatario().matches(EmailEnum.EMAIL_MASCARA_REGEX.getValor())) {
            throw new IllegalArgumentException("O formato do email é inválido");
        }
    }

    private void validarDataResponsavelDoceNula(LocalDate dataCriacao) {
        Optional.ofNullable(dataCriacao)
                .orElseThrow(() -> new IllegalArgumentException("Data responsável pelo doce não pode ser nula"));
    }

    private void validarDataResponsavelDoceJaCadastrado(Funcionario funcionario) {
        if (funcionarioService.dataResponsavelDoceJaCadastrado(funcionario)) {
            throw new IllegalArgumentException("Data de criação do funcionário já cadastrada");
        }
    }


    private void tratarNomeComEspacosEmBranco(Funcionario funcionario) {
        funcionario.setNome(funcionario.getNome().trim());
    }

    private void validarNomeFuncionarioJaCadastrado(Funcionario funcionario) {
        if (funcionarioService.nomeFuncionarioJaCadastrado(funcionario)) {
            throw new IllegalArgumentException("Nome do funcionário já utilizado");
        }
    }

}