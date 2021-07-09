package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import models.Produtos;

public class ProdutoEscritaLeitura {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Produtos.txt";

    public void salvarProduto(Produtos produto){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho));) {
            oos.writeObject(produto);
            
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    public List<Produtos> listarProdutos() {
        List<Produtos> produtos = new ArrayList<Produtos>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            int qtdObjeto = ois.readInt();
            for(int i = 0; i < qtdObjeto; i++);
                produtos.add((Produtos) ois.readObject());
        
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
