package me.top2001.OreCloudTeleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Note;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public void onEnable() {
		getLogger().info("Plugin Enabled!");
	}
	
	public void onDisable() {
		getLogger().info("Plugin Disabled!");
	}
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  if(sender instanceof Player) {
		   final String prefix = ChatColor.GREEN + "Ore" + ChatColor.GRAY + "Cloud" + ChatColor.DARK_GREEN + " > ";
		   Player player = (Player) sender;
		   Location loc = player.getLocation();
		   if(cmd.getName().equalsIgnoreCase("tp")) {
		    if (args.length == 0) {
		    	player.sendMessage(prefix + ChatColor.GREEN + "You haven't specified a player to teleport to!");
	            player.playNote(loc, Instrument.PIANO, new Note(1));
	            return true;
		    }
		    Player target = Bukkit.getServer().getPlayerExact(args[0]);
		    if (target == null) {
		    	player.sendMessage(prefix + ChatColor.GREEN + "The player, " + ChatColor.GREEN + args[0] + ChatColor.GREEN + " is currently not online.");
		    	player.playNote(loc, Instrument.PIANO, new Note(1));
		    	return true;
		    }
		    player.teleport(target.getLocation());
		    return true;
		   }
		   // Sets Spawn.
		   if(cmd.getName().equalsIgnoreCase("setspawn")) {
			   player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
			   player.sendMessage(prefix + ChatColor.GREEN + "Spawn location created.");
		   }
		   // Teleports Player To Spawn.
		   if (cmd.getName().equalsIgnoreCase("spawn")) {
			   player.teleport(player.getWorld().getSpawnLocation());
			   player.sendMessage(prefix + ChatColor.GREEN + "Now sending you to spawn...");
			   return true;
		   }
		   }
		return false;
	 }
}
