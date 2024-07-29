package br.com.application.cadastro.funcionario.infra;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.application.cadastro.funcionario.infra.data.FuncionarioData;

@Repository
public interface FuncionarioDataRepository extends JpaRepository<FuncionarioData, Long>, JpaSpecificationExecutor<FuncionarioData> {

    @Query("select case when count(funcionario.id) > 0 then true else false end " +
        "from FuncionarioData funcionario " +
        "where funcionario.nome = ?1 ")
    boolean nomeFuncionarioJaCadastrado(String nome);

    @Query("select case when count(funcionario.id) > 0 then true else false end " +
        "from FuncionarioData funcionario " +
        "where funcionario.nome = ?1 and funcionario.id <> ?2")
    boolean nomeFuncionarioJaCadastradoNotMe(String nome, Long id);


    @Query("select case when count(funcionario.id) > 0 then true else false end " +
            "from FuncionarioData funcionario " +
            "where funcionario.dataResponsavelDoce = ?1")
    boolean dataResponsavelDoceJaCadastrado(LocalDate dataCriacao);
}
