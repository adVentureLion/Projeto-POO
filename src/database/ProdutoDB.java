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

    private static final String cProdExcluido = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "ProdutosExcluidos.txt";

    private static Set<Produto> produtos = new HashSet<>();
    private static Set<Produto> produtosExcluidos = new HashSet<>();

    
    public static void setProdutosExcluidos(Set<Produto> produtosExcluidos) {
        ProdutoDB.produtosExcluidos = produtosExcluidos;
    }
    protected static Set<Produto> getProdutos() {
        return produtos;
    }

    protected static void setProdutos(Set<Produto> produtos) {
        ProdutoDB.produtos = produtos;
    }
    public static Set<Produto> getProdutosExcluidos() {
        return produtosExcluidos;
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
    
    public static void atualizarAqurivoProdutosExcluidos(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cProdExcluido))) {
            oos.writeInt(ProdutoDB.produtosExcluidos.size());
            Iterator<Produto> pIterator = ProdutoDB.produtosExcluidos.iterator();
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

    protected static Set<Produto> listarProdutosExcluidos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cProdExcluido))) {
            if(cProdExcluido.isEmpty())
                return ProdutoDB.produtosExcluidos;
            else {
                int num = ois.readInt();
                for(int i = 0; i < num; i++) {
                    ProdutoDB.produtosExcluidos.add((Produto) ois.readObject());
                } 
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }    
        return ProdutoDB.produtosExcluidos;
    }
}
