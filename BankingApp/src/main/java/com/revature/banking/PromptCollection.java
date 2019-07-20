package com.revature.banking;

import java.util.HashMap;

public class PromptCollection 
{
	//public PromptChoice main1 = new PromptChoice(1, "Login");
	//public PromptChoice main2 = new PromptChoice(2, "Create Account");
	//public PromptChoice main3 = new PromptChoice(3, "Quit");
	public HashMap<Integer, String> list = new HashMap<Integer, String>();
	public Prompt test = new Prompt("Welcome!", list);
	
	public void initialize()
	{
		list.put(1, "Login");
		list.put(2, "Create Account");
		list.put(3, "Quit");
	}
}
