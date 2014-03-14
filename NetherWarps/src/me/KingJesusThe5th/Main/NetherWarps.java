package me.KingJesusThe5th.Main;

import java.util.logging.Logger;

import me.KingJesusThe5th.Main.Listners.PlayerListener;
import me.KingJesusThe5th.Main.Listners.SignMakeListner;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherWarps extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static NetherWarps plugin;
	public final PlayerListener PListner = new PlayerListener(this);
	public final SignMakeListner SListner = new SignMakeListner(this);
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(this.PListner, this);
		getServer().getPluginManager().registerEvents(this.SListner, this);
	}
	@Override
	public void onDisable() {
		getServer().getScheduler().cancelTasks(this);
	}
}