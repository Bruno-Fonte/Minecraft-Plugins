package me.niko.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.niko.manhunt.Main;

public class RespawnListener implements Listener{
	private Main plugin;
	
	public RespawnListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin) plugin);
	}
	
	@EventHandler
	public void PlayerRespawn(PlayerRespawnEvent event) {
		
		Player p = event.getPlayer();
		
		if(plugin.hunted != "") {
			p.getInventory().addItem(new ItemStack(Material.COMPASS));
		}		
	}
}
