package drafts;

import java.io.IOException;
import java.util.ArrayList;

public class TriggerScriptIdea
{
	public static void main(String[] args)
	{
		ArrayList<String> waypoints = new ArrayList<>();
		String currentLocation;
		String[] trigger = {"python","D:/Workspace/python.py"};
		
		waypoints.add("pooto");
		waypoints.add("polto");
		waypoints.add("poloo");
		waypoints.add("polot");

		while(!waypoints.isEmpty()) //Maybe measure battery here aswell?
		{
			currentLocation = "pooto";
			if(currentLocation.equals(waypoints.get(0)))
			{
				//hover drone
				//activate SDR script
				try
				{
					Process p =Runtime.getRuntime().exec(trigger);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				waypoints.remove(0);
			}
			
					
			
		} 
	}
}
