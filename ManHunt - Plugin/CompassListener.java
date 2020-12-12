package me.niko.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import me.niko.manhunt.Main;

public class CompassListener implements Listener{

	private Main plugin;
	
	public CompassListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin) plugin);
	}
	
	@EventHandler
	public void CompassClick(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		Material held = event.getItem().getType();
		Action act = event.getAction();
		
		if(plugin.hunted != "" && !(p.getName().equals(this.plugin.hunted)) && held == Material.COMPASS && (act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK)) {
			
			Player hntd = p.getServer().getPlayer(this.plugin.hunted);
			
			p.setCompassTarget(hntd.getLocation());
			p.sendMessage("§eA bússola está apontando para " + this.plugin.hunted);
			
		}
		
	}
}
