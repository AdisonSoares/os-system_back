package com.adison.os.repositorie;

import com.adison.os.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @Query("SELECT objectPessoa FROM Pessoa objectPessoa WHERE objectPessoa.cpf =:cpf ")
    Pessoa findByCpf(@Param("cpf") String cpf);
}
