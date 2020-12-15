package me.niko.mobsexplodes;

import org.bukkit.plugin.java.JavaPlugin;

import me.niko.mobsexplodes.commands.MobsExplodesCommand;
import me.niko.mobsexplodes.listeners.MobDeathListener;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		new MobsExplodesCommand(this);
		new MobDeathListener(this);
	}
}
