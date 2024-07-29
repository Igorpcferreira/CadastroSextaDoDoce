package br.com.application.cadastro.funcionario.aplicacao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.repository.FuncionarioRepository;
import br.com.application.core.exceptions.NaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario consultar(Long id) {
        return funcionarioRepository.consultar(id).orElseThrow(() -> new NaoEncontradoException("Funcionário não encontrado"));
    }

    public Funcionario incluir(Funcionario funcionario) {
        return funcionarioRepository.incluir(funcionario);
    }

    public Funcionario alterar(Funcionario funcionario) {
        return funcionarioRepository.alterar(funcionario);
    }

    public void excluir(Long id) {
        funcionarioRepository.excluir(id);
    }

    public Page<Funcionario> listar() {
        return funcionarioRepository.listar();
    }

    public boolean nomeFuncionarioJaCadastrado(Funcionario funcionario) {
        return funcionarioRepository.nomeFuncionarioJaCadastrado(funcionario);
    }

    public boolean nomeFuncionarioJaCadastradoNotMe(Funcionario funcionario) {
        return funcionarioRepository.nomeFuncionarioJaCadastradoNotMe(funcionario);
    }

    public boolean dataResponsavelDoceJaCadastrado(Funcionario funcionario) {
        return funcionarioRepository.dataResponsavelDoceJaCadastrado(funcionario);
    }
}
