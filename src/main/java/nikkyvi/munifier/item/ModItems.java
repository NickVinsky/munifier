package nikkyvi.munifier.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nikkyvi.munifier.Munifier;

public class ModItems {

	public static Item testItem;
	
	public static void preInit(){
		testItem = new Item().setUnlocalizedName("munifier_testItem").setCreativeTab(Munifier.TabMunifier);
		registerItems();
	}
	
	public static void registerItems(){
		GameRegistry.register(testItem, new ResourceLocation(Munifier.MODID, "munifier_testItem"));
	}
	
	public static void registerRenders(){
		registerRender(testItem);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Munifier.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
