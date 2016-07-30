package Model;

import java.util.Date;

/**
 * Created by ArthurF on 27/07/16.
 */
public class Morador {

    String nome;
    String dataNascimento;
    String email;
    int nApartamento;


    public Morador(){

    }

    public Morador(String nome, String dataNascimento, String email, int nApartamento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nApartamento = nApartamento;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public int getnApartamento() {
        return nApartamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setnApartamento(int nApartamento) {
        this.nApartamento = nApartamento;
    }
}
