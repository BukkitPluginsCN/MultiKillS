package me.crafter.mc.multikills;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		DeathInfo info = new DeathInfo(event);
		event.setDeathMessage(null);
		
		if (info.getReason().equals("other")){
			event.getEntity().sendMessage(ChatColor.RED+"非正常死亡，请将此次实际死亡原因和以下内容私聊腐竹以便排除bug，谢谢！");
			event.getEntity().sendMessage("Reason "+info.getReason());
			event.getEntity().sendMessage("Death "+info.getDier());
			event.getEntity().sendMessage("Killer "+info.getKiller());
			event.getEntity().sendMessage("Cause "+info.getCause());
			event.getEntity().sendMessage("Damager "+info.getDamager());
		}
		
		List<String> multimessage = MkdMessage.getMessage(info);
		if (event.getEntity().getWorld().getName().startsWith("game")){
			for (Player rec : event.getEntity().getWorld().getPlayers()){
				rec.sendMessage(KillMessage.getKillMessage(info));
				for (String x : multimessage){
					rec.sendMessage(x);
				}
			}
		} else {
			Bukkit.broadcastMessage(KillMessage.getKillMessage(info));
			for (String x : multimessage){
				Bukkit.broadcastMessage(x);
			}
		}
	}
	
//	@EventHandler
//	public void onPlayerJoinExtra(final PlayerJoinEvent event){
//		
//		Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("MultiKillS"), new Runnable(){
//
//			@Override
//			public void run() {
//				String name = event.getPlayer().getName();
//				if (name.equals("Meiqiu")) name = ChatColor.RED + "煤球桑";
//				if (event.getPlayer().getItemInHand().getType() == Material.AIR){
//					//Do Nothing
//					//Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + name + ChatColor.LIGHT_PURPLE + " 两手空空闪亮登场！");
//				} else {
//					Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + name + ChatColor.LIGHT_PURPLE + " 手拿 " + ChatColor.AQUA + KillWeapon.gethisweapon(event.getPlayer()) + ChatColor.LIGHT_PURPLE + " 闪亮登场！");
//				}
//				
//			}
//			
//			
//					
//		}, 5L);
//		
//
//	}
	

}


