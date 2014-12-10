package model;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.util.TreeSet;

import javax.swing.JPanel;



public class CellRunner {
	private TreeSet<Character> keySet;
	private SpriteObject gBasic;
	private List<SpriteObject> basic;
	private JFrame frame;
	private JPanel panel;
	private Timer animTimer;
	
	public CellRunner()
	{
		keySet = new TreeSet<Character>();
		basic = new LinkedList<SpriteObject>();
		
		// Germ units
		gBasic = new GermBasic(100, 100);// TODO for all these units and below
									//		add in correct parameters
		gBasic.start();
		
		panel = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent( g);
				gBasic.draw(g);
				for(SpriteObject germBasic: basic)
					germBasic.draw(g);
			}
		};
		
		panel.setPreferredSize(new Dimension (800,600));
		
		animTimer = new Timer(15, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				/*if (frog != null)
				{ // move the frog according to what keys are being pressed
					if (keySet.contains('w'))
						frog.moveUp();
					else if (keySet.contains('a'))
						frog.moveLeft();
					else if (keySet.contains('s'))
						frog.moveDown();
					else if (keySet.contains('d'))
						frog.moveRight();
					else
						frog.moveStop();
				}*/
				
				// clean up finished explosions
				try
				{
					LinkedList<SpriteObject> dead = new LinkedList<SpriteObject>();
					for (SpriteObject s : basic)
						if (s.getSprite().isFinished())
						{
							dead.add(s);
							s.stop();
						}
					
					for (SpriteObject s: dead)
						basic.remove(s);
					
				} catch(Exception e){}
				
				// repaint the panel
				panel.repaint();
			}
			
		});
		
		frame = new JFrame();
		frame.add(panel);
		
		frame.addMouseListener(new MouseAdapter (){
			@Override
			public void mousePressed(MouseEvent arg0){
				GermBasic g = new GermBasic(0,0);
				g.setPosition(arg0.getPoint().x, arg0.getPoint().y - g.getSprite().getHeight()/2);
				basic.add(g);
				g.start();
			}
		});
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		animTimer.start();
	}
	
	public static void main(String[] args){
		new CellRunner();
	}
	
}
