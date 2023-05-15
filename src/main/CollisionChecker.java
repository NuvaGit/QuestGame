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

	switch(entity.direction) {
		case "up":
			entitytoprow = (entitytopworldy - entity.speed)/ gp.tileSize;

			tileNum1 = gp.tileM.mapTileNum[entityleftcol][entitytoprow];
			tileNum2  = gp.tileM.mapTileNum[entityrightcol][entitytoprow];
			if(gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true) {
entity.collisionOn = true;
			}
			break;
		case "down":
			entitybottomrow = (entitybottomworldy + entity.speed)/ gp.tileSize;

			tileNum1 = gp.tileM.mapTileNum[entityleftcol][entitybottomrow];
			tileNum2  = gp.tileM.mapTileNum[entityrightcol][entitybottomrow];
			if(gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				break;
			}
		case "left":
			entityleftcol = ((entityLeftWorldx - entity.speed) / gp.tileSize);

			tileNum1 = gp.tileM.mapTileNum[entityleftcol][entitytoprow];
			tileNum2  = gp.tileM.mapTileNum[entityleftcol][entitybottomrow];
			if(gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				break;
			}
		case "right":
			entityrightcol = ((entityLeftWorldx + entity.speed)/ gp.tileSize);

			tileNum1 = gp.tileM.mapTileNum[entityrightcol][entitybottomrow];
			tileNum2  = gp.tileM.mapTileNum[entityrightcol][entitybottomrow];
			if(gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				break;
				// tileNume1 = gp.tileM.tileNum[entityrightcol][entitybottomrow];
			}
	}
	// next do switch statement 
	
}
}

