package br.com.application.cadastro.funcionario.dominio.regras;

import javax.inject.Named;

import br.com.application.cadastro.funcionario.aplicacao.FuncionarioService;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.core.regras.Regras;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class ExcluirFuncionarioRegras implements Regras<Funcionario> {

    FuncionarioService funcionarioService;

    @Override
    public Funcionario execute(Funcionario funcionario) {
        return new Funcionario(this.execute(funcionario.getId()));
    }

    public Long execute(Long id) {
        validarIdNulo(id);
        funcionarioService.excluir(id);
        return id;
    }

    public void validarIdNulo(Long id) {
        if (id == null) {
            throw new NullPointerException("O id é obrigatório");
        }
    }

}
