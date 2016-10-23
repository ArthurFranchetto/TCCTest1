package model;

import java.io.Serializable;

/**
 * Created by ArthurF on 18/10/16.
 */
public class Reuniao implements Comparable<Reuniao>, Serializable {

    public int id;
    public String titulo;
    public String pauta;
    public String dataI;
    public String dataF;
    public String status;
    public static final String NAO_ENCONTRADA = "Não encontrada";

    public Reuniao(){

    }

    public Reuniao(int id, String titulo, String pauta, String dataI, String dataF, String status) {
        this.id = id;
        this.titulo = titulo;
        this.pauta = pauta;
        this.dataI = dataI;
        this.dataF = dataF;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getDataI() {
        return dataI;
    }

    public void setDataI(String dataI) {
        this.dataI = dataI;
    }

    public String getDataF() {
        return dataF;
    }

    public void setDataF(String dataF) {
        this.dataF = dataF;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reunião{" +
                "dataF='" + dataF + '\'' +
                ", dataI='" + dataI + '\'' +
                ", status='" + status + '\'' +
                ", pauta='" + pauta + '\'' +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Reuniao reuniao){
        if (titulo.equals(reuniao.getTitulo())){
            return 0;
        }
        return this.getTitulo().compareTo(reuniao.getTitulo());
    }


}
