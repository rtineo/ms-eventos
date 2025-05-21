package com.ms.eventos.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table (name = "eventos")


public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Date fechaEvento;
    private String ubicacion;
    private int capacidad;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Date getFechaEvento(){
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento){
        this.fechaEvento = fechaEvento;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
}
