package net.minecraft.src;

import java.util.Random;

public class BlockXmascraftStoneOre extends Block
{
    public BlockXmascraftStoneOre(int i, int j) {
    	
        super(i, j, Material.rock);  
        
    }
    
    public int idDropped(int i, Random random, int j) {
    	
        return mod_Xmascraft.XmascraftXmasShards.shiftedIndex;
        
    }
    public int quantityDropped(Random random) {
    
            return 5;
    }
}