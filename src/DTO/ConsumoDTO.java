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
public class ConsumoDTO {
    private int id_consumo, id_usuario, id_tomada;

    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tomada() {
        return id_tomada;
    }

    public void setId_tomada(int id_tomada) {
        this.id_tomada = id_tomada;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }
    private Double tarifa, potencia;
    
}