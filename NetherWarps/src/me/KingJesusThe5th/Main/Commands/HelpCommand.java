package me.KingJesusThe5th.Main.Commands;

import me.KingJesusThe5th.Main.NetherWarps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor{
	private NetherWarps plugin;
	public HelpCommand(NetherWarps plugin){
		this.plugin = plugin;
		}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("NetherWarps")){
			Player p = (Player) sender;
			if(p.hasPermission("NetherWarps.sign.place")){
			if(args.length >= 1&&args[0].equalsIgnoreCase("Help")){
				p.sendMessage(""+ChatColor.GRAY+"Place down a sign and write:"+ChatColor.WHITE+"\n"
						+ "\"[Warp]\"\n"
						+ "\"Wilderness\"\n"
						+ "\"Nether\"\n"
						+ChatColor.BLUE+"Plugin version: "+ChatColor.YELLOW+plugin.getDescription().getVersion());
			}else if(args.length == 1 && args[0].equalsIgnoreCase("Reload")&&p.hasPermission("NetherWarps.reload")){
			plugin.reloadConfig();
			p.sendMessage(""+ChatColor.BLUE+"Config reloaded");
			}else if(p.hasPermission("NetherWarps.sign.place")||p.hasPermission("NetherWarps.reload")){
				p.sendMessage(""+ChatColor.RED+"Unknown command! Type \"/NetherWarps help\" for more info");
			}
			}
		}
		return false;
	}

}
