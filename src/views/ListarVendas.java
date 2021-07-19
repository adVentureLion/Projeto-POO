package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListarVendas extends JFrame {
	
	

	private JPanel contentPane;
	private JTable tabela;
	private JScrollPane scTab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarVendas frame = new ListarVendas();
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
	public ListarVendas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VENDAS REALIZADAS");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 664, 28);
		contentPane.add(lblNewLabel);
		
		tabela = new JTable();
		tabela.setBounds(10, 69, 664, 315);
		contentPane.add(tabela);
		
		scTab = new JScrollPane(tabela);
		scTab.setBounds(10, 69, 664, 315);
		contentPane.add(scTab);
		DefaultTableModel auxVendas = (DefaultTableModel) tabela.getModel();
		auxVendas.addColumn("CPF COMPRADOR");
		auxVendas.addColumn("VALOR VENDA");
		
		
		
		
		
		
		
		
	}

}
