package me.crafter.mc.multikills;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KillWeapon {
	
	public static Map<Material,String> itemList = new HashMap<Material, String>();
	public static Map<String,String> itemSpecialList = new HashMap<String, String>();
	
	public KillWeapon(File folder) {
		File fi = new File(folder, "items.txt");
		List<String> item = new ArrayList<String>();
		item = scan(fi);
		String[] splitted;
		for (String x : item){
			if (x.contains(":")){
				splitted = x.split(":",2);
				if (splitted[0].equals("JINKELA")){
					itemSpecialList.put("JINKELA", splitted[1]);
				}
				else if (splitted[0].equals("FIST")){
					itemSpecialList.put("FIST", splitted[1]);
				}
				else {
					itemList.put(Material.getMaterial(splitted[0]), splitted[1]);
				}
			}
		}
	}

	public static String gethisweapon(Player killer) {
		if (killer.getItemInHand().hasItemMeta() && killer.getItemInHand().getItemMeta().getDisplayName()!=null) return killer.getItemInHand().getItemMeta().getDisplayName();
		if ((killer.getItemInHand().getType().equals(Material.INK_SACK)) && ((killer.getItemInHand().getDurability() == 15))) return itemSpecialList.get("JINKELA");;
		if (getTweakName(killer.getItemInHand()) != null) return getTweakName(killer.getItemInHand());
		return killer.getItemInHand().getType().name().toLowerCase().replaceAll("_", " ");
	}
	
	

	private static String getTweakName(ItemStack itemInHand) {
		Material item = itemInHand.getType();
	    return itemList.get(item);
	}

	public static String getTweakNameAlternate(ItemStack items){
		Material item = items.getType();
		if (item.equals(Material.IRON_SWORD)) return "铁剑"; 
		if (item.equals(Material.DIAMOND_SWORD)) return "钻石剑"; 
		if (item.equals(Material.STONE_SWORD)) return "石剑";
		if (item.equals(Material.WOOD_SWORD)) return "桃木剑";
		if (item.equals(Material.GOLD_SWORD)) return "土豪剑"; 
		if (item.equals(Material.ACTIVATOR_RAIL)) return "激活铁轨";
		if (item.equals(Material.ANVIL)) return "铁砧";
		if (item.equals(Material.APPLE)) return "肾";
		if (item.equals(Material.ARROW)) return "箭";
		if (item.equals(Material.BAKED_POTATO)) return "马铃薯烧土豆";
		if (item.equals(Material.BEACON)) return "猪柳蛋";
		if (item.equals(Material.BED)) return "爱床";
		if (item.equals(Material.BED_BLOCK)) return "爱床";
		if (item.equals(Material.BEDROCK)) return "地基石";
		if (item.equals(Material.BIRCH_WOOD_STAIRS)) return "要命楼梯"; 
		if (item.equals(Material.BLAZE_POWDER)) return "燃情烈焰粉"; 
		if (item.equals(Material.BLAZE_ROD)) return "烈焰大根"; 
		if (item.equals(Material.BOAT)) return "泰坦尼克"; 
		if (item.equals(Material.BONE)) return "棒状金坷垃"; 
		if (item.equals(Material.BOOK)) return "字典"; 
		if (item.equals(Material.BOOK_AND_QUILL)) return "本子"; 
		if (item.equals(Material.BOOKSHELF)) return "本子架"; 
		if (item.equals(Material.BOW)) return "弩炮"; 
		if (item.equals(Material.BOWL)) return "海碗"; 
		if (item.equals(Material.BREAD)) return "早苗的面包"; 
		if (item.equals(Material.BREWING_STAND)) return "炼药台"; 
		if (item.equals(Material.BREWING_STAND_ITEM)) return "炼药台"; 
		if (item.equals(Material.BRICK)) return "板砖"; 
		if (item.equals(Material.BRICK_STAIRS)) return "垫脚石"; 
		if (item.equals(Material.BROWN_MUSHROOM)) return "振动棒"; 
		if (item.equals(Material.BUCKET)) return "桶子"; ////////////////
		if (item.equals(Material.BURNING_FURNACE)) return "炉子"; 
		if (item.equals(Material.CACTUS)) return "仙人球"; 
		if (item.equals(Material.CAKE)) return "切糕"; 
		if (item.equals(Material.CAKE_BLOCK)) return "切糕"; 
		if (item.equals(Material.CARPET)) return "飞毯"; 
		if (item.equals(Material.CARROT)) return "萝♂卜"; 
		if (item.equals(Material.CARROT_ITEM)) return "萝♂卜"; 
		if (item.equals(Material.CARROT_STICK)) return "肥皂"; 
		if (item.equals(Material.CAULDRON)) return "马桶"; 
		if (item.equals(Material.CAULDRON_ITEM)) return "马桶"; 
		if (item.equals(Material.CHAINMAIL_BOOTS)) return "真空丝袜"; 
		if (item.equals(Material.CHAINMAIL_CHESTPLATE)) return "真空胸罩"; 
		if (item.equals(Material.CHAINMAIL_HELMET)) return "真空帽"; 
		if (item.equals(Material.CHAINMAIL_LEGGINGS)) return "真空短裙"; 
		if (item.equals(Material.CHEST)) return "聚宝盆"; 
		if (item.equals(Material.CLAY)) return "泥人张"; 
		if (item.equals(Material.CLAY_BALL)) return "粘土手办"; 
		if (item.equals(Material.CLAY_BRICK)) return "瓷"; 
		if (item.equals(Material.COAL)) return "黑丸"; 
		if (item.equals(Material.COAL_BLOCK)) return "黑子"; 
		if (item.equals(Material.COAL_ORE)) return "煤矿";//////////////////// 
		if (item.equals(Material.COBBLE_WALL)) return "石头棒棒"; 
		if (item.equals(Material.COBBLESTONE)) return "碎裂石块";//////////////// 
		if (item.equals(Material.COBBLESTONE_STAIRS)) return "碎块楼梯"; 
		if (item.equals(Material.COCOA)) return "咖啡豆"; 
		if (item.equals(Material.COMMAND)) return "指令方块"; 
		if (item.equals(Material.COMPASS)) return "指♂南针"; 
		if (item.equals(Material.COOKED_BEEF)) return "巨无霸"; 
		if (item.equals(Material.COOKED_CHICKEN)) return "上校鸡块"; 
		if (item.equals(Material.COOKED_FISH)) return "麦香鱼"; 
		if (item.equals(Material.COOKIE)) return "趣多多"; 
		if (item.equals(Material.CROPS)) return "亩产一千八"; 
		if (item.equals(Material.DAYLIGHT_DETECTOR)) return "白日探测器"; 
		if (item.equals(Material.DEAD_BUSH)) return "死树"; 
		if (item.equals(Material.DETECTOR_RAIL)) return "探测铁轨";///////////////////// 
		if (item.equals(Material.DIAMOND)) return "一颗就破产的钻石"; 
		if (item.equals(Material.DIAMOND_AXE)) return "钻石斧"; 
		if (item.equals(Material.DIAMOND_BARDING)) return "钻石马鞍"; 
		if (item.equals(Material.DIAMOND_BLOCK)) return "破产九次的钻石块"; 
		if (item.equals(Material.DIAMOND_BOOTS)) return "钻石靴"; 
		if (item.equals(Material.DIAMOND_CHESTPLATE)) return "钻石胸甲"; 
		if (item.equals(Material.DIAMOND_HELMET)) return "钻石头盔"; 
		if (item.equals(Material.DIAMOND_HOE)) return "共产主义之怒"; 
		if (item.equals(Material.DIAMOND_LEGGINGS)) return "钻石长裤"; 
		if (item.equals(Material.DIAMOND_ORE)) return "马上就破产的钻石矿"; 
		if (item.equals(Material.DIAMOND_PICKAXE)) return "钻石镐"; 
		if (item.equals(Material.DIAMOND_SPADE)) return "钻石铲"; 
		if (item.equals(Material.DIODE)) return "链♂接装置"; 
		if (item.equals(Material.DIODE_BLOCK_OFF)) return "链♂接装置"; 
		if (item.equals(Material.DIODE_BLOCK_ON)) return "链♂接装置"; 
		if (item.equals(Material.DIRT)) return "两米下有氮磷钾的土"; 
		if (item.equals(Material.DISPENSER)) return "射人机器"; 
		if (item.equals(Material.DOUBLE_STEP)) return "二明治"; 
		if (item.equals(Material.DRAGON_EGG)) return "龙の蛋蛋"; 
		if (item.equals(Material.DROPPER)) return "自动售货机"; 
		if (item.equals(Material.EGG)) return "蛋蛋"; 
		if (item.equals(Material.EMERALD)) return "通用货币"; 
		if (item.equals(Material.EMERALD_BLOCK)) return "大额通用货币"; 
		if (item.equals(Material.EMERALD_ORE)) return "通用货币材料"; 
		if (item.equals(Material.EMPTY_MAP)) return "宣纸"; 
		if (item.equals(Material.ENCHANTED_BOOK)) return "魔法书"; 
		if (item.equals(Material.ENCHANTMENT_TABLE)) return "抚摸台"; 
		if (item.equals(Material.ENDER_CHEST)) return "基佬箱"; 
		if (item.equals(Material.ENDER_PEARL)) return "基佬珍珠"; 
		if (item.equals(Material.ENDER_PORTAL)) return "基佬世界之门"; 
		if (item.equals(Material.ENDER_PORTAL_FRAME)) return "基佬世界之门"; 
		if (item.equals(Material.ENDER_STONE)) return "基佬石"; 
		if (item.equals(Material.EXP_BOTTLE)) return "节操瓶"; 
		if (item.equals(Material.EXPLOSIVE_MINECART)) return "死亡动车"; 
		if (item.equals(Material.EYE_OF_ENDER)) return "基佬眼"; 
		if (item.equals(Material.FEATHER)) return "毛"; 
		if (item.equals(Material.FENCE)) return "隔离护栏"; 
		if (item.equals(Material.FENCE_GATE)) return "隔离门"; 
		if (item.equals(Material.FERMENTED_SPIDER_EYE)) return "蜘蛛眼奶酪"; 
		if (item.equals(Material.FIRE)) return "火球"; 
		if (item.equals(Material.FIREBALL)) return "FFF弹药"; 
		if (item.equals(Material.FIREWORK_CHARGE)) return "礼花弹"; 
		if (item.equals(Material.FIREWORK)) return "孔明灯"; 
		if (item.equals(Material.FISHING_ROD)) return "破旧钓竿"; 
		if (item.equals(Material.FLINT)) return "打火石"; 
		if (item.equals(Material.FLINT_AND_STEEL)) return "打火机"; 
		if (item.equals(Material.FLOWER_POT)) return "花盆"; 
		if (item.equals(Material.FLOWER_POT_ITEM)) return "花盆"; 
		if (item.equals(Material.FURNACE)) return "炉子"; 
		if (item.equals(Material.GHAST_TEAR)) return "天使之淚"; 
		if (item.equals(Material.GLASS)) return "假钻石"; 
		if (item.equals(Material.GLASS_BOTTLE)) return "酒瓶"; 
		if (item.equals(Material.GLOWING_REDSTONE_ORE)) return "闪光红石矿"; 
		if (item.equals(Material.GLOWSTONE)) return "闪光石";  
		if (item.equals(Material.GLOWSTONE_DUST)) return "胭脂"; 
		if (item.equals(Material.GOLD_AXE)) return "土豪斧"; 
		if (item.equals(Material.GOLD_BARDING)) return "土豪马甲"; 
		if (item.equals(Material.GOLD_BLOCK)) return "大土豪象征"; 
		if (item.equals(Material.GOLD_BOOTS)) return "土豪丝袜"; 
		if (item.equals(Material.GOLD_CHESTPLATE)) return "土豪胸罩"; 
		if (item.equals(Material.GOLD_HELMET)) return "乌纱帽";  
		if (item.equals(Material.GOLD_HOE)) return "共产主义之辉"; 
		if (item.equals(Material.GOLD_INGOT)) return "土豪象征"; 
		if (item.equals(Material.GOLD_LEGGINGS)) return "土豪短裙"; 
		if (item.equals(Material.GOLD_NUGGET)) return "镶金的牙"; 
		if (item.equals(Material.GOLD_ORE)) return "土豪矿石"; 
		if (item.equals(Material.GOLD_PICKAXE)) return "土豪镐"; 
		if (item.equals(Material.GOLD_PLATE)) return "土豪地板"; 
		if (item.equals(Material.GOLD_RECORD)) return "盘"; 
		if (item.equals(Material.RECORD_3)) return "盘";
		if (item.equals(Material.RECORD_4)) return "盘";
		if (item.equals(Material.RECORD_5)) return "盘";
		if (item.equals(Material.RECORD_6)) return "盘";
		if (item.equals(Material.RECORD_7)) return "盘";
		if (item.equals(Material.RECORD_8)) return "盘";
		if (item.equals(Material.RECORD_9)) return "盘";
		if (item.equals(Material.RECORD_10)) return "盘";
		if (item.equals(Material.RECORD_11)) return "盘";
		if (item.equals(Material.RECORD_12)) return "盘";
		if (item.equals(Material.GOLD_SPADE)) return "土豪铲"; 
		if (item.equals(Material.GOLDEN_APPLE)) return "土豪苹果"; 
		if (item.equals(Material.GOLDEN_CARROT)) return "土豪萝卜"; 
		if (item.equals(Material.GRASS)) return "艹"; 
		if (item.equals(Material.GRAVEL)) return "碎石沙"; 
		if (item.equals(Material.GREEN_RECORD)) return "盘"; 
		if (item.equals(Material.GRILLED_PORK)) return "猪柳蛋"; 
		if (item.equals(Material.HARD_CLAY)) return "发硬的土"; 
		if (item.equals(Material.HAY_BLOCK)) return "骨灰缸"; 
		if (item.equals(Material.HOPPER)) return "圆锥体"; 
		if (item.equals(Material.HOPPER_MINECART)) return "圆锥×方形"; 
		if (item.equals(Material.HUGE_MUSHROOM_1)) return "大蘑菇"; 
		if (item.equals(Material.HUGE_MUSHROOM_2)) return "大蘑菇"; 
		if (item.equals(Material.ICE)) return "永冻之冰"; 
		if (item.equals(Material.INK_SACK)) return "油漆";
		if ((item.equals(Material.INK_SACK)) && (items.getDurability() == 15)) return "金坷垃";
		if (item.equals(Material.IRON_AXE)) return "铁斧"; 
		if (item.equals(Material.IRON_BARDING)) return "铁马甲"; 
		if (item.equals(Material.IRON_BLOCK)) return "铁块"; 
		if (item.equals(Material.IRON_BOOTS)) return "铁鞋"; 
		if (item.equals(Material.IRON_DOOR)) return "铁门"; 
		if (item.equals(Material.IRON_FENCE)) return "护栏"; 
		if (item.equals(Material.IRON_HELMET)) return "铁头套"; 
		if (item.equals(Material.IRON_HOE)) return "共产主义之力"; 
		if (item.equals(Material.IRON_INGOT)) return "铁锭"; 
		if (item.equals(Material.IRON_ORE)) return "铁矿"; 
		if (item.equals(Material.IRON_PICKAXE)) return "铁镐"; 
		if (item.equals(Material.IRON_PLATE)) return "铁地板"; 
		if (item.equals(Material.ITEM_FRAME)) return "画框"; 
		if (item.equals(Material.JACK_O_LANTERN)) return "万圣灯笼"; 
		if (item.equals(Material.JUKEBOX)) return "收音机"; 
		if (item.equals(Material.JUNGLE_WOOD_STAIRS)) return "贝爷楼梯"; 
		if (item.equals(Material.LADDER)) return "云梯"; 
		if (item.equals(Material.LAPIS_BLOCK)) return "蓝宝石"; 
		if (item.equals(Material.LAPIS_ORE)) return "蓝宝石矿"; 
		if (item.equals(Material.LAVA)) return "岩浆"; 
		if (item.equals(Material.LAVA_BUCKET)) return "一桶热水"; 
		if (item.equals(Material.LEASH)) return "鞭子"; 
		if (item.equals(Material.LEATHER)) return "脸皮"; 
		if (item.equals(Material.LEATHER_BOOTS)) return "皮鞋"; 
		if (item.equals(Material.LEATHER_CHESTPLATE)) return "皮衣"; 
		if (item.equals(Material.LEATHER_HELMET)) return "皮帽"; 
		if (item.equals(Material.LEATHER_LEGGINGS)) return "皮裤"; 
		if (item.equals(Material.LEAVES)) return "柳叶"; 
		if (item.equals(Material.LEVER)) return "杠杆"; 
		//if (item.equals(Material.LOCKED_CHEST)) return "箱子"; 
		if (item.equals(Material.LOG)) return "新手木头"; 
		if (item.equals(Material.LONG_GRASS)) return "艹"; 
		if (item.equals(Material.MAGMA_CREAM)) return "滚烫史莱姆球"; 
		if (item.equals(Material.MAP)) return "开过的图"; 
		if (item.equals(Material.MELON)) return "西瓜"; 
		if (item.equals(Material.MELON_BLOCK)) return "大西瓜"; 
		if (item.equals(Material.MELON_SEEDS)) return "瓜子"; 
		if (item.equals(Material.MELON_STEM)) return "瓜苗"; 
		if (item.equals(Material.MILK_BUCKET)) return "三聚氰胺"; 
		if (item.equals(Material.MINECART)) return "过山车"; 
		//if (item.equals(Material.MOB_SPAWNER)) return "刷怪笼"; 
		if (item.equals(Material.MONSTER_EGG)) return "动物蛋蛋"; 
		if (item.equals(Material.MONSTER_EGGS)) return "动物蛋蛋"; 
		if (item.equals(Material.MOSSY_COBBLESTONE)) return "长毛的石头"; 
		if (item.equals(Material.MUSHROOM_SOUP)) return "毒蘑菇汤"; 
		if (item.equals(Material.MYCEL)) return "腐蚀之地"; 
		if (item.equals(Material.NAME_TAG)) return "狗牌"; 
		if (item.equals(Material.NETHER_BRICK)) return "下界砖头"; 
		if (item.equals(Material.NETHER_BRICK_ITEM)) return "下界板砖"; 
		if (item.equals(Material.NETHER_BRICK_STAIRS)) return "地狱梯"; 
		if (item.equals(Material.NETHER_FENCE)) return "地狱护栏"; 
		if (item.equals(Material.NETHER_STALK)) return "地狱毒蘑菇"; 
		if (item.equals(Material.NETHER_STAR)) return "史诗级星星"; 
		if (item.equals(Material.NETHER_WARTS)) return "地狱毒蘑菇"; 
		if (item.equals(Material.NETHERRACK)) return "地狱土块"; 
		if (item.equals(Material.NOTE_BLOCK)) return "留声机"; 
		if (item.equals(Material.OBSIDIAN)) return "火山岩"; 
		if (item.equals(Material.PAINTING)) return "哲学挂画"; 
		if (item.equals(Material.PAPER)) return "白纸一张"; 
		if (item.equals(Material.PISTON_BASE)) return "伸缩机"; 
		if (item.equals(Material.PISTON_EXTENSION)) return "伸缩机"; 
		if (item.equals(Material.PISTON_MOVING_PIECE)) return "伸缩机"; 
		if (item.equals(Material.PISTON_STICKY_BASE)) return "粘性伸缩机"; 
		if (item.equals(Material.POISONOUS_POTATO)) return "发芽的马铃薯"; 
		if (item.equals(Material.PORK)) return "生肉"; 
		if (item.equals(Material.PORTAL)) return "传送门"; 
		if (item.equals(Material.POTATO)) return "土豆烩马铃薯"; 
		if (item.equals(Material.POTATO_ITEM)) return "土豆烩马铃薯"; 
		if (item.equals(Material.POTION)) return "水壶"; 
		if (item.equals(Material.POWERED_MINECART)) return "动车侠"; 
		if (item.equals(Material.POWERED_RAIL)) return "动力铁轨"; 
		if (item.equals(Material.PUMPKIN)) return "南瓜头"; 
		if (item.equals(Material.PUMPKIN_PIE)) return "南瓜饼"; 
		if (item.equals(Material.PUMPKIN_SEEDS)) return "南瓜子"; 
		if (item.equals(Material.PUMPKIN_STEM)) return "南瓜苗";
		if (item.equals(Material.QUARTZ)) return "二氧化硅"; 
		if (item.equals(Material.QUARTZ_BLOCK)) return "大号二氧化硅"; 
		if (item.equals(Material.QUARTZ_ORE)) return "硅矿"; 
		if (item.equals(Material.QUARTZ_STAIRS)) return "硅胶楼梯"; 
		if (item.equals(Material.RAILS)) return "高铁轨"; 
		if (item.equals(Material.RAW_BEEF)) return "生肉"; 
		if (item.equals(Material.RAW_CHICKEN)) return "生肉"; 
		if (item.equals(Material.RAW_FISH)) return "刺身"; 
		if (item.equals(Material.RED_MUSHROOM)) return "毒蘑菇"; 
		if (item.equals(Material.RED_ROSE)) return "⑨⑨⑨玫瑰"; 
		if (item.equals(Material.REDSTONE)) return "砒霜"; 
		if (item.equals(Material.REDSTONE_BLOCK)) return "砒霜固体"; 
		if (item.equals(Material.REDSTONE_COMPARATOR)) return "砒霜测量仪"; 
		if (item.equals(Material.REDSTONE_COMPARATOR_OFF)) return "砒霜测量仪"; 
		if (item.equals(Material.REDSTONE_COMPARATOR_ON)) return "砒霜测量仪"; 
		if (item.equals(Material.REDSTONE_LAMP_OFF)) return "爱迪生之爱"; 
		if (item.equals(Material.REDSTONE_LAMP_ON)) return "爱迪生之爱"; 
		if (item.equals(Material.REDSTONE_ORE)) return "砒霜原材料"; 
		if (item.equals(Material.REDSTONE_TORCH_OFF)) return "砒霜火把"; 
		if (item.equals(Material.REDSTONE_TORCH_ON)) return "砒霜火把"; 
		if (item.equals(Material.REDSTONE_WIRE)) return "砒霜线路"; 
		if (item.equals(Material.ROTTEN_FLESH)) return "发霉的肉"; 
		if (item.equals(Material.SADDLE)) return "皮马甲"; 
		if (item.equals(Material.SAND)) return "流沙"; 
		if (item.equals(Material.SANDSTONE)) return "沙石"; //////////////////
		if (item.equals(Material.SANDSTONE_STAIRS)) return "沙石楼梯"; /////////////
		if (item.equals(Material.SAPLING)) return "树苗苗"; 
		if (item.equals(Material.SEEDS)) return "BT种子"; 
		if (item.equals(Material.SHEARS)) return "剪♂刀"; 
		if (item.equals(Material.SIGN)) return "大字报"; 
		if (item.equals(Material.SIGN_POST)) return "大字报"; 
		if (item.equals(Material.SKULL)) return "头颅"; 
		if (item.equals(Material.SKULL_ITEM)) return "头颅"; 
		if (item.equals(Material.SLIME_BALL)) return "发泄球"; 
		if (item.equals(Material.SMOOTH_BRICK)) return "圆滑砖"; 
		if (item.equals(Material.SMOOTH_STAIRS)) return "圆形楼梯"; 
		if (item.equals(Material.SNOW)) return "血"; 
		if (item.equals(Material.SNOW_BALL)) return "血球"; 
		if (item.equals(Material.SNOW_BLOCK)) return "血豆腐"; 
		if (item.equals(Material.SOIL)) return "耕地"; 
		if (item.equals(Material.SOUL_SAND)) return "中二沙"; 
		if (item.equals(Material.SPECKLED_MELON)) return "闪光西瓜"; 
		if (item.equals(Material.SPIDER_EYE)) return "蜘蛛眼球"; 
		if (item.equals(Material.SPONGE)) return "海绵宝宝"; 
		if (item.equals(Material.SPRUCE_WOOD_STAIRS)) return "小楼梯"; 
		if (item.equals(Material.STAINED_CLAY)) return "瓷块"; 
		if (item.equals(Material.STATIONARY_LAVA)) return "岩浆"; 
		if (item.equals(Material.STATIONARY_WATER)) return "水"; 
		if (item.equals(Material.STEP)) return "小石头"; 
		if (item.equals(Material.STICK)) return "棍♂子"; 
		if (item.equals(Material.STONE)) return "孙悟空的原型"; 
		if (item.equals(Material.STONE_AXE)) return "石斧"; 
		if (item.equals(Material.STONE_HOE)) return "共产主义之希望"; 
		if (item.equals(Material.STONE_PICKAXE)) return "石镐"; 
		if (item.equals(Material.STONE_PLATE)) return "石地板"; 
		if (item.equals(Material.STONE_SPADE)) return "石铲";  
		if (item.equals(Material.STORAGE_MINECART)) return "火车侠"; 
		if (item.equals(Material.STRING)) return "毛线"; 
		if (item.equals(Material.SUGAR)) return "糖糖"; 
		if (item.equals(Material.SUGAR_CANE_BLOCK)) return "甘蔗"; 
		if (item.equals(Material.SULPHUR)) return "硫磺"; 
		if (item.equals(Material.THIN_GLASS)) return "假金刚石片"; 
		if (item.equals(Material.TNT)) return "飞毛腿"; 
		if (item.equals(Material.TORCH)) return "火炬"; 
		if (item.equals(Material.TRAP_DOOR)) return "陷阱门"; 
		if (item.equals(Material.TRAPPED_CHEST)) return "假聚宝盆"; 
		if (item.equals(Material.TRIPWIRE)) return "绊线"; 
		if (item.equals(Material.TRIPWIRE_HOOK)) return "钩♂子"; 
		if (item.equals(Material.VINE)) return "蔓藤"; 
		if (item.equals(Material.WALL_SIGN)) return "大字报"; 
		if (item.equals(Material.WATCH)) return "时钟"; 
		if (item.equals(Material.WATER)) return "水"; 
		if (item.equals(Material.WATER_BUCKET)) return "桶装水"; 
		if (item.equals(Material.WATER_LILY)) return "莲蓬×"; 
		if (item.equals(Material.WEB)) return "互联网"; 
		if (item.equals(Material.WHEAT)) return "亩产一千八"; 
		if (item.equals(Material.WOOD)) return "新手木头"; 
		if (item.equals(Material.WOOD_AXE)) return "木斧"; 
		if (item.equals(Material.WOOD_BUTTON)) return "木质按钮"; 
		if (item.equals(Material.WOOD_DOOR)) return "防盗门"; 
		if (item.equals(Material.WOOD_DOUBLE_STEP)) return "木头块"; 
		if (item.equals(Material.WOOD_HOE)) return "共产主义之萌芽"; 
		if (item.equals(Material.WOOD_PICKAXE)) return "木镐"; 
		if (item.equals(Material.WOOD_PLATE)) return "木地板"; 
		if (item.equals(Material.WOOD_SPADE)) return "木铲"; 
		if (item.equals(Material.WOOD_STAIRS)) return "木梯"; 
		if (item.equals(Material.WOOD_STEP)) return "小木块";  
		if (item.equals(Material.WOODEN_DOOR)) return "木门"; 
		if (item.equals(Material.WOOL)) return "羊绒"; 
		if (item.equals(Material.WORKBENCH)) return "工作台"; 
		if (item.equals(Material.WRITTEN_BOOK)) return "工口本";
		if (item.equals(Material.YELLOW_FLOWER)) return "蒲公英"; 
		return null;
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
