package me.KingJesusThe5th.Main.Listners;

import java.util.Random;

import me.KingJesusThe5th.Main.NetherWarps;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
	private NetherWarps plugin;
	public PlayerListener(NetherWarps plugin) {
		this.plugin = plugin;
		}
	private Location RandomXZLocation(World world, int y){
	Location L = null;
	Random r = new Random();
	int MaxConX = r.nextInt(plugin.getConfig().getInt("MaxX"));
	int MaxConZ = r.nextInt(plugin.getConfig().getInt("MaxZ"));
	int MinConX = r.nextInt(plugin.getConfig().getInt("MinX"))*-1;
	int MinConZ = r.nextInt(plugin.getConfig().getInt("MinZ"))*-1;
	int RandomFour = r.nextInt(4)+1;
	if(RandomFour==1){
	L = new Location(world, MaxConX, y, MaxConZ);}
	if(RandomFour==2){
	L = new Location(world, MaxConX, y, MinConZ);}
	if(RandomFour==3){
	L = new Location(world, MinConX, y, MaxConZ);}
	if(RandomFour==4){
	L = new Location(world, MinConX, y, MinConZ);}
	return L;
	}
	@EventHandler
	public void OnSignClick(PlayerInteractEvent e){
		if(e.hasBlock()){
			if(e.getClickedBlock()!=null&&e.getClickedBlock().getState() instanceof Sign){
			Sign sign = (Sign) e.getClickedBlock().getState();
			if(sign.getLine(0).equalsIgnoreCase("["+ChatColor.BLUE+"Warp"+ChatColor.BLACK+"]")&&
			   sign.getLine(1).equalsIgnoreCase("Wilderness")&&
			   sign.getLine(2).equalsIgnoreCase("Nether")){
				if(e.getPlayer().getWorld().getEnvironment().equals(Environment.NETHER)){
				e.getPlayer().sendMessage("Warping...");
				Location L = RandomXZLocation(e.getPlayer().getWorld(), 10);
				while(true){
					if(L.getBlock().isEmpty()==false&&
					   L.getBlock().isLiquid()==false){
						//Makes sure there's a block for the player to stand on
					 if(L.getBlock().getRelative(BlockFace.UP).isEmpty()&&L.getBlock().getRelative(BlockFace.UP, 2).isEmpty()){
						 //Makes sure that there's a space for the player to spawn
						 break;
					 }
					}
					L.setY(L.getY()+1);
					if(L.getY()>=120){
						L=RandomXZLocation(e.getPlayer().getWorld(), 10);
						//No open area for that player to teleport to, Finding a new location
					}
				}
				e.getPlayer().teleport(L.add(0.5, 1.5, 0.5));
				}else{
					e.getPlayer().sendMessage("This sign only works in the nether!");
				}
			}
			}
			}
	}
}
	
