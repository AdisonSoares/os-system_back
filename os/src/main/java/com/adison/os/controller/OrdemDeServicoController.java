package com.adison.os.controller;

import com.adison.os.dto.OrdemDeServicoDto;
import com.adison.os.service.OrdenDeServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/os")
public class OrdemDeServicoController {
    @Autowired
    private OrdenDeServicoService ordenDeServicoService;
    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeServicoDto> findById(@PathVariable Integer id){
        OrdemDeServicoDto objectOrdemDeServicoDto = new OrdemDeServicoDto(ordenDeServicoService.findById(id));
        return ResponseEntity.ok().body(objectOrdemDeServicoDto);
    }
}
