package me.top2001.OreCloudTeleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
				   player.sendMessage(prefix + ChatColor.GREEN + "Please specify a player. (/tp <Player> {TargetPlayer})");
			   }else if (args.length == 1) {
				   Player targetPlayer = player.getServer().getPlayerExact(args[0]);
				   Location targetPlayerLocation = targetPlayer.getLocation();
				   player.teleport(targetPlayerLocation);
				   player.sendMessage(prefix + ChatColor.GREEN + "Now teleporting...");
			   }else if (args.length == 2) {
				   Player targetPlayer = player.getServer().getPlayerExact(args[0]);
				   Player targetPlayer1 = player.getServer().getPlayerExact(args[1]);
				   Location targetPlayer1Location = targetPlayer1.getLocation();
				   targetPlayer.teleport(targetPlayer1Location);
				   player.sendMessage(prefix + ChatColor.GREEN + "Now teleporting...");
			   }
			   Player targetPlayer = Bukkit.getServer().getPlayerExact(args[0]);
			   if (targetPlayer == null) {
				   player.sendMessage(prefix + ChatColor.GREEN + "The player, " + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + ", is currently not online.");
			   }
			   Player targetPlayer1 = Bukkit.getServer().getPlayerExact(args[1]);
			   if (targetPlayer1 == null) {
				   player.sendMessage(prefix + ChatColor.GREEN + "The player, " + ChatColor.DARK_GREEN + args[1] + ChatColor.GREEN + ", is currently not online.");
			   }
		   }
		   // Sets Spawn.
		   if(cmd.getName().equalsIgnoreCase("setspawn")) {
			   if(sender.hasPermission("orecloudteleport.setspawn")){
				   player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
				   player.sendMessage(prefix + ChatColor.GREEN + "Spawn location created.");
			   }else{
				   player.sendMessage(prefix + ChatColor.RED + "Sorry, you don't have permission to perform this command.");
			   }
		   }
		   // Teleport Player To Spawn.
		   if (cmd.getName().equalsIgnoreCase("spawn")) {
			   if(sender.hasPermission("orecloudteleport.spawn")){
				   player.teleport(player.getWorld().getSpawnLocation());
				   player.sendMessage(prefix + ChatColor.GREEN + "Now sending you to spawn...");
			   }else{
				   player.sendMessage(prefix + ChatColor.RED + "Sorry, you don't have permission to perform this command.");
				   return true;
			   }
		   }
		   }
		return false;
	 }
}
