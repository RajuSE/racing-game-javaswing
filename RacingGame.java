import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class RacingGame extends JFrame implements ActionListener{
	
	private int fwidth=870, fheight=300;
	private Image objectA=new ImageIcon("railroad_18.png").getImage();//Way1: Using Image
	private Image objectB=new ImageIcon("railroad_blue_18.png").getImage();
	private Image winnerObj=new ImageIcon("winner_48.png").getImage();

//	private Thread thread;
	private volatile int objAX=100;
	private volatile int objBX=100;
	
    JButton btnRestart = new JButton(" New Race ");
    JButton btnRace = new JButton(" Race Now ");
    JPanel pnlButton ;

	
	public RacingGame(){
		
		
		
//        btnRace.setBounds(200, 400, 100, 50);
//        btnRestart.setBounds(500, 400, 100, 50);
		
		pnlButton= new JPanel();
		

//		pnlButton.setBounds(10, 400, 100, 50);
		pnlButton.setBackground(Color.lightGray);
//		pnlButton.setLayout(null);
//        pnlButton.setLocation(20,20);

		
//		runnable=(Runnable)this;

		btnRace.setActionCommand("RaceNow");
		btnRace.addActionListener(this);
		
		btnRestart.setActionCommand("NewRace");
		btnRestart.addActionListener(this);
		
		pnlButton.add(btnRace);
		pnlButton.add(btnRestart);
		btnRace.setEnabled(true);
		pnlButton.setLocation(20,20);
		add(pnlButton);
		
		setBounds(50, 60, fwidth, fheight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		
//		try {
//			cloud=ImageIO.read(new File("cloud_icon.png"));//Way2
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			sun=ImageIO.read(new File("sun_medium.png"));//Way2
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public void paint(final Graphics g){
		g.setColor(Color.green);
		fwidth = getWidth();
	    fheight = getHeight();
		g.fillRect(0, 70, fwidth, fheight);

		g.setColor(Color.gray);
		g.fillOval(100, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(130, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(160, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(190, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(220, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(250, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(280, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(310, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(340, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(370, 160, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(400, 160, 1, 1);
		
		g.setColor(Color.gray);
		g.fillOval(100, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(130, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(160, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(190, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(220, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(250, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(280, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(310, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(340, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(370, 210, 1, 1);
		g.setColor(Color.gray);
		g.fillOval(400, 210, 1, 1);
		

		g.setColor(Color.white);
		g.fillRect(590, 145, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 150, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 155, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 160, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 165, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 170, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 175, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 180, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 185, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 190, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 195, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 200, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 205, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 210, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 215, 20, 4);
		g.setColor(Color.black);
		g.fillRect(590, 220, 20, 4);
		g.setColor(Color.white);
		g.fillRect(590, 225, 20, 4);
		
		
//		g.setColor(Color.white);
//		g.fillRect(30, 40, 100, 50);
//		
//		g.setColor(Color.cyan);
//		g.fillOval(150, 150, 200, 200);
//		
		g.drawImage(objectA, objAX, 150, null);
		g.drawImage(objectB, objBX, 200, null);
		synchronized (this) {
		if(decided){
			g.drawImage(winnerObj, 650, 150, null);
			    g.setColor(Color.yellow);
				g.drawString("Winner is ", 700, 170);
			    g.setColor(Color.black);
				g.drawString(winnerCar[0], 758, 170);
			}
		}
		
	}
	
	
	volatile static String[] winnerCar=new String[1];

	private static int getRandomInteger(int aStart, int aEnd, Random aRandom){
	    if (aStart > aEnd) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * aRandom.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);    
	    return randomNumber;
	  }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RacingGame();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getActionCommand().endsWith("RaceNow")){
		MyThread thread1=new MyThread();
		thread1.start();
		SecondThread thread2=new SecondThread();
		thread2.start();
		
		}else if(arg0.getActionCommand().endsWith("NewRace")){
			objAX=100;
			objBX=100;
			repaint();
			decided=false;
		}
	}
	

	class MyThread extends Thread{
		public void run(){
			while(objAX<572 ){
				
				int START = 1;
			    int END = 10;
			    Random random = new Random();
			    objAX=objAX+getRandomInteger(START, END, random);
			      
				repaint();
				try{
					Thread.sleep(11);
				}catch(InterruptedException ie){
					System.out.println(ie.getMessage());
				}
			}
			
//			finalDecision();
		}
	}
	
	volatile boolean decided=false;
	void finalDecision(){
		synchronized (this) {
			if(!decided){
			if(objAX>571){
				winnerCar[0]="Orange Car";
				System.out.println(winnerCar[0]);
				repaint();
				decided=true;
			}else if(objBX>571){
				winnerCar[0]="Blue Car";
				System.out.println(winnerCar[0]);
				repaint();
				decided=true;
			}else {
				decided=false;
			}
			}
		}
	}
	
	
	class SecondThread extends Thread{
		public void run(){
			while( objBX<572 ){
				
				int START = 1;
			    int END = 10;
			    Random random = new Random();
			      objBX=objBX+getRandomInteger(START, END, random);
				repaint();
				try{
					Thread.sleep(11);
				}catch(InterruptedException ie){
					System.out.println(ie.getMessage());
				}
			}
			
			finalDecision();
			
		}
	}
	
}
