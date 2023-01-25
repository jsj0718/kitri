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

// GUI�� ���� JFrame ���
public class ClientFrame extends JFrame {
	// ȭ���� ���� �г� ����
	private JPanel panel = new JPanel(new BorderLayout());
	// �ؽ�Ʈ ���� ����
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
		this.setTitle("ä��");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 400, 400); // â�� ��� ����� ��ǥ ���� (������ �ȼ�)
		textArea.setFocusable(false);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(textField, BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		this.setVisible(true);
		
		while (true) {
			id = JOptionPane.showInputDialog(this, "��ȭ���� �Է����ּ���.", 
					"��ȭ�� �Է�", JOptionPane.QUESTION_MESSAGE);
			
			if (id != null && !id.equals("")) {
				break;
			}
		}
		
		textField.addActionListener(new ActionListener() {
			
			// textField�� ���� �̺�Ʈ�� ���� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				DataOutputStream dos = Client.dos;
				try {
					dos.writeUTF("��"+ id + "��" + textField.getText());
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
		textArea.setCaretPosition(textArea.getText().length());	// �ؽ�Ʈ ���̸�ŭ ����
	}
	
	public static void main(String[] args) {
		new ClientFrame();
	}

}
