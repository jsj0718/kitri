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

public class ServerFrame extends JFrame {
	private JPanel panel = new JPanel(new BorderLayout());
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private JTextField textField = new JTextField();
	
	public ServerFrame() {
		this.setTitle("로그");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 400, 400); // 창을 어디에 띄울지 좌표 선언 (단위는 픽셀)
		textArea.setFocusable(false);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(textField, BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		this.setVisible(true);
		
		
	}
	
	public void putLogText(String msg) {
		textArea.append(msg + "\n");
		textArea.setCaretPosition(textArea.getText().length());	// 텍스트 길이만큼 내림
	}
	
	public static void main(String[] args) {
		new ServerFrame();
	}
	
}
