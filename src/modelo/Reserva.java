package modelo;

import java.util.Objects;

public class Reserva {

    private int codigo_reserva;
    private String fecha_reserva ;
    private int duracion;
    private int hora;
    private String motivo;
    private int id_espacio;

    public Reserva(int codigo_reserva, String fecha_reserva, int duracion, int hora, String motivo, int id_espacio) {
        this.codigo_reserva = codigo_reserva;
        this.fecha_reserva = fecha_reserva;
        this.duracion = duracion;
        this.hora = hora;
        this.motivo = motivo;
        this.id_espacio = id_espacio;
    }

    public int getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(int codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(int id_espacio) {
        this.id_espacio = id_espacio;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%d,%d,%s,%d", codigo_reserva,fecha_reserva,duracion,hora,motivo,id_espacio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return codigo_reserva == reserva.codigo_reserva;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_reserva);
    }
}
