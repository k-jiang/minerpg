package io.github.tamashii.mineRPG;

public final class Configs {
	private final MineRPG plugin;
	
	public Configs() {
		plugin = MineRPG.getInstance();
	}
	
	public void load() {
		plugin.saveDefaultConfig();
	}
}
