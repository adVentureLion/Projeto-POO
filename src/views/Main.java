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

        // Produto p1 = new Produto(4, "T", 15.0, 0);
        // Produto p2 = new Produto(5, "c", 15.0, 3);
        // Produto p3 = new Produto(6, "f", 15.0, 3);


        // cp.adicionarProdutoController(p1);
        // cp.adicionarProdutoController(p2);
        // cp.adicionarProdutoController(p3);

        // cp.adicionarNoEstoque(2, 10);
        // Produto p1 = new Produto(2, "a", 10, 5);
        // cp.atualizarDadosProduto(p1);

        // Set<Produto> produtos = cp.listarProdutosController();
        // for (Produto produto : produtos) {
        //     System.out.println(produto);
        // }
        // System.out.println();

        // cp.excluirProduto(2);
        // cp.excluirProduto(4);
        // cp.excluirProduto(1);

        // Set<Produto> produtos2 = cp.listarProdutosController();
        // for (Produto produto : produtos2) {
        //     System.out.println(produto);
        // }
        // System.out.println();

        // System.out.println("Produtos Excluios:");
        // Set<Produto> produtosExcluidos = cp.listarProdutosExcluidosController();
        // for (Produto produto : produtosExcluidos) {
        //     System.out.println(produto);
        // }

        // Set<Produto> produtosD = cp.listarProdutosDisponiveisController();
        // for (Produto produto : produtosD) {
        //     System.out.println(produto);
        // }

        // cp.atualizarProdutos();

        ControleCliente cc = new ControleCliente();
        cc.iniciarClientes();

        Cliente c1 = new Cliente("Vera", "144.752.864-14", "25/10/1996", "F");      
        // Cliente c2 = new Cliente("Clauido", "124.752.864-14", "25/10/1996", "F");      
        Cliente c3 = new Cliente("Turan", "134.752.864-14", "25/10/1996", "F");      
        Cliente c4 = new Cliente("FF", "154.752.864-14", "25/10/1996", "F");    

        cc.adicionarClienteController(c1);
        // cc.adicionarClienteController(c2);
        cc.adicionarClienteController(c3);
        cc.adicionarClienteController(c4);

        Set<Cliente> clientes = cc.listarClienteController();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        cc.excluirCliente("FF");
        cc.excluirCliente("Vera");
        System.out.println();

        Set<Cliente> clientes2 = cc.listarClienteController();
        for (Cliente cliente : clientes2) {
            System.out.println(cliente);
        }
        System.out.println();
        System.out.println("Cliente Excluidos:");

        Set<Cliente> clientesE = cc.listarClienteExcluidosController();
        for (Cliente cliente : clientesE) {
            System.out.println(cliente);
        }


        cc.atualizarClientes();
    }
}
