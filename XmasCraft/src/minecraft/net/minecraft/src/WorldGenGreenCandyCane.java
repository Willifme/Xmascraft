package net.minecraft.src;

import java.util.*;
import java.io.*;

public class WorldGenGreenCandyCane extends WorldGenerator {

	public WorldGenGreenCandyCane() {

	}



	 public boolean generate(World world, Random rand, int x, int y, int z)
	   {
	      if(world.getBlockId(x, y, z)!= mod_Xmascraft.XmascraftSnow.blockID || world.getBlockId(x, y + 1, z)!= 0)
	      {
	         return false;
	      }
	                int block = mod_Xmascraft.XmascraftCandyCaneGreen.blockID;

	            	world.setBlockWithNotify(x, y, z, block);
	            	world.setBlockWithNotify(x, y + 1, z, block);
	            	world.setBlockWithNotify(x, y + 2, z, block);
	            	world.setBlockWithNotify(x, y + 3, z, block);
	            		
	            		//Creates the outer part then the part that goes down
	            	world.setBlockWithNotify(x + 1, y + 3, z, block);
	            	world.setBlockWithNotify(x + 2, y + 3, z, block);
	            	world.setBlockWithNotify(x + 2, y + 2, z , block);
	               
	                return true;
	   }  
	
	
}