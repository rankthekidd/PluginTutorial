package com.rankthekidd.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
								//  Remember that 'implements Listener'!
public class EntityHit implements Listener {

	/*
	 * This code was explained in more detail in episode #2 of rank's tutorials.
	 * Please only use this code if you understand what it means.
	 * ...I don't ask for a lot, but I'd rather you learn this than copy and paste
	 */
	
	
	@EventHandler // And remember that @EventHandler. You MUST have this on event listeners. 
	public void playerHit(EntityDamageByEntityEvent e) //EntityDamageByEntityEvent is when an entity (player) hits another entity (cow) [Can be any entity, not just those 2]
	{
		if(e.getDamager() instanceof Player) //If the entity that did the hitting was a player
		{
			Player p = (Player) e.getDamager(); //Make a Player variable so we can reference the player easily. 
			if(e.getEntity() instanceof Cow) //If the entity that took the damage was a cow
			{
				p.damage(2); //Damage the player by 2 (1 heart, accounts for half hearts)
				p.sendMessage("§cCows have feelings too!"); //Send the player a message
				Bukkit.getConsoleSender().sendMessage("§c" + p.getName() + " hit a cow." ); //Broadcast this to the console (not necessary) 
				
				Location l = e.getEntity().getLocation(); //Make a Location variable so we can reference the entity location easily.
				Cow babyCow = (Cow) l.getWorld().spawnEntity(l, EntityType.COW); //Create a new entity to spawn at the location.
				babyCow.setCustomName("§6Smol cow"); //Setting the custom name attribute to the cow.
				babyCow.setCustomNameVisible(true); //Sets the name to visible, that w
				babyCow.setBaby(); //Sets the cow to a baby cow.
			}
		}
	}
}
