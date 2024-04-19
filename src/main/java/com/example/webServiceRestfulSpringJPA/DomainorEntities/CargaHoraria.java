package com.example.webServiceRestfulSpringJPA.DomainorEntities;

public enum CargaHoraria {
     VINTE_HORAS("20H"),
    TRINTA_HORAS("30H"),
    OITENTA_HORAS("60H");

    private String valor; 

    CargaHoraria(String valor){
        this.valor = valor;

    }

    public String getValor(){
        return this.valor;
    }

}
