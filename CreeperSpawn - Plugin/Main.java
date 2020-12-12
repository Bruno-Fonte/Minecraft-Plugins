package me.niko.CreeperSpawn;

import org.bukkit.plugin.java.JavaPlugin;

import me.niko.CreeperSpawn.commands.CreeperCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new CreeperCommand(this);
	}
}
