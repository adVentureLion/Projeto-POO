package views;

import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
public class TelaPrincipal {

	private JFrame frmProjeto;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmProjeto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList produtos = new ArrayList();
		ArrayList quantidade = new ArrayList();
		
	
		frmProjeto = new JFrame();
		frmProjeto.getContentPane().setBackground(Color.WHITE);
		frmProjeto.setTitle("Projeto");
		frmProjeto.setBounds(100, 100, 364, 644);
		frmProjeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjeto.getContentPane().setLayout(null);
		
		JLabel lnlNomeProduto = new JLabel("Produto");
		lnlNomeProduto.setFont(new Font("Century", Font.PLAIN, 16));
		lnlNomeProduto.setBounds(12, 28, 71, 33);
		frmProjeto.getContentPane().add(lnlNomeProduto);
	
		tabela = new JTable();
		DefaultTableModel val = (DefaultTableModel) tabela.getModel();
		val.addColumn("PRODUTO");
		val.addColumn("Quantidade");
		tabela.setBackground(Color.WHITE);
		tabela.setForeground(Color.BLACK);
		tabela.setFont(new Font("Century", Font.PLAIN, 12));
		tabela.setBounds(39, 91, 266, 435);
		frmProjeto.getContentPane().add(tabela);
		
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(12, 129, 330, 387);
		frmProjeto.getContentPane().add(scrollPane);
		
		JComboBox BoxP = new JComboBox();
		BoxP.setFont(new Font("Century", Font.PLAIN, 12));
		BoxP.setModel(new DefaultComboBoxModel(new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i"}));
		BoxP.setBounds(95, 34, 247, 22);
		frmProjeto.getContentPane().add(BoxP);
		
		JButton btnNewButton = new JButton("ADICIONAR");
		btnNewButton.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/util/beaker-plus (1).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a = BoxP.getSelectedItem().toString();
					val.addRow(new String[] {a, "1"});
				}
				catch (ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(null, "NENHUM PRODUTO SELECIONADO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				} 
				
				
			}
		});
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 12));
		btnNewButton.setBounds(12, 73, 140, 36);
		frmProjeto.getContentPane().add(btnNewButton);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/util/beaker-remove.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					val.removeRow(tabela.getSelectedRow());
				}
				catch (ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				} 
				
			}
		});
		btnRemover.setFont(new Font("Century", Font.PLAIN, 12));
		btnRemover.setBounds(202, 73, 140, 36);
		frmProjeto.getContentPane().add(btnRemover);
		
		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabela.getRowCount() > 0) {
					ConfirmarVenda frame;
				try {
					for (int i = 0; i < tabela.getRowCount() ; i++) {
						produtos.add(tabela.getValueAt(i, 0));
						quantidade.add(tabela.getValueAt(i, 1));
					}
					frame = new ConfirmarVenda();
					
				} 
				catch (ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(null, "NENHUM PRODUTO SELECIONADO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				} 
				
				} else {
					JOptionPane.showMessageDialog(null, "NENHUM PRODUTO SELECIONADO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnFinalizar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/util/bookmark-check-outline.png")));
		btnFinalizar.setFont(new Font("Century", Font.PLAIN, 12));
		btnFinalizar.setBounds(202, 530, 140, 36);
		frmProjeto.getContentPane().add(btnFinalizar);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmProjeto.setJMenuBar(menuBar);
		
		JMenu mnOpes = new JMenu("GERENCIAR");
		mnOpes.setFont(new Font("Arial Black", Font.PLAIN, 14));
		mnOpes.setForeground(Color.BLACK);
		menuBar.add(mnOpes);
		
		JSeparator separator = new JSeparator();
		mnOpes.add(separator);
		
		JSeparator separator_7 = new JSeparator();
		mnOpes.add(separator_7);
		
		JMenu subMenuProdutos = new JMenu("Produtos");
		subMenuProdutos.setFont(new Font("Century", Font.PLAIN, 12));
		mnOpes.add(subMenuProdutos);
		
		JMenuItem CadastarProduto = new JMenuItem("Cadastrar");
		CadastarProduto.setFont(new Font("Century", Font.PLAIN, 12));
		subMenuProdutos.add(CadastarProduto);
		
		JMenuItem ListarProdutosExcluidos = new JMenuItem("Listar Produtos Exclu\u00EDdos");
		ListarProdutosExcluidos.setFont(new Font("Century", Font.PLAIN, 12));
		subMenuProdutos.add(ListarProdutosExcluidos);
		
		JMenu subMenuCliente = new JMenu("Cliente");
		subMenuCliente.setFont(new Font("Century", Font.PLAIN, 12));
		mnOpes.add(subMenuCliente);
		
		JMenuItem CadastarCliente = new JMenuItem("Cadastar Cliente");
		CadastarCliente.setFont(new Font("Century", Font.PLAIN, 12));
		subMenuCliente.add(CadastarCliente);
		
		JMenuItem ListarClienteExcluido = new JMenuItem("Listar Clientes Exclu\u00EDdos");
		ListarClienteExcluido.setFont(new Font("Century", Font.PLAIN, 12));
		subMenuCliente.add(ListarClienteExcluido);
		
		JMenuItem subMenuLista = new JMenuItem("Listar Dados");
		subMenuLista.setFont(new Font("Century", Font.PLAIN, 12));
		mnOpes.add(subMenuLista);
	}
}
