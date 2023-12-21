package com.adison.os.domain;

import com.adison.os.domain.enums.Prioridade;
import com.adison.os.domain.enums.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter @Setter @EqualsAndHashCode(of = {"id"})
public class OrdemDeServico {
    private Integer id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private Integer prioridade;
    private String observacoes;
    private Integer status;
    private Tecnico tecnico;
    private Cliente cliente;

    public OrdemDeServico() {
        this.setDataAbertura(LocalDateTime.now());
        this.setPrioridade(Prioridade.BAIXA);
        this.setStatus(Status.ABERTO);
    }

    public OrdemDeServico(Integer id, Prioridade prioridade, String observacoes,
                          Status status, Tecnico tecnico,
                          Cliente cliente) {
        this.id = id;
        this.setDataAbertura(LocalDateTime.now());
        this.prioridade = (prioridade == null) ? 0 : prioridade.getCodigo();
        this.observacoes = observacoes;
        this.status = (prioridade == null) ? 0 : status.getCodigo();
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Prioridade getPrioridade() {
        return Prioridade.toEnum(this.prioridade);
    }

    public void setPrioridade(Prioridade prioridade){
        this.prioridade = prioridade.getCodigo();
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public void setStatus(Status status){
        this.status = status.getCodigo();
    }
}
