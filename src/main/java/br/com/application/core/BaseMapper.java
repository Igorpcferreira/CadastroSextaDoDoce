package br.com.application.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public abstract class BaseMapper<DOMINIO, DATA> {
    public abstract DOMINIO toDomain(DATA data);

    public abstract DATA toData(DOMINIO dominio);

    public List<DOMINIO> toDomain(List<DATA> datas) {
        if (CollectionUtils.isEmpty(datas)) return new ArrayList<>();
        return datas.stream().map(this::toDomain).collect(Collectors.toList());
    }

    public List<DATA> toData(List<DOMINIO> dominios) {
        if (CollectionUtils.isEmpty(dominios)) return new ArrayList<>();
        return dominios.stream().map(this::toData).collect(Collectors.toList());
    }

    public Set<DOMINIO> toDomain(Set<DATA> datas) {
        if (CollectionUtils.isEmpty(datas)) return new HashSet<>();
        return datas.stream().map(this::toDomain).collect(Collectors.toSet());
    }

    public Set<DATA> toData(Set<DOMINIO> dominios) {
        if (CollectionUtils.isEmpty(dominios)) return new HashSet<>();
        return dominios.stream().map(this::toData).collect(Collectors.toSet());
    }

}
