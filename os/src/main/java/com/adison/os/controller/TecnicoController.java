package com.adison.os.controller;

import com.adison.os.domain.Tecnico;
import com.adison.os.dto.TecnicoDto;
import com.adison.os.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
    @Autowired
    private TecnicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id){
       Tecnico objectController = service.findById(id);
       TecnicoDto objectDto = new TecnicoDto(objectController);
       return ResponseEntity.ok().body(objectDto);
    }
    @GetMapping
    public ResponseEntity<List<TecnicoDto>> findAll(){
        List<Tecnico> listTecnico = service.findAll();
        List<TecnicoDto> listTecnicoDto= new ArrayList<>();

        for (Tecnico objectTecnico : listTecnico) {
            listTecnicoDto.add(new TecnicoDto(objectTecnico));
        }

        //ForEach simplificado
        //listTecnico.forEach(objectTecnico -> listTecnicoDto.add(new TecnicoDto(objectTecnico)));

        //Simplificação de tudo acima
        /**
         * List<TecnicoDto> listDto = service.findAll()
         *                .stream().map(objectTecnico -> new TecnicoDto(objectTecnico))
         *                .collect(Collectors.toList());
         */

        return ResponseEntity.ok().body(listTecnicoDto);
    }
}
