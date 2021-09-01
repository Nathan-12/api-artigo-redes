package com.rfid.education.controller;

import com.rfid.education.model.Atividade;
import com.rfid.education.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Atividade>> listarAtividades(){
        List<Atividade> atividades = atividadeService.listarAtividadesCadastradas();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

}
