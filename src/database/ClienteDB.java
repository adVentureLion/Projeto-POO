package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import models.Cliente;

public class ClienteDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Clientes.txt";

    private static final String cClientesExcluidos = "src" + System.getProperty("file.separator")+ "arquivos" +
                                                System.getProperty("file.separator") + "ClientesExcluidos.txt";                                    
    
    
   
    public static void atualizarArquivoCliente(Set<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeInt(clientes.size());
            Iterator<Cliente> cIterator = clientes.iterator();
            while(cIterator.hasNext()) {
                oos.writeObject(cIterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void atualizarArquivoClienteExcluidos(Set<Cliente> clientesExcluidos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cClientesExcluidos))) {
            oos.writeInt(clientesExcluidos.size());
            Iterator<Cliente> cIterator = clientesExcluidos.iterator();
            while(cIterator.hasNext()) {
                oos.writeObject(cIterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Set<Cliente> listarClientes() {
        Set<Cliente> clientes = new HashSet<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            if(caminho.isEmpty())
                return clientes;
            else {
                int num = ois.readInt();
                for(int i = 0; i < num; i++) {
                    clientes.add((Cliente) ois.readObject());
                }  
            }
        } catch (IOException e) {
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return clientes;
    }

    protected static Set<Cliente> listarClientesExcluidos() {
        Set<Cliente> clientesExcluidos = new HashSet<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cClientesExcluidos))) {
            if(cClientesExcluidos.isEmpty())
                return clientesExcluidos;
            else {
                int num = ois.readInt();
                for(int i = 0; i < num; i++) {
                    clientesExcluidos.add((Cliente) ois.readObject());
                }
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientesExcluidos;
    }
}
