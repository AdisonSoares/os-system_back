package com.adison.os.repositorie;

import com.adison.os.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    @Query("SELECT objectTecnico FROM Tecnico objectTecnico WHERE objectTecnico.cpf =:cpf ")
    Tecnico findByCpf(@Param("cpf") String cpf);
}
