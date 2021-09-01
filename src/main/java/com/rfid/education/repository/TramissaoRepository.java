package com.rfid.education.repository;

import com.rfid.education.model.Transmissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface TramissaoRepository extends JpaRepository<Transmissao, Integer> {

    @Query("SELECT tr.nome AS nome, tr.codigo AS codigo, tr.id AS id FROM Transmissao tr, Atividade t LEFT JOIN t.transmissaos d WHERE t.id = :id AND d.id = tr.id")
    List<Map<String, Object>> findAllArquivosPorAtividadeMeios(@Param("id") Integer id);
}
