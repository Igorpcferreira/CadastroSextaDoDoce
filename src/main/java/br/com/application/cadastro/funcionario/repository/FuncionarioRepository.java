package br.com.application.cadastro.funcionario.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.infra.data.FuncionarioData;
import br.com.application.core.infra.BaseRepository;


public interface FuncionarioRepository extends BaseRepository<Funcionario, FuncionarioData> {

    Optional<Funcionario> consultar(Long id);

    Page<Funcionario> listar();

    boolean nomeFuncionarioJaCadastrado(Funcionario funcionario);

    boolean nomeFuncionarioJaCadastradoNotMe(Funcionario funcionario);

    boolean dataNotificacaoFuncionarioJaCadastrado(Funcionario funcionario);

}
