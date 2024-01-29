package com.adison.os.service;

import com.adison.os.domain.Cliente;
import com.adison.os.domain.OrdemDeServico;
import com.adison.os.domain.Tecnico;
import com.adison.os.domain.enums.Prioridade;
import com.adison.os.domain.enums.Status;
import com.adison.os.dto.OrdemDeServicoDto;
import com.adison.os.repositorie.OrdemDeServicoRepository;
import com.adison.os.service.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenDeServicoService {
    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public OrdemDeServico findById(Integer id){
        Optional<OrdemDeServico> objectOrdemDeServico = ordemDeServicoRepository.findById(id);
        return objectOrdemDeServico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id+
                ", Tipo: "+ OrdemDeServico.class.getName()));
    }

    public List<OrdemDeServico> findAll(){
        return ordemDeServicoRepository.findAll();
    }

    public OrdemDeServico create(@Valid OrdemDeServicoDto objectDto) {
        return fromDto(objectDto);
    }
    public OrdemDeServico update(OrdemDeServicoDto objectOrdemDeServicoDto) {
        findById(objectOrdemDeServicoDto.getId());
        return fromDto(objectOrdemDeServicoDto);
    }
    private OrdemDeServico fromDto(OrdemDeServicoDto objectDto) {
        OrdemDeServico newObject = new OrdemDeServico();
        newObject.setId(objectDto.getId());
        newObject.setObservacoes(objectDto.getObservacoes());
        newObject.setPrioridade(Prioridade.toEnum(objectDto.getPrioridade()));
        newObject.setStatus(Status.toEnum(objectDto.getStatus()));

        Tecnico tecnico = tecnicoService.findById(objectDto.getTecnico());
        Cliente cliente = clienteService.findById(objectDto.getCliente());

        newObject.setTecnico(tecnico);
        newObject.setCliente(cliente);

        if (newObject.getStatus().getCodigo().equals(2)){
            newObject.setDataFechamento(LocalDateTime.now());
        }

        return ordemDeServicoRepository.save(newObject);
    }
}
