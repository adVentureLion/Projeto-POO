package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class ProdutoDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Produtos.txt";

    public void adicionarProduto(Produto produto){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))){            
            bw.write(produto.toStringW());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            
            while(linha != null) {
                String[] atributos = linha.split(";");
                Integer cod = Integer.parseInt(atributos[0]);
                String nome = atributos[1];
                Double valor = Double.parseDouble(atributos[2]);
                Integer qtd = Integer.parseInt(atributos[3]);

                Produto prod = new Produto(cod, nome, valor, qtd);
                produtos.add(prod);
                linha = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return produtos;
    }
}
