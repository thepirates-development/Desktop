package com.thepirates;

import com.thepirates.ui.LauncherFrame;

public class Main {
	
	public static Main INSTANCE = new Main();
	public Discord DiscordSRV = new Discord();
	
	
	public void startup() {
		DiscordSRV.start();
	}
	
	public void shutdown() {
		DiscordSRV.shutdown();
	}
	
	public Discord getDiscord() {
		return DiscordSRV;
	}
	
	
	
	
	
	public static void main(String [] args) {
		new LauncherFrame();
	}
	
	
	
	
	
	
	
	public static void launch() {
		
	}
}