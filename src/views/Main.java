package views;

import java.io.IOException;
import java.util.List;

import controller.ControleProduto;
import models.Produtos;

public class Main {
    public static void main(String[] args) throws IOException {
        //Produtos vela = new Produtos("Vela", 25.00);
        ControleProduto controller = new ControleProduto();

        //controller.salvarProdutoController(vela);
        
        List<Produtos> produtos = controller.listarProdutosController();
        for (Produtos produto : produtos) {
            System.out.println(produto.getNome());
        }
        
            
            
    
        
    }
}
