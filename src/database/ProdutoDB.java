package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

import models.Produto;

public class ProdutoDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Produtos.txt";

    protected void cadastrarProduto(Produto produto){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))){            
            bw.write(produto.toString() + System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void excluirDadosProdutos() {
        File temp = new File(caminho);
        
        if (temp.exists()) {
            try (RandomAccessFile raf = new RandomAccessFile(temp, "rw")) {
                raf.setLength(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    protected Set<Produto> listarProdutos() {
        Set<Produto> produtos = new HashSet<>();

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
