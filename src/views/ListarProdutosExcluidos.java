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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 384, 664, -325);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("PRODUTOS EXCLU\u00CDDOS");
		lblNewLabel.setBounds(10, 11, 664, 28);
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "VALOR", "QUANTIDADE EXCLU\u00CDDA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(2).setPreferredWidth(133);
		tabela.setFont(new Font("Century", Font.PLAIN, 12));
		tabela.setBounds(10, 383, 664, -312);
		scrollPane.setViewportView(tabela);
		
		
		
		
		
		
		
	}

	}


