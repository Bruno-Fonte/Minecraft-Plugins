package me.niko.manhunt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.niko.manhunt.Main;

public class HunterCommand implements CommandExecutor{
	private Main plugin;
	
	public HunterCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("manhunt").setExecutor(this);
		plugin.getCommand("undo").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("manhunt")) {
			this.plugin.hunted = args[0];
		}
		
		if(label.equalsIgnoreCase("undo")) {
			this.plugin.hunted = "";
		}
		
		return true;
	}
}
