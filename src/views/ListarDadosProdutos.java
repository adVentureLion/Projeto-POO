package views;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
public class ListarDadosProdutos {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tabelaCliente;
	private JTable tabelaProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarDadosProdutos window = new ListarDadosProdutos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarDadosProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabelaCliente = new JTable();
		tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "CPF", "DATA NASCIMENTO", "IDADE", "SEXO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
		});
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(110);
		tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(85);
		DefaultTableModel val = (DefaultTableModel) tabelaCliente.getModel();
		tabelaCliente.setFont(new Font("Century", Font.PLAIN, 13));
		tabelaCliente.setBounds(10, 45, 659, 293);
		frame.getContentPane().add(tabelaCliente);
		val.addRow(new String [] {"hugo", "111.111.111-11", "11/11/1111", "masculino", "1"});
		
		
		
		
		
		
		
		tabelaProduto = new JTable();
		tabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "C\u00D3DIGO", "VALOR (R$)", "QTD ESTOQUE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaProduto.getColumnModel().getColumn(3).setPreferredWidth(85);
		tabelaProduto.setFont(new Font("Century", Font.PLAIN, 12));
		tabelaProduto.setBounds(10, 45, 659, 293);
		frame.getContentPane().add(tabelaProduto);
		DefaultTableModel val2 = (DefaultTableModel) tabelaProduto.getModel();
		
		
		
		
		JScrollPane scrollPaneProduto = new JScrollPane(tabelaProduto);
		scrollPaneProduto.setBounds(10, 45, 659, 293);
		frame.getContentPane().add(scrollPaneProduto);
		
		
		JScrollPane scrollPaneCliente = new JScrollPane(tabelaCliente);
		scrollPaneCliente.setBounds(10, 45, 659, 293);
		frame.getContentPane().add(scrollPaneCliente);
		val2.addRow(new String[] {"motor", "123456789", "99,99", "25"});
		
		
		
		
		
		
		
		
		JButton excluirCliente = new JButton("EXCLUIR");
		excluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		excluirCliente.setToolTipText("");
		excluirCliente.setFont(new Font("Century", Font.PLAIN, 12));
		excluirCliente.setBounds(548, 363, 121, 23);
		frame.getContentPane().add(excluirCliente);
		
		JButton excluirProduto = new JButton("EXCLUIR");
		excluirProduto.setFont(new Font("Century", Font.PLAIN, 12));
		excluirProduto.setBounds(399, 363, 121, 23);
		frame.getContentPane().add(excluirProduto);
		excluirProduto.setVisible(false);
		
		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setToolTipText("");
		btnEstoque.setFont(new Font("Century", Font.PLAIN, 12));
		btnEstoque.setBounds(553, 363, 121, 23);
		frame.getContentPane().add(btnEstoque);
		
		JToggleButton btnCliente = new JToggleButton("CLIENTE");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scrollPaneCliente.setVisible(true);
					tabelaCliente.setVisible(true);
					excluirProduto.setVisible(false);
					excluirCliente.setVisible(true);
					tabelaProduto.setVisible(false);
					scrollPaneProduto.setVisible(false);
					btnEstoque.setVisible(false);
				} catch(Exception w) {
					
				}
			}
		});
		btnCliente.setBounds(10, 11, 121, 23);
		buttonGroup.add(btnCliente);
		btnCliente.setFont(new Font("Century", Font.PLAIN, 12));
		frame.getContentPane().add(btnCliente);
		
		JToggleButton btnProduto = new JToggleButton("PRODUTO");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scrollPaneProduto.setVisible(true);
					tabelaProduto.setVisible(true);
					tabelaCliente.setVisible(false);
					excluirProduto.setVisible(true);
					excluirCliente.setVisible(false);
					scrollPaneCliente.setVisible(false);
					btnEstoque.setVisible(true);
				} catch(Exception w) {
					
				}
			}
		});
		
		btnCliente.setSelected(true);
		tabelaProduto.setVisible(false);
		scrollPaneProduto.setVisible(false);
		excluirProduto.setVisible(false);
		btnEstoque.setVisible(false);
		
		
		btnProduto.setBounds(141, 11, 121, 23);
		buttonGroup.add(btnProduto);
		frame.getContentPane().add(btnProduto);
		
		
		
		
		
		
		
		
	
		
		
	}
}
