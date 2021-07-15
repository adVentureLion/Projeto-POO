package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import models.Produto;

public class ProdutoDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Produtos.txt";

    private static Set<Produto> produtos = new HashSet<>();

    protected static void setProdutos(Set<Produto> produtos) {
        ProdutoDB.produtos = produtos;
    }
    protected static Set<Produto> getProdutos() {
        return produtos;
    }

    public static void atualizarAqurivoProdutos(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeInt(ProdutoDB.produtos.size());
            Iterator<Produto> pIterator = ProdutoDB.produtos.iterator();
            while(pIterator.hasNext()) 
                oos.writeObject(pIterator.next());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected static Set<Produto> listarProdutos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            if(caminho.isEmpty())
                return ProdutoDB.produtos;
            else {
                int num = ois.readInt();
                for(int i = 0; i < num; i++) {
                    ProdutoDB.produtos.add((Produto) ois.readObject());
                }  
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }    
        return ProdutoDB.produtos;
    }
}
