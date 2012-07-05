package net.minecraft.src;

import java.util.Random;

public class BlockXmascraftCandyCaneGreen extends Block
{
    public BlockXmascraftCandyCaneGreen(int i, int j)
    {
        super(i, j, Material.grass);           
    }
    public int idDropped(int i, Random random)
    {
       return mod_Xmascraft.XmascraftCandyCaneGreenFood.shiftedIndex;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
            return getBlockTextureFromSide(i);
    }
    
 public int getBlockTextureFromSide(int i) {
        if(i == 1) 
        {
            return mod_Xmascraft.XmascraftCandyCaneGreenTopandBottom;
        }
        if(i == 0)
        {
            return mod_Xmascraft.XmascraftCandyCaneGreenTopandBottom;
        }else
        {
            return blockIndexInTexture;
        }
    }
}