package com.example.test.services.documentoPersona;

import com.example.test.entities.Documento;
import com.example.test.entities.DocumentoPersona;
import com.example.test.entities.dao.DocumentoPersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentoPersonaService {

    private final DocumentoPersonaDao documentoPersonaDao;

    @Autowired
    public DocumentoPersonaService(DocumentoPersonaDao documentoPersonaDao) {
        this.documentoPersonaDao = documentoPersonaDao;
    }

    public DocumentoPersona findPersonaByDocumentoAndNumeroDocumento(Documento documento, String numeroDocumento) {
        return this.documentoPersonaDao.findPersonaByDocumentoAndNumeroDocumento(documento, numeroDocumento);
    }
}
