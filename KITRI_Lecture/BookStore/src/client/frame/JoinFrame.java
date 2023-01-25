package client.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.program.ClientHandler;
import customer.CustomerVO;
import message.CustomerMessage;

public class JoinFrame extends JFrame implements ActionListener, KeyListener{
	JPanel joinPanel;
	JLabel joinL;
	JLabel idL;
	JLabel pwdL;
	JLabel pwdOkL;
	//��й�ȣ Ȯ�� ��
	JLabel pwdChekL;
	JLabel nameL;
	JLabel addressL;
	JLabel phoneL;
	
	JTextField idField;
	JPasswordField pwdField;
	JPasswordField pwdOkField;
	JTextField nameField;
	JTextField addressField;
	JTextField phoneField;
	
	JButton idCheckBt;
	JButton joinBt;
	JButton cancelBt;
	
	int idCheck;
	int pwdCheck;
	
	public JoinFrame() {
		this.setTitle("ȸ������");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(400, 200, 350, 450);
		this.setLayout(null); //absoulute
		setComponent();
		this.setVisible(true);
		
	}
	
	public void setComponent() {
		joinPanel = new JPanel();
		joinPanel.setLayout(null);
		
		idL = new JLabel();
		idL.setText("���̵�");
		pwdL = new JLabel();
		pwdL.setText("��й�ȣ");
		pwdOkL = new JLabel();
		pwdOkL.setText("��й�ȣ Ȯ��");
		pwdChekL = new JLabel();
//		pwdChekL.setText("");
		nameL = new JLabel();
		nameL.setText("�̸�");
		addressL = new JLabel();
		addressL.setText("�ּ�");
		phoneL = new JLabel();
		phoneL.setText("�ڵ���");
		joinL = new JLabel();
		joinL.setText("ȸ������");
		
		
		
		joinL.setFont(new Font("���� ���", Font.BOLD, 30));
		joinL.setHorizontalAlignment(JLabel.CENTER);
		
		idField = new JTextField();
		pwdField = new JPasswordField();
		pwdOkField = new JPasswordField();
		nameField = new JTextField();
		addressField = new JTextField();
		phoneField = new JTextField();
		
		idCheckBt = new JButton();
		idCheckBt.setText("�ߺ� Ȯ��");
		joinBt = new JButton();
		joinBt.setText("����");
		cancelBt = new JButton();
		cancelBt.setText("���");
		
		
		joinL.setBounds(56, 22, 227, 44);
		idL.setBounds(12, 84, 85, 32);
		pwdL.setBounds(12, 126, 85, 32);
		pwdOkL.setBounds(12, 170, 85, 32);
		
		nameL.setBounds(12, 213, 85, 32);
		addressL.setBounds(12, 255, 85, 32);
		phoneL.setBounds(12, 297, 85, 32);
		
		idField.setBounds(98, 90, 103, 21);
		pwdField.setBounds(98, 133, 171, 21);
		
		pwdChekL.setBounds(98, 198, 150, 15);
		
		pwdOkField.setBounds(98, 176, 171, 21);
		nameField.setBounds(98, 219, 171, 21);
		addressField.setBounds(98, 261, 171, 21);
		phoneField.setBounds(98, 303, 171, 21);
		
		idCheckBt.setBounds(213, 89, 97, 23);
		joinBt.setBounds(56, 345, 97, 35);
		cancelBt.setBounds(186, 345, 97, 35);
		
		joinPanel.add(joinL);
		joinPanel.add(idL);
		joinPanel.add(pwdL);
		joinPanel.add(pwdOkL);
		joinPanel.add(pwdChekL);
		joinPanel.add(nameL);
		joinPanel.add(addressL);
		joinPanel.add(phoneL);
		joinPanel.add(idField);
		joinPanel.add(pwdField);
		joinPanel.add(pwdOkField);
		joinPanel.add(nameField);
		joinPanel.add(addressField);
		joinPanel.add(phoneField);
		joinPanel.add(idCheckBt);
		joinPanel.add(joinBt);
		joinPanel.add(cancelBt);
		
		
		
		
		this.setContentPane(joinPanel);
		eventList();
	}
	
	
	public void eventList() {
		cancelBt.addActionListener(this);	// ȸ������ ��� ��ư
		idCheckBt.addActionListener(this);	// ���̵� �ߺ�üũ ��ư
		joinBt.addActionListener(this);		// ȸ������ ��ư
		pwdOkField.addKeyListener(this);	// �н����� Ȯ��
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cancelBt == e.getSource()) {
			dispose();
		}else if(idCheckBt == e.getSource()) {
			//id �Է� -> ������ id�� �������ϴ� ��Ȳ
			String id = idField.getText();
			if(id.equals("")) {
				JOptionPane.showConfirmDialog(null, "���̵� �Է��ϼ���.",
						"���",JOptionPane.DEFAULT_OPTION);
				idField.requestFocus();
				return;
			}
			CustomerMessage cmsg = new CustomerMessage();
			CustomerVO cvo = new CustomerVO();
			cvo.setCustId(id);
			cmsg.setCvo(cvo);
			cmsg.setState(1);//1 : id check	
			
			
			//write
			ObjectOutputStream oos =  ClientHandler.oos;
			try {
				oos.writeObject(cmsg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
		}else if(joinBt == e.getSource()) {	// ȸ������
			// idCheck�� �ϸ� 1, ���ϸ� 0
			if(idCheck==0) {
				JOptionPane.showConfirmDialog(null, "���̵� �ߺ� üũ ���ּ���.","���",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(pwdField.getText().equals("") ) {
				JOptionPane.showConfirmDialog(null, "��й�ȣ�� �Է��ϼ���","���",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				pwdField.requestFocus();
				return;
			}
			if(pwdOkField.getText().equals("") ) {
				JOptionPane.showConfirmDialog(null, "��й�ȣ Ȯ���� �Է��ϼ���","���",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				pwdField.requestFocus();
				return;
			}
			if(pwdCheck==0 ) {
				JOptionPane.showConfirmDialog(null, "��й�ȣ Ȯ���� �ʿ��մϴ�.","���",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			CustomerMessage cmsg = new CustomerMessage();
			CustomerVO cvo = new CustomerVO();
			
			cvo.setCustId(idField.getText());
			cvo.setPwd(pwdField.getText()); 
			cvo.setName(nameField.getText());
			cvo.setAddress(addressField.getText());
			cvo.setPhone(phoneField.getText());
			
			cmsg.setState(2);
			cmsg.setCvo(cvo);
			try {
				ClientHandler.oos.writeObject(cmsg);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new JoinFrame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	//Ű���� �Է� �̺�Ʈ (�Ϻ��ϰ� ������ ���� ��츸 ����)
	@Override
	public void keyReleased(KeyEvent e) {
		
		String pwd = pwdField.getText();
		String pwdOk = pwdOkField.getText();
		if(pwd.equals(pwdOk)) {
			//��Ʈ ����
			pwdChekL.setForeground(Color.black);
			pwdChekL.setText("��й�ȣ Ȯ�� �Ϸ�");
			pwdCheck=1;
		}else {
			//��Ʈ ����
			pwdChekL.setForeground(Color.red);
			pwdChekL.setText("��й�ȣ�� ���� �ʽ��ϴ�.");
			pwdCheck=0;
		}
		
	}
	
	
	
	//���̵� �ߺ�üũ ��� ó��
	public void idCheckResult(int result) {
		if(result == 0) {
			//result == 0
			//��밡���� ���̵� �Դϴ�.
			JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�.");
			idCheck = 1;
		}else {
			//result ==? 
			//�̹������ϴ� ���̵� �Դϴ�.
			//idField�� �ִ� ���� �����ְ� ��Ŀ�� �����ش�.
			JOptionPane.showConfirmDialog(null, "�̹� �����ϴ� ���̵� �Դϴ�.","���",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			idField.setText("");
			idField.requestFocus();
			idCheck = 0;
		}
	}
	
	//ȸ������ ��� ó��
	public void joinCheck(CustomerMessage cm) {
		if(cm.getResult()!=0) {
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
			dispose();
			
		}else {
			JOptionPane.showConfirmDialog(null, "�߸��� ������ �Է��Ͽ����ϴ�.","���",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	
	
	
	
}
