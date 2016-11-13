import java.awt.*;

import java.awt.event.*;

class Ex02_sub extends Frame implements MouseListener,MouseMotionListener{
	BorderLayout bl=new BorderLayout();
	Button bt=new Button("Ok");
	Label lb=new Label("x=000,y=000");
	
	public Ex02_sub(String title){
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
			this.setLayout(bl);
			this.add("North", lb);
			this.add("South", bt);
		}
		public void start(){
			bt.addMouseListener(this);
			this.addMouseMotionListener(this);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==bt){
				bt.setLabel("on the Button");
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==bt){
				bt.setLabel("out the Button");
			}
			
		}
		@Override
		
		
		
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
				int x=e.getX();
				int y=e.getY();
						
						
				lb.setText("x="+x+",y="+y);
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		
		}
}

public class Ex02 {
	public static void main(String ar[]){
		Ex02_sub ex=new Ex02_sub("오예");
	}

}
