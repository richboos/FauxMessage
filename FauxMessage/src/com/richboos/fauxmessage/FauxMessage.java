/*
 * FauxMessage by Rich Boos
 * http://dev.bukkit.com/profiles/richboos
 */
package com.richboos.fauxmessage;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class FauxMessage extends JavaPlugin{

	Logger log;
	public void onEnable(){
		log = this.getLogger();
		log.info("Enabling FauxMessage 0.1");
	}
 
	public void onDisable(){
		log.info("Disabling FauxMessage 0.1");
	}
}