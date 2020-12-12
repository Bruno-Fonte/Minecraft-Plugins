package me.niko.itemdrop;

import org.bukkit.plugin.java.JavaPlugin;

import me.niko.itemdrop.commands.ItemDropCommand;
import me.niko.itemdrop.listeners.BlockDropListener;
import me.niko.itemdrop.listeners.MobDeathListener;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new ItemDropCommand(this);
		new BlockDropListener(this);
		new MobDeathListener(this);
	}
}
