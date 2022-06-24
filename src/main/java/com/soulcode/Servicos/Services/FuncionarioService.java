package com.soulcode.Servicos.Services;

import com.soulcode.Servicos.Models.Funcionario;
import com.soulcode.Servicos.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Quando se fala em serviços, estamos falando dos métodos do crud da tabela
@Service
public class FuncionarioService {

    // aqui se faz a injeção de dependência
    @Autowired
    FuncionarioRepository funcionarioRepository;

    //primeiro serviço na tabela de funcionários vai ser a leitura de todos os funcionarios cadastrados
    //findALL -> método do spring JPA -> busca todos os registros de uma tabela
    public List<Funcionario> mostrarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    //vamos criar um serviço relacionado ao funcionário
    //criar um serviço de buscar apenas um funcionario pelo seu id(chave primaria)

    public Funcionario mostrarUmFuncionarioPeloId(Integer idFuncionario){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
        return funcionario.orElseThrow();
    }

    //vamos criar mais um serviço para buscar um funcionário pelo seu email

    public Funcionario mostrarUmFuncionarioPeloEmail(String  email){
        Optional<Funcionario> funcionario =funcionarioRepository.findByEmail(email);
        return funcionario.orElseThrow();
    }
    //vamos criar um serviço para cadastrar um novo funcionario

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        //só por precaução nós vamos colocar o id do funcionário como nullo
        funcionario.setIdFuncionario(null);
        return funcionarioRepository.save(funcionario);
    }

    public void excluirFuncionario(Integer idFuncionario){
        //mostrarUmFuncionarioPeloId(idFuncionario);
        funcionarioRepository.deleteById(idFuncionario);
    }

    public Funcionario editarFuncionario(Funcionario funcionario){
       Funcionario funcionarioProcurado = mostrarUmFuncionarioPeloId(funcionario.getIdFuncionario());
        return funcionarioRepository.save(funcionario);


    }
    public Funcionario salvarFoto(Integer idFuncionario, String caminhoFoto){
        Funcionario funcionario = mostrarUmFuncionarioPeloId(idFuncionario);
        funcionario.setFoto(caminhoFoto);
        return funcionarioRepository.save(funcionario);
    }

}