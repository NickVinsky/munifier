package nikkyvi.munifier.block;


import java.util.List;
import java.util.Random;

import blusunrize.immersiveengineering.common.IEContent;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import net.minecraft.block.state.IBlockState;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nikkyvi.munifier.Config;
import nikkyvi.munifier.Munifier;
import nikkyvi.munifier.handlers.DropHandler;
import nikkyvi.munifier.tables.DropEnum;
import slimeknights.tconstruct.shared.TinkerCommons;

public class BlockGemstoneOre extends Block {
	
	BlockGemstoneOre(Material materialIn, String name) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Munifier.TabMunifier);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.GLASS);
		this.setHarvestLevel("pickaxe", 2);
	}
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();        
        
        ret.add(new ItemStack(Items.ENDER_PEARL, DropHandler.getDrop(Config.dropTable.get(DropEnum.ENDER_PEARL).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.EMERALD, DropHandler.getDrop(Config.dropTable.get(DropEnum.EMERALD).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.DIAMOND, DropHandler.getDrop(Config.dropTable.get(DropEnum.DIAMOND).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.DYE, DropHandler.getDrop(Config.dropTable.get(DropEnum.LAPIS).firstEntry(), fortune), 4));
        ret.add(new ItemStack(Items.GHAST_TEAR, DropHandler.getDrop(Config.dropTable.get(DropEnum.GHAST_TEAR).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.QUARTZ, DropHandler.getDrop(Config.dropTable.get(DropEnum.QUARTZ).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.SLIME_BALL, DropHandler.getDrop(Config.dropTable.get(DropEnum.SLIME_BALL).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.PRISMARINE_CRYSTALS, DropHandler.getDrop(Config.dropTable.get(DropEnum.PRISMARINE_CRYSTALS).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.PRISMARINE_SHARD, DropHandler.getDrop(Config.dropTable.get(DropEnum.PRISMARINE_SHARD).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.NETHER_STAR, DropHandler.getDrop(Config.dropTable.get(DropEnum.NETHER_STAR).firstEntry(), fortune)));
        //NUGGETS
        ret.add(new ItemStack(Items.GOLD_NUGGET, DropHandler.getDrop(Config.dropTable.get(DropEnum.GOLD_NUGGET).firstEntry(), fortune)));
        ret.add(new ItemStack(IEContent.itemMetal, DropHandler.getDrop(Config.dropTable.get(DropEnum.SILVER_NUGGET).firstEntry(), fortune), 23));  //silver nugget
        ret.add(new ItemStack(IEContent.itemMetal, DropHandler.getDrop(Config.dropTable.get(DropEnum.ALUMINIUM_GRIT).firstEntry(), fortune), 10));  //alumin grit
        ret.add(new ItemStack(TinkerCommons.nuggetAlubrass.getItem(), DropHandler.getDrop(Config.dropTable.get(DropEnum.COBALT_NUGGET).firstEntry(), fortune), 0));  // Cobalt
        ret.add(new ItemStack(TinkerCommons.nuggetAlubrass.getItem(), DropHandler.getDrop(Config.dropTable.get(DropEnum.ARDITE_NUGGET).firstEntry(), fortune), 1)); // Ardite
        ret.add(new ItemStack(TinkerCommons.nuggetAlubrass.getItem(), DropHandler.getDrop(Config.dropTable.get(DropEnum.ALUBRASS_NUGGET).firstEntry(), fortune), 5));  //Aluminium brass
             
        if(DropHandler.NoDrop(ret)) {ret.add(new ItemStack(Items.COAL, 1));}
        return ret;
    }   
    
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            return MathHelper.getRandomIntegerInRange(rand, 3, 4);
        }
        return 0;
    }
}
