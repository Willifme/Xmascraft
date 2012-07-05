package net.minecraft.src;
import java.util.Random;
public class BlockXmascraftSnow extends Block
{
    public BlockXmascraftSnow(int i, int j)
    {
        super(i, j, Material.ground);           
    }
    public int idDropped(int i, Random random)
    {
       return mod_Xmascraft.XmascraftSnow.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }
}