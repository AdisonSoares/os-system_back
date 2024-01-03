package com.adison.os.service;

import com.adison.os.domain.Tecnico;
import com.adison.os.repositorie.TecnicoRepository;
import com.adison.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> objectRepository = repository.findById(id);
        return objectRepository.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+ id + ", Tipo: "+ Tecnico.class.getName()));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }
}
