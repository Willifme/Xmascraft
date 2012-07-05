// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, WorldProviderBase, BiomeGenBase

public class GenLayerDimensionWater extends GenLayer
{

    private GenLayer field_35512_b;
    private GenLayer field_35513_c;
    private WorldProviderBase worldProvider;

    public GenLayerDimensionWater(long l, GenLayer genlayer, GenLayer genlayer1, WorldProviderBase worldproviderbase)
    {
        super(l);
        field_35512_b = genlayer;
        field_35513_c = genlayer1;
        worldProvider = worldproviderbase;
    }

    public void func_35496_b(long l)
    {
        field_35512_b.func_35496_b(l);
        field_35513_c.func_35496_b(l);
        super.func_35496_b(l);
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = field_35512_b.func_35500_a(i, j, k, l);
        int ai1[] = field_35513_c.func_35500_a(i, j, k, l);
        int ai2[] = IntCache.func_35267_a(k * l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            BiomeGenBase biomegenbase = worldProvider.setOceanBiomes(null, this);
            if(biomegenbase != null && ai[i1] == biomegenbase.field_35494_y)
            {
                ai2[i1] = ai[i1];
                continue;
            }
            if(ai1[i1] >= 0)
            {
                BiomeGenBase biomegenbase1 = worldProvider.setRiverBiomes(BiomeGenBase.field_35486_a[ai[i1]], this);
                if(biomegenbase1 != null)
                {
                    ai2[i1] = biomegenbase1.field_35494_y;
                } else
                {
                    ai2[i1] = ai1[i1];
                }
            } else
            {
                ai2[i1] = ai[i1];
            }
        }

        return ai2;
    }
}
