// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase, WorldProviderBase

public class GenLayerDimensionBorderBiome extends GenLayer
{

    private WorldProviderBase worldProvider;

    public GenLayerDimensionBorderBiome(long l, GenLayer genlayer, WorldProviderBase worldproviderbase)
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
                int l1 = ai[j1 + 1 + ((i1 + 1) - 1) * (k + 2)];
                int i2 = ai[j1 + 1 + 1 + (i1 + 1) * (k + 2)];
                int j2 = ai[((j1 + 1) - 1) + (i1 + 1) * (k + 2)];
                int k2 = ai[j1 + 1 + (i1 + 1 + 1) * (k + 2)];
                BiomeGenBase biomegenbase = worldProvider.setBorderBiomes(BiomeGenBase.field_35486_a[k1], BiomeGenBase.field_35486_a[l1], this);
                BiomeGenBase biomegenbase1 = worldProvider.setBorderBiomes(BiomeGenBase.field_35486_a[k1], BiomeGenBase.field_35486_a[i2], this);
                BiomeGenBase biomegenbase2 = worldProvider.setBorderBiomes(BiomeGenBase.field_35486_a[k1], BiomeGenBase.field_35486_a[j2], this);
                BiomeGenBase biomegenbase3 = worldProvider.setBorderBiomes(BiomeGenBase.field_35486_a[k1], BiomeGenBase.field_35486_a[k2], this);
                if(biomegenbase != null)
                {
                    ai1[j1 + i1 * k] = biomegenbase.field_35494_y;
                    continue;
                }
                if(biomegenbase1 != null)
                {
                    ai1[j1 + i1 * k] = biomegenbase1.field_35494_y;
                    continue;
                }
                if(biomegenbase2 != null)
                {
                    ai1[j1 + i1 * k] = biomegenbase2.field_35494_y;
                    continue;
                }
                if(biomegenbase3 != null)
                {
                    ai1[j1 + i1 * k] = biomegenbase3.field_35494_y;
                } else
                {
                    ai1[j1 + i1 * k] = k1;
                }
            }

        }

        return ai1;
    }
}
