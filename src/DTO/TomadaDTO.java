/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ysabela
 */
public class TomadaDTO {
    private int id_tomada;
    private String nome_tomada, local_tomada;

    public int getId_tomada() {
        return id_tomada;
    }

    public void setId_tomada(int id_tomada) {
        this.id_tomada = id_tomada;
    }

    public String getNome_tomada() {
        return nome_tomada;
    }

    public void setNome_tomada(String nome_tomada) {
        this.nome_tomada = nome_tomada;
    }

    public String getLocal_tomada() {
        return local_tomada;
    }

    public void setLocal_tomada(String local_tomada) {
        this.local_tomada = local_tomada;
    }
    
}
