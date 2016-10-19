package model;

import java.io.Serializable;

/**
 * Created by ArthurF on 03/10/16.
 */
public class Anuncio implements Comparable<Anuncio>, Serializable {

    int id;
    String nomeMorador;
    String anunciante;
    public String titles;
    String categoria;
    public String descriptions;
    int telefone;
    String email;
    String data;
    //public int images;

    public Anuncio(){

    }

    public Anuncio(int id, String nomeMorador, String anunciante, String titles, String categoria, String descriptions, int telefone, String email, String data/*,int images*/) {
        this.id = id;
        this.nomeMorador = nomeMorador;
        this.anunciante = anunciante;
        this.titles = titles;
        this.categoria = categoria;
        this.descriptions = descriptions;
        this.telefone = telefone;
        this.email = email;
        this.data = data;
        //this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

   /* public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }*/

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "id='" + id + '\''+
                "nomeMorador='" + nomeMorador + '\'' +
                ", anunciante='" + anunciante + '\'' +
                ", titles='" + titles + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", data='" + data + '\'' +
                //", images=" + images +
                '}';
    }

    @Override
    public int compareTo(Anuncio anuncio){
        if (titles.equals(anuncio.getTitles())){
            return 0;
        }
        return this.getTitles().compareTo(anuncio.getTitles());
    }

}
