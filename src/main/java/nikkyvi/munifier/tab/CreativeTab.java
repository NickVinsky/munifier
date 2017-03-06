package nikkyvi.munifier.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(int index, String label) {
		super(index, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.RABBIT_FOOT;
	}
	
	

}
