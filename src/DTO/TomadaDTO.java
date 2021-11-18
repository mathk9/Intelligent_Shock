/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
<<<<<<< HEAD
 * @author mathn
 */
public class TomadaDTO {
    
    private Integer idTomada;
    private String localTomada, nomeTomada;
    
    public TomadaDTO() {}

    public TomadaDTO(Integer idTomada, String nomeTomada, String localTomada) {
        this.idTomada = idTomada;
        this.localTomada = localTomada;
        this.nomeTomada = nomeTomada;
    }    

    public Integer getIdTomada() {
        return idTomada;
    }

    public void setIdTomada(Integer idTomada) {
        this.idTomada = idTomada;
    }

    public String getLocalTomada() {
        return localTomada;
    }

    public void setLocalTomada(String localTomada) {
        this.localTomada = localTomada;
    }

    public String getNomeTomada() {
        return nomeTomada;
    }

    public void setNomeTomada(String nomeTomada) {
        this.nomeTomada = nomeTomada;
    }
    
}