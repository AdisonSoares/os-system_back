package com.adison.os.domain.enums;

import lombok.Getter;

@Getter
public enum Prioridade {
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Prioridade toEnum(Integer codigo) throws IllegalAccessException {
        if (codigo == null){
            return null;
        }
        for (Prioridade objetoPrioridade : Prioridade.values()){
            if (codigo.equals(objetoPrioridade.getCodigo())){
                return objetoPrioridade;
            }
        }
        throw new IllegalAccessException("Prioridade inválida!" + codigo);
    }
}
