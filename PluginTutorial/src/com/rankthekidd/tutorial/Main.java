package com.rankthekidd.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

                                              
public class Main extends JavaPlugin implements Listener { // << Any class that you have an event in will need the 'implements Listener' at the end of the class name.
	//                    ^^^^^^^^^^  - MUST extend JavaPlugin for your Main.java class. This is not needed for other classes!
	
	/*
	 * ===================================================== 
	 *  This is the official code for rankthekidd's plugin tutorial
	 *  
	 *  - Please feel free to copy and paste as you'd like, but please try to take the time to learn and
	 *  understand the code that you copy. Copy and paste will only give you a small portion of what you 
	 *  can do with this code. Learn from it, and then create your own unique concepts.
	 *  
	 *  - If you're using this code, please subscribe to my YouTube channel. It helps me grow as a creator
	 *  and helps you be notified when I change this code from a video. Thanks. ( https://www.youtube.com/user/MultiMowing/ )
	 * 
	 * ===================================================== 
	 */
	public void onEnable()
	{
		/*
		 * Registering Listeners and Commands here!
		 * =========================================
		 */
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
		//Broadcast a message to the console to alert the operator that the plugin has been enabled with no errors.
		Bukkit.getConsoleSender().sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "Plugin Enabled!");
		//This supports BUKKIT COLOR CODES ( https://wiki.ess3.net/mc/ ) ex. "§a§lPlugin Enabled!"
	}
	
	public void onDisable()
	{
		//Broadcast a message to the console to alert the operator that the plugin has been disabled with no errors.
		Bukkit.getConsoleSender().sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Plugin Disabled!");
		//This supports BUKKIT COLOR CODES ( https://wiki.ess3.net/mc/ ) ex. "§a§lPlugin Enabled!"
	}
	
	@EventHandler //This lets the server know that we are doing something during this event.
	public void playerJoin(PlayerJoinEvent event)
	{
		Player p = event.getPlayer(); //We set the variable 'p' to event.getPlayer() so we don't have to write out event.getPlayer() every time we want to reference the player.
		event.setJoinMessage("§6[§aServer§6] §8» §a" + p.getName());
		// ChatColors can be replaced with bukkit color codes. This is how a normal message would look with those.
	}
	
	@EventHandler
	public void playerLeave(PlayerQuitEvent event)
	{
		//This is super similar to the playerJoin() method right above.
		Player p = event.getPlayer();
		event.setQuitMessage("§6[§aServer§6] §8« §c" + p.getName());
	}
}
