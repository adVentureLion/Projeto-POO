package views;

import java.awt.BorderLayout;
import controller.ControllerProduto;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Cliente;
import models.Produto;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class ListarProdutosExcluidos extends JFrame {

	private JPanel contentPane;
	ControllerProduto  controle = new ControllerProduto();
	Set<Produto> produtos;
	private JTable tabela;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProdutosExcluidos frame = new ListarProdutosExcluidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarProdutosExcluidos() {
		
		
		controle.iniciarProdutos();
		produtos = controle.listarProdutosExcluidosController();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUTOS EXCLU\u00CDDOS");
		lblNewLabel.setBounds(10, 11, 664, 28);
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		tabela = new JTable();
		tabela.setBounds(10, 69, 664, 315);
		contentPane.add(tabela);
		
		JScrollPane spTab = new JScrollPane(tabela);
		spTab.setBounds(10, 69, 664, 315);
		contentPane.add(spTab);
		DefaultTableModel auxProduto = (DefaultTableModel) tabela.getModel();
		auxProduto.addColumn("NOME");
		auxProduto.addColumn("CÓDIGO");
		auxProduto.addColumn("VALOR");
		
		for(Produto listagemProd: produtos) {
			auxProduto.addRow(new String [] {listagemProd.getNome(), Integer.toString(listagemProd.getCodigo()) , Double.toString(listagemProd.getValor())});;
		}
		
		
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				
				
				
				while(auxProduto.getRowCount()>0){
					auxProduto.removeRow(0);
				}
				for(Produto listagemProd: produtos) {
					auxProduto.addRow(new String [] {listagemProd.getNome(), Integer.toString(listagemProd.getCodigo()) , Double.toString(listagemProd.getValor()), Integer.toString(listagemProd.getQtd())});;
				}
				tabela.revalidate();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		
		
	}
	}
