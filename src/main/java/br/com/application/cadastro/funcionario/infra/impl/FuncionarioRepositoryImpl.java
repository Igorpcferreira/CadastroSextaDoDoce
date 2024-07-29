package br.com.application.cadastro.funcionario.infra.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.application.cadastro.funcionario.FuncionarioMapper;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.infra.FuncionarioDataRepository;
import br.com.application.cadastro.funcionario.infra.data.FuncionarioData;
import br.com.application.cadastro.funcionario.repository.FuncionarioRepository;
import br.com.application.core.BaseMapper;
import br.com.application.core.infra.impl.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class FuncionarioRepositoryImpl extends BaseRepositoryImpl<Funcionario, FuncionarioData> implements FuncionarioRepository {

    private final FuncionarioMapper funcionarioMapper;
    private final FuncionarioDataRepository funcionarioDataRepository;

    @Override
    public BaseMapper<Funcionario, FuncionarioData> getMapper() {
        return funcionarioMapper;
    }

    @Override
    public JpaRepository<FuncionarioData, Long> getRepository() {
        return funcionarioDataRepository;
    }

    @Override
    public Optional<Funcionario> consultar(Long id) {
        return funcionarioDataRepository.findById(id).map(funcionarioMapper::toDomain);
    }

    @Override
    public Page<Funcionario> listar() {
        return funcionarioDataRepository.findAll(Pageable.unpaged()).map(funcionarioMapper::toDomain);
    }

    @Override
    public boolean nomeFuncionarioJaCadastrado(Funcionario funcionario) {
        return funcionarioDataRepository.nomeFuncionarioJaCadastrado(funcionarioMapper.toData(funcionario).getNome());
    }

    @Override
    public boolean nomeFuncionarioJaCadastradoNotMe(Funcionario funcionario) {
        return funcionarioDataRepository.nomeFuncionarioJaCadastradoNotMe(funcionarioMapper.toData(funcionario).getNome(), funcionario.getId());
    }

    @Override
    public boolean dataResponsavelDoceJaCadastrado(Funcionario funcionario) {
        return funcionarioDataRepository.dataResponsavelDoceJaCadastrado(funcionarioMapper.toData(funcionario).getDataResponsavelDoce());
    }

}
