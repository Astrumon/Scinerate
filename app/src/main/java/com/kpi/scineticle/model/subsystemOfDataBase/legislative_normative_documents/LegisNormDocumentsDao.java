package com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;

import java.util.List;

public interface LegisNormDocumentsDao {
    @Insert
    void insert(LegisNormDocuments legisNormDocuments);

    @Update
    void update(LegisNormDocuments legisNormDocuments);

    @Delete
    void delete(LegisNormDocuments legisNormDocuments);

    @Query("DELETE FROM legislative_normative_documents")
    void deleteAll();

    @Query("SELECT * FROM legislative_normative_documents ORDER BY name")
    LiveData<List<LegisNormDocuments>> getAllLegisNormDocuments();

    @Query("Select * FROM legislative_normative_documents WHERE name = :name")
    LegisNormDocuments getLegisNormDocumentsByName(String name);

    @Query("Select * FROM legislative_normative_documents WHERE type = :type")
    LegisNormDocuments getLegisNormDocumentsByType(String type);

    @Query("Select * FROM legislative_normative_documents WHERE dateAccess = :dateAccess")
    LegisNormDocuments getLegisNormDocumentsByDateAccess(String dateAccess);

    @Query("Select * FROM legislative_normative_documents WHERE number = :number")
    LegisNormDocuments getLegisNormDocumentsByNumber(String number);

    @Query("Select * FROM legislative_normative_documents WHERE publish = :publish")
    LegisNormDocuments getLegisNormDocumentsByPublish(String publish);

    @Query("Select * FROM legislative_normative_documents WHERE datePublish = :datePublish")
    LegisNormDocuments getLegisNormDocumentsByDatePublish(String datePublish);

    @Query("Select * FROM legislative_normative_documents WHERE serial = :serial")
    LegisNormDocuments getLegisNormDocumentsBySerial(String serial);

    @Query("Select * FROM legislative_normative_documents WHERE sheets = :sheets")
    LegisNormDocuments getLegisNormDocumentsBySheets(String sheets);
}
