package com.rfid.education.service;


import java.util.List;
import java.util.Map;

public interface ArquivoService {

    List<Map<String, Object>> buscarArquivosPorAtividade(Integer id);

    List<Map<String, Object>> buscarArquivosPorAtividadeMeios(Integer id);
}
