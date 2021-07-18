package models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vendas {
    private String nomeCliente;
    private String cpfCliente;  
    private String produtos;
    private double valorVenda;
    private Date dataDaVenda;
    
    public Vendas(String nomeCliente, String cpfCliente, String produto, double valorVenda, String dataDaVenda) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.produtos = produto;
        this.valorVenda = valorVenda;
        try {
            this.dataDaVenda = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataDaVenda);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }
    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }
    public String getProdutos() {
        return produtos;
    }
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    public double getValorVenda() {
        return valorVenda;
    }
    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
    public Date getDataDaVenda() {
        return dataDaVenda;
    }
    


}
