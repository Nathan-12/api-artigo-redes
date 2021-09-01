package com.rfid.education.controller;

import com.rfid.education.model.Atividade;
import com.rfid.education.model.Usuario;
import com.rfid.education.repository.AtividadeRepository;
import com.rfid.education.repository.UsuarioRepository;
import com.rfid.education.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("exibir/{id}")
    public ResponseEntity<List<Map<String, Object>>> listarArquivosPorAtividade(@PathVariable Integer id) {
        List<Map<String, Object>> arquivos = this.arquivoService.buscarArquivosPorAtividade(id);
        return new ResponseEntity<>(arquivos, HttpStatus.OK);
    }

    @GetMapping("exibir/meios/{id}")
    public ResponseEntity<List<Map<String, Object>>> listarArquivosPorAtividadeMeios(@PathVariable Integer id) {
        List<Map<String, Object>> arquivos = this.arquivoService.buscarArquivosPorAtividadeMeios(id);
        return new ResponseEntity<>(arquivos, HttpStatus.OK);
    }

    @PostMapping("/{name}/{idAtividade}")
    public Usuario adicionarUsuario(
            @PathVariable("name") String name,
            @PathVariable("idAtividade") Integer idAtividade) {
        Atividade atividade = atividadeRepository.findById(idAtividade).get();
        Usuario novo = new Usuario();
        novo.setNome(name);
        novo.setAtividade(atividade);
        return usuarioRepository.save(novo);
    }

    @PostMapping("/meios/{name}/{idAtividade}")
    public Usuario adicionarUsuarioMeios(
            @PathVariable("name") String name,
            @PathVariable("idAtividade") Integer idAtividade) {
        Atividade atividade = atividadeRepository.findById(idAtividade).get();
        Usuario novo = new Usuario();
        novo.setNome(name);
        novo.setAtividade(atividade);
        return usuarioRepository.save(novo);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable("id") Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @GetMapping("/name/{nome}")
    public Usuario buscarUsuarioByName(
            @PathVariable("nome") String nome) {
        return usuarioRepository.findUsuarioByNome(nome);
    }

    @PutMapping("/{id}/{pontuacao}")
    public Usuario editarUsuario(@PathVariable("id") Integer id, @PathVariable("pontuacao") Long pontuacao) {
        Usuario userEdit = usuarioRepository.getById(id);
        userEdit.setPontuacao(pontuacao);
        return usuarioRepository.save(userEdit);
    }
}
