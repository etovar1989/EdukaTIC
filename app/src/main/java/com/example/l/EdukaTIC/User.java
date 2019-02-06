package com.example.l.EdukaTIC;

public class User {
    private static  String user,pws,names,lastN, d1m, idU, perfil;


    public  String getIdU() {
        return idU;
    }

    public  void setIdU(String idU) {
        User.idU = idU;
    }

    public  String getPerfil() {
        return perfil;
    }

    public  void setPerfil(String perfil) {
        User.perfil = perfil;
    }


    public  String getD1m() {
        return d1m;
    }

    public void setD1m(String d1m) {
        this.d1m = d1m;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastN() {
        return lastN;
    }

    public void setLastN(String lastN) {
        this.lastN = lastN;
    }



}
