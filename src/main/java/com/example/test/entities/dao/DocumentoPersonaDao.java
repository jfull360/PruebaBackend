package com.example.test.entities.dao;

import com.example.test.entities.Documento;
import com.example.test.entities.DocumentoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentoPersonaDao extends JpaRepository<DocumentoPersona, Long> {

    @Query("select dp from DocumentoPersona dp where dp.documento = ?1 and dp.numeroDocumento = ?2")
    DocumentoPersona findPersonaByDocumentoAndNumeroDocumento(Documento documento, String numeroDocumento);

}
