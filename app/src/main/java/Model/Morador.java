package model;

import java.io.Serializable;

/**
 * Created by ArthurF on 27/07/16.
 */
public class Morador implements Comparable<Morador>, Serializable{

    String nome;
    String dataNascimento;
    String email;
    int nApartamento;
    public static final String NAO_ENCONTRADO = "Não encontrado.";


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

    public String toString(){
        return "nome=" + nome + '\'' +
         "dataNascimento=" + dataNascimento + '\'' +
         "email=" + email + '\'' +
         "apartamento=" + nApartamento + '\'' +
                '}';
    }

    @Override
    public int compareTo(Morador morador){
        if (email.equals(morador.getEmail())){
            return 0;
        }
        return this.getEmail().compareTo(morador.getEmail());
    }

}
