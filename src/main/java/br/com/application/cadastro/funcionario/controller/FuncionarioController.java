package br.com.application.cadastro.funcionario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.cadastro.funcionario.aplicacao.FuncionarioService;
import br.com.application.cadastro.funcionario.dominio.entidade.Funcionario;
import br.com.application.cadastro.funcionario.dominio.regras.AlterarFuncionarioRegras;
import br.com.application.cadastro.funcionario.dominio.regras.ExcluirFuncionarioRegras;
import br.com.application.cadastro.funcionario.dominio.regras.IncluirFuncionarioRegras;
import br.com.application.cadastro.funcionario.infra.dto.FuncionarioDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cadastro/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final IncluirFuncionarioRegras inserirFuncionarioRegras;
    private final AlterarFuncionarioRegras alterarFuncionarioRegras;
    private final ExcluirFuncionarioRegras excluirFuncionarioRegras;


    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Funcionario> consultar(@RequestBody Long id) {
        Funcionario entidade = funcionarioService.consultar(id);
        return ResponseEntity.ok(entidade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> incluir(@RequestBody FuncionarioDto funcionarioDto) {
        Funcionario domain = funcionarioDto.toEntity();
        return ResponseEntity.ok(inserirFuncionarioRegras.execute(domain).getId());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> alterar(@RequestBody @Valid FuncionarioDto funcionarioDto) {
        Funcionario domain = funcionarioDto.toEntity();
        if (domain.getId() == null) domain.setId(funcionarioDto.getId());
        return ResponseEntity.ok(alterarFuncionarioRegras.execute(domain).getId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        excluirFuncionarioRegras.execute(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.ok(funcionarioService.listar().getContent());
    }
}
