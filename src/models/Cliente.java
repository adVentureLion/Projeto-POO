package models;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nome;
    private String cpf;
    private String dataNasci;
    private String sexo; 

    public Cliente(String nome, String cpf, String dataNasci, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasci = dataNasci;
        this.sexo = sexo;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    
    public void setDataNasci(String dataNasci) {
        this.dataNasci = dataNasci;
    }
    public String getDataNasci() {
        return dataNasci;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSexo() {
        return sexo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;

        Cliente cliente = (Cliente) obj; 
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cpf);
    }

    @Override
    public String toString() {
        return this.nome+";"+
               this.cpf+";"+     
               this.sexo+";"+     
               this.dataNasci;     
    }
}
