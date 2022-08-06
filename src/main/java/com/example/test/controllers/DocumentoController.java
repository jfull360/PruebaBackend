package com.example.test.controllers;

import com.example.test.entities.Documento;
import com.example.test.entities.dtos.Option;
import com.example.test.services.documentos.DocumentoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/documentos")
public class DocumentoController {

    private final DocumentoServiceImpl service;

    public DocumentoController(DocumentoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/options")
    public List<Option<Documento>> findAll() {
        return service.findAll().stream().map(
                        option -> new Option<Documento>(option.getDocumento(), option))
                .collect(Collectors.toList());
    }

}
