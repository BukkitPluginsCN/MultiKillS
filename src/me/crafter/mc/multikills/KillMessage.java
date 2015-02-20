package me.crafter.mc.multikills;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.bukkit.ChatColor;

public class KillMessage {
	
	private static Random random;
	private static List<String> thorns = new ArrayList<String>();
	private static List<String> pvp = new ArrayList<String>();
	private static List<String> pvparrow = new ArrayList<String>();
	private static List<String> fuzhu = new ArrayList<String>();
	private static List<String> other = new ArrayList<String>();
	private static List<String> tnt = new ArrayList<String>();
	private static List<String> cactus = new ArrayList<String>();
	private static List<String> water = new ArrayList<String>();
	private static List<String> creeper = new ArrayList<String>();
	private static List<String> fall = new ArrayList<String>();
	private static List<String> anvil = new ArrayList<String>();
	private static List<String> fire = new ArrayList<String>();
	private static List<String> lava = new ArrayList<String>();
	private static List<String> lightning = new ArrayList<String>();
	private static List<String> potion = new ArrayList<String>();
	private static List<String> snowman = new ArrayList<String>();
	private static List<String> poison = new ArrayList<String>();
	private static List<String> hunger = new ArrayList<String>();
	private static List<String> suffocation = new ArrayList<String>();
	private static List<String> kill = new ArrayList<String>();
	private static List<String> voids = new ArrayList<String>();
	private static List<String> withereffect = new ArrayList<String>();
	private static List<String> skeleton = new ArrayList<String>();
	private static List<String> witherskeleton = new ArrayList<String>();
	private static List<String> zombie = new ArrayList<String>();
	private static List<String> spider = new ArrayList<String>();
	private static List<String> cavespider = new ArrayList<String>();
	private static List<String> enderman = new ArrayList<String>();
	private static List<String> silverfish = new ArrayList<String>();
	private static List<String> magmacube = new ArrayList<String>();
	private static List<String> slime = new ArrayList<String>();
	private static List<String> wolf = new ArrayList<String>();
	private static List<String> pigzombie = new ArrayList<String>();
	private static List<String> irongolem = new ArrayList<String>();
	private static List<String> giant = new ArrayList<String>();
	private static List<String> wither = new ArrayList<String>();
	private static List<String> blaze = new ArrayList<String>();
	private static List<String> ghast = new ArrayList<String>();
	private static List<String> dispenser = new ArrayList<String>();
	private static List<String> guardian = new ArrayList<String>();
	private static List<String> rabbit = new ArrayList<String>();

	public KillMessage(File folder) {
		random = new Random();
		File fi = new File(folder, "messages.txt");
		List<String> item = new ArrayList<String>();
		item = scan(fi);
		String[] split; 
		for (String x : item){
			if (!x.contains(":")) continue;
			split = x.split(":",2);
			if (split[0].equals("thorns")) thorns.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("pvp")) pvp.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("pvparrow")) pvparrow.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("fuzhu")) fuzhu.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("other")) other.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("tnt")) tnt.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("cactus")) cactus.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("water")) water.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("creeper")) creeper.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("fall")) fall.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("anvil")) anvil.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("fire")) fire.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("lava")) lava.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("lightning")) lightning.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("potion")) potion.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("snowman")) snowman.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("poison")) poison.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("hunger")) hunger.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("suffocation")) suffocation.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("kill")) kill.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("voids")) voids.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("withereffect")) withereffect.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("skeleton")) skeleton.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("witherskeleton")) witherskeleton.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("zombie")) zombie.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("spider")) spider.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("cavespider")) cavespider.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("enderman")) enderman.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("silverfish")) silverfish.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("magmacube")) magmacube.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("slime")) slime.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("wolf")) wolf.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("pigzombie")) pigzombie.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("irongolem")) irongolem.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("giant")) giant.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("wither")) wither.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("blaze")) blaze.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("ghast")) ghast.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("dispenser")) dispenser.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("guardian")) guardian.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
			if (split[0].equals("rabbit")) rabbit.add(ChatColor.translateAlternateColorCodes("&".charAt(0) , split[1]));
		}
	}

	public static String getKillMessage(DeathInfo info){
		if (info.getReason().equals("thorns")){
			return (thorns.get(random.nextInt(thorns.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("pvp")){
			return (pvp.get(random.nextInt(pvp.size()))).replace("%d",info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("pvparrow")){
			return (pvparrow.get(random.nextInt(pvparrow.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("fuzhu")){
			return (fuzhu.get(random.nextInt(fuzhu.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("tnt")){
			return (tnt.get(random.nextInt(tnt.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("cactus")){
			return (cactus.get(random.nextInt(cactus.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("water")){
			return (water.get(random.nextInt(water.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("creeper")){
			return (creeper.get(random.nextInt(creeper.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("fall")){
			return (fall.get(random.nextInt(fall.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("anvil")){
			return (anvil.get(random.nextInt(anvil.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("fire")){
			return (fire.get(random.nextInt(fire.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("lava")){
			return (lava.get(random.nextInt(lava.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("lightning")){
			return (lightning.get(random.nextInt(lightning.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("potion")){
			return (potion.get(random.nextInt(potion.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("snowman")){
			return (snowman.get(random.nextInt(snowman.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("poison")){
			return (poison.get(random.nextInt(poison.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("hunger")){
			return (hunger.get(random.nextInt(hunger.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("suffocation")){
			return (suffocation.get(random.nextInt(suffocation.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("kill")){
			return (kill.get(random.nextInt(kill.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("voids")){
			return (voids.get(random.nextInt(voids.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("withereffect")){
			return (withereffect.get(random.nextInt(withereffect.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("skeleton")){
			return (skeleton.get(random.nextInt(skeleton.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("witherskeleton")){
			return (witherskeleton.get(random.nextInt(witherskeleton.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("zombie")){
			return (zombie.get(random.nextInt(zombie.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("spider")){
			return (spider.get(random.nextInt(spider.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("cavespider")){
			return (cavespider.get(random.nextInt(cavespider.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("enderman")){
			return (enderman.get(random.nextInt(enderman.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("silverfish")){
			return (silverfish.get(random.nextInt(silverfish.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("magmacube")){
			return (magmacube.get(random.nextInt(magmacube.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("slime")){
			return (slime.get(random.nextInt(slime.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("pigzombie")){
			return (pigzombie.get(random.nextInt(pigzombie.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("irongolem")){
			return (irongolem.get(random.nextInt(irongolem.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("giant")){
			return (giant.get(random.nextInt(giant.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("wither")){
			return (wither.get(random.nextInt(wither.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("blaze")){
			return (blaze.get(random.nextInt(blaze.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("ghast")){
			return (ghast.get(random.nextInt(ghast.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("dispenser")){
			return (dispenser.get(random.nextInt(dispenser.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("wolf")){
			return (wolf.get(random.nextInt(wolf.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("guardian")){
			return (guardian.get(random.nextInt(guardian.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		}
		else if (info.getReason().equals("rabbit")){
			return (rabbit.get(random.nextInt(rabbit.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon());
		} else {
			return (other.get(random.nextInt(other.size()))).replace("%d", info.getDierDisplayName()).replace("%k", info.getKillerDisplayName()).replace("%w", info.getWeapon())+"("+info.getReason()+")";
		}
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
