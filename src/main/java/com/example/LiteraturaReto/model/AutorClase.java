package com.example.LiteraturaReto.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class AutorClase {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY) //autoincrementado el id
    private int id;

    private String nombre;

    private int fechaCumpleanos;

    private int fechaMuerte;

    @ManyToOne
    private LibroClase libroClase;


    public AutorClase(Autor autor){
        this.nombre = autor.nombre();
        this.fechaCumpleanos = autor.fechaCumpleaños();
        this.fechaMuerte = autor.fechaMuerte();

    }

    public AutorClase() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFechaCumpleanos() {
        return fechaCumpleanos;
    }

    public void setFechaCumpleanos(int fechaCumpleanos) {
        this.fechaCumpleanos = fechaCumpleanos;
    }

    public int getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(int fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLibroClase(LibroClase libroClase) {
        this.libroClase = libroClase;

    }

    public LibroClase getLibroClase() {
        return libroClase;
    }

    @Override
    public String toString() {
        return "AutorClase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaCumpleanos=" + fechaCumpleanos +
                ", fechaMuerte=" + fechaMuerte +
                '}';
    }


}
