package io.github.tamashii.mineRPG;

import io.github.tamashii.mineRPG.listeners.PlayerListener;

import java.io.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * MineRPG.java
 * 
 * @version 14.2.5.133
 * @author Tamashii
 *
 */
public final class MineRPG extends JavaPlugin {
	
	private static MineRPG instance;
	
	public static MineRPG getInstance() {
		return instance;
	}
	
	public MineRPG() {
		super();
		instance = this;
	}
	
	@Override
	public void onEnable() {
		// TODO plugin enabled codes here.
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
			StringTable.copyDefault();
		}
	}
	
	@Override
	public void onDisable() {
	}
	
	public void onReload() {
		StringTable.copyDefault();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("minerpg") || cmd.getName().equalsIgnoreCase("myrpg")) {
			if(args.length == 0) {
				sender.sendMessage(StringTable.get("forHelps"));
			}
			return true;
		}
		return false;
	}
	
	public ClassLoader getClassLoaderBypass() {
		return super.getClassLoader();
	}
	
	public File getFileBypass() {
		return super.getFile();
	}
}
