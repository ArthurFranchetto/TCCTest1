package model;

/**
 * Created by ArthurF on 08/10/16.
 */
public class ListaDeConvidados {


    int id, id_locacao;
    String nome, data;

    public ListaDeConvidados(){

    }

    public ListaDeConvidados(int id, int id_locacao, String nome, String data){
        this.id = id;
        this.id_locacao = id_locacao;
        this.nome = nome;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}
