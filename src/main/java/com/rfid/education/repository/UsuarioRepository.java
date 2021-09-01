package com.rfid.education.repository;

import com.rfid.education.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByNome(String nome);

    @Query("select '*' from Usuario as u where u.id = :id and u.atividade.id = :idAtividade")
    Usuario queryUser(@Param("id") Integer id, @Param("idAtividade") Integer idAtividade);
}
