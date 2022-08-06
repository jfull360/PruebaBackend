package com.example.test.services.documentoPersona;

import com.example.test.entities.Documento;
import com.example.test.entities.DocumentoPersona;

public interface IDocumentoPersonaService {

    DocumentoPersona findPersonaByDocumentoAndNumeroDocumento(Documento documento, Integer numeroDocumento);

}
