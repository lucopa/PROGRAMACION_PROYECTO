package modelo;

import java.util.Objects;

public class Espacio {
    private int id_espacio;
    private String descripcion;
    private int capacidad;
    private int ordenadores;
    private int pizarra;
    private int proyector;
    private int nombre;
    private int codigo_reserva;

    public Espacio(int id_espacio, String descripcion, int capacidad, int ordenadores, int pizarra, int proyector, int nombre, int codigo_reserva) {
        this.id_espacio = id_espacio;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.ordenadores = ordenadores;
        this.pizarra = pizarra;
        this.proyector = proyector;
        this.nombre = nombre;
        this.codigo_reserva = codigo_reserva;
    }

    public int getId_espacio() {
        return id_espacio;
    }

    public void setEspacio(int id_espacio) {
        this.id_espacio = id_espacio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getOrdenadores() {
        return ordenadores;
    }

    public void setOrdenadores(int ordenadores) {
        this.ordenadores = ordenadores;
    }

    public int getPizarra() {
        return pizarra;
    }

    public void setPizarra(int pizarra) {
        this.pizarra = pizarra;
    }

    public int getProyector() {
        return proyector;
    }

    public void setProyector(int proyector) {
        this.proyector = proyector;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(int codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%d,%d,%d,%d,%d", id_espacio,descripcion,capacidad,ordenadores,pizarra,proyector,nombre,codigo_reserva);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Espacio espacio = (Espacio) o;
        return id_espacio == espacio.id_espacio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_espacio);
    }
}
