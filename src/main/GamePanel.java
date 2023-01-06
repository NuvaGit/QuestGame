 package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
final int originaltilesize = 16;
final int scale = 3;
public final int tileSize = originaltilesize * scale;
public final int maxscreencol = 16;

public final int maxscreenrow = 12;
public final int screenwidth = tileSize * maxscreencol;
public final int screenheight = tileSize * maxscreenrow;

//world settings

public final int maxWorldCol = 50;
public final int maxWorldRow = 50;
public final int worldWidth = tileSize * maxWorldCol; 
public final int worldHeight = tileSize * maxWorldRow; 


int FPS = 60; //FPS

TileManager tileM = new TileManager(this);

KeyHandler keyH = new KeyHandler();
Thread gameThread;

public Player player = new Player(this,keyH);

// set payer pos
int playerX = 100;
int playerY = 100;
int playerSpeed = 4;


public GamePanel() {
	this.setPreferredSize(new Dimension(screenwidth,screenheight));
	this.setBackground(Color.black);
	this.setDoubleBuffered(true);
	this.addKeyListener(keyH);
	this.setFocusable(true);
}
public void startGameThread() {
	gameThread = new Thread(this);
	gameThread.start();
}
@Override
public void run() {
	
	double drawInterval = 1000000000/FPS;
	double nextDrawTime = System.nanoTime() + drawInterval;
	
	//creat the game loop
	
	while(gameThread != null) {
		update();
		repaint(); //constatly painting
		
		try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;	
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		 
	}
}

 
public void update() {
	player.update();
}


public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	tileM.draw(g2);
	
	player.draw(g2);
	
	g2.dispose(); 
	
}
}
