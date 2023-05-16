import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.*; 
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.Timer;

public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private JPanel panel;
	
	private ArrayList <Integer> flashSequence;
	//numbList = new ArrayList <0, 1, 2 , 4>;
	private List<ImageIcon> arrowList;
	private ImageIcon background;
	private ImageIcon up;
	private ImageIcon down;
	private ImageIcon left;
	private ImageIcon right;
	private boolean showText;
	private boolean showImage;
	private Timer timer;
	boolean soundIt;
	boolean music;
	boolean music2;
	
	private enum Arrow {
		Green, Red, Blue, Yellow;
	}
	
	private void appendFlashSequence()
	{
		if (flashSequence == null) {
			flashSequence = new ArrayList<Integer>();
		}
		
		flashSequence.add(getNextArrow());
	}
	

		
		
		
		
	
	
	private int getNextArrow() {
		Random random = new Random();
		return random.nextInt(4);
		
	}
	
	public Game() 
	{
		Init();
		//setFlashSequence();
	}

	private void Init()
	{
		new Thread(this).start();	

		
		initConfig();
		SetInitCanvas();
		gameMusic();
		this.appendFlashSequence();
		this.addKeyListener(this);
	}
	
	private void initConfig() {
		key =-1;
		music = true;
		music2 = false;
		soundIt = true;
	}
	
	
	
	private void SetInitCanvas() 
	{
		background = new ImageIcon("disco.gif");
		up = new ImageIcon("up.png");
		down = new ImageIcon("down.png");
		left = new ImageIcon("left.png");
		right = new ImageIcon("right.png");
	}
	
	
	
	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
		
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Impact", Font.BOLD, 50));
		g2d.setColor(Color.WHITE);
		
		g2d.drawImage(background.getImage(), 0, 0, 1800, 1400, this);
		g2d.drawString("Let's get in the Grooooooove!", 395, 100);
		g2d.drawImage(up.getImage(), 650, 225, 175, 175, this);
		g2d.drawImage(down.getImage(), 650, 425, 175, 175, this);
		g2d.drawImage(left.getImage(), 500, 325, 175, 175, this);
		g2d.drawImage(right.getImage(), 800, 350, 150, 150, this);
		if (key == 37) {
			g2d.setColor(Color.YELLOW);
			g2d.drawString("LEFT", 425, 375);
		}
		
		if (key == 38) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("UP", 650, 250);
		}
		if (key == 39) {
			g2d.setColor(Color.RED);
			g2d.drawString("RIGHT", 900, 375);
		}
		if (key == 40) {
			g2d.setColor(Color.BLUE);
			g2d.drawString("DOWN", 650, 625);
		}

		
	
		twoDgraph.drawImage(back, null, 0, 0);
		
		
	}

	
	private void gameMusic()
	{
		if (music) playmusic("Music.wav");
		music = false;
		
	}
	
		
	




	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		if (key == 37) {
			playmusic("23.wav");
		}
		if (key == 38) {
			playmusic("23.wav");
		}
		if (key == 39) {
			playmusic("23.wav");
		}
		if (key == 40) {
			playmusic("23.wav");
		}
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
		public void playmusic(String musicfile) 
		{
			File soundFile = new File(musicfile);
			try {
				Clip clip = AudioSystem.getClip();
				AudioInputStream inputStream= AudioSystem.getAudioInputStream(soundFile);
				clip.open(inputStream);
				clip.start();
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	

	
}
