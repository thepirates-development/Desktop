package com.thepirates;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class Discord {
	
	private boolean running = true;
	private long created = 0;
	
	public void start() {
		
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			
			@Override
			public void apply(DiscordUser user) {
				System.out.println("Welcome " + user.username + "#" + user.discriminator + "");
				update("Starting Neppixel", "");
			}
		}).build();
		
		DiscordRPC.discordInitialize("1001465809375334491", handlers, running);
		
		new Thread("Discord RPC Callback") {
			public void run() {
				while(running) {
					DiscordRPC.discordRunCallbacks();
				}
			};
		}.start();
	}
	
	public void shutdown() {
		
		running = false;
		DiscordRPC.discordShutdown();
		
	}
	
	public void update(String firstLine, String secondLine) {
		
		DiscordRichPresence.Builder b= new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("logo", "https://simpclient.golde.org/");
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}

}
