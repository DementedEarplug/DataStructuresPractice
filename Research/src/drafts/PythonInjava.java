package drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PythonInjava
{
	public static void main(String[] args)
	{
		ArrayList<String> cmd = new ArrayList<>();
		cmd.add("python");
		cmd.add("hey.py");
		
		ProcessBuilder pb = new ProcessBuilder(cmd);
		
		Process p = null;
		
		try
		{
			p=pb.start();
			
			//The next two line print any output from the program to the java console.
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream())); 
	        System.out.println(in.readLine());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
