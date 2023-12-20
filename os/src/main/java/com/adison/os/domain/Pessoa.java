package com.adison.os.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Pessoa {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
}
