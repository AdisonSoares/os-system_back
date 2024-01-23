package com.adison.os.service;

import com.adison.os.domain.Cliente;
import com.adison.os.domain.Pessoa;
import com.adison.os.dto.ClienteDto;
import com.adison.os.repositorie.ClienteRepository;
import com.adison.os.repositorie.PessoaRepository;
import com.adison.os.service.exception.DataIntegratyViolationException;
import com.adison.os.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> objectRepository = clienteRepository.findById(id);
        return objectRepository.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+ id + ", Tipo: "+ Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDto clienteDto){
        if (findByCpf(clienteDto) !=null){
            throw new DataIntegratyViolationException("Cpf já cadastrado na base de dados!");
        }
        Cliente objectCliente = new Cliente(null, clienteDto.getNome(), clienteDto.getCpf(), clienteDto.getTelefone());
        return clienteRepository.save(objectCliente);
    }
    
    public Cliente update(Integer id, ClienteDto objectDto) {
        Cliente oldObjectCliente = findById(id);
        if (findByCpf(objectDto) != null && !Objects.equals(findByCpf(objectDto).getId(), id)){
            throw new DataIntegratyViolationException("Cpf já cadastrado na base de dados!");
        }

        oldObjectCliente.setNome(objectDto.getNome());
        oldObjectCliente.setCpf(objectDto.getCpf());
        oldObjectCliente.setTelefone(objectDto.getTelefone());

        return clienteRepository.save(oldObjectCliente);
    }

    public void delete(Integer id) {
        Cliente objectCliente = findById(id);
        if (!objectCliente.getList().isEmpty()){
            throw new DataIntegratyViolationException("Cliente possui ordens de serviço, não pode ser deletado!");
        }
        clienteRepository.deleteById(id);
    }

    private Pessoa findByCpf(ClienteDto clienteDto){
        return pessoaRepository.findByCpf(clienteDto.getCpf());
    }
}
