package com.rfid.education.service.impl;

import com.rfid.education.repository.ArquivoRepository;
import com.rfid.education.repository.AtividadeRepository;
import com.rfid.education.repository.TramissaoRepository;
import com.rfid.education.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-files}")
    private String diretorioArquivos;

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private TramissaoRepository tramissaoRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Override
    public List<Map<String, Object>> buscarArquivosPorAtividade(Integer id){
        return this.arquivoRepository.findAllArquivosPorAtividade(id);
    }

    @Override
    public List<Map<String, Object>> buscarArquivosPorAtividadeMeios(Integer id){
        return this.tramissaoRepository.findAllArquivosPorAtividadeMeios(id);
    }

    public String analisar(String caminho)
    {
        //cria um objeto file para o caminho especificado pelo usuario
        File nome = new File (raiz);

        //se o nome existir e for diretorio , gera informações
        if (nome.exists() && nome.isDirectory())
        {
            //recebe a lista do nome dos arquivos
            String arquivos [] = nome.list();

            for (String item : arquivos){
                System.out.printf("%s\n",item);

            }
        }
        else 	System.out.printf("%s\n" , "Nao encontrado");
        return caminho;
    }

}
