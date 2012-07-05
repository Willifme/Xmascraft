// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase, WorldProviderBase

public class GenLayerDimensionOcean1 extends GenLayer
{

    private WorldProviderBase worldProvider;

    public GenLayerDimensionOcean1(long l, GenLayer genlayer, WorldProviderBase worldproviderbase)
    {
        super(l);
        field_35504_a = genlayer;
        worldProvider = worldproviderbase;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int i1 = i - 1;
        int j1 = j - 1;
        int k1 = k + 2;
        int l1 = l + 2;
        int ai[] = field_35504_a.func_35500_a(i1, j1, k1, l1);
        int ai1[] = IntCache.func_35267_a(k * l);
        for(int i2 = 0; i2 < l; i2++)
        {
            for(int j2 = 0; j2 < k; j2++)
            {
                int k2 = ai[j2 + 0 + (i2 + 0) * k1];
                int l2 = ai[j2 + 2 + (i2 + 0) * k1];
                int i3 = ai[j2 + 0 + (i2 + 2) * k1];
                int j3 = ai[j2 + 2 + (i2 + 2) * k1];
                int k3 = ai[j2 + 1 + (i2 + 1) * k1];
                func_35499_a(j2 + i, i2 + j);
                if(k3 == 0 && (k2 != 0 || l2 != 0 || i3 != 0 || j3 != 0))
                {
                    int l3 = 1;
                    int i4 = 1;
                    if(k2 != 0 && func_35498_a(l3++) == 0)
                    {
                        i4 = k2;
                    }
                    if(l2 != 0 && func_35498_a(l3++) == 0)
                    {
                        i4 = l2;
                    }
                    if(i3 != 0 && func_35498_a(l3++) == 0)
                    {
                        i4 = i3;
                    }
                    if(j3 != 0 && func_35498_a(l3++) == 0)
                    {
                        i4 = j3;
                    }
                    if(func_35498_a(3) == 0)
                    {
                        ai1[j2 + i2 * k] = i4;
                        continue;
                    }
                    BiomeGenBase biomegenbase1 = null;
                    if(i4 >= 0)
                    {
                        biomegenbase1 = worldProvider.setOceanBiomes(BiomeGenBase.field_35486_a[i4], this);
                    } else
                    {
                        biomegenbase1 = worldProvider.setOceanBiomes(null, this);
                    }
                    if(biomegenbase1 != null)
                    {
                        ai1[j2 + i2 * k] = biomegenbase1.field_35494_y;
                    }
                    continue;
                }
                if(k3 > 0 && (k2 == 0 || l2 == 0 || i3 == 0 || j3 == 0))
                {
                    if(func_35498_a(5) == 0)
                    {
                        BiomeGenBase biomegenbase = worldProvider.setOceanBiomes(BiomeGenBase.field_35486_a[k3], this);
                        if(biomegenbase != null)
                        {
                            ai1[j2 + i2 * k] = biomegenbase.field_35494_y;
                        }
                    } else
                    {
                        ai1[j2 + i2 * k] = k3;
                    }
                } else
                {
                    ai1[j2 + i2 * k] = k3;
                }
            }

        }

        return ai1;
    }
}
