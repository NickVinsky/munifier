package nikkyvi.munifier.handlers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nikkyvi.munifier.Munifier;

public class RegHandler {
	
	public static void autoReg(Item item, String name) {
		item.setUnlocalizedName(name);
		item.setCreativeTab(Munifier.TabMunifier);
		GameRegistry.register(item, new ResourceLocation(Munifier.MODID, name));		
		//LogHandler.getLogger().info("Item " + name + " has been registred in Game Registry.");
	}
	
	public static void autoReg(Block block, String name) {		
		GameRegistry.register(block, new ResourceLocation(Munifier.MODID, name));
		GameRegistry.register(new ItemBlock(block), new ResourceLocation(Munifier.MODID, name));
		//LogHandler.getLogger().info("Block " + name + " has been registred in Game Registry.");
	}
	
	public static void regRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Munifier.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void regRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Munifier.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
