package br.com.application.cadastro.funcionario.infra;

import org.springframework.stereotype.Component;

import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.infra.data.FuncionarioData;
import br.com.application.core.BaseMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper extends BaseMapper<Funcionario, FuncionarioData> {


    @Override
    public Funcionario toDomain(FuncionarioData funcionarioData) {
        if (funcionarioData == null) return null;

        return Funcionario.builder()
                .id(funcionarioData.getId())
                .nome(funcionarioData.getNome())
                .build();
    }

    @Override
    public FuncionarioData toData(Funcionario funcionario) {
        if (funcionario == null) return null;

        return FuncionarioData.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .build();
    }
}
