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
    private Integer id;

    @NotEmpty(message = "Campo obrigatório!")
    private String nome;

    @CPF
    @NotEmpty(message = "Campo obrigatório!")
    private String cpf;

    @NotEmpty(message = "Campo obrigatório!")
    private String telefone;

    public ClienteDto(Cliente objectCliente) {
        this.id = objectCliente.getId();
        this.nome = objectCliente.getNome();
        this.cpf = objectCliente.getCpf();
        this.telefone = objectCliente.getTelefone();
    }
}
