// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase, WorldProviderBase

public class GenLayerDimensionMinorBiome extends GenLayer
{

    private WorldProviderBase worldProvider;

    public GenLayerDimensionMinorBiome(long l, GenLayer genlayer, WorldProviderBase worldproviderbase)
    {
        super(l);
        field_35504_a = genlayer;
        worldProvider = worldproviderbase;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = field_35504_a.func_35500_a(i - 1, j - 1, k + 2, l + 2);
        int ai1[] = IntCache.func_35267_a(k * l);
        for(int i1 = 0; i1 < l; i1++)
        {
            for(int j1 = 0; j1 < k; j1++)
            {
                func_35499_a(j1 + i, i1 + j);
                int k1 = ai[j1 + 1 + (i1 + 1) * (k + 2)];
                if(func_35498_a(3) == 0)
                {
                    int l1 = k1;
                    BiomeGenBase biomegenbase = worldProvider.setMinorBiomes(BiomeGenBase.field_35486_a[k1], this);
                    if(biomegenbase != null)
                    {
                        l1 = biomegenbase.field_35494_y;
                    }
                    if(l1 != k1)
                    {
                        int i2 = ai[j1 + 1 + ((i1 + 1) - 1) * (k + 2)];
                        int j2 = ai[j1 + 1 + 1 + (i1 + 1) * (k + 2)];
                        int k2 = ai[((j1 + 1) - 1) + (i1 + 1) * (k + 2)];
                        int l2 = ai[j1 + 1 + (i1 + 1 + 1) * (k + 2)];
                        if(i2 == k1 && j2 == k1 && k2 == k1 && l2 == k1)
                        {
                            ai1[j1 + i1 * k] = l1;
                        } else
                        {
                            ai1[j1 + i1 * k] = k1;
                        }
                    } else
                    {
                        ai1[j1 + i1 * k] = k1;
                    }
                } else
                {
                    ai1[j1 + i1 * k] = k1;
                }
            }

        }

        return ai1;
    }
}
