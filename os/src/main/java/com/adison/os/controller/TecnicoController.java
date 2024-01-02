package com.adison.os.controller;

import com.adison.os.domain.Tecnico;
import com.adison.os.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
    @Autowired
    private TecnicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
       Tecnico objectController = service.findById(id);
       return ResponseEntity.ok().body(objectController);
    }
}