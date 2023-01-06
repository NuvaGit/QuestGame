package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
GamePanel gp;
tile[] tile;
int mapTileNum[][];
public TileManager(GamePanel gp) {
	this.gp = gp;
	tile = new tile[10];
	mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
	getTileImage();
	loadMap("/maps/world2.txt");
}
public void getTileImage() {
	try {
		//grass
		tile[0] = new tile();
		tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/finalgrass.png"));
		// walls
		tile[1] = new tile();
		tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava2.png"));
		// acid
		tile[2] = new tile();
		tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
		// dirt
		tile[3] = new tile();
		tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth2.png"));
		//trees
		tile[4] = new tile();
		tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree2.png"));
	    //sand	
		tile[5] = new tile();
		tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand2.png"));
		
	}
	catch(IOException e ) {
		e.printStackTrace();
	}
}

public void loadMap(String filepath) {
	try {
		
		InputStream is = getClass().getResourceAsStream(filepath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		
		int col = 0;
		int row = 0;


		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			String line = br.readLine();
			
			while(col < gp.maxWorldCol) {
			
				String numbers[] = line.split(" ");
			
				int num = Integer.parseInt(numbers[col]);
			
			mapTileNum[col][row] = num;
			col++;
			
			}
			if(col == gp.maxWorldCol) {

				col =0;
				row++;
			}
			}
			br.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public void draw(Graphics2D g2) {

	
	int Worldcol = 0;
	int Worldrow = 0;
	
	
	while(Worldcol< gp.maxWorldCol && Worldrow < gp.maxWorldRow) {
		int tileNum = mapTileNum[Worldcol][Worldrow];
		
		int worldx = Worldcol * gp.tileSize;
		int worldy = Worldrow * gp.tileSize;
		int screenx = worldx - gp.player.worldx + gp.player.screenx;
		int screeny = worldy - gp.player.worldy + gp.player.screeny;
		
		
		if(worldx + gp.tileSize > gp.player.worldx - gp.player.screenx && 
				worldx - gp.tileSize < gp.player.worldx + gp.player.screenx &&
				worldy + gp.tileSize > gp.player.worldy - gp.player.screeny &&
				worldy - gp.tileSize < gp.player.worldy + gp.player.screeny) {
			
			g2.drawImage(tile[tileNum].image,screenx,screeny,gp.tileSize,gp.tileSize,null);

		}
		
		Worldcol++;

		if(Worldcol == gp.maxWorldCol) {
			Worldcol = 0;
			Worldrow++;
		}
		
	}


}
}
