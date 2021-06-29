package multinetwork;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// GUI를 위해 JFrame 상속
public class ClientFrame extends JFrame {
	// 화면을 위해 패널 생성
	private JPanel panel = new JPanel(new BorderLayout());
	// 텍스트 공간 생성
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private JTextField textField = new JTextField();
	private String id = "";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClientFrame() {
		this.setTitle("채팅");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 400, 400); // 창을 어디에 띄울지 좌표 선언 (단위는 픽셀)
		textArea.setFocusable(false);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(textField, BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		this.setVisible(true);
		
		while (true) {
			id = JOptionPane.showInputDialog(this, "대화명을 입력해주세요.", 
					"대화명 입력", JOptionPane.QUESTION_MESSAGE);
			
			if (id != null && !id.equals("")) {
				break;
			}
		}
		
		textField.addActionListener(new ActionListener() {
			
			// textField에 엔터 이벤트가 들어가면 동작
			@Override
			public void actionPerformed(ActionEvent e) {
				DataOutputStream dos = Client.dos;
				try {
					dos.writeUTF("★"+ id + "★" + textField.getText());
					putChatText("!" + id + "!" + textField.getText());
					textField.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(textField.getText());
			}
		});
	}
	
	public void putChatText(String msg) {
		textArea.append(msg + "\n");
		textArea.setCaretPosition(textArea.getText().length());	// 텍스트 길이만큼 내림
	}
	
	public static void main(String[] args) {
		new ClientFrame();
	}

}
