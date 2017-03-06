package nikkyvi.munifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nikkyvi.munifier.block.ModBlocks;
import nikkyvi.munifier.cooking.foodList;
import nikkyvi.munifier.proxy.CommonProxy;
import nikkyvi.munifier.recipes.ModRecipes;
import nikkyvi.munifier.tab.CreativeTab;

@Mod(modid = Munifier.MODID, version = Munifier.VERSION, name = Munifier.NAME)
public class Munifier
{
    public static final String MODID = "munifier";
    public static final String VERSION = "1.3b";
    public static final String NAME = "Munifier";
    
    @SidedProxy(clientSide = "nikkyvi.munifier.proxy.ClientProxy", serverSide = "nikkyvi.munifier.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static Munifier instance;
    public static CreativeTab TabMunifier;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)    {
    	TabMunifier = new CreativeTab(CreativeTabs.getNextID(), "tab_munifier");
    	foodList.preInit();
    	ModBlocks.preInit();    	
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)    {    	  
    	ModRecipes.Init();
    	proxy.init(event);
        // some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)    {
    	MinecraftForge.EVENT_BUS.register(new nikkyvi.munifier.handlers.EventHandler());
    	proxy.postInit(event);
    }
}
