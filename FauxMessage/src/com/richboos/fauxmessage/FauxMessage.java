/*
 * FauxMessage by Rich Boos
 * http://dev.bukkit.com/profiles/richboos
 */
package com.richboos.fauxmessage;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

public class FauxMessage extends JavaPlugin{

	Logger log;
	
	public static Permission perms = null;
    public static Chat chat = null;
    
	public void onEnable(){
		log = this.getLogger();
		log.info("Enabling FauxMessage Version 0.1");
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			log.info("[FauxMessage] Vault not found, proceed with caution.");
			return;
		}

		try{
			setupPermissions();
		}
		catch(Exception e){
			log.info("[FauxMessage] Vault not found, proceed with caution.");
		}

		try{
			setupChat();
		}
		catch(Exception e){
			log.info("[MCDocs] ERROR: Vault failed to load the chat scheme!");
		}
	}
 
	public void onDisable(){
		log.info("Disabling FauxMessage 0.1");
	}
	   private boolean setupChat() {
	        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
	        chat = rsp.getProvider();
	        return chat != null;
	    }

	    private boolean setupPermissions() {
	        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
	        perms = rsp.getProvider();
	        return perms != null;
	    }

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
	 
		if (cmd.getName().equalsIgnoreCase("fm"))
			if(perms.has(player, "fm.test")){ 
			Bukkit.getServer().broadcastMessage("[FauxMessage] Testing 1,2,3");
			return true;
			}
			else {sender.sendMessage("You do not have permission");
		} else if (cmd.getName().equalsIgnoreCase("fm")) {
			if (player == null) {
				sender.sendMessage("this command can only be run by a player");
			} else {
				// do something else...
			}
			return true;
		}
		return false;
	}


}
