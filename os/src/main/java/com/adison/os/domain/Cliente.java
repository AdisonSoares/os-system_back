package com.adison.os.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter @Setter
public class Cliente extends Pessoa implements Serializable {
    public Cliente(Integer id, String nome, @CPF String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }
    public Cliente() {
        super();
    }

    @OneToMany(mappedBy = "cliente")
    private List<OrdemDeServico> list = new ArrayList<>();
}
