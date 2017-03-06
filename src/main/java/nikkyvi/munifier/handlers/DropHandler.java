package nikkyvi.munifier.handlers;

import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.item.ItemStack;

public class DropHandler {

	public static int getDrop(Entry<Integer, Integer> dropTable, int fortune) {
        int drop = 0;
        Random rnd = new Random();   
        int chance = dropTable.getKey();
        int rolls = dropTable.getValue();
        //LogHandler.getLogger().info("Flvl: " + fortune + "; before (c/r): " + chance + "/" + rolls);
        chance += chance * fortune * 0.34; 
        
        for (int i = 0; i < (rolls + fortune); i++)
        	if (chance > rnd.nextInt(100)) { drop++;}
        
        //LogHandler.getLogger().info("Flvl: " + fortune + "; after (c/r): " + chance + "/" + (rolls + fortune));
		return drop;			
	}
	
	
	public static int getDrop(int chance, int rolls, int fortune) {
        int drop = 0;
        Random rnd = new Random();      
        //LogHandler.getLogger().info("Flvl: " + fortune + "; before (c/r): " + chance + "/" + rolls);
        chance += chance * fortune * 0.34; 
        
        for (int i = 0; i < (rolls + fortune); i++)
        	if (chance > rnd.nextInt(100)) { drop++;}
        
        //LogHandler.getLogger().info("Flvl: " + fortune + "; after (c/r): " + chance + "/" + (rolls + fortune));
		return drop;			
	}
	
	static int getDrop(int chance, int rolls) {
        int drop = 0;
        Random rnd = new Random();        
        
        for (int i = 0; i < rolls; i++)
        	if (chance > rnd.nextInt(100)) { drop++;}
		return drop;		
	}
	
	public static boolean NoDrop(List<ItemStack> loot) {
        int q = 0;
        for (ItemStack item : loot){ q += item.stackSize; }
        
        if(q == 0) { return true;}
        return false;
	}
}

/*
        int EnderPearlChance = 10;
        int EmeraldChance = 10;   
        int DiamondChance = 10;  
        
        int EnderPearlq = 0; int EnderPearlRolls = 3 + fortune;
        int Emeraldq = 0; int EmeraldRolls = 3 + fortune;     
        int Diamondq = 0; int DiamondRolls = 3 + fortune;     
        Random rnd = new Random();        
        
        for (int i = 0; i < EnderPearlRolls; i++)
        	if (EnderPearlChance > rnd.nextInt(100)) { EnderPearlq++;}
        
        for (int i = 0; i < EmeraldRolls; i++)
        	if (EmeraldChance > rnd.nextInt(100)) { Emeraldq++;}
        
        for (int i = 0; i < DiamondRolls; i++)
        	if (DiamondChance > rnd.nextInt(100)) { Diamondq++;}
        	
        	        int BPchance = 12; // 11 * fortune
        int GDchance = 12;        
        int BPq = 0; int BProlls = 3 + fortune;
        int GDq = 0; int GDrolls = 4 + fortune;        
        Random rnd = new Random();        
        
        for (int i = 0; i < BProlls; i++)
        	if (BPchance > rnd.nextInt(100)) { BPq++;}
        
        for (int i = 0; i < GDrolls; i++)
        	if (GDchance > rnd.nextInt(100)) { GDq++;}
        
        if(BPq + GDq == 0) {
        	ret.add(new ItemStack(Items.GUNPOWDER, 1));
        	} else {
        		ret.add(new ItemStack(Items.BLAZE_POWDER, BPq));
        		ret.add(new ItemStack(Items.GLOWSTONE_DUST, GDq));
        	}    
        	
 */
