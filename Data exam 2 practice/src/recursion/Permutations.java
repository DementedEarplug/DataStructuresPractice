package recursion;

import java.util.ArrayList;

public class  Permutations
{
	public static ArrayList<String> permutations(int n)
	{
		
		String combos="";
		int ch= (char)'A';
		
		for(int i=0;i<n;i++)
		{
			combos=combos+(char)ch;
			ch++;
		}
		
		
		return recPerms(combos);
		
	}
	
	private static ArrayList<String> recPerms(String combo)
	{
		ArrayList<String> perms = new ArrayList<>();
		
		if(combo.length()==0)
		{	perms.add(combo);
			return perms;
		}
		else
		{
			for(int i=0;i< combo.length();i++)
			{
				String lilCombo= combo.substring(0, i)+combo.substring(i+1);
				ArrayList<String> lilPerms = recPerms(lilCombo);
				
				for(String s: lilPerms)
				{
					perms.add(combo.charAt(i)+s);
				}
			}
			return perms;
		}
		
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(permutations(3));
	}
}
