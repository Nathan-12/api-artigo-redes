package com.rfid.education.model.enums;

public enum TipoAtividade {
    PROTOCOLOS_DE_REDE("Protocolo"),
    MEIOS_DE_TRANSMISSAO("Meios de Transmissão");
    private String descricao;

    TipoAtividade (String valor){
        descricao = valor;
    }

    public String getDescricao(){
        return descricao;
    }
}
