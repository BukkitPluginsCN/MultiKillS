package me.crafter.mc.multikills;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MkdMessage {

	private static HashMap<Player, Integer> deathcount = new HashMap<Player, Integer>();
	private static HashMap<Player, Integer> killcount = new HashMap<Player, Integer>();
	private static HashMap<Integer, String> deathmessage = new HashMap<Integer, String>();
	private static HashMap<Integer, String> killmessage = new HashMap<Integer, String>();
	private static HashMap<Integer, String> breakdeathmessage = new HashMap<Integer, String>();
	private static HashMap<Integer, String> breakkillmessage = new HashMap<Integer, String>();
	private static List<String> message = new ArrayList<String>();
	
	public MkdMessage(File folder){
		File fi = new File(folder, "combo.txt");
		List<String> item = new ArrayList<String>();
		item = scan(fi);
		String[] split; 
		for (String x : item){
			if (!x.contains(":")) continue;
			split = x.split(":",3);
			if (split[0].equals("death")){
				MkdMessage.deathmessage.put(Integer.parseInt(split[1]), ChatColor.translateAlternateColorCodes("&".charAt(0) , split[2]));
			}
			if (split[0].equals("kill")){
				MkdMessage.killmessage.put(Integer.parseInt(split[1]), ChatColor.translateAlternateColorCodes("&".charAt(0) , split[2]));
			}
			if (split[0].equals("breakdeath")){
				MkdMessage.breakdeathmessage.put(Integer.parseInt(split[1]), ChatColor.translateAlternateColorCodes("&".charAt(0) , split[2]));
			}
			if (split[0].equals("breakkill")){
				MkdMessage.breakkillmessage.put(Integer.parseInt(split[1]), ChatColor.translateAlternateColorCodes("&".charAt(0) , split[2]));
			}
		}
	}
	
	public static void deathadd(Player p){
		if (p == null) return;
		if (MkdMessage.deathcount.containsKey(p)) {
			Integer number = MkdMessage.deathcount.get(p);
			MkdMessage.deathcount.remove(p);
			MkdMessage.deathcount.put(p, new Integer (number.intValue()+1));
		}
		else {
			MkdMessage.deathcount.put(p, new Integer (1));
		}
	}
	public static void killadd(Player p){
		if (p == null) return;
		if (MkdMessage.killcount.containsKey(p)) {
			Integer number = MkdMessage.killcount.get(p);
			MkdMessage.killcount.remove(p);
			MkdMessage.killcount.put(p, new Integer (number.intValue()+1));
		}
		else {
			MkdMessage.killcount.put(p, new Integer (1));
		}
	}
	
	public static void breakKillSpree(Player k, Player d){
		if (k == null || d == null) return;
		if (!MkdMessage.killcount.containsKey(d) || k == d) return;
		int handle = MkdMessage.killcount.get(d);
		if (handle > 10) handle = 10;
		if (MkdMessage.breakkillmessage.containsKey(handle) && k != d){
			MkdMessage.message.add(MkdMessage.breakkillmessage.get(handle).replaceAll("%k", k.getDisplayName()).replaceAll("%d", d.getDisplayName()));
			for (Player p : Bukkit.getServer().getOnlinePlayers()){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "playsound custom.kill_break "+p.getName());
			}
		}
		MkdMessage.killcount.remove(d);
	}
	
	public static void breakDeathSpree(Player k, Player d){
		if (k == null || d == null) return;
		if (!MkdMessage.deathcount.containsKey(k) || k == d) return;
		int handle = MkdMessage.deathcount.get(k);
		if (handle > 10) handle = 10;
		if (MkdMessage.breakdeathmessage.containsKey(handle)){
			MkdMessage.message.add(MkdMessage.breakdeathmessage.get(handle).replaceAll("%k", k.getDisplayName()).replaceAll("%d", d.getDisplayName()));
		}
		MkdMessage.deathcount.remove(k);
	}
	
	public static void killSpree(Player k){
		if (k == null) return;
		int handle = MkdMessage.killcount.get(k).intValue();
		if (handle > 10) handle = 10;
		if (MkdMessage.killmessage.containsKey(handle)){
			MkdMessage.message.add(MkdMessage.killmessage.get(handle).replaceAll("%k", k.getDisplayName()));
		}
		for (Player p : Bukkit.getServer().getOnlinePlayers()){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "playsound custom.kill_"+String.valueOf(handle)+" "+p.getName());
		}
	}
	
	public static void deathSpree(Player d){
		if (d == null) return;
		int handle = MkdMessage.deathcount.get(d).intValue();
		if (handle > 10) handle = 10;
		if (MkdMessage.deathmessage.containsKey(handle)){
			MkdMessage.message.add(MkdMessage.deathmessage.get(handle).replaceAll("%d", d.getDisplayName()));
		}
	}
	
	
	
	public static List<String> getMessage(DeathInfo info){
		MkdMessage.message.clear();
		Player thedie = Bukkit.getPlayer(info.getDier());
		Player thekill = Bukkit.getPlayer(info.getKiller());
		if (thedie != thekill){
			deathadd(thedie);
			killadd(thekill);
			deathSpree(thedie);
			killSpree(thekill);
			breakKillSpree(thekill,thedie);
			breakDeathSpree(thekill,thedie);
		}
		List<String> messageinverse = new ArrayList<String>();
		for (String x : message){
			messageinverse.add(0, x);
		}	
		return messageinverse;
	}
	
	public List<String> scan(File file){
		List<String> ret = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new FileReader(file));
			while (scanner.hasNextLine()) {
				ret.add(scanner.nextLine());
			}
			scanner.close();
		} catch (Exception e){
			}
		return ret;
	}
}
