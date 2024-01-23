package com.adison.os.controller;

import com.adison.os.domain.Cliente;
import com.adison.os.dto.ClienteDto;
import com.adison.os.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Integer id){
        Cliente objectController = service.findById(id);
        ClienteDto objectDto = new ClienteDto(objectController);
       return ResponseEntity.ok().body(objectDto);
    }
    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll(){
        List<Cliente> listCliente = service.findAll();
        List<ClienteDto> listClienteDto= new ArrayList<>();

        for (Cliente objectCliente : listCliente) {
            listClienteDto.add(new ClienteDto(objectCliente));
        }

        //ForEach simplificado
        //listCliente.forEach(objectCliente -> listClienteDto.add(new ClienteDto(objectCliente)));

        //Simplificação de tudo acima
        /**
         * List<ClienteDto> listDto = service.findAll()
         *                .stream().map(objectCliente -> new ClienteDto(objectCliente))
         *                .collect(Collectors.toList());
         */

        return ResponseEntity.ok().body(listClienteDto);
    }
    @PostMapping
    public ResponseEntity<ClienteDto> create(@Valid @RequestBody ClienteDto objectDto) {
        Cliente objectCliente = service.create(objectDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(objectCliente.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Integer id, @Valid @RequestBody ClienteDto objectDto){
        ClienteDto newObjectDto = new ClienteDto(service.update(id, objectDto));
        return ResponseEntity.ok().body(newObjectDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

