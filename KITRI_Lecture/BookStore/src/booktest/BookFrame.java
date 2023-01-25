package booktest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BookFrame extends JFrame {
	JPanel panel;
	
	JLabel subTitle;
	JComboBox<String> items;
	JTextField searchField;
	JButton searchBtn;
	
	DefaultTableModel bookDTM;	// ���̺��� �� ���� �ٷ�� ���� ��ü
	JTable bookTable;
	JScrollPane scroll;
	
	JLabel bookNameL, publisherL, priceL;
	
	JTextField bookIdField, bookNameField, publisherField, priceField;
	
	JButton registBtn, updateBtn, deleteBtn;
	
	BookDAO bdao = new BookDAO();
	String item = "å��ȣ";
	int row;
	
	public BookFrame() {
		this.setTitle("å ���� �ý���");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// close ��ư ����
		this.setBounds(700, 200, 430, 550);	// ȭ���� ��� ����� ����, ȭ���� ũ�� ����
		this.setLayout(null);
		setComponent();	// setComponent() ����
		
		this.setVisible(true);	// true�� �����ؾ� ȭ���� ���.
	}
	
	public void setComponent() {
		panel = new JPanel();
		panel.setLayout(null);
		
		// Ÿ��Ʋ
		subTitle = new JLabel();
		subTitle.setText("BOOK TABLE ���� �ý���");	// Ÿ��Ʋ �̸� �ֱ�
		subTitle.setBounds(130, 20, 150, 15);
		
		// �˻�â
		String[] columns = {"å��ȣ", "å�̸�", "���ǻ�", "����"};
		items = new JComboBox<String>(columns);
		items.setBounds(20, 40, 120, 30);
		
		searchField = new JTextField();
		searchField.setBounds(140, 40, 180, 30);
		
		searchBtn = new JButton();
		searchBtn.setText("�˻�");
		searchBtn.setBounds(320, 40, 69, 30);
		
		// ���̺�
		bookDTM = new DefaultTableModel(columns, 0);	// ���̺��� �� ���� �ٷ�� ���� ��ü (columns�� �������ν� ���� ����)
		bookTable = new JTable(bookDTM);
		scroll = new JScrollPane(bookTable);
		scroll.setBounds(20, 80, 370, 270);
		initBookTable();
		
		// ���(��)
		bookNameL = new JLabel();
		bookNameL.setText("å �̸�");
		bookNameL.setBounds(30, 370, 120, 15);
		
		publisherL = new JLabel();
		publisherL.setText("���ǻ�");
		publisherL.setBounds(160, 370, 120, 15);
		
		priceL = new JLabel();
		priceL.setText("����");
		priceL.setBounds(290, 370, 120, 15);
		
		// ���(�ʵ�)
		bookIdField = new JTextField();
		
		bookNameField = new JTextField();
		bookNameField.setBounds(20, 390, 110, 30);
		
		publisherField = new JTextField(); 
		publisherField.setBounds(150, 390, 110, 30);
		
		priceField = new JTextField();
		priceField.setBounds(280, 390, 110, 30);
		
		// ���(��ư)
		registBtn = new JButton();
		registBtn.setText("���");
		registBtn.setBounds(20, 430, 110, 30);
		
		updateBtn = new JButton();
		updateBtn.setText("����");
		updateBtn.setBounds(150, 430, 110, 30);
		
		deleteBtn = new JButton();
		deleteBtn.setText("����");
		deleteBtn.setBounds(280, 430, 110, 30);
		
		// �гο� �ø���
		panel.add(subTitle);
		
		panel.add(items);
		panel.add(searchField);
		panel.add(searchBtn);
		
		panel.add(scroll);
		
		panel.add(bookNameL);
		panel.add(publisherL);
		panel.add(priceL);
		
		panel.add(bookNameField);
		panel.add(publisherField);
		panel.add(priceField);
		
		panel.add(registBtn);
		panel.add(updateBtn);
		panel.add(deleteBtn);
		
		// �г� ��ġ �� ũ�� ����
		panel.setBounds(0, 0, 400, 550);
		
		// �г��� �����ӿ� �ø���
		this.setContentPane(panel);
		
		eventList();
	}
	
	public void eventList() {
		// �˻� ��ư
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// searchBtn ��ư�� ������ �� Action �����ϴ� ���๮
				bookDTM.setNumRows(0);	// ���� ���̺� ���� �ʱ�ȭ
				
				ArrayList<BookVO> blist = bdao.select(item, searchField.getText());
				addRowBook(blist);
				
				searchField.setText("");
			}
		});
		
		// �޺��ڽ����� �� ������
		items.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				item = items.getSelectedItem().toString();
				
			}
		});
		
		// insert ��ư
		registBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				String[] bookColumns = new String[4];
				bookColumns[1] = bookNameField.getText();
				bookColumns[2] = publisherField.getText();
				bookColumns[3] = priceField.getText();
				
				// �Է�â �� ���
				if (bookNameField.getText().equals("")) {
					// �˸�â
					JOptionPane.showConfirmDialog(null, "å �̸��� �Է��ϼ���.", 
							"���", JOptionPane.DEFAULT_OPTION);
					// �ش� �ʵ忡 Ŀ���� ��
					bookNameField.requestFocus();
					return;
				}
				if (publisherField.getText().equals("")) {
					// �˸�â
					JOptionPane.showConfirmDialog(null, "���ǻ縦 �Է��ϼ���.", 
							"���", JOptionPane.DEFAULT_OPTION);
					// �ش� �ʵ忡 Ŀ���� ��
					publisherField.requestFocus();
					return;
				}
				if (priceField.getText().equals("")) {
					// �˸�â
					JOptionPane.showConfirmDialog(null, "������ �Է��ϼ���.", 
							"���", JOptionPane.DEFAULT_OPTION);
					// �ش� �ʵ忡 Ŀ���� ��
					priceField.requestFocus();
					return;
				}
				
				BookVO bvo = new BookVO();
				
				bvo.setBookName(bookNameField.getText());
				bvo.setPublisher(publisherField.getText());
				bvo.setPrice(Integer.parseInt(priceField.getText()));
				
				int seq = bdao.selectBookSeq();
				
				bookIdField.setText(String.valueOf(seq));
				bookColumns[0] = bookIdField.getText();
				
				if (bdao.insert(bvo) > 0) {;
					JOptionPane.showConfirmDialog(null, "��Ͽ� �����߽��ϴ�.", 
							"����", JOptionPane.DEFAULT_OPTION);
					bookNameField.setText("");
					publisherField.setText("");
					priceField.setText("");
					
					bookDTM.addRow(bookColumns);
				} else {
					JOptionPane.showConfirmDialog(null, "�߸��� �Է��Դϴ�.", 
							"���", JOptionPane.DEFAULT_OPTION);
					bookNameField.setText("");
					publisherField.setText("");
					priceField.setText("");
					bookNameField.requestFocus();
				}
			}
		});
		
		
		// Ŭ���Ͽ� ������ �� ��������
		bookTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			// Ŭ���Ͽ� �� ��������
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��, �� ��������
//				System.out.println(bookTable.getSelectedRow());
//				System.out.println(bookTable.getSelectedColumn());
				
				// ��, ���� �̿��� �� ��������
//				String selectVal = bookTable.getValueAt(bookTable.getSelectedRow(), 
//						bookTable.getSelectedColumn()).toString();
				
				row = bookTable.getSelectedRow();
				
				String bookID = bookTable.getValueAt(row, 0).toString();
				String bookName = bookTable.getValueAt(row, 1).toString();
				String publisher = bookTable.getValueAt(row, 2).toString();
				String price = bookTable.getValueAt(row, 3).toString();
				
				bookIdField.setText(bookID);
				bookNameField.setText(bookName);
				publisherField.setText(publisher);
				priceField.setText(price);
				
				
			}
		});
		
		// update ��ư
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BookVO bvo = new BookVO();
				bvo.setBookID(Integer.parseInt(bookIdField.getText()));
				bvo.setBookName(bookNameField.getText());
				bvo.setPublisher(publisherField.getText());
				bvo.setPrice(Integer.parseInt(priceField.getText()));
				
				int result = bdao.update(bvo);
				
				if (result > 0) {
					JOptionPane.showConfirmDialog(null, "�����Ǿ����ϴ�.", 
							"Ȯ��", JOptionPane.DEFAULT_OPTION);
					bookTable.setValueAt(bookNameField.getText(), row, 1);
					bookTable.setValueAt(publisherField.getText(), row, 2);
					bookTable.setValueAt(priceField.getText(), row, 3);
					
					initVal();
				} else {
					JOptionPane.showConfirmDialog(null, "�����ϴµ� �����߽��ϴ�.", 
							"���", JOptionPane.DEFAULT_OPTION);
				}
				
				bookTable.clearSelection();
			}
		});
		
		// delete ��ư
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = bdao.delete(Integer.parseInt(bookIdField.getText()));
				
				if (result > 0) {
					JOptionPane.showConfirmDialog(null, "�����Ǿ����ϴ�.", 
							"Ȯ��", JOptionPane.DEFAULT_OPTION);
					bookDTM.removeRow(row);
					initVal();		
				} else {
					JOptionPane.showConfirmDialog(null, "�����ϴµ� �����߽��ϴ�.", 
							"���", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
	}
	
	// ���̺� Book ���� �ֱ�
	public void initBookTable() {
		ArrayList<BookVO> blist = bdao.select();
		addRowBook(blist);
	}
	
	public void addRowBook(ArrayList<BookVO> blist) {
		String[] bookColumns = new String[4];
		for (BookVO bvo : blist) {
			bookColumns[0] = bvo.getBookID() + "";
			bookColumns[1] = bvo.getBookName();
			bookColumns[2] = bvo.getPublisher();
			bookColumns[3] = bvo.getPrice() + "";
			
			bookDTM.addRow(bookColumns);
		}
	}
	
	public void initVal() {
		bookIdField.setText("");
		bookNameField.setText("");
		publisherField.setText("");
		priceField.setText("");
	}
	
	public static void main(String[] args) {
		new BookFrame();
	}
	
}
