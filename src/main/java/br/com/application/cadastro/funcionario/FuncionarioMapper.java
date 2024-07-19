package br.com.application.cadastro.funcionario;

import org.springframework.stereotype.Component;

import br.com.application.cadastro.email.EmailMapper;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.infra.data.FuncionarioData;
import br.com.application.core.BaseMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper extends BaseMapper<Funcionario, FuncionarioData> {

    private final EmailMapper emailMapper;

    @Override
    public Funcionario toDomain(FuncionarioData funcionarioData) {
        if (funcionarioData == null) return null;

        return Funcionario.builder()
                .id(funcionarioData.getId())
                .nome(funcionarioData.getNome())
                .email(emailMapper.toDomain(funcionarioData.getEmail()))
                //.dataCriacao(funcionarioData.getDataNotificacao())
                .build();
    }

    @Override
    public FuncionarioData toData(Funcionario funcionario) {
        if (funcionario == null) return null;

        return FuncionarioData.builder()
                .id(funcionario.getId())
                .nome(funcionario.getNome())
                .email(emailMapper.toData(funcionario.getEmail()))
                .build();
    }
}
