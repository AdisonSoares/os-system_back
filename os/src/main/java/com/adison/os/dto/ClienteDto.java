package com.adison.os.dto;

import com.adison.os.domain.Cliente;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class ClienteDto implements Serializable {
    public static final String CAMPO_OBRIGATORIO = "Campo obrigatório!";
    private Integer id;

    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String nome;

    @CPF
    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String cpf;

    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String telefone;

    public ClienteDto(Cliente objectCliente) {
        this.id = objectCliente.getId();
        this.nome = objectCliente.getNome();
        this.cpf = objectCliente.getCpf();
        this.telefone = objectCliente.getTelefone();
    }
}
