package model;

import java.io.Serializable;

/**
 * Created by ArthurF on 20/10/16.
 */
public class Ocorrencia implements Comparable<Ocorrencia>, Serializable {

    public int id;
    public String email, descricao , tipoOcorrencia, assunto, data;

    public Ocorrencia(){

    }

    public Ocorrencia(int id, String email, String descricao, String tipoOcorrencia, String assunto, String data) {
        this.id = id;
        this.email = email;
        this.descricao = descricao;
        this.tipoOcorrencia = tipoOcorrencia;
        this.assunto = assunto;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ocorrencia{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipoOcorrencia='" + tipoOcorrencia + '\'' +
                ", assunto='" + assunto + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public int compareTo(Ocorrencia ocorrencia){
        if (email.equals(ocorrencia.getEmail())){
            return 0;
        }
        return this.getEmail().compareTo(ocorrencia.getEmail());
    }
}

