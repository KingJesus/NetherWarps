package me.KingJesusThe5th.Main.Listners;

import me.KingJesusThe5th.Main.NetherWarps;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignMakeListner implements Listener {
	@SuppressWarnings("unused")
	private NetherWarps plugin;
	public SignMakeListner(NetherWarps plugin){
		this.plugin = plugin;
		}
	@EventHandler
	public void onsignplace(SignChangeEvent e){
		if(e.getLine(0).equals("["+ChatColor.BLUE+"Warp"+ChatColor.BLACK+"]")&&e.getLine(2).equals("Wilderness")&&e.getLine(3).equals("Nether")
		 ||e.getLine(0).equals("[Warp]")&&e.getLine(1).equals("Wilderness")&&e.getLine(2).equals("Nether")){
			if(e.getPlayer().hasPermission("NetherWarps.sign.place")){
			e.setLine(0, "["+ChatColor.BLUE+"Warp"+ChatColor.BLACK+"]");
			e.getPlayer().sendMessage("Sign successfully made");
		}else{
			e.setLine(0, ChatColor.DARK_AQUA+"[Warp]");
			e.getPlayer().sendMessage(""+ChatColor.RED+"You don not have permission to make Nether Wilderness signs");
		}
	}
	}
}
