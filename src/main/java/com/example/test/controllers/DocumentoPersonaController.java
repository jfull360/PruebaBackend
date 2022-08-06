package com.example.test.controllers;


import com.example.test.entities.DocumentoPersona;
import com.example.test.entities.Persona;
import com.example.test.services.documentoPersona.DocumentoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/documentoPersona/")
public class DocumentoPersonaController {

    private final DocumentoPersonaService service;

    @Autowired
    public DocumentoPersonaController(DocumentoPersonaService service) {
        this.service = service;
    }

    @PostMapping("search")
    public ResponseEntity<?> findByNumeroDocumento(@Valid @RequestBody DocumentoPersona doc, BindingResult result) {
        DocumentoPersona dcp= null;
        Persona persona = null;
        Map<String, Object> response  = new HashMap<>();

        if (result.hasErrors()) {
            FieldError error = result.getFieldError();
            response.put("code", 400);
            assert error != null;
            response.put("errors", error.getDefaultMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            dcp = this.service.findPersonaByDocumentoAndNumeroDocumento(doc.getDocumento(), doc.getNumeroDocumento());
        } catch (DataAccessException e) {
            response.put("code", 500);
            response.put("message", "Error al buscar la persona");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(dcp == null) {
            response.put("code", 404);
            response.put("message", "Persona no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            persona = dcp.getPersona();
            response.put("code", 200);
            response.put("message", "Persona encontrada");
            response.put("data", persona);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
