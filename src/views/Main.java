package views;

import java.util.Set;

import controller.ControleCliente;
import controller.ControleProduto;
import models.Cliente;
import models.Produto;

public class Main {
    public static void main(String[] args)  {
        // ControleProduto cp = new ControleProduto();
        // cp.iniciarProdutos();

        // // Produto p1 = new Produto(4, "b", 15.0, 3);
        // // Produto p2 = new Produto(5, "c", 15.0, 3);
        // // Produto p3 = new Produto(6, "f", 15.0, 3);


        // // cp.adicionarProdutoController(p1);
        // // cp.adicionarProdutoController(p2);
        // // cp.adicionarProdutoController(p3);

        // cp.adicionarNoEstoque(2, 10);
        // Produto p1 = new Produto(2, "a", 10, 5);
        // cp.atualizarDadosProduto(p1);

        // Set<Produto> produtos = cp.listarProdutosController();
        // for (Produto produto : produtos) {
        //     System.out.println(produto);
        // }
        // cp.atualizarProdutos();

        ControleCliente cc = new ControleCliente();
        cc.iniciarClientes();

        Cliente c1 = new Cliente("Vera", "144.752.864-14", "25/10/1996", "F");      
        Cliente c2 = new Cliente("Clauido", "124.752.864-14", "25/10/1996", "F");      
        Cliente c3 = new Cliente("Turan", "134.752.864-14", "25/10/1996", "F");      
        Cliente c4 = new Cliente("FF", "154.752.864-14", "25/10/1996", "F");    

        cc.adicionarClienteController(c1);
        cc.adicionarClienteController(c2);
        cc.adicionarClienteController(c3);
        cc.adicionarClienteController(c4);

        Set<Cliente> clientes = cc.listarClienteController();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        cc.atualizarClientes();
        }
}
