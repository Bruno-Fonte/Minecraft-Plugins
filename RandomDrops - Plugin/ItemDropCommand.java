package me.niko.itemdrop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.niko.itemdrop.Main;

public class ItemDropCommand implements CommandExecutor{

	private Main plugin;
	
	public ItemDropCommand(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("random").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("random")) {
			p.sendMessage("§eEsse plugin faz com que blocos dropem itens aleatórios!");
		}
		return false;
	}	
	
}
