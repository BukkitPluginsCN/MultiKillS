package me.crafter.mc.multikills;

import org.bukkit.Bukkit;
//import org.bukkit.craftbukkit.v1_7_R1.entity.CraftLargeFireball;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathInfo {

	private Player die;
	private Long time;
	private String weapon;
	private String killer;
	private String reason;
	private DamageCause cause;
	private Entity damager;
	
	public DeathInfo(PlayerDeathEvent event) {
		killer = "???";
		weapon = "???";
		reason = "other";
		die = event.getEntity();
		time = Bukkit.getWorld("world").getFullTime();
		//Check player is the killer
		if (event.getEntity().getKiller() instanceof Player){
			killer = event.getEntity().getKiller().getName();
			//killer = ((Player)((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager()).getName();
			
			if (event.getEntity().getLastDamageCause().getCause() == DamageCause.THORNS){
				reason = "thorns";
			}
			else {
				reason = "pvp";
				weapon = KillWeapon.gethisweapon(event.getEntity().getKiller());
				if (event.getEntity().getLastDamageCause().getCause() == DamageCause.PROJECTILE){
					reason = "pvparrow";
					weapon = KillWeapon.gethisweapon(event.getEntity().getKiller());
				}
			}
			if (killer.equals("connection_lost")){
				reason = "fuzhu";
			}
			if (killer.equals(die.getName())){
				reason = "kill";
			}
		}
		//or else, mob or environment did this
		else if (event.getEntity().getLastDamageCause() == null) {
			reason = "other";
		}
		else {
			cause = event.getEntity().getLastDamageCause().getCause();
			if (cause == DamageCause.BLOCK_EXPLOSION) reason = "tnt";
			if (cause == DamageCause.CONTACT) reason = "cactus";
			if (cause == DamageCause.CUSTOM) reason = "other";
			if (cause == DamageCause.DROWNING) reason = "water";
			if (cause == DamageCause.ENTITY_EXPLOSION) reason = "creeper";
			if (cause == DamageCause.FALL) reason = "fall";
			if (cause == DamageCause.FALLING_BLOCK) reason = "anvil";
			if (cause == DamageCause.FIRE) reason = "fire";
			if (cause == DamageCause.FIRE_TICK) reason = "fire";
			if (cause == DamageCause.LAVA) reason = "lava";
			if (cause == DamageCause.LIGHTNING) reason = "lightning";
			if (cause == DamageCause.MAGIC) reason = "potion";
			if (cause == DamageCause.MELTING) reason = "snowman";
			if (cause == DamageCause.POISON) reason = "poison";
			if (cause == DamageCause.STARVATION) reason = "hunger";
			if (cause == DamageCause.SUFFOCATION) reason = "suffocation";
			if (cause == DamageCause.SUICIDE) reason = "kill";
			if (cause == DamageCause.VOID) reason = "voids";
			if (cause == DamageCause.WITHER) reason = "withereffect";
			damager = null;
			if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
				damager = ((EntityDamageByEntityEvent)event.getEntity().getLastDamageCause()).getDamager();
				//VOODOO FIX NOT INTEND
				if (damager instanceof Player){
					killer = ((Player)damager).getName();
					if (event.getEntity().getLastDamageCause().getCause() == DamageCause.THORNS){
						reason = "thorns";
					}
					else {
						reason = "pvp";
						weapon = KillWeapon.gethisweapon((Player)damager);
						if (event.getEntity().getLastDamageCause().getCause() == DamageCause.PROJECTILE){
							reason = "pvparrow";
							weapon = KillWeapon.gethisweapon((Player)damager);
						}
					}
					if (killer.equals("connection_lost")){
						reason = "fuzhu";
					}
					if (killer.equals(die.getName())){
						reason = "kill";
					}
				}
			}
			if (cause == DamageCause.PROJECTILE){
				if (damager.toString().contains("CraftSmallFireball")) reason = "blaze";
				if (damager.toString().contains("CraftLargeFireball") || damager instanceof Ghast){
					reason = "ghast";
				}
				else if (damager instanceof Arrow){
					reason = "dispenser";
					if (((Arrow) damager).getShooter() instanceof Skeleton){
						reason = "skeleton";
					}
				}
			}
			if (cause == DamageCause.ENTITY_ATTACK){
		        if ((damager instanceof Creeper)) reason = "creeper";
		        if ((damager instanceof Zombie)) reason = "zombie";
		        if ((damager instanceof Spider)) reason = "spider";
		        if ((damager instanceof CaveSpider)) reason = "cavespider";
		        if ((damager instanceof Enderman)) reason = "enderman";
		        if ((damager instanceof Silverfish)) reason = "silverfish";
		        if (damager.getType().equals(org.bukkit.entity.EntityType.MAGMA_CUBE)) reason = "magmacube";
		        if (damager.getType().equals(org.bukkit.entity.EntityType.SLIME)) reason = "slime";
		        if (damager.getType().equals(org.bukkit.entity.EntityType.SKELETON)) {
		        	if (((Skeleton)damager).getSkeletonType().equals(Skeleton.SkeletonType.WITHER)){
		        		reason = "witherskeleton";
		        	}
		        	else {
		        		reason = "skeleton";
		        	}
		        }
		        if ((damager instanceof Wolf)) {
		        	reason = "wolf";
		        	if (((Wolf)damager).getOwner() == null){
		        		killer = "Ò°Éú";
		        	} else {
		        		killer = ((Wolf)damager).getOwner().getName();
		        	}
		        }
		        if ((damager instanceof PigZombie)) reason = "pigzombie";
		        if ((damager instanceof IronGolem)) reason = "irongolem";
		        if ((damager instanceof Giant)) reason = "giant";
		        if ((damager instanceof Wither)) reason = "wither";
		        if ((damager instanceof Blaze)) reason = "blaze";
		        if ((damager instanceof Guardian)) reason = "guardian";
		        if ((damager instanceof Rabbit)) reason = "rabbit";
			}
		}
	}
	
	public String getDier(){
		return die.getName();
	}
	
	public String getKiller(){
		return killer;
	}
	
	public String getDierDisplayName(){
		return die.getDisplayName();
	}
	
	public String getKillerDisplayName(){
		Player pk = Bukkit.getPlayer(killer);
		if (pk == null) {
			return "???";
		} else {
			return pk.getDisplayName();
		}
	}
	
	public String getReason(){
		return reason;
	}
	
	public String getWeapon(){
		return weapon;
	}
	
	public long getTime(){
		return time;
	}
	
	public String getMessage(){
		return KillMessage.getKillMessage(this);
	}
	
	public String getDamager(){
		return damager.toString();
	}
	
	public String getCause(){
		return cause.toString();
	}
	
	
	
	
	

}
