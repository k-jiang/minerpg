package io.github.tamashii.mineRPG.listeners;

import io.github.tamashii.mineRPG.MineRPG;
import io.github.tamashii.mineRPG.StringTable;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.scoreboard.*;



/**
 * PlayerListener.java
 * 
 * @version 14.2.5.133
 * @author Tamashii
 *
 */
public class PlayerListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player player = e.getPlayer();
		// TODO Load user data here.
		final World world = player.getWorld();
		Scoreboard scoreboard =  Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective objective = scoreboard.registerNewObjective("mineRPGStats", "dummy");
		objective.setDisplayName(StringTable.get("status"));
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onWorldChanged(PlayerChangedWorldEvent e) {
		final Player player = e.getPlayer();
		final World world = player.getWorld();
		// TODO branch worlds here.
		/*Scoreboard scoreboard =  Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective objective = scoreboard.registerNewObjective("mineRPGStats", "dummy");
		objective.setDisplayName(StringTable.get("status"));
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);*/
	}
}
