package com.adison.os.service;

import com.adison.os.domain.Pessoa;
import com.adison.os.domain.Tecnico;
import com.adison.os.dto.TecnicoDto;
import com.adison.os.repositorie.PessoaRepository;
import com.adison.os.repositorie.TecnicoRepository;
import com.adison.os.service.exception.DataIntegratyViolationException;
import com.adison.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> objectRepository = tecnicoRepository.findById(id);
        return objectRepository.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+ id + ", Tipo: "+ Tecnico.class.getName()));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDto tecnicoDto){
        if (findByCpf(tecnicoDto) !=null){
            throw new DataIntegratyViolationException("Cpf já cadastrado na base de dados!");
        }
        Tecnico objectTecnico = new Tecnico(null, tecnicoDto.getNome(), tecnicoDto.getCpf(), tecnicoDto.getTelefone());
        return tecnicoRepository.save(objectTecnico);
    }
    
    public Tecnico update(Integer id, TecnicoDto objectDto) {
        Tecnico oldObjectTecnico = findById(id);
        if (findByCpf(objectDto) != null && !Objects.equals(findByCpf(objectDto).getId(), id)){
            throw new DataIntegratyViolationException("Cpf já cadastrado na base de dados!");
        }

        oldObjectTecnico.setNome(objectDto.getNome());
        oldObjectTecnico.setCpf(objectDto.getCpf());
        oldObjectTecnico.setTelefone(objectDto.getTelefone());

        return tecnicoRepository.save(oldObjectTecnico);
    }

    public void delete(Integer id) {
        Tecnico objectTecnico = findById(id);
        if (!objectTecnico.getList().isEmpty()){
            throw new DataIntegratyViolationException("Técnico possui ordens de serviço, não pode ser deletado!");
        }
        tecnicoRepository.deleteById(id);
    }

    private Pessoa findByCpf(TecnicoDto tecnicoDto){
        return pessoaRepository.findByCpf(tecnicoDto.getCpf());
    }
}
