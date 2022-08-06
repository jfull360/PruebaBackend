package com.example.test.services.documentos;

import com.example.test.entities.Documento;

import java.util.List;

public interface IDocumentoService {
    public List<Documento> findAll();
}
