package nikkyvi.munifier.worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import nikkyvi.munifier.Config;
import nikkyvi.munifier.block.BlockBlazeriteOre;
import nikkyvi.munifier.block.ModBlocks;
import nikkyvi.munifier.handlers.EnumHandler.OreType;
import slimeknights.tconstruct.shared.block.BlockOre.OreTypes;

public class OreGen implements IWorldGenerator{

	private WorldGenerator oreBlazerite_overworld;
	private WorldGenerator oreGemstone_overworld;
	
	public OreGen() {
		oreBlazerite_overworld = new WorldGenMinable(ModBlocks.BlazeriteOre.getDefaultState(), Config.blazeriteOreSpawnCount, new OWGenPredicate());
		oreGemstone_overworld = new WorldGenMinable(ModBlocks.GemstoneOre.getDefaultState(), Config.GemstoneOreSpawnCount, new OWGenPredicate());
		//IEWorldGen.addOreGen(ModBlocks.BlazeriteOre.getUnlocalizedName(), ModBlocks.BlazeriteOre.getDefaultState(), Config.blazeriteOreSpawnCount, Config.blazeriteOreSpawnMinHeight, Config.blazeriteOreSpawnMaxHeight, Config.blazeriteOreSpawnChance, 0);
	}
	
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));	        
		        
		}
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		//if(world.provider.getDimension() == 0) this.runGenerator(oreBlazerite_overworld, world, random, chunkX, chunkZ, Config.blazeriteOreSpawnChance, Config.blazeriteOreSpawnMinHeight, Config.blazeriteOreSpawnMaxHeight);		
	
	    switch (world.provider.getDimensionType()) {
	    case OVERWORLD: //Overworld
	    	this.runGenerator(oreBlazerite_overworld, world, random, chunkX, chunkZ, Config.blazeriteOreSpawnChance, Config.blazeriteOreSpawnMinHeight, Config.blazeriteOreSpawnMaxHeight);
	    	this.runGenerator(oreGemstone_overworld, world, random, chunkX, chunkZ, Config.GemstoneOreSpawnChance, Config.GemstoneOreSpawnMinHeight, Config.GemstoneOreSpawnMaxHeight);
	        break;
	    case NETHER: //Nether

	        break;
	    case THE_END: //End

	        break;
	    }
	}

}
