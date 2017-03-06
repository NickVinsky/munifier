package nikkyvi.munifier.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nikkyvi.munifier.handlers.RegHandler;

public class ModBlocks {

	public static Block BlazeriteOre;
	public static Block GemstoneOre;
	
	public static void preInit() {		
		RegHandler.autoReg(BlazeriteOre = 
				 new BlockBlazeriteOre(Material.ROCK, "oreBlazerite"), "oreBlazerite");	
		RegHandler.autoReg(GemstoneOre = 
				 new BlockGemstoneOre(Material.ROCK, "oreGemstone"), "oreGemstone");
	}
	public static void registerRenders() {
		RegHandler.regRender(BlazeriteOre);
		RegHandler.regRender(GemstoneOre);
	}
}
