package com.soulcode.Servicos.Repositories;

import com.soulcode.Servicos.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByEmail(String email);
    // Optional<Cliente> findByNome

    //Optional<Cliente> findByNomeAndEmailAndFoto(String nome, String email, String foto);


}