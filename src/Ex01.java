import java.awt.*;
import java.awt.event.*; // awt�� ������ ���� import �������
class Ex01_sub extends Frame /*implements MouseListener*/{
	private Button bt=new Button("Ȯ��");
	GridBagLayout gbl=new GridBagLayout();
	
	public Ex01_sub(String title){
		super(title); // ��ü�� ��� ?
		super.setSize(300,200);

		this.init();
		this.start(); //event �߰� thrad �߰�
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
	} // �͸� �̳� Ŭ����
	
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
		Ex01_sub ex=new Ex01_sub("����");
	}

}



/*class A implements ActionListener{ //��ӹ����� abstract �޼ҵ带 ������ �� �ؾ���.
	
	
public void actionPerformed(ActionEvent e){
	System.exit(0);
}
	
}*/


/*class A extends MouseAdapter{
	public void mouseClicked(MouseEvent e){
		System.exit(0);
	}
}*/

/*class A implements MouseListener{ // ������ �ʿ� 5�������ؾ��ϱ�... 
	public void mouseClicked(MouseEvent e){
		System.exit(0);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}*/