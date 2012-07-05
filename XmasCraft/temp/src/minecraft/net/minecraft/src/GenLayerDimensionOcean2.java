// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, WorldProviderBase, BiomeGenBase

public class GenLayerDimensionOcean2 extends GenLayer
{

    private WorldProviderBase worldProvider;

    public GenLayerDimensionOcean2(long l, GenLayer genlayer, WorldProviderBase worldproviderbase)
    {
        super(l);
        field_35504_a = genlayer;
        worldProvider = worldproviderbase;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = field_35504_a.func_35500_a(i, j, k, l);
        int ai1[] = IntCache.func_35267_a(k * l);
        for(int i1 = 0; i1 < l; i1++)
        {
            for(int j1 = 0; j1 < k; j1++)
            {
                func_35499_a(j1 + i, i1 + j);
                BiomeGenBase biomegenbase = worldProvider.setOceanBiomes(null, this);
                if(biomegenbase != null && ai[j1 + i1 * k] <= 0)
                {
                    ai1[j1 + i1 * k] = biomegenbase.field_35494_y;
                } else
                {
                    ai1[j1 + i1 * k] = func_35498_a(2) + 2;
                }
            }

        }

        return ai1;
    }
}
