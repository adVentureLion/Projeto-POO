package views;

import java.awt.BorderLayout;

import controller.ControllerCliente;
import controller.ControllerProduto;
import controller.ControllerVendaCliente;
import models.Produto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowStateListener;
import controller.ControllerVendaProduto;
import models.VendaProduto;
import models.Produto;

public class TelPrincipal extends JFrame {
	
	ControllerProduto Prod = new ControllerProduto();
	
	ControllerCliente c = new ControllerCliente();
	
	ControllerVendaCliente vc = new ControllerVendaCliente();
	
	ControllerVendaProduto venda = new ControllerVendaProduto();
	
	CadastrarCliente cadastrar = new CadastrarCliente();
	
	ListarDados listar = new ListarDados();
	
	ListarProdutosExcluidos listarEx = new ListarProdutosExcluidos();
	CadastrarProduto cad = new CadastrarProduto();
	
	ListarClientesEx ListarCEx = new ListarClientesEx();
	
	VendaProduto VProd;
	
	
	
	Set<Produto> produtoss;
	
	ArrayList produtos = new ArrayList();
	ArrayList quantidade = new ArrayList();
	private JPanel contentPane;
	private JTable tabela;
	ConfirmVenda confirm = new ConfirmVenda();
	int Var = 0;
	Double ValorFinal = 0.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelPrincipal frame = new TelPrincipal();
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
	
	private Boolean VerificarTabela(JTable tabela, String item) {
		for (int i = 0; i < tabela.getRowCount(); i++) {
			if(tabela.getValueAt(i, 0).equals(item)) {
				Var = i;
				return true;
			}
		}
		return false;
		
	}
	
	
	
	
	public TelPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Prod.iniciarProdutos();
				c.iniciarClientes();
				
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Prod.atualizarProdutosController();
				c.atualizarClientesController();
			}
		});
		
		
		
		Prod.iniciarProdutos();
		produtoss = Prod.listarProdutosController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 690);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		
		
		
		JMenu mnNewMenu = new JMenu("GERENCIAR");
		mnNewMenu.setFont(new Font("Century", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Produtos");
		mnNewMenu_1.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem CadProduto = new JMenuItem("Cadastrar");
		CadProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cad.setVisible(true);
			}
		});
		CadProduto.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu_1.add(CadProduto);
		
		JMenuItem ListarProdEx = new JMenuItem("Listar Produtos Exclu\u00EDdos");
		ListarProdEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEx.setVisible(true);
			}
		});
		ListarProdEx.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu_1.add(ListarProdEx);
		
		JMenu mnNewMenu_2 = new JMenu("Cliente");
		mnNewMenu_2.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem CadCliente = new JMenuItem("Cadastrar Cliente");
		CadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastrar.setVisible(true);
			}
		});
		CadCliente.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu_2.add(CadCliente);
		
		JMenuItem ListarCadExc = new JMenuItem("Listar Cliente Exclu\u00EDdos");
		ListarCadExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCEx.setVisible(true);
			}
		});
		ListarCadExc.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu_2.add(ListarCadExc);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar Dados");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listar.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Century", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Produtos");
		lbl1.setBounds(12, 28, 71, 33);
		lbl1.setFont(new Font("Century", Font.PLAIN, 16));
		contentPane.add(lbl1);
		
		JComboBox BoxProd = new JComboBox();
		BoxProd.setBounds(95, 34, 247, 22);
		BoxProd.setFont(new Font("Century", Font.PLAIN, 12));
		contentPane.add(BoxProd);
		for(Produto listagem: produtoss) {
			
			if(listagem.getQtd() > 0) {
				
			BoxProd.addItem(listagem.getNome());
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 129, 330, 387);
		contentPane.add(scrollPane);
		
		JLabel lblValor = new JLabel("00,00");
		lblValor.setFont(new Font("Century", Font.PLAIN, 12));
		lblValor.setBounds(238, 527, 104, 40);
		contentPane.add(lblValor);
		
		tabela = new JTable();
		DefaultTableModel val = (DefaultTableModel) tabela.getModel();
		val.addColumn("PRODUTO");
		val.addColumn("Quantidade");
		tabela.setFont(new Font("Century", Font.PLAIN, 12));
		scrollPane.setViewportView(tabela);
		
		
		
		
		JButton btnADD = new JButton("ADICIONAR");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						if(VerificarTabela(tabela, BoxProd.getSelectedItem().toString()) ) {
							String valor = val.getValueAt(Var, 1).toString();
							int valorInt = Integer.parseInt(valor);
							for(Produto listagem: produtoss) {
								if(listagem.getNome().equals(BoxProd.getSelectedItem())) {
									Produto Produto = new Produto(listagem.getCodigo(), listagem.getNome(), listagem.getValor(), listagem.getQtd());
									VProd = new VendaProduto(Produto, 1);
									if(venda.venderProdutoController(Prod, VProd)) {
										valorInt += 1;
										val.setValueAt(valorInt, Var, 1);
									} else {
										JOptionPane.showMessageDialog(null, "N?O TEM MAIS ESTE PRODUTO EM ESTOQUE", "FALHA", JOptionPane.INFORMATION_MESSAGE);
									}
								}
								
								}

							
						}else {
							
							String a = BoxProd.getSelectedItem().toString();
							
							for(Produto listagem: produtoss) {
								if(listagem.getNome().equals(a)) {
									Produto Produto = new Produto(listagem.getCodigo(), listagem.getNome(), listagem.getValor(), listagem.getQtd());
									VendaProduto VProd = new VendaProduto(Produto, 1);
									venda.venderProdutoController(Prod, VProd);
								}
							}
							val.addRow(new String[] {a, "1"});
					}
						
						lblValor.setText(CalcularValorCompra(tabela).toString());;
						
				}
				catch (ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(null, "NENHUM PRODUTO SELECIONADO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnADD.setBounds(12, 73, 140, 36);
		btnADD.setIcon(new ImageIcon(TelPrincipal.class.getResource("/util/beaker-plus (1).png")));
		btnADD.setFont(new Font("Century", Font.PLAIN, 12));
		contentPane.add(btnADD);
		
		JButton btnRemove = new JButton("REMOVER");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					val.removeRow(tabela.getSelectedRow());
				}
				catch (ArrayIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				} 
				lblValor.setText(CalcularValorCompra(tabela).toString());;
			}
		});
		btnRemove.setBounds(202, 73, 140, 36);
		btnRemove.setFont(new Font("Century", Font.PLAIN, 12));
		btnRemove.setIcon(new ImageIcon(TelPrincipal.class.getResource("/util/beaker-remove.png")));
		contentPane.add(btnRemove);
		
		
		JButton btnNewButton = new JButton("AVAN\u00C7AR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if( val.getRowCount() > 0 ) {
					confirm.setVisible(true);
					confirm.produtos = (Set<VendaProduto>) VProd;
				} else {
					throw new Exception();
				}
				} catch(Exception w) {
					JOptionPane.showMessageDialog(null, "NENHUM PRODUTO SELECIONADO", "ERRO", 2);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon(TelPrincipal.class.getResource("/util/bookmark-check-outline.png")));
		btnNewButton.setBounds(202, 578, 140, 36);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("R$");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel.setBounds(205, 539, 23, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da Compra:");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(95, 539, 100, 14);
		contentPane.add(lblNewLabel_1);
	
		
		
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				c.atualizarClientesController();
				c.iniciarClientes();
				Prod.iniciarProdutos();
				produtoss = Prod.listarProdutosController();
				BoxProd.removeAllItems();
				for(Produto listagem: produtoss) {
					
					if(listagem.getQtd() > 0) {
						
					BoxProd.addItem(listagem.getNome());
					}
				}
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
	}
	

	
	private Double CalcularValorCompra(JTable tabela) {
		ValorFinal = 0.0;
		for (int i = 0; i < tabela.getRowCount(); i++) {
			for(Produto listagem: produtoss) {
				String str = tabela.getValueAt(i, 1).toString();
				int qtd =   Integer.parseInt(str);
				if(tabela.getValueAt(i, 0).equals(listagem.getNome())) {
					ValorFinal += listagem.getValor() * qtd;
				}
				}
		}
		
		return ValorFinal;
	}
	
	
	
	
	
}