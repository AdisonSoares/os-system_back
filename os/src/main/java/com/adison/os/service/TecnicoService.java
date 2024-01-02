package com.adison.os.service;

import com.adison.os.domain.Tecnico;
import com.adison.os.repositorie.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> objectRepository = repository.findById(id);
        return objectRepository.orElse(null);
    }
}
