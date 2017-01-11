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

	private volatile int objAX=100;
	private volatile int objBX=100;
	
    JButton btnRestart = new JButton(" New Race ");
    JButton btnRace = new JButton(" Race Now ");
    JPanel pnlButton ;

	
	public RacingGame(){

		pnlButton= new JPanel();
		pnlButton.setBackground(Color.lightGray);
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

	}
	
	@Override
	public void paint(final Graphics g){
		g.setColor(Color.green);
		fwidth = getWidth();
	    fheight = getHeight();
		g.fillRect(0, 70, fwidth, fheight);

		g.setColor(Color.red);
		for(int i=100; i<600; i=i+30){
            g.fillOval(i, 160, 5, 5);
        }

		g.setColor(Color.blue);
        for(int i=100; i<600; i=i+30){
            g.fillOval(i, 210, 5, 5);
        }

		
        for(int i=145; i<=225;){
            g.setColor(Color.white);
            g.fillRect(590, i, 20, 4);
            g.setColor(Color.black);
            i=i+5;
            g.fillRect(590, i, 20, 4);
            i=i+5;
        }

		
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