package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
public int worldx,worldy;
public int speed;
public BufferedImage up1, up2,down1,down2,left1,left2,right1,right2;
public String direction;
public int spriteCounter = 0;
public int spriteNum = 1;
public int SpriteCounter = 0;
public Rectangle solidArea;

public boolean collisionOn = false;
}
