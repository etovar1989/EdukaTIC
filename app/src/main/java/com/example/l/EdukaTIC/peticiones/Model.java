package com.example.l.EdukaTIC.peticiones;

public class Model {
    String nombreMonitor;
    String solicitudMonitor;
    String idP;
    String estado;
    String nota;
    int imagen;
    String hora;




    public Model(String nombreMonitor, String solicitudMonitor, String idP, String estado, String nota,int imagen, String hora) {
        this.nombreMonitor = nombreMonitor;
        this.solicitudMonitor = solicitudMonitor;
        this.idP = idP;
        this.estado = estado;
        this.nota = nota;
        this.imagen = imagen;
        this.hora = hora;

    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreMonitor() {
        return nombreMonitor;
    }

    public void setNombreMonitor(String nombreMonitor) {
        this.nombreMonitor = nombreMonitor;
    }

    public String getSolicitudMonitor() {
        return solicitudMonitor;
    }

    public void setSolicitudMonitor(String solicitudMonitor) {
        this.solicitudMonitor = solicitudMonitor;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }
}
