package com.soulcode.Servicos.Controllers;

import com.soulcode.Servicos.Models.Funcionario;
import com.soulcode.Servicos.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> mostrarTodosFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.mostrarTodosFuncionarios();
        return  funcionarios;
    }

    @GetMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Funcionario> mostrarUmFuncionarioPeloId(@PathVariable Integer idFuncionario){
        Funcionario funcionario = funcionarioService.mostrarUmFuncionarioPeloId(idFuncionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/funcionarios/{email}")
    public ResponseEntity<Funcionario> mostrarUmFuncionarioPeloEmail(@PathVariable String email){
        Funcionario funcionario = funcionarioService.mostrarUmFuncionarioPeloEmail(email);
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario){
        // nessa linha 42, o funcionário já é savo na tabela do database
        // agora precisamos criar uma uri para esse novo registro da tabela
        funcionario = funcionarioService.cadastrarFuncionario(funcionario);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(funcionario.getIdFuncionario()).toUri();
        return ResponseEntity.created(novaUri).body(funcionario);
    }

    @DeleteMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Integer idFuncionario){
        funcionarioService.excluirFuncionario(idFuncionario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Integer idFuncionario, @RequestBody Funcionario funcionario ){

        funcionario.setIdFuncionario(idFuncionario);
        funcionarioService.editarFuncionario(funcionario);
        return ResponseEntity.noContent().build();

    }
}