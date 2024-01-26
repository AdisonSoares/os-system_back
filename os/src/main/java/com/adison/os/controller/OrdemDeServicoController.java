package com.adison.os.controller;

import com.adison.os.dto.OrdemDeServicoDto;
import com.adison.os.service.OrdenDeServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/os")
public class OrdemDeServicoController {
    @Autowired
    private OrdenDeServicoService ordemDeServicoService;
    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeServicoDto> findById(@PathVariable Integer id){
        OrdemDeServicoDto objectOrdemDeServicoDto = new OrdemDeServicoDto(ordemDeServicoService.findById(id));
        return ResponseEntity.ok().body(objectOrdemDeServicoDto);
    }

    @GetMapping
    public ResponseEntity<List<OrdemDeServicoDto>> findAll(){
        List<OrdemDeServicoDto> listOrdemDeServicoDto = ordemDeServicoService.
                findAll().stream()
                .map(OrdemDeServicoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listOrdemDeServicoDto);
    }
}
