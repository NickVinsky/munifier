package nikkyvi.munifier.block;

import java.util.List;
import java.util.Random;

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

public class BlockBlazeriteOre extends Block {
	
	//public static final PropertyEnum TYPE = PropertyEnum.create("type", OreType.class);

	BlockBlazeriteOre(Material materialIn, String name) {
		super(materialIn);
		this.setUnlocalizedName(name);
		//this.setRegistryName(new ResourceLocation(Munifier.MODID, name));
		this.setCreativeTab(Munifier.TabMunifier);
		this.setHardness(5.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 2);
		//this.setLightLevel(2.0f);
		//this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD)); //Default state
	}
	
   
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
         
        ret.add(new ItemStack(Items.BLAZE_POWDER, DropHandler.getDrop(Config.dropTable.get(DropEnum.BLAZE_POWDER).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.BLAZE_ROD, DropHandler.getDrop(Config.dropTable.get(DropEnum.BLAZE_POWDER).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.GLOWSTONE_DUST, DropHandler.getDrop(Config.dropTable.get(DropEnum.GLOWSTONE_DUST).firstEntry(), fortune)));
        ret.add(new ItemStack(Items.GUNPOWDER, DropHandler.getDrop(Config.dropTable.get(DropEnum.GUNPOWDER).firstEntry(), fortune)));
        
        if(DropHandler.NoDrop(ret)) {ret.add(new ItemStack(Items.GUNPOWDER, 1));}
        return ret;
    }   
    
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            return MathHelper.getRandomIntegerInRange(rand, 2, 5);
        }
        return 0;
    }
    
    
	/*
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		OreType type = (OreType) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
	}*/
	
    /*@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.BLAZE_POWDER;
    }
    @Override
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }*/
}
