package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import models.VendaCliente;
import models.Vendas;

public class VendasDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Vendas.txt";

    
    protected static void atualizarAqurivoVendas(List<VendaCliente> vendas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (int i = 0; i < vendas.size(); i++) {
                bw.write(vendas.toString() + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static List<Vendas> listarVendas() {
        List<Vendas> vendas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            while(linha != null) {
                String[] atributos = linha.split(";");
                String nomeCliente = atributos[0];
                String cpfCliente = atributos[1];
                String produtos = atributos[2];
                Double valorVenda = Double.parseDouble(atributos[3]);
                String dataDaVenda = atributos[4];
                Vendas vendaFeita = new Vendas(nomeCliente, cpfCliente, produtos, valorVenda,
                                    dataDaVenda);
                vendas.add(vendaFeita);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return vendas;
    }
}
