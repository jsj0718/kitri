package client.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.program.ClientHandler;
import customer.CustomerVO;
import message.CustomerMessage;

public class JoinFrame extends JFrame implements ActionListener {
	JPanel joinPanel;
	
	// 회원가입 화면에 필요한 변수 선언
	JLabel joinL, idL, passwordL, passwordCheckL, nameL, addressL, phoneL;	
	JTextField idField, passwordField, passwordCheckField, nameField, addressField, phoneField; 	
	JButton idCheckBtn, joinBtn, cancelBtn;

	
	public JoinFrame() {
		this.setTitle("회원가입");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(400, 200, 350, 500);
		this.setLayout(null);	// Absolute Layout
		setComponent();
		this.setVisible(true);
	}
	
	public void setComponent() {
		joinPanel = new JPanel();
		joinPanel.setLayout(null);
		
		// 라벨
		joinL = new JLabel();
		idL = new JLabel();
		passwordL = new JLabel();
		passwordCheckL = new JLabel();
		nameL= new JLabel();
		addressL = new JLabel();
		phoneL = new JLabel();
		
		// 텍스트 필드
		idField = new JTextField();
		passwordField = new JTextField();
		passwordCheckField = new JTextField();
		nameField = new JTextField();
		addressField = new JTextField();
		phoneField = new JTextField();
		
		// 버튼
		idCheckBtn = new JButton();
		cancelBtn = new JButton();
		joinBtn = new JButton();
		
		// 텍스트 필드, 버튼 값 넣기
		joinL.setText("회원가입");
		joinL.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		joinL.setHorizontalAlignment(JLabel.CENTER);
		idL.setText("아이디 : ");
		passwordL.setText("비밀번호 : ");
		passwordCheckL.setText("비밀번호 확인 : ");
		nameL.setText("이름 : ");
		addressL.setText("주소 : ");
		phoneL.setText("번호 : ");
		
		idCheckBtn.setText("중복 확인");
		joinBtn.setText("회원가입");
		cancelBtn.setText("취소");
		
		joinL.setHorizontalAlignment(JLabel.CENTER);
		
		// 라벨, 텍스트 필드, 버튼 크기 설정
		joinL.setBounds(56, 22, 227, 44);
		idL.setBounds(12, 84, 85, 32);
		passwordL.setBounds(12, 126, 85, 32);
		passwordCheckL.setBounds(12, 170, 85, 32);
		nameL.setBounds(12, 213, 85, 32);
		addressL.setBounds(12, 255, 85, 32);
		phoneL.setBounds(12, 297, 85, 32);
		
		idField.setBounds(98, 90, 113, 21);
		passwordField.setBounds(98, 130, 180, 21);
		passwordCheckField.setBounds(98, 174, 180, 21);
		nameField.setBounds(98, 217, 180, 21);
		addressField.setBounds(98, 259, 180, 21);
		phoneField.setBounds(98, 301, 180, 21);
		
		idCheckBtn.setBounds(230, 90, 100, 19);
		joinBtn.setBounds(70, 400, 90, 30);
		cancelBtn.setBounds(180, 400, 90, 30);
		
		// 패널에 넣기
		joinPanel.add(joinL);
		joinPanel.add(idL);
		joinPanel.add(passwordL);
		joinPanel.add(passwordCheckL);
		joinPanel.add(nameL);
		joinPanel.add(addressL);
		joinPanel.add(phoneL);
		joinPanel.add(idField);
		joinPanel.add(passwordField);
		joinPanel.add(passwordCheckField);
		joinPanel.add(nameField);
		joinPanel.add(addressField);
		joinPanel.add(phoneField);
		joinPanel.add(idCheckBtn);
		joinPanel.add(joinBtn);
		joinPanel.add(cancelBtn);
		
		// 패널 위치 및 크기 설정
		joinPanel.setBounds(0, 0, 300, 230);
				
		// 패널을 프레임에 올리기
		this.setContentPane(joinPanel);
		eventList();
	}
	
	public void eventList() {
		cancelBtn.addActionListener(this);
		idCheckBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (cancelBtn == e.getSource()) {
			// 회원가입 창만 종료
			dispose();
		} 
		
		if (idCheckBtn == e.getSource()) {
			// ID 입력 -> 서버로 ID를 보내야하는 상황
			String id = idField.getText();
			
			if (id == null || id.equals("")) {
				JOptionPane.showConfirmDialog(null, "아이디를 입력해주세요.", 
						"경고", JOptionPane.DEFAULT_OPTION);
				idField.requestFocus();
				return;
			}
			CustomerMessage cmsg = new CustomerMessage();
			CustomerVO cvo = new CustomerVO();
			cvo.setCustID(id);
			cmsg.setCvo(cvo);
			cmsg.setState(1);	// 1 : ID Check (in CUSTOMER)
						
			// write
			ObjectOutputStream oos = ClientHandler.oos;
			try {
				oos.writeObject(cmsg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	public void idCheckOk(int result) {
		// result == 1
		// 사용 가능한 아이디입니다.
		if (result == 0) {
			JOptionPane.showConfirmDialog(null, "사용 가능한 아이디입니다.", 
					"확인", JOptionPane.DEFAULT_OPTION);
			return;
		}
		// result == ?
		// 이미 존재하는 아이디입니다.
		// idField에 있는 값을 지우고 포커싱한다.
		else {
			JOptionPane.showConfirmDialog(null, "이미 존재하는 아이디입니다.", 
					"경고", JOptionPane.DEFAULT_OPTION);
			idField.setText("");
			idField.requestFocus();
			return;
		}
	}

	public static void main(String[] args) {
		new JoinFrame();
	}

	
	
}
