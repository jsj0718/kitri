package client.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
	JPanel loginPanel;
	
	// 로그인 화면에 필요한 변수 선언
	JLabel loginL, idL, passwordL;	
	JTextField idField, passwordField; 	
	JButton loginBtn, joinBtn;
	
	public JoinFrame join;
	
	Socket socket;
	
	public LoginFrame(Socket socket) {
		this.socket = socket;
		this.setTitle("로그인");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(700, 400, 300, 230);
		this.setLayout(null);	// Absolute Layout
		setComponent();
		this.setVisible(true);
		eventList();
	}
	
	public void setComponent() {
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		
		// 라벨
		loginL = new JLabel();
		idL = new JLabel();
		passwordL = new JLabel();
		
		// 텍스트 필드
		idField = new JTextField();
		passwordField = new JTextField();
		
		// 버튼
		loginBtn = new JButton();
		joinBtn = new JButton();
		
		// 텍스트 필드, 버튼 값 넣기
		loginL.setText("로 그 인");
		idL.setText("ID : ");
		passwordL.setText("Password : ");
		
		loginBtn.setText("로그인");
		joinBtn.setText("회원가입");
		
		loginL.setHorizontalAlignment(JLabel.CENTER);
		
		// 라벨, 텍스트 필드, 버튼 크기 설정
		loginL.setBounds(0, 5, 300, 15);
		idL.setBounds(20, 25, 100, 30);
		passwordL.setBounds(20, 65, 100, 30);
		
		idField.setBounds(120, 25, 150, 30);
		passwordField.setBounds(120, 65, 150, 30);
		
		loginBtn.setBounds(50, 115, 90, 30);
		joinBtn.setBounds(150, 115, 90, 30);
		
		// 패널에 넣기
		loginPanel.add(loginL);
		loginPanel.add(idL);
		loginPanel.add(passwordL);
		loginPanel.add(idField);
		loginPanel.add(passwordField);
		loginPanel.add(loginBtn);
		loginPanel.add(joinBtn);
		
		// 패널 위치 및 크기 설정
		loginPanel.setBounds(0, 0, 300, 230);
				
		// 패널을 프레임에 올리기
		this.setContentPane(loginPanel);
				
	}
	
	public void eventList() {
		// 회원가입 버튼(actionPerformed()로 향함)
		joinBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (joinBtn == e.getSource()) {
			join = new JoinFrame();		// 생성자 호출로 실행시킴
		}
	}

//	public static void main(String[] args) {
//		new LoginFrame();
//	}
	
	
}
