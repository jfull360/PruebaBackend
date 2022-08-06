package com.example.test.services.documentos;

import com.example.test.entities.Documento;
import com.example.test.entities.dao.DocumentoDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

    private final DocumentoDao documentoDao;

    public DocumentoServiceImpl(DocumentoDao documentoDao) {
        this.documentoDao = documentoDao;
    }

    @Override
    public List<Documento> findAll() {
        return (List<Documento>) this.documentoDao.findAll();
    }
}

