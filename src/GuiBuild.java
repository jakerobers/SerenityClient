


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class GuiBuild extends JFrame
{
	private ArrayList<String> info = new ArrayList<String>();	//info stored from http request
	private ArrayList<String> admins = new ArrayList<String>();
	private ArrayList<String> mods = new ArrayList<String>();
	private ArrayList<String> seniors = new ArrayList<String>();
	
	public GuiBuild()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//terminates program when frame is closed.
		setSize(800, 800);								//sets frame size
		setVisible(true);								//sets visible to true
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);									//housekeeping requirements
		int x = 50;										//stores position in x
		int y = 80;										//stores position in y
		getContentPane().setBackground(new Color(230, 255, 204));

				
		g.setColor(Color.BLUE);
		g.drawString("Currently there are ", x, 50);
		if (!info.isEmpty())
			g.drawString(info.get(0), 175, 50);
		g.drawString("people online!", 215, 50);
		
		for(int count = 1; count < info.size(); count++)//loops through the array from http request and
		{												//draws the contents of each subscript to the frame
			g.setColor(Color.BLACK);
			y+=20;										//increments position in y
			
			if(admins.contains(info.get(count))) 
				g.setColor(Color.RED);
			if(mods.contains(info.get(count)))
				g.setColor(new Color(205, 102, 51));	//orange
			if(seniors.contains(info.get(count)))
				g.setColor(new Color(0, 184, 46));		//green
			
			g.drawString(info.get(count), x, y);		//draws the string in info (count)
		}
	}
	
	public void readFile() throws IOException, InterruptedException
	{
		String mcURL = "http://server.serenitymc.net/minequery/plain.php";//Url
		String contents;
			
		
		info.clear();									//resets the array so it can gather
														//new information
		URL SerenityLink = new URL(mcURL);				//links to the url
		BufferedReader in = new BufferedReader(new InputStreamReader(SerenityLink.openStream()));
		while ((contents = in.readLine()) != null)		//while there are new lines.....
		{
			info.add(contents);							//read and add to array
		}
		
	}
	
	public void loadAdmins()
	{
		admins.add("cedicine");
		admins.add("Camnora");
		admins.add("tjbenator");
		admins.add("Willie27");
		admins.add("bengarrr");
		admins.add("ArkGullwing");
	}
	public void loadMods()
	{
		mods.add("Bbaass_TMH");
		mods.add("darklord636");
		mods.add("englishkiwi");
		mods.add("LeafToucher");
		mods.add("McBoots");
		mods.add("newbuilder");
		mods.add("RainbowBlues");
		mods.add("rithrin");
		mods.add("SonicParadox");
		mods.add("TROMBONE888");
		mods.add("Trykangaroo");
		mods.add("Warrada");
	}
	public void loadSeniors()
	{
		seniors.add("Doomworks");
		seniors.add("Kensei");
	}
}











/*try 
{
	Image img = ImageIO.read(new URL("http://soundtrack2.dreamhosters.com/wp-content/uploads/2010/10/Faded.jpg"));
	g.drawImage(img, 0, 0, null);
} catch (MalformedURLException e) {} catch (IOException e) {}
*/
