package net.minecraft.src;
import java.util.Random;
public class BlockXmascraftStone extends Block
{
    public BlockXmascraftStone(int i, int j)
    {
        super(i, j, Material.rock);           
    }
    public int idDropped(int i, Random random)
    {
       return mod_Xmascraft.XmascraftStone.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }
}