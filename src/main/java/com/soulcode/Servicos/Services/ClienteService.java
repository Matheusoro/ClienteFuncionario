

package com.soulcode.Servicos.Services;

import com.soulcode.Servicos.Models.Cliente;
import com.soulcode.Servicos.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Quando se fala em serviços, estamos falando dos métodos do crud da tabela
@Service
public class ClienteService {

    // aqui se faz a injeção de dependência
    @Autowired
    ClienteRepository clienteRepository;

    //primeiro serviço na tabela de funcionários vai ser a leitura de todos os funcionarios cadastrados
    //findALL -> método do spring JPA -> busca todos os registros de uma tabela
    public List<Cliente> mostrarTodosClientes(){
        return clienteRepository.findAll();
    }

    //vamos criar um serviço relacionado ao funcionário
    //criar um serviço de buscar apenas um funcionario pelo seu id(chave primaria)

    public Cliente mostrarUmClientePeloId(Integer idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente.orElseThrow();
    }

    //vamos criar mais um serviço para buscar um funcionário pelo seu email

    public Cliente mostrarUmClientePeloEmail(String  email){
        Optional<Cliente> cliente =clienteRepository.findByEmail(email);
        return cliente.orElseThrow();
    }
    //vamos criar um serviço para cadastrar um novo funcionario

    public Cliente cadastrarCliente(Cliente cliente){
        //só por precaução nós vamos colocar o id do funcionário como nullo
        cliente.setIdCliente(null);
        return clienteRepository.save(cliente);
    }

    public void excluirCliente(Integer idCliente){
        //mostrarUmClientePeloId(idCliente);
        clienteRepository.deleteById(idCliente);
    }

    public Cliente editarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }


}