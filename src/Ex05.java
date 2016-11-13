import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Ex05_sub extends Frame implements ActionListener, WindowListener,ItemListener {
	Label lb1 = new Label("글목록!", Label.LEFT);
	Label lb2 = new Label("글보기!", Label.CENTER);
	Button bt1 = new Button("글쓰기");
	Button bt2 = new Button("새로고침");
	Button bt3 = new Button("수정");
	Button bt4 = new Button("삭제");
	Button bt5 = new Button("종료");
	List l1 = new List();
	TextArea ta1 = new TextArea();
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	Panel p4 = new Panel();
	FlowLayout fl1 = new FlowLayout();
	FlowLayout fl2 = new FlowLayout();
	FlowLayout fl3 = new FlowLayout();

	Dialog w_dlg = new Dialog(this, "글쓰기", false);
	Label lb3 = new Label("글제목: ", Label.RIGHT);
	Label lb4 = new Label("작성자: ", Label.RIGHT);
	Label lb5 = new Label("첨부파일: ", Label.RIGHT);
	Label lb6 = new Label("글쓰기", Label.CENTER);
	Button bt6 = new Button("찾아보기");
	Button bt7 = new Button("등록");
	Button bt8 = new Button("취소");
	TextField tf1 = new TextField(70);
	TextField tf2 = new TextField(70);
	TextField tf3 = new TextField(60);
	TextArea ta2 = new TextArea();
	Panel p5 = new Panel();
	Panel p6 = new Panel();
	Panel p7 = new Panel();
	Panel p8 = new Panel();
	Panel p9 = new Panel();
	
	File dir = new File("boardData");
	File ff[]=dir.listFiles();

	Ex05_sub(String title) {
		super(title);
		this.setSize(800, 600);
		this.init();
		this.start();
		d_init();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		int x = (int) (screen.width - frm.width) / 2;
		int y = (int) (screen.height - frm.height) / 2;
		this.setLocation(x, y);
		w_dlg.setLocation(x, y);

		this.setResizable(true);
		this.setVisible(true);

	}

	public void d_init() {
		w_dlg.setSize(600, 500);
		w_dlg.setResizable(false);
		w_dlg.setLayout(new BorderLayout(10, 10));
		p5.setLayout(new GridLayout(4, 1, 1, 1));
		p5.add(lb6);

		p6.add(lb3);
		p6.add(tf1);
		p5.add(p6);

		p7.add(lb4);
		p7.add(tf2);
		p5.add(p7);

		p8.add(lb5);
		p8.add(tf3);
		p8.add(bt6);
		p5.add(p8);
		w_dlg.add(p5, "North");

		w_dlg.add("Center", ta2);

		p9.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p9.add(bt7);
		tf3.setBackground(Color.lightGray);
		tf3.setEnabled(false);
		p9.add(bt8);
		w_dlg.add("South", p9);

	}

	public void init() {
		this.setLayout(new GridLayout(1, 2, 10, 10));
		p1.setLayout(new BorderLayout(3, 3));
		p1.add("North", lb1);
		
		l1.removeAll();
		File ff[]=dir.listFiles();
		if(ff.length!=0){
			for (int i = 0; i < ff.length; i++) {
				l1.add((i + 1) + ": " + ff[i].getName());
				
			}}
		p1.add("Center", l1);
		p3.setLayout(new GridLayout(1, 2, 3, 3));
		p3.add(bt1);
		p3.add(bt2);
		p1.add("South", p3);
		this.add(p1);
		p2.setLayout(new BorderLayout(3, 3));
		p2.add(lb2, "North");
		ta1.setBackground(Color.lightGray);
		ta1.setEditable(false);
		p2.add(ta1, "Center");
		p4.setLayout(new GridLayout(1, 3, 3, 3));
		p4.add(bt3);
		p4.add(bt4);
		p4.add(bt5);
		p2.add(p4, "South");
		this.add(p2);

	}

	public void start() {
		w_dlg.addWindowListener(this);
		this.addWindowListener(this);
		bt1.addActionListener(this);
		bt3.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
		bt8.addActionListener(this);
		bt2.addActionListener(this);
		l1.addActionListener(this);
		bt4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bt1) {
			w_dlg.setVisible(true);
		}

		if (e.getSource() == bt2) {
			l1.removeAll();
			File ff[]=dir.listFiles();
			if(ff.length!=0){
			for (int i = 0; i < ff.length; i++) {
				l1.add((i + 1) + ": " + ff[i].getName());
				
			}}
		}
		
		if (e.getSource() == bt3) {
			if(l1.getSelectedItem()!=null){
			
			if (bt3.getLabel().equals("수정")) {
				bt3.setLabel("수정 중");
				ta1.setEditable(true);
				ta1.setBackground(Color.white);
				l1.setEnabled(false);
			}
				
			else if (bt3.getLabel().equals("수정 중")) {
				bt3.setLabel("수정");
				ta1.setEditable(false);
				ta1.setBackground(Color.lightGray);
				l1.setEnabled(true);
				String imsi=ta1.getText();
				String str=l1.getSelectedItem();
				str=str.substring(str.indexOf(":")+1).trim();
				File file=new File(dir,str);
				try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				out.print(imsi);
				out.close(); // 리셋하고 적는 기능이있는듯..(조금더 공부해 봐야겠긴하다)
				} catch (IOException ee) {
				}
				
			}
			}
		}
		

		if (e.getSource() == bt4) {
			if(l1.getSelectedItem()!=null){
				String str=l1.getSelectedItem();
				str=str.substring(str.indexOf(":")+1).trim();
				File file=new File(dir,str);
					file.delete();
					l1.removeAll();
					File ff[]=dir.listFiles();
					if(ff.length!=0){
						for (int i = 0; i < ff.length; i++) {
							l1.add((i + 1) + ": " + ff[i].getName());
							
						}}
				
			}
		}

		if (e.getSource() == bt5) {
			System.exit(0);
		}

		if (e.getSource() == bt6) {
			FileDialog fdlg = new FileDialog(w_dlg, "파일 첨부", FileDialog.LOAD);
			fdlg.setVisible(true);
			String str = fdlg.getDirectory().trim() + fdlg.getFile().trim();
			tf3.setText(str);
		}

		if (e.getSource() == bt7) {
			String str1 = tf1.getText();
			String str2 = tf2.getText();
			String str3 = tf3.getText();
			String str4 = ta2.getText();

			 // 폴더생성
			if (!dir.exists()) {
				dir.mkdir();
			}
			File file = new File(dir, str1 + " (" + str2 + ")"); // 파일생성
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				out.println("글제목: " + str1);
				out.println("작성자: " + str2);
				out.println("첨부파일: " + str3);
				out.println("내용 :"); // \n이 안먹나 ?? 이상한 문자뜸. 메모장으로볼때 --> 워드패드로 보면
										// ㄱㅊ
				out.println(str4);
				out.close();
			} catch (IOException ee) {
			}
			String str = "";
			tf1.setText(str);
			tf2.setText(str);
			tf3.setText(str);
			ta2.setText(str);
			File ff[]=dir.listFiles();
			l1.removeAll();
			
			for(int i=0;i<ff.length;i++){
				l1.add((i+1)+": "+ff[i].getName());
			}
			w_dlg.setVisible(false);

		}

		if (e.getSource() == bt8) {
			String str = ""; // 왜 null 값 ""으로 주면 작동을 안하지 ? // 디버깅 해보고 찾아보고 해봐야함
								// !!
			tf1.getText();
			tf2.getText();
			tf3.getText();
			ta2.getText();
			tf1.setText(str);
			tf2.setText(str);
			tf3.setText(str);
			ta2.setText(str);
			w_dlg.setVisible(false);
		
		}
		
		if(e.getSource()==l1){
			ta1.setText("");
			String str=l1.getSelectedItem();
			str=str.substring(str.indexOf(":")+1).trim();
			File file=new File(dir,str);
			try{
				BufferedReader in = new BufferedReader(new FileReader(file));
				while(true){
				String imsi=in.readLine();
				if(imsi==null)break;
				ta1.append(imsi+"\n");
				
				}
				in.close();
			} catch (IOException ee) {
			}
		
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this) {
			System.exit(0);
		}
		if (e.getSource() == w_dlg) {
			w_dlg.setVisible(false);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}

public class Ex05 {
	public static void main(String args[]) {
		Ex05_sub ex = new Ex05_sub("로컬 게시판");
	}
}