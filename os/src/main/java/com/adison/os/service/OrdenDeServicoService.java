package com.adison.os.service;

import com.adison.os.domain.OrdemDeServico;
import com.adison.os.repositorie.OrdemDeServicoRepository;
import com.adison.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenDeServicoService {
    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    public OrdemDeServico findById(Integer id){
        Optional<OrdemDeServico> objectOrdemDeServico = ordemDeServicoRepository.findById(id);
        return objectOrdemDeServico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id+
                ", Tipo: "+ OrdemDeServico.class.getName()));
    }

    public List<OrdemDeServico> findAll(){
        return ordemDeServicoRepository.findAll();
    }
}
