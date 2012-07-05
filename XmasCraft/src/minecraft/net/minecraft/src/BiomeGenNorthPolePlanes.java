package net.minecraft.src;

import java.util.Random;

public class BiomeGenNorthPolePlanes extends BiomeGenBase
{
	
	
    protected BiomeGenNorthPolePlanes(int par1)
    {
        super(par1);
        
        spawnableWaterCreatureList.clear();
        topBlock = (byte)Block.dirt.blockID;
        fillerBlock = (byte)Block.dirt.blockID;
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
    	
    	if (par1Random.nextInt(5) == 0)
        {
            return worldGenNorthpoleForest;
        }

        if (par1Random.nextInt(1) == 0)
        {
            return worldGenNorthpoleBigTree;
        }
        else
        {
            return worldGenNorthpoleTrees;
        }
    	
    	
    }
}
