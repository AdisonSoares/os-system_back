package com.adison.os.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Tecnico extends Pessoa implements Serializable {
    public Tecnico(Integer id, String nome, @CPF String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }
    public Tecnico() {
        super();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<OrdemDeServico> list = new ArrayList<>();
}
