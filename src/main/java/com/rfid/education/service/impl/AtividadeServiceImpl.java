package com.rfid.education.service.impl;

import com.rfid.education.model.Atividade;
import com.rfid.education.repository.AtividadeRepository;
import com.rfid.education.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-files}")
    private String diretorioArquivos;

    @Autowired
    private AtividadeRepository atividadeRepository;


    @Override
    public List<Atividade> listarAtividadesCadastradas(){
        return atividadeRepository.findAll();
    }

}
