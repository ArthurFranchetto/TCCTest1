package model;

/**
 * Created by ArthurF on 08/10/16.
 */
public class DescricaoAnuncio {

    int id;
    String morador, data, descricao, tipo;

    public DescricaoAnuncio(){

    }

    public DescricaoAnuncio(int id, String morador, String data, String descricao, String tipo){
        this.id = id;
        this.morador = morador;
        this.data = data;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
