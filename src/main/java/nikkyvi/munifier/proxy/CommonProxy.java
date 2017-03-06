package nikkyvi.munifier.proxy;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nikkyvi.munifier.Config;
import nikkyvi.munifier.worldgen.OreGen;

public class CommonProxy {
	public static Configuration config;
	
    public void preInit(FMLPreInitializationEvent event)
    {
        File directory = event.getModConfigurationDirectory();
        
        config = new Configuration(new File(directory.getPath(), "munifier.cfg"));
        Config.readConfig();
    }
    
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerWorldGenerator(new OreGen(), 0);     	
    }
    
    public void postInit(FMLPostInitializationEvent event)
    {
        if (config.hasChanged()) {
            config.save();
        }
    }
}
