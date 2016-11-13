import java.awt.*;
import java.awt.event.*; // awt와 별개로 따로 import 해줘야함
class Ex01_sub extends Frame /*implements MouseListener*/{
	private Button bt=new Button("확인");
	GridBagLayout gbl=new GridBagLayout();
	
	public Ex01_sub(String title){
		super(title); // 객체는 어디에 ?
		super.setSize(300,200);

		this.init();
		this.start(); //event 추가 thrad 추가
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm=super.getSize();
		
		
		int xpos=(int)(screen.getWidth()/2-frm.getWidth()/2);
		int ypos=(int)(screen.getHeight()/2-frm.getHeight()/2);
		super.setLocation(xpos,ypos);
		super.setResizable(false);
		super.setVisible(true);
		
	}
	public void init(){
		this.setLayout(gbl);
		this.add(bt);
	}
	
	public void start(){
		bt.addMouseListener(ma); //MouseListener --> MouseAdapter
	} // 익명 이너 클래스
	
	MouseAdapter ma=new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			System.exit(0);
		}
	};

	
	/*public void mouseClicked(MouseEvent e){
		System.exit(0);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}*/
}

public class Ex01 {
	public static void main(String ar[]){
		Ex01_sub ex=new Ex01_sub("제목");
	}

}



/*class A implements ActionListener{ //상속받으면 abstract 메소드를 재정의 꼭 해야함.
	
	
public void actionPerformed(ActionEvent e){
	System.exit(0);
}
	
}*/


/*class A extends MouseAdapter{
	public void mouseClicked(MouseEvent e){
		System.exit(0);
	}
}*/

/*class A implements MouseListener{ // 재정의 필요 5가지나해야하군... 
	public void mouseClicked(MouseEvent e){
		System.exit(0);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}*/