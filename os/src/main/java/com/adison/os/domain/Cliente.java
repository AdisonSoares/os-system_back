package com.adison.os.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @AllArgsConstructor
public class Cliente extends Pessoa implements Serializable {

    @OneToMany(mappedBy = "cliente")
    private List<OrdemDeServico> list = new ArrayList<>();
}
