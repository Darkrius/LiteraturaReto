package com.example.LiteraturaReto.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table ( name = "libros")
public class LibroClase {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY) //autoincrementado el id
    private int id;


    private int idLibro;

    @Column(unique = true)
    private String titulo;

    @OneToMany(mappedBy = "libroClase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AutorClase> autorClases;


    public LibroClase(Libro libro){
        this.idLibro = libro.idLibro();
        this.idLibro = libro.idLibro();
        this.titulo = libro.titulo();
    }

    public LibroClase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorClase> getAutorClases() {
        return autorClases;
    }

    public void setAutorClases(List<AutorClase> autorClases) {
        autorClases.forEach(e ->e.setLibroClase(this));
        this.autorClases = autorClases;
    }
    @Override
    public String toString() {
        return "LibroClase{" +
                "id=" + id +
                ", idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autorClases=" + autorClases +
                '}';
    }


}
