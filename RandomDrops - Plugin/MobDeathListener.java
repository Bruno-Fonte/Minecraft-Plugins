package me.niko.itemdrop.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.niko.itemdrop.Main;

public class MobDeathListener implements Listener{

private Main plugin;
	
	public MobDeathListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin) plugin);
	}
	
	public Boolean Type(Material material) {
		
		if((material.getMaxStackSize() == 1 || material.isBlock() || material.isEdible() || material.isInteractable() || material.isItem()) 
				&& (!material.name().contains("POTTED") && !material.name().contains("_WALL") && !material.name().contains("_SPAWN_") 
				&& !material.name().contains("STEM") && !material.name().contains("TWISTING_VINES") 
				&& !material.name().contains("COMMAND_BLOCK") && !material.equals(Material.BARRIER)
				&& !material.equals(Material.VOID_AIR) && !material.equals(Material.AIR) && !material.equals(Material.CAVE_AIR) 
				&& !material.equals(Material.FROSTED_ICE) && !material.equals(Material.CARROTS) && !material.equals(Material.SOUL_FIRE) 
				&& !material.equals(Material.KELP_PLANT) && !material.equals(Material.PISTON_HEAD) && !material.equals(Material.WALL_TORCH) 
				&& !material.equals(Material.POTATOES) && !material.equals(Material.END_GATEWAY) && !material.equals(Material.TALL_SEAGRASS) 
				&& !material.equals(Material.BEETROOTS) && !material.equals(Material.REDSTONE_WIRE) && !material.equals(Material.FIRE) 
				&& !material.equals(Material.JIGSAW) && !material.equals(Material.END_PORTAL_FRAME) && !material.equals(Material.BEDROCK)
			    && !material.equals(Material.WATER) && !material.equals(Material.NETHER_PORTAL) && !material.equals(Material.LAVA)
			    && !material.equals(Material.STRUCTURE_VOID) && !material.equals(Material.STRUCTURE_BLOCK) && !material.equals(Material.DEBUG_STICK)
			    && !material.equals(Material.DRAGON_EGG) && !material.equals(Material.SWEET_BERRY_BUSH))){
			return false;
		}
		else {
			return true;
		}
	}
	
	@EventHandler
	public void MobDeath(EntityDeathEvent event) {
		
		Entity entity = event.getEntity();
		
		Player p = event.getEntity().getKiller();
		
		Material randomMaterial;
		
		Random r = new Random();
		
		
		if(plugin.getConfig().contains(((String.valueOf(entity.getName()))))) {
			
			String m = plugin.getConfig().getString(String.valueOf((entity.getName())));
			
			event.getDrops().clear();
			
			randomMaterial = Material.matchMaterial(m);
			
			if(randomMaterial.getMaxStackSize() == 1) {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(randomMaterial, 1));
			}
			else {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(randomMaterial, r.nextInt(20) + 1));
			}
		}
		else {
			
			List<String> names = new ArrayList<>();
			for (Material material : Material.values()) {
				names.add(material.name());
			}
			
			int i = names.size();
			
			Material newRandomMaterial;
			
			do{
				newRandomMaterial = Material.values()[r.nextInt(i)];
				String str = newRandomMaterial.name();
				p.sendMessage(str);
			}
			while(Type(newRandomMaterial));
			
			plugin.getConfig().set(String.valueOf(entity.getName()), newRandomMaterial);
			
			plugin.saveConfig();
			
			event.getDrops().clear();
			
			if(newRandomMaterial.getMaxStackSize() == 1) {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(newRandomMaterial, 1));
			}
			else {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(newRandomMaterial, r.nextInt(20) + 1));
			}
		}
	}
}
