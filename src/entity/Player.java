package entity;
import main.KeyHandler;
import main.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
GamePanel gp;
KeyHandler keyH;

public final int screenx;
public final int screeny;


public Player(GamePanel gp,KeyHandler keyH) {
	this.gp = gp;
	this.keyH = keyH;
	
	screenx = gp.screenwidth/2 - (gp.tileSize/2);
	screeny = gp.screenheight/2 - (gp.tileSize/2);
	
	solidArea = new Rectangle(8,16,gp.tileSize-16,gp.tileSize-16);
	
	setDefaultValues();
	getPlayerImage();
}
public void setDefaultValues() {
	worldx = gp.tileSize * 23;
	worldy = gp.tileSize * 21;
	speed = 4;
	direction = "up";
}
public void getPlayerImage() {
	try {
		up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
		up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
		down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
		down2 =ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
		left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
		left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
		right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
		right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

	}catch(IOException e) {
		e.printStackTrace();
	}
}
public void update() {
	if(keyH.upPressed == true) {
		direction = "up";
		worldy -=speed;
	}
	else if(keyH.downPressed == true) {
		direction = "down";

		worldy += speed;
	}
	else if(keyH.leftPressed == true) {
		direction = "left";

		worldx -= speed;
	}
	else if(keyH.rightPressed == true) {
		direction = "right";

		worldx += speed;
	}
	
	collisionOn = false;
	gp.checker.checkTile(this);
	
	
}
public void draw(Graphics2D g2) {
	//g2.setColor(Color.white);
	//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
	
	BufferedImage image = null;


	switch(direction) {
	case "up":
		image = up1;
		break;
	
case "down":
	image = down1;
	break;

case "left":
	image = left1;
	break;

case "right":
	image = right1;
	break;
}
	g2.drawImage(image, screenx, screeny, gp.tileSize, gp.tileSize,null);
    g2.dispose();
	
}
}
