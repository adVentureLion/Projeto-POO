package models;




public class Cliente {
    private String nome;
    private String dataNasci;
    private String cpf;
    private String sexo; 

    public Cliente(String nome, String dataNasci, String cpf, String sexo) {
        this.nome = nome;
        this.dataNasci = dataNasci;
        this.cpf = cpf;
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

    public String toStringW() {
        return this.nome+";"+
               this.cpf+";"+     
               this.sexo+";"+     
               this.dataNasci;     
    }
    
    public String toString() {
        return this.nome+" "+
               this.cpf+" "+     
               this.sexo+" "+     
               this.dataNasci;     
    }

}
