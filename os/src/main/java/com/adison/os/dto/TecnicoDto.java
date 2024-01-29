package com.adison.os.dto;

import com.adison.os.domain.Tecnico;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class TecnicoDto implements Serializable {
    public static final String CAMPO_OBRIGATORIO = "Campo obrigatório!";
    private Integer id;

    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String nome;

    @CPF
    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String cpf;

    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String telefone;

    public TecnicoDto(Tecnico objectTecnico) {
        this.id = objectTecnico.getId();
        this.nome = objectTecnico.getNome();
        this.cpf = objectTecnico.getCpf();
        this.telefone = objectTecnico.getTelefone();
    }
}
