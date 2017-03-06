package nikkyvi.munifier.recipes;

import com.raoulvdberge.refinedstorage.RSItems;
import com.raoulvdberge.refinedstorage.item.ItemProcessor;

import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.stone.BlockTypes_StoneDecoration;
import forestry.core.PluginFluids;
import forestry.api.core.EnumContainerType;
import mods.railcraft.common.items.RailcraftItems;
import mods.railcraft.common.items.ItemTie.EnumTie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import nikkyvi.munifier.cooking.foodList;
import slimeknights.tconstruct.shared.TinkerCommons;

public class ModRecipes {
	
	public static void Init() {
		munifiedRecipes();
		exlusiveRecipes();  	

    	//ModBlocks.BlazeriteOre;
    	//BlockSeared.SearedType.BRICK
	}
	
	private static void exlusiveRecipes() {		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.SPIDER_EYE, 32), new ItemStack(Items.ENDER_EYE, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.STRING, 2), new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
		
		// VARENIK
    	GameRegistry.addRecipe(new ItemStack(foodList.foodVarenik, 8),
    	" W ",
    	"WPW",
    	" W ",
    	'W', Items.WHEAT, 'P', Items.BAKED_POTATO
    	);
		// PELMEN
    	GameRegistry.addRecipe(new ItemStack(foodList.foodPelmen, 10), " W ", "WMW", " W ", 'W', Items.WHEAT, 'M', Items.PORKCHOP);
    	GameRegistry.addRecipe(new ItemStack(foodList.foodPelmen, 10), " W ", "WMW", " W ", 'W', Items.WHEAT, 'M', Items.BEEF);
    	GameRegistry.addRecipe(new ItemStack(foodList.foodPelmen, 8), " W ", "WMW", " W ", 'W', Items.WHEAT, 'M', Items.MUTTON);    	
		// PIROZHOK S KARTOSHKOI
    	GameRegistry.addRecipe(new ItemStack(foodList.foodPotatoPie, 8),
    	" WP",
    	"WPW",
    	"PW ",
    	'W', Items.WHEAT, 'P', Items.BAKED_POTATO
    	);
    	//PIROZHKI S MYASOM
    	GameRegistry.addRecipe(new ItemStack(foodList.foodMeatPie, 9), " WM", "WMW", "MW ", 'W', Items.WHEAT, 'M', Items.PORKCHOP);
    	GameRegistry.addRecipe(new ItemStack(foodList.foodMeatPie, 9), " WM", "WMW", "MW ", 'W', Items.WHEAT, 'M', Items.BEEF);
    	GameRegistry.addRecipe(new ItemStack(foodList.foodMeatPie, 7), " WM", "WMW", "MW ", 'W', Items.WHEAT, 'M', Items.MUTTON);
    	GameRegistry.addRecipe(new ItemStack(foodList.foodMeatPie, 7), " WM", "WMW", "MW ", 'W', Items.WHEAT, 'M', Items.CHICKEN);
    	GameRegistry.addRecipe(new ItemStack(foodList.foodMeatPie, 6), " WM", "WMW", "MW ", 'W', Items.WHEAT, 'M', Items.RABBIT);
    	//SELEDKA POD SHUBOI
    	GameRegistry.addRecipe(new ItemStack(foodList.foodCoatedHerring, 6),
    	"BBB",
    	"CPC",
    	"FFF",
    	'B', Items.BEETROOT, 'P', Items.BAKED_POTATO, 'C', Items.CARROT, 'F', Items.FISH
    	);
	}
	
	private static void munifiedRecipes() {
		//ItemRegistryFluids fluidItems = PluginFluids.items;				
		//ItemStack canCreosote = fluidItems.getContainer(EnumContainerType.CAN, FluidRegistry.getFluid("creosote"));
		GameRegistry.addRecipe(new ItemStack(RebornStorage.init.ModItems.REBORN_STORAGE_PART.getByNameOrId("rebornstorage:multicrafter")),
		    	"QSQ",
		    	"TPT",
		    	"QLQ",
		    	'Q', RSItems.QUARTZ_ENRICHED_IRON,
		    	'T', new ItemStack(RailcraftItems.PLATE.item(),1,2),
		    	'L', new ItemStack(RailcraftItems.PLATE.item(),1,4),
		    	'S', new ItemStack(RailcraftItems.PLATE.item(),1,5),
		    	'P', new ItemStack(RSItems.PROCESSOR, 1, ItemProcessor.TYPE_IMPROVED)
		    	);		
		//RailcraftItems.PLATE - 2:Tin; 4:Lead; 5:Silver
		
    	GameRegistry.addRecipe(new ItemStack(RailcraftItems.PLATE.item(),4,2),
    	"T T",
    	"   ",
    	"T T",
    	'T', new ItemStack(RailcraftItems.INGOT.item(),1,2)
    	);
		
    	
    	GameRegistry.addRecipe(new ItemStack(IEContent.blockTreatedWood,8),
    	"PPP",
    	"PCP",
    	"PPP",
    	'P', new ItemStack(Blocks.PLANKS,1,OreDictionary.WILDCARD_VALUE), 'C', PluginFluids.items.getContainer(EnumContainerType.CAN, FluidRegistry.getFluid("creosote"))
    	);
    	
    	
		GameRegistry.addRecipe(RailcraftItems.TIE.getStack(1, EnumTie.WOOD),
		    	"   ",
		    	" O ",
		    	"SSS",
		    	'S', new ItemStack(Blocks.WOODEN_SLAB, 1, OreDictionary.WILDCARD_VALUE), 'O', PluginFluids.items.getContainer(EnumContainerType.CAN, FluidRegistry.getFluid("creosote"))
		);	

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.OBSIDIAN, 1),PluginFluids.items.getContainer(EnumContainerType.CAN, FluidRegistry.getFluid("water")),
				PluginFluids.items.getContainer(EnumContainerType.CAN, FluidRegistry.getFluid("lava")));
		
		//Broken agricraft nuggets convert
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("railcraft", "nugget"),1,0), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,3));	
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("railcraft", "nugget"),1,2), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,4));	
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("railcraft", "nugget"),1,3), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,5));	
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("railcraft", "nugget"),1,4), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,6));	
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("railcraft", "nugget"),1,5), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,7));	
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("immersiveengineering", "metal"),1,21), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,8));	
		GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("immersiveengineering", "metal"),1,24), new ItemStack(GameRegistry.findItem("agricraft", "agri_nugget"),1,9));	
				
		GameRegistry.addRecipe(new ItemStack(IEContent.blockStoneDecoration,2,BlockTypes_StoneDecoration.BLASTBRICK.getMeta()),
    	"SBS",
    	"BPB",
    	"SBS",
    	'S', TinkerCommons.searedBrick, 'B', Items.BRICK, 'P', Items.BLAZE_POWDER
    	);
    	
		
    	GameRegistry.addRecipe(new ItemStack(Items.GHAST_TEAR, 3),
    	" D ",
    	"SPS",
    	"SGS",
    	'G', Items.GLOWSTONE_DUST, 'S', Items.SNOWBALL, 'P', Items.BLAZE_POWDER, 'D', new ItemStack(IEContent.itemMetal,1,12)
    	);
	}
}
