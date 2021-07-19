package models;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class VendaCliente {
    private List<VendaProduto> vendaProd;
    private Cliente cliente;
    private SimpleDateFormat dataFormtada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private GregorianCalendar dataVenda;
    private double valorDaVenda = 0;
    
    public VendaCliente(List<VendaProduto> vendaProd, Cliente cliente) {
        this.vendaProd = vendaProd;
        this.cliente = cliente;
        this.dataVenda = new GregorianCalendar();
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

    public void setDataVenda(GregorianCalendar dataVenda) {
        this.dataVenda = dataVenda;
    }
    public GregorianCalendar getDataVenda() {
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
        return this.getCliente().salvarNaVendaClie() +";" + this.getVendaProd() + ";" + this.getValorDaVenda() +";" + this.dataFormtada.format(dataVenda.getTimeInMillis()); 
    }

}
