package be.goldocelot.admintools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		getServer().getPluginManager().registerEvents(new Events(), this);
		getCommand("at").setExecutor(new AdminToolsCmd());
	}
	
	@Override
	public void onDisable() {
		for(Player online : Bukkit.getOnlinePlayers()) {
			for(Player inList : Events.pVanish) {
				online.showPlayer(inList);
			}
		for (Player inList : Events.freezes) {
			Events.freezes.remove(inList);
		}
		}
		
		plugin = null;
	}
}
