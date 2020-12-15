package me.niko.mobsexplodes.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

import me.niko.mobsexplodes.Main;

public class MobDeathListener implements Listener{
	
	private Main plugin;
	
	public MobDeathListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin) plugin);
	}
	
	@EventHandler
	public void MobDeath(EntityDeathEvent event) {
		
		Entity entity = event.getEntity();
		
		Entity p = event.getEntity().getKiller();
		
		if(p instanceof Player) {
			entity.getLocation().getWorld().createExplosion(entity.getLocation(), 3);
		}
	}
}
