package ar.edu.utn.frsf.isi.dam.guiavanzado;

/**
 * Created by mdominguez on 05/10/17.
 */

public class Plato {
    private Integer id;
    private String titulo;
    private String descripcion;
    private Double precio;

    public Plato(String titulo, String descripcion, Double precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Plato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
