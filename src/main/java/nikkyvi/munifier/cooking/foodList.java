package nikkyvi.munifier.cooking;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import nikkyvi.munifier.handlers.RegHandler;

public class foodList {
	public static Item foodPelmen;
	public static Item foodVarenik;
	public static Item foodMeatPie;
	public static Item foodPotatoPie;
	public static Item foodCoatedHerring;
	
	public static void preInit() {
		RegHandler.autoReg(foodPelmen =
				new ModFood(2, 3.0f, 10, true, new PotionEffect(Potion.getPotionById(5), 2400, 0)), "foodPelmen");
		RegHandler.autoReg(foodVarenik = 
				new ModFood(2, 2.5f, 10, false, new PotionEffect(Potion.getPotionById(5), 2400, 0)), "foodVarenik");
		RegHandler.autoReg(foodMeatPie = 
				new ModFood(5, 7.0f, 26, true, new PotionEffect(Potion.getPotionById(5), 2400, 1)), "foodMeatPie");
		RegHandler.autoReg(foodPotatoPie = 
				new ModFood(4, 5.0f, 22, false, new PotionEffect(Potion.getPotionById(5), 2400, 1)), "foodPotatoPie");
		RegHandler.autoReg(foodCoatedHerring = 
				new ModFood(8, 10.0f, 38, false), "foodCoatedHerring");		
	}	
	
	public static void registerRenders() {
		RegHandler.regRender(foodPelmen);
		RegHandler.regRender(foodVarenik);
		RegHandler.regRender(foodMeatPie);
		RegHandler.regRender(foodPotatoPie);
		RegHandler.regRender(foodCoatedHerring);
	}
}
