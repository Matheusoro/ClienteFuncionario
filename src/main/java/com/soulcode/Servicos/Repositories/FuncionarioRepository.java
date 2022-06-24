package com.soulcode.Servicos.Repositories;

import com.soulcode.Servicos.Models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByEmail(String email);
    // Optional<Funcionario> findByNome

    //Optional<Funcionario> findByNomeAndEmailAndFoto(String nome, String email, String foto);


}