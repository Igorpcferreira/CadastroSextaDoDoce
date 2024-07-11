package br.com.application.core.infra.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.application.core.infra.BaseRepository;

public abstract class BaseRepositoryImpl<DOMAIN, DATA> implements BaseRepository<DOMAIN, DATA> {

    private static final Logger logger = LogManager.getLogger(BaseRepositoryImpl.class.getName());

    public DOMAIN incluir(DOMAIN domain) {
        try {
            DATA data = getMapper().toData(domain);
            data = getRepository().save(data);
            return getMapper().toDomain(data);
        } catch (Exception e) {
            logger.error("Erro ao inserir registro:", e);
            throw new RuntimeException(e);
        }
    }

    public DOMAIN alterar(DOMAIN domain) {
        try {
            DATA data = getMapper().toData(domain);
            data = getRepository().save(data);
            return getMapper().toDomain(data);
        } catch (Exception e) {
            logger.error("Erro ao alterar registro:", e);
            throw new RuntimeException(e);
        }
    }

    public Long excluir(Long id) {
        try {
            getRepository().deleteById(id);
            return id;
        } catch (Exception e) {
            logger.error("Erro ao excluir registro:", e);
            throw new RuntimeException(e);
        }
    }

}
