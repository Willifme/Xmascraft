package net.minecraft.src;
import java.util.Random;

public class BlockXmascraftIce extends Block
{
    public BlockXmascraftIce(int i, int j)
    {
        super(i, j, Material.ground);           
    }
    public int idDropped(int i, Random random)
    {
       return mod_Xmascraft.XmascraftIce.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }
}