/*
 * FauxMessage by Rich Boos
 * http://dev.bukkit.com/profiles/richboos
 */
package com.richboos.fauxmessage;
import org.bukkit.plugin.java.JavaPlugin;

public class FauxMessage extends JavaPlugin{

	private FMCommands executor;
    
	public void onEnable(){
		getLogger().info("Enabling FauxMessage Version 0.1");
		executor = new FMCommands(this);
		getCommand("fm").setExecutor(executor);
	}
 
	public void onDisable(){
		getLogger().info("Disabling FauxMessage 0.1");
	}




}
