package br.com.application.core.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.application.core.BaseMapper;

public interface BaseRepository<DOMAIN, DATA> {

    DOMAIN incluir(DOMAIN dominio);
    DOMAIN alterar(DOMAIN dominio);
    Long excluir(Long id);
    BaseMapper<DOMAIN, DATA> getMapper();
    JpaRepository<DATA, Long> getRepository();

}
