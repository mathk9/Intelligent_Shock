/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mathn
 */
public class TomadaDTO {
    
    private Integer idTomada;

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
    private String localTomada, nomeTomada;
}
