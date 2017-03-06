package nikkyvi.munifier;

import java.util.TreeMap;

import net.minecraftforge.common.config.Configuration;
import nikkyvi.munifier.handlers.LogHandler;
import nikkyvi.munifier.proxy.CommonProxy;
import nikkyvi.munifier.tables.DropEnum;

public class Config {

	private static final String CATEGORY_GENERAL = "general";
	private static final String CATEGORY_GENERATION = "World generation configuration";
    private static final String CATEGORY_DROP = "Drop configuration";

    // This values below you can access elsewhere in your mod:
    //ublic static boolean isThisAGoodTutorial = true;
    //public static String yourRealName = "Steve";
    
    public static int blazeriteOreSpawnCount = 6;
    public static int blazeriteOreSpawnChance = 5;
    public static int blazeriteOreSpawnMinHeight = 4;
    public static int blazeriteOreSpawnMaxHeight = 24; 
    
    public static int GemstoneOreSpawnCount = 8;
    public static int GemstoneOreSpawnChance = 4;
    public static int GemstoneOreSpawnMinHeight = 0;
    public static int GemstoneOreSpawnMaxHeight = 16;
    
    public static TreeMap<Enum<DropEnum>, TreeMap<Integer, Integer>> dropTable = new TreeMap<Enum<DropEnum>, TreeMap<Integer, Integer>>();        

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {    	
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initWorldGenerationConfig(cfg);
            initDropConfig(cfg);
        } catch (Exception e1) {
            //ModTut.logger.log(Level.ERROR, "Problem loading config file!", e1);     
        	LogHandler.getLogger().error(e1);
        	
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initWorldGenerationConfig(Configuration cfg) {    
    	
        //cfg.addCustomCategoryComment(CATEGORY_GENERATION, "World generation configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        //isThisAGoodTutorial = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, isThisAGoodTutorial, "Set to false if you don't like this tutorial");
        //yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
        blazeriteOreSpawnCount = cfg.getInt("BlazeriteOre_SpawnCount", CATEGORY_GENERATION, blazeriteOreSpawnCount, 0, 100, "");
        blazeriteOreSpawnChance = cfg.getInt("BlazeriteOre_SpawnChance", CATEGORY_GENERATION, blazeriteOreSpawnChance, 0, 100, "");
        blazeriteOreSpawnMinHeight = cfg.getInt("BlazeriteOre_MinSpawHeight", CATEGORY_GENERATION, blazeriteOreSpawnMinHeight, 0, 62, "");
        blazeriteOreSpawnMaxHeight = cfg.getInt("BlazeriteOre_MaxSpawHeight", CATEGORY_GENERATION, blazeriteOreSpawnMaxHeight, 0, 62, "");
        GemstoneOreSpawnCount = cfg.getInt("GemstoneOre_SpawnCount", CATEGORY_GENERATION, GemstoneOreSpawnCount, 0, 100, "");
        GemstoneOreSpawnChance = cfg.getInt("GemstoneOre_SpawnChance", CATEGORY_GENERATION, GemstoneOreSpawnChance, 0, 100, "");
        GemstoneOreSpawnMinHeight = cfg.getInt("GemstoneOre_MinSpawHeight", CATEGORY_GENERATION, GemstoneOreSpawnMinHeight, 0, 62, "");
        GemstoneOreSpawnMaxHeight = cfg.getInt("GemstoneOre_MaxSpawHeight", CATEGORY_GENERATION, GemstoneOreSpawnMaxHeight, 0, 62, "");
    }

    private static void initDropConfig(Configuration cfg) {    	
    	addDrop(DropEnum.BLAZE_POWDER,  7, 4, cfg);
    	addDrop(DropEnum.BLAZE_ROD,  2, 1, cfg);
    	addDrop(DropEnum.GLOWSTONE_DUST,  9, 7, cfg);
    	addDrop(DropEnum.GUNPOWDER,  8, 6, cfg);
    	
    	addDrop(DropEnum.DIAMOND,  3, 2, cfg);
    	addDrop(DropEnum.EMERALD,  8, 4, cfg);
    	addDrop(DropEnum.ENDER_PEARL,  4, 1, cfg);
    	addDrop(DropEnum.GHAST_TEAR,  5, 2, cfg);
    	addDrop(DropEnum.NETHER_STAR,  1, 1, cfg);
    	addDrop(DropEnum.QUARTZ,  7, 10, cfg);
    	addDrop(DropEnum.SLIME_BALL,  6, 7, cfg);
    	addDrop(DropEnum.LAPIS,  7, 8, cfg);
    	addDrop(DropEnum.PRISMARINE_SHARD,  3, 3, cfg);
    	addDrop(DropEnum.PRISMARINE_CRYSTALS,  3, 3, cfg);
    	addDrop(DropEnum.GOLD_NUGGET,  5, 11, cfg);
    	addDrop(DropEnum.SILVER_NUGGET,  5, 12, cfg);
    	addDrop(DropEnum.COBALT_NUGGET,  5, 12, cfg);
    	addDrop(DropEnum.ARDITE_NUGGET,  5, 12, cfg);
    	addDrop(DropEnum.ALUBRASS_NUGGET,  5, 12, cfg); 
    	addDrop(DropEnum.ALUMINIUM_GRIT,  7, 6, cfg); 
    	
    }
    
    private static void addDrop(Enum item, int defaultChance, int defaultRolls, Configuration cfg) {
    	final String sChance = "_DropChance"; final String sRolls = "_NumberOfRolls";
    	final String name = item.toString();
    	dropTable.put(item, new TreeMap<Integer, Integer>());
    	dropTable.get(item).put(cfg.getInt(name + sChance, CATEGORY_DROP + " for " + name, defaultChance, 0, 100, ""),
    								cfg.getInt(name + sRolls, CATEGORY_DROP + " for " + name, defaultRolls, 0, 100, ""));
    	//LogHandler.getLogger().info("addDrop: " + name);
    }
}