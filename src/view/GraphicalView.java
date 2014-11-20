package view;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GraphicalView extends JPanel implements Observer
{
	private Image tempCell, ground;
	private GermGame game;
	private GameMap map;
	
	public GraphicalView(GermGame theGame)
	{
		try
		{
			tempCell = ImageIO.read(new File("images/spaceinvader.png"));
			ground = ImageIO.read(new File("images/Ground.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		this.game = theGame;
	}
	public void update(Observable o, Object arg1)
	{
		repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		this.map = game.getMap();
		GameTile[][]board = map.getBoard();
		
		for( int r  = 0; r < map.getRows(); r++)
		{
			for(int c = 0; c< map.getColumns(); c++)
			{
				g2.drawImage(ground, r*35, c*35, null);
				
				if(board[r][c].hasUnit)
				{
					g2.drawImage(tempCell, r*35, c*35, null);
				}
			}
		}
	}
}
