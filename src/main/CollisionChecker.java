package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
public CollisionChecker(GamePanel gp) {
this.gp = gp;

}
public void checkTile(Entity entity) {

	int entityLeftWorldx = entity.worldx + entity.solidArea.x;
	int entityRightWorldx = entity.worldx + entity.solidArea.x + entity.solidArea.width;
	int entitytopworldy = entity.worldy + entity.solidArea.y;
	int entitybottomworldy = entity.worldy + entity.solidArea.y + entity.solidArea.height;
	
	int entityleftcol = entityLeftWorldx/gp.tileSize;
	int entityrightcol = entityRightWorldx/gp.tileSize;
	int entitytoprow = entitytopworldy/gp.tileSize;
	int entitybottomrow = entitybottomworldy/gp.tileSize;
	
	int tileNum1, tileNum2;
	
	// next do switch statement 
	
}
}

