package com.example.l.EdukaTIC;

public class Model {
    String nombreMonitor;
    String solicitudMonitor;
    String idP;



    public Model(String nombreMonitor, String solicitudMonitor, String idP) {
        this.nombreMonitor = nombreMonitor;
        this.solicitudMonitor = solicitudMonitor;
        this.idP = idP;
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
