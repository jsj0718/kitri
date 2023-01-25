package client.frame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import book.BookVO;
import client.program.ClientHandler;
import message.BookMessage;
import message.Message;
import message.OrdersMessage;
import orders.OrdersVO;

public class BookStoreFrame extends JFrame implements ActionListener, MouseListener {

	// ��ü �г�
	// ��� �̹��� ����
	static JPanel totalPanel=new JPanel() {
		//�̹��� �о����
		Image backGroundImg=new ImageIcon("./img/backgound.png").getImage();
		//â ũ�⿡ �°� ����
		Image scaledBackGroundImg = backGroundImg.getScaledInstance(800, 550, Image.SCALE_DEFAULT);
		Image backGroundFinalImg = new ImageIcon(scaledBackGroundImg).getImage();
		
		public void paintComponent(Graphics g) {//�׸��� �Լ�
			g.drawImage(backGroundFinalImg, 0, 0, null);//backgroundImg�� �׷���	
			setOpaque(false); //�����ϰ�
            super.paintComponent(g);

		}
	};	

	
	// å ���� �г�
	JPanel bookDetailPanel;
	// �ֹ� ���� �г�
	JPanel ordersDetailPanel;
	// tab �г�
	JTabbedPane tab;

	// ����, ���̵�, �α׾ƿ� ��ư
	JLabel titleL;
	JLabel custIdL;
	JButton logOutBt;

	// book tab ���̺�
	DefaultTableModel bookDTM;
	JTable bookTable;
	JScrollPane bookScroll;

	// order tab ���̺�
	DefaultTableModel ordersDTM;
	JTable ordersTable;
	JScrollPane ordersScroll;

	// å ���� �г� ����
	JLabel imgL;
	JLabel imgVal;
	JLabel bookIdVal;
	JLabel bookNameL;
	JLabel bookNameVal;
	JLabel publisherL;
	JLabel publisherVal;
	JLabel priceL;
	JLabel priceVal;
	JSpinner cnt;
	JButton orderBt;

	// �ֹ� ���� �г� ����
	JLabel orderIdL;
	JLabel orderBookNameL;
	JLabel orderSalePriceL;
	JLabel orderCntL;
	JLabel orderDateL;

	JLabel orderIdVal;
	JLabel orderBookNameVal;
	JLabel orderSalePriceVal;
	JLabel orderCntVal;
	JLabel orderDateVal;

	JButton orderCancelBt;

	LoginFrame login;
	String id;
	int bookRow;
	int ordersRow;

	public BookStoreFrame(LoginFrame login, String id) {
		this.login = login;
		this.id = id;

		this.setTitle("���� ����");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 800, 550);
		this.setLayout(new FlowLayout());
		// ȭ�鱸��
		setComponent();

		// �ʱ� ������ ����
		initTableRequest();

		// �̺�Ʈ ����
		eventList();

		this.setVisible(true);
	}

	public void setComponent() {
//		totalPanel = new JPanel() {
//			
//		}
		totalPanel.setLayout(null);

		bookDetailPanel = new JPanel();
		bookDetailPanel.setLayout(null);
		bookDetailPanel.setBorder(new EtchedBorder());

		ordersDetailPanel = new JPanel();
		ordersDetailPanel.setLayout(null);
		ordersDetailPanel.setBorder(new EtchedBorder());

		tab = new JTabbedPane();

		titleL = new JLabel();
		titleL.setText("�� �� �� ��");
		titleL.setFont(new Font("���� ���", Font.BOLD, 30));
		titleL.setHorizontalAlignment(JLabel.CENTER);
		custIdL = new JLabel();
		custIdL.setText(id + "�� ȯ���մϴ�.");
		logOutBt = new JButton();
		logOutBt.setText("�α׾ƿ�");

		String[] bookCol = { "å��ȣ", "å�̸�", "���ǻ�", "����", "�̹������" };
		bookDTM = new DefaultTableModel(bookCol, 0);
		bookTable = new JTable(bookDTM);

		// �� �����
		bookTable.getColumn("�̹������").setWidth(0);
		bookTable.getColumn("�̹������").setMinWidth(0);
		bookTable.getColumn("�̹������").setMaxWidth(0);

		bookScroll = new JScrollPane(bookTable);
		String[] ordersCol = { "�ֹ���ȣ", "å�̸�", "�ֹ�����", "����", "�ֹ�����", "å��ȣ" };
		ordersDTM = new DefaultTableModel(ordersCol, 0);
		ordersTable = new JTable(ordersDTM);
		ordersScroll = new JScrollPane(ordersTable);

		// �� �����
		ordersTable.getColumn("å��ȣ").setWidth(0);
		ordersTable.getColumn("å��ȣ").setMinWidth(0);
		ordersTable.getColumn("å��ȣ").setMaxWidth(0);

		// å ����
		imgL = new JLabel();
		imgVal = new JLabel();
		imgL.setBorder(new EtchedBorder());
		bookIdVal = new JLabel();
		bookNameL = new JLabel();
		bookNameL.setText("å�̸� :");
		publisherL = new JLabel();
		publisherL.setText("���ǻ� : ");
		priceL = new JLabel();
		priceL.setText("�� �� : ");
		bookNameVal = new JLabel();
		publisherVal = new JLabel();
		priceVal = new JLabel();
		cnt = new JSpinner();
		orderBt = new JButton();
		orderBt.setText("�ֹ�");

		// �ֹ� ����
		orderIdL = new JLabel();
		orderIdL.setText("�ֹ���ȣ : ");
		orderBookNameL = new JLabel();
		orderBookNameL.setText("å�̸� : ");
		orderSalePriceL = new JLabel();
		orderSalePriceL.setText("�ֹ����� : ");
		orderCntL = new JLabel();
		orderCntL.setText("�ֹ����� : ");
		orderDateL = new JLabel();
		orderDateL.setText("�ֹ�����");

		orderIdVal = new JLabel();
		orderBookNameVal = new JLabel();
		orderSalePriceVal = new JLabel();
		orderCntVal = new JLabel();
		orderDateVal = new JLabel();
		orderCancelBt = new JButton();
		orderCancelBt.setText("�ֹ����");

		totalPanel.setBounds(12, 10, 771, 494);
		bookDetailPanel.setBounds(462, 89, 297, 395);
		ordersDetailPanel.setBounds(462, 89, 297, 395);
		titleL.setBounds(121, 14, 215, 42);
		custIdL.setBounds(635, 15, 100, 20);
		logOutBt.setBounds(645, 35, 90, 25);

		tab.setBounds(30, 66, 420, 418);

		// å ���� ��ġ
		imgL.setBounds(67, 10, 171, 165);
		bookNameL.setBounds(22, 199, 75, 31);
		publisherL.setBounds(22, 240, 75, 31);
		priceL.setBounds(22, 281, 75, 31);
		bookNameVal.setBounds(109, 199, 165, 31);
		publisherVal.setBounds(109, 240, 165, 31);
		priceVal.setBounds(109, 281, 165, 31);
		cnt.setBounds(22, 341, 75, 31);
		orderBt.setBounds(109, 338, 108, 36);

		// �ֹ����� ��ġ
		orderIdL.setBounds(22, 31, 91, 36);
		orderBookNameL.setBounds(22, 87, 91, 36);
		orderSalePriceL.setBounds(22, 143, 91, 36);
		orderCntL.setBounds(22, 199, 91, 36);
		orderDateL.setBounds(22, 255, 91, 36);
		orderIdVal.setBounds(125, 31, 160, 36);
		orderBookNameVal.setBounds(125, 87, 160, 36);
		orderSalePriceVal.setBounds(125, 143, 160, 36);
		orderCntVal.setBounds(125, 199, 160, 36);
		orderDateVal.setBounds(125, 255, 160, 36);
		orderCancelBt.setBounds(100, 327, 108, 36);

		// tab �г�
		tab.addTab("å ���", bookScroll);
		tab.addTab("�ֹ� ����", ordersScroll);

		// å ���� �г�
		bookDetailPanel.add(imgL);
		bookDetailPanel.add(bookNameL);
		bookDetailPanel.add(publisherL);
		bookDetailPanel.add(priceL);
		bookDetailPanel.add(bookNameVal);
		bookDetailPanel.add(publisherVal);
		bookDetailPanel.add(priceVal);
		bookDetailPanel.add(cnt);
		bookDetailPanel.add(orderBt);

		// �ֹ� ���� �г�
		ordersDetailPanel.add(orderIdL);
		ordersDetailPanel.add(orderBookNameL);
		ordersDetailPanel.add(orderSalePriceL);
		ordersDetailPanel.add(orderCntL);
		ordersDetailPanel.add(orderDateL);
		ordersDetailPanel.add(orderIdVal);
		ordersDetailPanel.add(orderBookNameVal);
		ordersDetailPanel.add(orderSalePriceVal);
		ordersDetailPanel.add(orderCntVal);
		ordersDetailPanel.add(orderDateVal);
		ordersDetailPanel.add(orderCancelBt);

		// ��ü �г�
		totalPanel.add(titleL);
		totalPanel.add(custIdL);
		totalPanel.add(logOutBt);
		totalPanel.add(tab);
		totalPanel.add(bookDetailPanel);

		this.setContentPane(totalPanel);

	}
	
	public void backGoundPaint() {
		
	}

	// �г� ���� �޼ҵ�
	public void change(JPanel beforePanel, JPanel afterPanel) {
		totalPanel.remove(beforePanel);
		totalPanel.add(afterPanel);
		this.setContentPane(totalPanel);
		// ���Ӱ� ����
		revalidate();
		repaint();
	}

	// �ʱⵥ���� ��û
	public void initTableRequest() {
		bookSelectAll();
		orderSelectAll();

	}

	public void bookSelectAll() {
		BookMessage bmsg = new BookMessage();
		bmsg.setState(1);

		try {
			ClientHandler.oos.writeObject(bmsg);
			ClientHandler.oos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void orderSelectAll() {
		OrdersMessage omsg = new OrdersMessage();
		OrdersVO ovo = new OrdersVO();
		ovo.setCustId(id);
		omsg.setState(1);
		omsg.setOvo(ovo);
		try {
			ClientHandler.oos.writeObject(omsg);
			ClientHandler.oos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// �ʱⵥ���� ����
	public void initTableResponse(Message msg) {
		if (msg instanceof BookMessage) {
			BookMessage bmsg = (BookMessage) msg;
			addRowBook(bmsg.getBlist());
		} else if (msg instanceof OrdersMessage) {
			OrdersMessage bmsg = (OrdersMessage) msg;
			addRowOrder(bmsg.getOlist());
		}

	}

	public void addRowBook(ArrayList<BookVO> blist) {
		String[] bookCol = new String[5];
		for (BookVO bvo : blist) {
			bookCol[0] = String.valueOf(bvo.getBookId());
			bookCol[1] = bvo.getBookName();
			bookCol[2] = bvo.getPublisher();
			bookCol[3] = String.valueOf(bvo.getPrice());
			bookCol[4] = bvo.getImgPath();
			bookDTM.addRow(bookCol);

		}
	}

	public void addRowOrder(ArrayList<OrdersVO> olist) {
		String[] OrdersCol = new String[5];
		for (OrdersVO ovo : olist) {
			OrdersCol[0] = String.valueOf(ovo.getOrderId());
			OrdersCol[1] = ovo.getBookName();
			OrdersCol[2] = String.valueOf(ovo.getSalePrice());
			OrdersCol[3] = String.valueOf(ovo.getCount());
			OrdersCol[4] = String.valueOf(ovo.getOrderDate());

			ordersDTM.addRow(OrdersCol);

		}
	}

	public void eventList() {
		logOutBt.addActionListener(this); // �α׾ƿ�
		orderBt.addActionListener(this); // �ֹ�
		bookTable.addMouseListener(this); // å ���̺� �� �� ����
		ordersTable.addMouseListener(this); // �ֹ� ���̺� �� �� ����
		tab.addMouseListener(this); //å ���, �ֹ����� �� ����
		orderCancelBt.addActionListener(this); // �ֹ���� 
	}

	// ��ư Ŭ�� �̺�Ʈ �Լ�
	@Override
	public void actionPerformed(ActionEvent e) {

		if (logOutBt == e.getSource()) { // �α׾ƿ�
			id = null;
			totalPanel.removeAll();	// total �гο� �ִ� ������Ʈ ����
			login.setVisible(true);
			dispose();
			
			
		} else if (orderBt == e.getSource()) { // �ֹ�

			OrdersMessage omsg = new OrdersMessage();
			OrdersVO ovo = new OrdersVO();
			ovo.setBookId(Integer.parseInt(bookIdVal.getText()));
			ovo.setBookName(bookNameVal.getText());
			ovo.setCustId(id);

			// �ֹ����� X �ݾ�
			int count = Integer.parseInt(cnt.getValue().toString());
			if (count == 0) {
				JOptionPane.showConfirmDialog(null, "������ �־��ּ���", "���", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int price = Integer.parseInt(priceVal.getText());
			int salePrice = count * price;
			ovo.setSalePrice(salePrice);

			ovo.setCount(count);

			omsg.setState(2);
			omsg.setOvo(ovo);
			try {
				ClientHandler.oos.writeObject(omsg);
				ClientHandler.oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else if (orderCancelBt == e.getSource()) { // �ֹ����
			OrdersMessage omsg = new OrdersMessage();
			OrdersVO ovo = new OrdersVO();
			ovo.setOrderId(Integer.parseInt(orderIdVal.getText()));
			omsg.setState(3);
			omsg.setOvo(ovo);
			try {
				ClientHandler.oos.writeObject(omsg);
				ClientHandler.oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	// ���̺� ���콺 Ŭ�� �̺�Ʈ �Լ�
	@Override
	public void mouseClicked(MouseEvent e) {
		if (bookTable == e.getSource()) {
			bookRow = bookTable.getSelectedRow();

			String bookId = bookTable.getValueAt(bookRow, 0).toString();
			String bookName = bookTable.getValueAt(bookRow, 1).toString();
			String publisher = bookTable.getValueAt(bookRow, 2).toString();
			String price = bookTable.getValueAt(bookRow, 3).toString();
			String imgPath = null;
			ImageIcon scaledImgIcon = null;

			// �����ͺ��̽��� �̹��� ��ΰ� �ִ��� Ȯ��
			if (bookTable.getValueAt(bookRow, 4) != null) {
				// �̹��� ������ ����
				imgPath = bookTable.getValueAt(bookRow, 4).toString();
				// DB�� �ִ� �̹��� ��θ� ���� �̹��� ����
				Image selectedImg = new ImageIcon(imgPath).getImage();
				Image scaledImg = selectedImg.getScaledInstance(171, 165, Image.SCALE_DEFAULT);
				scaledImgIcon = new ImageIcon(scaledImg);
			}

			imgL.setIcon(scaledImgIcon);
			bookIdVal.setText(bookId);
			bookNameVal.setText(bookName);
			publisherVal.setText(publisher);
			priceVal.setText(price);

		} else if (ordersTable == e.getSource()) {

			ordersRow = ordersTable.getSelectedRow();

			String orderId = ordersTable.getValueAt(ordersRow, 0).toString();
			String orderBookName = ordersTable.getValueAt(ordersRow, 1).toString();
			String orderSalePrice = ordersTable.getValueAt(ordersRow, 2).toString();
			String orderCnt = ordersTable.getValueAt(ordersRow, 3).toString();
			String orderDate = ordersTable.getValueAt(ordersRow, 4).toString();

			orderIdVal.setText(orderId);
			orderBookNameVal.setText(orderBookName);
			orderSalePriceVal.setText(orderSalePrice);
			orderCntVal.setText(orderCnt);
			orderDateVal.setText(orderDate);

		} else if (tab == e.getSource()) {	// tab(å ���, �ֹ�����) Ŭ�� ���� �̺�Ʈ
			if (tab.getSelectedIndex() == 0) {
				change(ordersDetailPanel, bookDetailPanel);
			} else if (tab.getSelectedIndex() == 1) {
				ordersDTM.setNumRows(0);
				change(bookDetailPanel, ordersDetailPanel);
				orderSelectAll();
			}
		}
	}

	// �ֹ� ��� ó��
	public void orderResult(int result) {
		if (result != 0) {
			JOptionPane.showMessageDialog(null, "�ֹ��� ���������� �Ϸ�Ǿ����ϴ�.");

		} else {
			JOptionPane.showConfirmDialog(null, "�ֹ��� �����Ͽ����ϴ�.", "���", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE);

		}
	}

	// �ֹ� ��� ��� ó��
	public void orderCancelResult(int result) {
		if (result != 0) {
			JOptionPane.showMessageDialog(null, "�ֹ��� ��ҵǾ����ϴ�.");
			ordersDTM.removeRow(ordersRow);
			orderIdVal.setText("");
			orderBookNameVal.setText("");
			orderSalePriceVal.setText("");
			orderCntVal.setText("");
			orderDateVal.setText("");
			

		} else {
			JOptionPane.showConfirmDialog(null, "�ֹ� ��ҿ� �����Ͽ����ϴ�.", "���", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new BookStoreFrame(null, "2");
	}

}
