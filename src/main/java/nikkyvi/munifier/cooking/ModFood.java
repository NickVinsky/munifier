package nikkyvi.munifier.cooking;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ModFood extends ItemFood{
	
	private PotionEffect[] effects;

	private int itemUseDuration;

	public ModFood(int amount, int useDuration, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, isWolfFood);
		this.effects = potionEffects;
		this.itemUseDuration = useDuration;
	}

	ModFood(int amount, float saturation, int useDuration, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, saturation, isWolfFood);
		this.effects = potionEffects;
		this.itemUseDuration = useDuration;
	}
	
	@Override   
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return itemUseDuration;
    }
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		for (PotionEffect effect : effects) {
			player.addPotionEffect(effect);
		}
	}	
}
