package me.crafter.mc.multikills;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiKillS extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Mincraft");
	public final KillListener pl = new KillListener();
	

    public void onEnable(){
    	this.logger.info("Plugin made by connection_lost. www.crafter.me");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.pl, this);
        File df = getDataFolder();
        new KillWeapon(df);
        new KillMessage(df);
        new MkdMessage(df);
        }
 

    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, final String[] args){
    	if (!(sender instanceof Player)) return false;
    	Player p = ((Player)sender);
    	Material item = p.getItemInHand().getType();
    	int dura = p.getItemInHand().getDurability();
    	p.sendMessage(ChatColor.GOLD+"Item marerial name: "+item.toString()+", Item durability: "+String.valueOf(dura));
    	return true;
    }
	
}
