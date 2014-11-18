package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.SimpleGameSetup;

public class testTextView extends JPanel implements Observer{
	
	private JTextArea text;
	
	public testTextView(SimpleGameSetup theGame){
		text = new JTextArea();
		text.setBackground(Color.GRAY);
		setLayout(null);
		text.setSize(660, 690);
		text.setLocation(0,0);
		
		String textView = "";
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				textView += theGame.getRoom(j, i).toString();
			}
			textView += "\n";
		}
		
		text.setText(textView);
		text.setFont(new Font("Courier", Font.PLAIN, 14));
		text.setForeground(Color.WHITE);
		text.setEditable(false);
		add(text);
	}

	@Override
	public void update(Observable observedObject, Object unused) {
		SimpleGameSetup theGame = (SimpleGameSetup) observedObject;
		
		String textView = "";
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				textView += theGame.getRoom(j, i).toString();
			textView += "\n";
		}
		
		text.setText(textView);
	}
}
