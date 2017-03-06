package nikkyvi.munifier.handlers;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	//ADD DROP TO MOBS
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(LivingDropsEvent event)
	{
	    if (event.getEntity() instanceof EntityPig || event.getEntity() instanceof EntityCow)
	    {
	        //System.out.println("EntitySheep drops event");
	        //event.getDrops().clear();
	        ItemStack itemStackToDrop = new ItemStack(Items.BONE, DropHandler.getDrop(40, 2));
	        event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
	              event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	    }
	    if (event.getEntity() instanceof EntityChicken || event.getEntity() instanceof EntitySheep || event.getEntity() instanceof EntityRabbit)
	    {
	        ItemStack itemStackToDrop = new ItemStack(Items.BONE, DropHandler.getDrop(20, 2));
	        event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, 
	              event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	    }
	} 
	
	/*@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(ItemPickupEvent event)
	{
		LogHandler.getLogger().info(event.pickedUp.);
	} 
	*/
}
