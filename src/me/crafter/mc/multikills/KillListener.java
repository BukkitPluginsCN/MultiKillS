package me.crafter.mc.multikills;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		DeathInfo info = new DeathInfo(event);
		event.setDeathMessage(null);
		Bukkit.broadcastMessage(KillMessage.getKillMessage(info));
		if (info.getReason().equals("other")){
			event.getEntity().sendMessage(ChatColor.RED+"非正常死亡，请将此次实际死亡原因和以下内容私聊腐竹以便排除bug，谢谢！");
			event.getEntity().sendMessage("Reason "+info.getReason());
			event.getEntity().sendMessage("Death "+info.getDier());
			event.getEntity().sendMessage("Killer "+info.getKiller());
			event.getEntity().sendMessage("Cause "+info.getCause());
			event.getEntity().sendMessage("Damager "+info.getDamager());
		}
		List<String> multimessage = MkdMessage.getMessage(info);
		for (String x : multimessage){
			Bukkit.broadcastMessage(x);
		}
	}
	

}


