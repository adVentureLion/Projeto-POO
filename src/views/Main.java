package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import controller.ControllerCliente;
import controller.ControllerProduto;
import controller.ControllerVendaCliente;
import controller.ControllerVendaProduto;
import controller.ControllerVendas;
import models.Cliente;
import models.Produto;
import models.VendaCliente;
import models.VendaProduto;

public class Main {
    public static void main(String[] args)  {
        ControllerProduto cp = new ControllerProduto();
        ControllerVendaProduto cvp = new ControllerVendaProduto();
        ControllerVendaCliente cvc = new ControllerVendaCliente();
        ControllerVendas cv = new ControllerVendas();
        cv.iniciarVendas();
        cp.iniciarProdutos();

        Produto p1 = new Produto(1, "B", 15.0, 0);
        Produto p2 = new Produto(2, "A", 15.0, 3);
        Produto p3 = new Produto(3, "D", 15.0, 3);


        cp.adicionarProdutoController(p1);
        cp.adicionarProdutoController(p2);
        cp.adicionarProdutoController(p3);

        // // cp.adicionarNoEstoque(2, 10);
        // // Produto p1 = new Produto(2, "a", 10, 5);
        // // cp.atualizarDadosProduto(p1);

        // Set<Produto> produtos = cp.listarProdutosController();
        // for (Produto produto : produtos) {
        //     System.out.println(produto);
        // }
        // System.out.println();

        // cp.excluirProduto(2);
        // cp.excluirProduto(4);
        // cp.excluirProduto(1);
        // cp.removerNoEstoque(3, 2);

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
        // System.out.println();

        // Set<Produto> produtosD = cp.listarProdutosDisponiveisController();
        // for (Produto produto : produtosD) {
        //     System.out.println(produto);
        // }


        ControllerCliente cc = new ControllerCliente();
        cc.iniciarClientes();

        Cliente c1 = new Cliente("Joao", "122.752.864-14", "25/10/1996", "F");      
        // Cliente c2 = new Cliente("Joana", "111.752.864-14", "25/10/1996", "F");      
        // Cliente c3 = new Cliente("Taiga", "156.752.864-14", "25/10/1996", "F");      
        // Cliente c4 = new Cliente("Beto", "188.752.864-14", "25/10/1996", "F");    

        // cc.adicionarClienteController(c1);
        // cc.adicionarClienteController(c2);
        // cc.adicionarClienteController(c3);
        // cc.adicionarClienteController(c4);

        // Set<Cliente> clientes = cc.listarClienteController();
        // for (Cliente cliente : clientes) {
        //     System.out.println(cliente);
        // }

        // cc.excluirCliente("Beto");
        // cc.excluirCliente("Clauido");
        // System.out.println();

        // Set<Cliente> clientes2 = cc.listarClienteController();
        // for (Cliente cliente : clientes2) {
        //     System.out.println(cliente);
        // }
        // System.out.println();
        // System.out.println("Cliente Excluidos:");

        // Set<Cliente> clientesE = cc.listarClienteExcluidosController();
        // for (Cliente cliente : clientesE) {
        //     System.out.println(cliente);
        // }





        
        List<VendaProduto> vendasDeProdutos = new ArrayList<>();
        VendaProduto vp = new VendaProduto(p2, 1);
        if((cvp.venderProdutoController(cp, vp)))
            vendasDeProdutos.add(vp);

        vp = new VendaProduto(p3, 1);
        if((cvp.venderProdutoController(cp, vp)))
            vendasDeProdutos.add(vp);
        
        VendaCliente vc = new VendaCliente(vendasDeProdutos, c1);
        cvc.calcularCompraCliente(vc);
        System.out.println(vc); 
        

        cv.adicionarVendasController(vc);
        

        cv.atualizarAqurivoVendasController();
        cc.atualizarClientesController();
        cp.atualizarProdutosController();

        Set<Produto> produtos = cp.listarProdutosController();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        List<VendaCliente> vendas = cv.listarVendasController();
        for (VendaCliente vendas2 : vendas) {
            System.out.println(vendas2);
        }

    }
}