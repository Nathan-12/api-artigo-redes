package com.rfid.education.model;

import com.rfid.education.model.enums.TipoAtividade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Arquivo> arquivos;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Transmissao> transmissaos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public List<Transmissao> getTransmissaos() {
        return transmissaos;
    }

    public void setTransmissaos(List<Transmissao> transmissaos) {
        this.transmissaos = transmissaos;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
}
