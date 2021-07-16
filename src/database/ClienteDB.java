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
    
    
    private static Set<Cliente> clientes = new HashSet<>();
    private static Set<Cliente> clientesExcluidos = new HashSet<>();

    public static void setClientes(Set<Cliente> clientes) {
        ClienteDB.clientes = clientes;
    }
    public static Set<Cliente> getClientes() {
        return clientes;
    }
    
    public static void setClientesExcluidos(Set<Cliente> clientesExcluidos) {
        ClienteDB.clientesExcluidos = clientesExcluidos;
    }
    public static Set<Cliente> getClientesExcluidos() {
        return clientesExcluidos;
    }

    public static void atualizarArquivoCliente() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeInt(ClienteDB.clientes.size());
            Iterator<Cliente> cIterator = ClienteDB.clientes.iterator();
            while(cIterator.hasNext()) {
                oos.writeObject(cIterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void atualizarArquivoClienteExcluidos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cClientesExcluidos))) {
            oos.writeInt(ClienteDB.clientesExcluidos.size());
            Iterator<Cliente> cIterator = ClienteDB.clientesExcluidos.iterator();
            while(cIterator.hasNext()) {
                oos.writeObject(cIterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Set<Cliente> listarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            if(caminho.isEmpty())
                return ClienteDB.clientes;
            else {
                int num = ois.readInt();
                for(int i = 0; i < num; i++) {
                    ClienteDB.clientes.add((Cliente) ois.readObject());
                }  
            }
        } catch (IOException e) {
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return ClienteDB.clientes;
    }

    protected static Set<Cliente> listarClientesExcluidos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cClientesExcluidos))) {
            if(cClientesExcluidos.isEmpty())
                return ClienteDB.clientesExcluidos;
            else {
                int num = ois.readInt();
                for(int i = 0; i < num; i++) {
                    ClienteDB.clientesExcluidos.add((Cliente) ois.readObject());
                }
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ClienteDB.clientesExcluidos;
    }
}
