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

import models.Cliente;

public class ClienteDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Clientes.txt";

    protected void cadastrarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(cliente.toString() + System.getProperty("line.separator"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void excluirDadosCliente(){
        File temp = new File(caminho);

        try (RandomAccessFile raf = new RandomAccessFile(temp, "rw")) {
            raf.setLength(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Set<Cliente> listarClientes() {
        Set<Cliente> clientes = new HashSet<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();

            while(linha != null) {
                String[] atributos = linha.split(";");
                String nome = atributos[0];
                String dataNasci = atributos[1];
                String cpf = atributos[2];
                String sexo = atributos[3];

                Cliente cliente = new Cliente(nome, dataNasci, cpf, sexo);
                clientes.add(cliente);

                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        return clientes;
    }
}
