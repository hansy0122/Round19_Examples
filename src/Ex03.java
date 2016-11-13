import java.awt.*;
import java.awt.event.*;

class Ex03_sub extends Frame implements ActionListener, WindowListener{	
		MenuBar mb=new MenuBar();
		Menu m=new Menu("FILE");
		MenuItem fopen=new MenuItem("OPEN");
		MenuItem fsave=new MenuItem("SAVE");
		FileDialog fdlg1=new FileDialog(this,"open mine",FileDialog.LOAD);
		FileDialog fdlg2=new FileDialog(this,"save mine",FileDialog.SAVE);
		
	
	
	public Ex03_sub(String title){
		super(title); // 객체는 어디에 ?
		super.setSize(300,200);
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
		this.setMenuBar(mb);
		mb.add(m);
		m.add(fopen);
		m.add(fsave);
		
	}
	public void start(){
		
	/*	// 다른방법 1
		WindowAdapter wa=new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		this.addWindowListener(wa);*/
		
		/*
		// 다른방법 2
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		*/
		
		fopen.addActionListener(this);
		fsave.addActionListener(this);
		this.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fopen){
			fdlg1.setVisible(true);
		}else if(e.getSource()==fsave){
			fdlg2.setVisible(true);
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
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
	
}

public class Ex03 {
	public static void main(String ar[]){
		Ex03_sub ex=new Ex03_sub("제목");
	}

}

