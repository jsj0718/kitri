package booktest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	DefaultTableModel bookDTM;	// 테이블을 더 쉽게 다루기 위한 객체
	JTable bookTable;
	JScrollPane scroll;
	
	JLabel bookNameL, publisherL, priceL;
	
	JTextField bookIdField, bookNameField, publisherField, priceField;
	
	JButton registBtn, updateBtn, deleteBtn;
	
	BookDAO bdao = new BookDAO();
	String item = "책번호";
	
	public BookFrame() {
		this.setTitle("책 관리 시스템");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// close 버튼 생성
		this.setBounds(700, 200, 430, 550);	// 화면이 어디에 뜰건지 설정, 화면의 크기 설정
		this.setLayout(null);
		setComponent();	// setComponent() 실행
		
		this.setVisible(true);	// true로 설정해야 화면이 뜬다.
	}
	
	public void setComponent() {
		panel = new JPanel();
		panel.setLayout(null);
		
		// 타이틀
		subTitle = new JLabel();
		subTitle.setText("BOOK TABLE 관리 시스템");	// 타이틀 이름 넣기
		subTitle.setBounds(130, 20, 150, 15);
		
		// 검색창
		String[] columns = {"책번호", "책이름", "출판사", "가격"};
		items = new JComboBox<String>(columns);
		items.setBounds(20, 40, 120, 30);
		
		searchField = new JTextField();
		searchField.setBounds(140, 40, 180, 30);
		
		searchBtn = new JButton();
		searchBtn.setText("검색");
		searchBtn.setBounds(320, 40, 69, 30);
		
		// 테이블
		bookDTM = new DefaultTableModel(columns, 0);	// 테이블을 더 쉽게 다루기 위한 객체 (columns를 넣음으로써 제목 생김)
		bookTable = new JTable(bookDTM);
		scroll = new JScrollPane(bookTable);
		scroll.setBounds(20, 80, 370, 270);
		initBookTable();
		
		// 등록(라벨)
		bookNameL = new JLabel();
		bookNameL.setText("책 이름");
		bookNameL.setBounds(30, 370, 120, 15);
		
		publisherL = new JLabel();
		publisherL.setText("출판사");
		publisherL.setBounds(160, 370, 120, 15);
		
		priceL = new JLabel();
		priceL.setText("가격");
		priceL.setBounds(290, 370, 120, 15);
		
		// 등록(필드)
		bookIdField = new JTextField();
		
		bookNameField = new JTextField();
		bookNameField.setBounds(20, 390, 110, 30);
		
		publisherField = new JTextField(); 
		publisherField.setBounds(150, 390, 110, 30);
		
		priceField = new JTextField();
		priceField.setBounds(280, 390, 110, 30);
		
		// 등록(버튼)
		registBtn = new JButton();
		registBtn.setText("등록");
		registBtn.setBounds(20, 430, 110, 30);
		
		updateBtn = new JButton();
		updateBtn.setText("수정");
		updateBtn.setBounds(150, 430, 110, 30);
		
		deleteBtn = new JButton();
		deleteBtn.setText("삭제");
		deleteBtn.setBounds(280, 430, 110, 30);
		
		// 패널에 올리기
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
		
		// 패널 위치 및 크기 설정
		panel.setBounds(0, 0, 400, 550);
		
		// 패널을 프레임에 올리기
		this.setContentPane(panel);
		
		eventList();
	}
	
	public void eventList() {
		// 검색 버튼
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// searchBtn 버튼을 눌렀을 때 Action 동작하는 실행문
				bookDTM.setNumRows(0);	// 기존 테이블 내용 초기화
				
				ArrayList<BookVO> blist = bdao.select(item, searchField.getText());
				addRowBook(blist);
				
				searchField.setText("");
			}
		});
		
		// 콤보박스에서 값 꺼내기
		items.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				item = items.getSelectedItem().toString();
				
			}
		});
		
		// 등록 버튼
		registBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] bookColumns = new String[4];
				bookColumns[0] = "";
				bookColumns[1] = bookNameField.getText();
				bookColumns[2] = publisherField.getText();
				bookColumns[3] = priceField.getText();
				
				// 입력창 빈 경우
				if (bookNameField.getText().equals("")) {
					// 알림창
					JOptionPane.showConfirmDialog(null, "책 이름을 입력하세요.", 
							"경고", JOptionPane.DEFAULT_OPTION);
					// 해당 필드에 커서를 둠
					bookNameField.requestFocus();
					return;
				}
				if (publisherField.getText().equals("")) {
					// 알림창
					JOptionPane.showConfirmDialog(null, "출판사를 입력하세요.", 
							"경고", JOptionPane.DEFAULT_OPTION);
					// 해당 필드에 커서를 둠
					publisherField.requestFocus();
					return;
				}
				if (priceField.getText().equals("")) {
					// 알림창
					JOptionPane.showConfirmDialog(null, "가격을 입력하세요.", 
							"경고", JOptionPane.DEFAULT_OPTION);
					// 해당 필드에 커서를 둠
					priceField.requestFocus();
					return;
				}
				
				BookVO bvo = new BookVO();
				
				bvo.setBookName(bookNameField.getText());
				bvo.setPublisher(publisherField.getText());
				bvo.setPrice(Integer.parseInt(priceField.getText()));
				
				if (bdao.insert(bvo) > 0) {;
					JOptionPane.showConfirmDialog(null, "등록에 성공했습니다.", 
							"성공", JOptionPane.DEFAULT_OPTION);
					bookNameField.setText("");
					publisherField.setText("");
					priceField.setText("");
					
					bookDTM.addRow(bookColumns);
				} else {
					JOptionPane.showConfirmDialog(null, "잘못된 입력입니다.", 
							"경고", JOptionPane.DEFAULT_OPTION);
					bookNameField.setText("");
					publisherField.setText("");
					priceField.setText("");
					bookNameField.requestFocus();
				}
			}
		});
	}
	
	// 테이블에 Book 정보 넣기
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
	
	public static void main(String[] args) {
		new BookFrame();
	}
	
}
