package com.thepirates;

import com.thepirates.ui.LauncherFrame;

public class Main {
	
	public String name = "Neppixel";
	public String version = "1.8.9";
	public String author = "Biraj Rai";
	public static Main INSTANCE = new Main();
	public DiscordRP discordRP = new DiscordRP();
	
	public void startup() {
		discordRP.start();
		System.out.println("Starting " + name + " " + version + " by " + author);
	}
	
	public void shutdown() {
		discordRP.shutdown();
		System.out.println("Shuting down " + name + " " + version);
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	public static void main(String [] args) {
		new LauncherFrame();
		
	}
	
	public static void launch() {
		
	}
}