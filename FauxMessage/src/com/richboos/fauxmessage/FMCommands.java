package com.richboos.fauxmessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FMCommands implements CommandExecutor{
	
	FauxMessage plugin;
	
	public FMCommands(FauxMessage plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0){
			sender.sendMessage(ChatColor.RED + "Specify foo.");
			return true;
		}
		if (args[0].equalsIgnoreCase("test")) {
			if (!sender.hasPermission("fm.test")){
				sender.sendMessage(ChatColor.RED + "No perms.");
				return true;
			}
			
		}
		sender.sendMessage(ChatColor.RED + "What the hell are you doing with this command?");
		return true;
	}

}
