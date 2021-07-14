package views;

import java.util.Set;

import controller.ControleCliente;
import models.Cliente;


public class Main {
    public static void main(String[] args)  {
        Cliente c1 = new Cliente("Vera", "447.252.956-42");
        Cliente c2 = new Cliente("Carla", "427.252.956-42");
        Cliente c3 = new Cliente("Lucio", "437.252.956-42");
        Cliente c4 = new Cliente("Ribamar", "441.252.956-42");
        Cliente c5 = new Cliente("Ribas", "411.252.956-42");

        ControleCliente cc = new ControleCliente();

        if(cc.adicionarClienteController(c1)){
            System.out.println("Produto cadastrado com sucesso!");
        }
        else
            System.out.println("Código Invalido");
       
        if(cc.adicionarClienteController(c2)){
            System.out.println("Produto cadastrado com sucesso!");
        }
        else
            System.out.println("Código Invalido");
        if(cc.adicionarClienteController(c3)){
            System.out.println("Produto cadastrado com sucesso!");
        }
        else
            System.out.println("Código Invalido");
        if(cc.adicionarClienteController(c4)){
            System.out.println("Produto cadastrado com sucesso!");
        }
        else
            System.out.println("Código Invalido");

        Set<Cliente> clientes = cc.listarClienteController();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        
        cc.excluirCliente("Lucio");
        if(cc.adicionarClienteController(c5)){
            System.out.println("Produto cadastrado com sucesso!");
        }
        else
            System.out.println("Código Invalido");
    }
}
