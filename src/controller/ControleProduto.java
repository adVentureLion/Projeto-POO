package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;




public class ControleProduto {
    private File file = new File((System.getProperty("user.dir")) + "\\src\\controller\\arquivos\\Estoque.txt");


    public void addEstoque() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha = br.readLine();
            linha = br.readLine();
        } catch (IOException e) {
            
        }
    }
}
