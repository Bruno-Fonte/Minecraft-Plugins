	package me.niko.manhunt;

import org.bukkit.plugin.java.JavaPlugin;

import me.niko.manhunt.commands.HunterCommand;
import me.niko.manhunt.listeners.CompassListener;
import me.niko.manhunt.listeners.RespawnListener;

public class Main extends JavaPlugin{
	
	public String hunted = "";
	
	@Override
	public void onEnable() {
		new HunterCommand(this);
		new CompassListener(this);
		new RespawnListener(this);
	}

}
