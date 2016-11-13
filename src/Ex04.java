import java.awt.*;
import java.awt.event.*;
class Ex04_sub extends Frame implements ItemListener,FocusListener, KeyListener{
	
	private TextField tf1=new TextField();
	private TextField tf2=new TextField();
	private Label lb1=new Label("NONE: ",Label.RIGHT);
	private Label lb2=new Label("NONE: ");
	private Choice ch=new Choice();
	private Label lb3=new Label("NONE: ");
	
	private Panel p1=new Panel();
	private Panel p2=new Panel();
	private GridLayout gl=new GridLayout(4,1);
	private GridLayout gl1=new GridLayout(1,2,5,5);
	private GridLayout gl2=new GridLayout(1,2,5,5);
	public Ex04_sub(String title){
		super(title); // 객체는 어디에 ?
		super.setSize(300,150);

		
		this.init();
		this.start();
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm=super.getSize();
		
		
		int xpos=(int)(screen.getWidth()/2-frm.getWidth()/2);
		int ypos=(int)(screen.getHeight()/2-frm.getHeight()/2);
		super.setLocation(xpos,ypos);
		super.setResizable(false);
		super.setVisible(true);
		
	}
	public void init(){
		this.setLayout(gl);
		p1.setLayout(gl1);
		p1.add(tf1);
		p1.add(tf2);
		
		this.add(p1);
		p2.setLayout(gl2);
		p2.add(lb1);
		p2.add(lb2);
		
		this.add(p2);
		ch.add("NONE");
		for(char c='A';c<='Z';c++){
			String str=""+c+c+c;
			ch.add(str);
		}
		this.add(ch);
		this.add(lb3);
		
	}
	public void start(){
		tf1.addFocusListener(this);
		tf2.addFocusListener(this);
		tf1.addKeyListener(this);
		tf2.addKeyListener(this);
		ch.addItemListener(this);
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf1){
			lb1.setText("first");
		}else if(e.getSource()==tf2){
			lb1.setText("second");
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==tf1){
			int cnt=tf1.getText().trim().length();
			lb2.setText(cnt+"");
		}else if(e.getSource()==tf2){
			int cnt=tf2.getText().trim().length();
			lb2.setText(cnt+"");
		}
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ch){
			String str=ch.getSelectedItem();
			lb3.setText(str);
		}
	}
}

public class Ex04 {
	public static void main(String ar[]){
		Ex04_sub ex=new Ex04_sub("제목");
	}

}
