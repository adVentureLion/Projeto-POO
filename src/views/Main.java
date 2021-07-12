package views;

import java.util.List;

import controller.ControleCliente;
import controller.ControleProduto;
import models.Cliente;
import models.Produto;

public class Main {
    public static void main(String[] args)  {
        Produto bico = new Produto(0,"Bico",20.00,15);
        Cliente Vera = new Cliente("Vera", "459.257.841-74");

        ControleProduto ctrlProduto = new ControleProduto();
        ControleCliente ctrlCliente = new ControleCliente();

        ctrlProduto.adicionarProdutoController(bico);
        ctrlCliente.adicionarCliente(Vera);
        

        
        List<Produto> produtos = ctrlProduto.listarProdutosController();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        
        List<Cliente> clientes = ctrlCliente.listarClienteController();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    
        
    }
}
