package models;

import java.util.Calendar;
import java.util.List;

public class Venda {
    private List<VendaProduto> vendaProd;
    private Cliente cliente;
    private Calendar dataVenda;
    private double valorDaVenda = 0;
    
    public Venda(List<VendaProduto> vendaProd, Cliente cliente) {
        this.vendaProd = vendaProd;
        this.cliente = cliente;
        this.dataVenda = Calendar.getInstance();
    }

    public void setVendaProd(List<VendaProduto> vendaProd) {
        this.vendaProd = vendaProd;
    }
    public List<VendaProduto> getVendaProd() {
        return vendaProd;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }
    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setValorDaVenda(double valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }
    public double getValorDaVenda() {
        return valorDaVenda;
    }
    
    @Override
    public String toString() {
        String descricao = ""; 
        for (VendaProduto vendaProduto : vendaProd) {
            descricao += vendaProduto.toString();
        }
        System.out.println(descricao);
        return this.getCliente().getNome() + ";" + this.getCliente().getCpf() +
               ";" + descricao + ";" + this.getValorDaVenda() +";" + this.getDataVenda(); 
    }

}
