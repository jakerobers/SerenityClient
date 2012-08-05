import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


/**
 * THE RUN METHOD IS PRETTY MUCH MY MAIN METHOD. MY MAIN METHOD ONLY
 * CONTAINS THE NEW OBJECT OF GUIBUILD AND THE RUN METHOD, SO IT WOULD BE
 * REDUNDANT TO INCLUDE THAT. 
 */

public class SerenityClient
{
	
	GuiBuild gb = new GuiBuild();
	
	public void run() throws InterruptedException, IOException
	{
		gb.loadAdmins();
		gb.loadMods();
		gb.loadSeniors();
		while (true)
		{
			try
			{
				gb.readFile();	//reads url contents
			} catch (Exception e) {}
			gb.repaint();	//prints out contents
			Thread.sleep(60000);
			
		}
	}
}
