package net.minecraft.src;

import java.util.Random;

public class BiomeGenNorthPoleHills extends BiomeGenBase
{
    protected BiomeGenNorthPoleHills(int par1)
    {
        super(par1);
        
        topBlock = (byte)mod_Xmascraft.XmascraftSnow.blockID;
        fillerBlock = (byte)mod_Xmascraft.XmascraftSnow.blockID;
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
