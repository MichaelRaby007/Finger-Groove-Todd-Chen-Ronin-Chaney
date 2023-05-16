
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 
import javax.swing.ImageIcon;
import javax.sound.sampled.*;
import java.io.*;

public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private ImageIcon background;
	private Arrow up;
	private Arrow down;
	private Arrow left;
	private Arrow right;
	private Clip clip;
	boolean soundIt;
	boolean music;

	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		background = new ImageIcon("disco.gif");
		up = new Arrow("up.png");
		down = new Arrow();
		left = new ImageIcon("left.png");
		right = new ImageIcon("right.png");
		soundIt = true;		
		music = true;
		gameMusic();
		playmusic();
		makeSound();
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
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		g2d.setColor(Color.WHITE);
		g2d.drawImage(up.getImage(), 80, 50, 2000, 1800, this);
		g2d.drawImage(down.getImage(), 20, 50, 2000, 1800, this);
		g2d.drawImage(left.getImage(), 60, 50, 2000, 1800, this);
		g2d.drawImage(right.getImage(), 400, 150, 50, 50, this);	
		g2d.drawImage(background.getImage(), 50, 50, 2000, 1800, this);
	
		g2d.drawString("Let's get in the Grooooooove!", 500, 100);
	
		twoDgraph.drawImage(back, null, 0, 0);

	}

	private void gameMusic()
	{
		if(music) playmusic("Music.wav");
		music = false;
	}



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void makeSound(String soundfile) {
		File soundFile = new File(soundfile);
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream= AudioSystem.getAudioInputStream(soundFile);
			clip.open(inputStream);
			//clip.loop(clip.LOOP_CONTINUOUSLY);
			clip.start();
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

//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		if (key == 37) {
			makeSound("23.wav");
		}
		if (key == 38) {
			makeSound("23.wav");
		}
		if (key == 39) {
			makeSound("23.wav");
		}
		if (key == 40) {
			makeSound("23.wav");
		}
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}
