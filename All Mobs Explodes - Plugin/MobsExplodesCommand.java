package me.niko.mobsexplodes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.niko.mobsexplodes.Main;

public class MobsExplodesCommand implements CommandExecutor {

	private Main plugin;
	
	public MobsExplodesCommand(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("explosion").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("explosion")) {
			p.sendMessage("§eEsse plugin faz com que mobs explodam quando morrem!");
		}
		return false;
	}	
}
