package com.adison.os.dto;

import com.adison.os.domain.OrdemDeServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data @NoArgsConstructor
public class OrdemDeServicoDto implements Serializable {

    public static final String CAMPO_OBRIGATORIO = "Campo obrigatório!";
    public static final String DATA = "dd/MM/yyyy HH:mm";
    private Integer id;

    @JsonFormat(pattern = DATA)
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = DATA)
    private LocalDateTime dataFechamento;

    private Integer prioridade;

    @NotEmpty(message = CAMPO_OBRIGATORIO)
    private String observacoes;

    private Integer status;

    private Integer tecnico;

    private Integer cliente;

    public OrdemDeServicoDto(OrdemDeServico objectOrdemDeServico) {
        this.id = objectOrdemDeServico.getId();
        this.dataAbertura = objectOrdemDeServico.getDataAbertura();
        this.dataFechamento = objectOrdemDeServico.getDataFechamento();
        this.prioridade = objectOrdemDeServico.getPrioridade().getCodigo();
        this.observacoes = objectOrdemDeServico.getObservacoes();
        this.status = objectOrdemDeServico.getStatus().getCodigo();
        this.tecnico = objectOrdemDeServico.getTecnico().getId();
        this.cliente = objectOrdemDeServico.getCliente().getId();
    }
}
