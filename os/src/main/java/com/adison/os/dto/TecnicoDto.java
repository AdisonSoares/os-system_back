package com.adison.os.dto;

import com.adison.os.domain.Tecnico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class TecnicoDto implements Serializable {
    private Integer id;

    private String nome;

    @CPF
    private String cpf;

    private String telefone;

    public TecnicoDto(Tecnico objectTecnico) {
        this.id = objectTecnico.getId();
        this.nome = objectTecnico.getNome();
        this.cpf = objectTecnico.getCpf();
        this.telefone = objectTecnico.getTelefone();
    }
}
