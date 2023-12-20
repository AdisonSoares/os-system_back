package com.adison.os.domain.enums;

import lombok.Getter;

@Getter
public enum Status {
    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Status toEnum(Integer codigo) throws IllegalAccessException{
        if (codigo == null){
            return null;
        }
        for (Status objetoStatus : Status.values()){
            if (codigo.equals(objetoStatus.getCodigo())){
                return objetoStatus;
            }
        }
        throw new IllegalAccessException("Status inválido!" + codigo);
    }
}
