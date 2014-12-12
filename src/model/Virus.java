package model;

import view.VirusSprite;

public class Virus extends SpriteObject 
{
	public Virus(int x, int y)
	{
		super(new VirusSprite(), x, y, 100);
	}
}
