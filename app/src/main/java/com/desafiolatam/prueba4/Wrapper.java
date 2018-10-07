package com.desafiolatam.prueba4;

public class Wrapper {
    private String version,autor,fecha;
    private Indicador utm;

    public Wrapper() {

    }

    public Indicador getUtm() {
        return utm;
    }

    public void setUtm(Indicador utm) {
        this.utm = utm;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
