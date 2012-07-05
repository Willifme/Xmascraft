// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WorldChunkManager, BiomeCache, WorldProviderBase, GenLayerDimension, 
//            World, WorldInfo, IntCache, GenLayer, 
//            BiomeGenBase, ChunkPosition, WorldType

public class WorldChunkManagerCustom extends WorldChunkManager
{

    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private BiomeCache biomeCache;
    private List biomesToSpawnIn;

    protected WorldChunkManagerCustom(WorldProviderBase worldproviderbase)
    {
        biomeCache = new BiomeCache(this);
        biomesToSpawnIn = new ArrayList();
        if(worldproviderbase.getBiomesToSpawnIn() != null)
        {
            biomesToSpawnIn = worldproviderbase.getBiomesToSpawnIn();
        }
    }

    public WorldChunkManagerCustom(long l, WorldType worldtype, WorldProviderBase worldproviderbase)
    {
        this(worldproviderbase);
        GenLayer agenlayer[] = GenLayerDimension.getGenLayers(l, worldproviderbase);
        genBiomes = agenlayer[0];
        biomeIndexLayer = agenlayer[1];
    }

    public WorldChunkManagerCustom(World world, WorldProviderBase worldproviderbase)
    {
        this(world.func_22138_q(), world.func_22144_v().func_46133_t(), worldproviderbase);
    }

    public List func_35559_a()
    {
        return biomesToSpawnIn;
    }

    public BiomeGenBase func_4073_a(int i, int j)
    {
        return biomeCache.func_35725_a(i, j);
    }

    public float[] func_35560_b(float af[], int i, int j, int k, int l)
    {
        IntCache.func_35268_a();
        if(af == null || af.length < k * l)
        {
            af = new float[k * l];
        }
        int ai[] = biomeIndexLayer.func_35500_a(i, j, k, l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            float f = (float)BiomeGenBase.field_35486_a[ai[i1]].func_35476_e() / 65536F;
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            af[i1] = f;
        }

        return af;
    }

    public float func_40540_a(float f, int i)
    {
        return f;
    }

    public float[] func_4071_a(float af[], int i, int j, int k, int l)
    {
        IntCache.func_35268_a();
        if(af == null || af.length < k * l)
        {
            af = new float[k * l];
        }
        int ai[] = biomeIndexLayer.func_35500_a(i, j, k, l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            float f = (float)BiomeGenBase.field_35486_a[ai[i1]].func_35474_f() / 65536F;
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            af[i1] = f;
        }

        return af;
    }

    public BiomeGenBase[] func_35557_b(BiomeGenBase abiomegenbase[], int i, int j, int k, int l)
    {
        IntCache.func_35268_a();
        if(abiomegenbase == null || abiomegenbase.length < k * l)
        {
            abiomegenbase = new BiomeGenBase[k * l];
        }
        int ai[] = genBiomes.func_35500_a(i, j, k, l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            abiomegenbase[i1] = BiomeGenBase.field_35486_a[ai[i1]];
        }

        return abiomegenbase;
    }

    public BiomeGenBase[] func_4070_a(BiomeGenBase abiomegenbase[], int i, int j, int k, int l)
    {
        return func_35555_a(abiomegenbase, i, j, k, l, true);
    }

    public BiomeGenBase[] func_35555_a(BiomeGenBase abiomegenbase[], int i, int j, int k, int l, boolean flag)
    {
        IntCache.func_35268_a();
        if(abiomegenbase == null || abiomegenbase.length < k * l)
        {
            abiomegenbase = new BiomeGenBase[k * l];
        }
        if(flag && k == 16 && l == 16 && (i & 0xf) == 0 && (j & 0xf) == 0)
        {
            BiomeGenBase abiomegenbase1[] = biomeCache.func_35723_d(i, j);
            System.arraycopy(abiomegenbase1, 0, abiomegenbase, 0, k * l);
            return abiomegenbase;
        }
        int ai[] = biomeIndexLayer.func_35500_a(i, j, k, l);
        for(int i1 = 0; i1 < k * l; i1++)
        {
            abiomegenbase[i1] = BiomeGenBase.field_35486_a[ai[i1]];
        }

        return abiomegenbase;
    }

    public boolean func_35562_a(int i, int j, int k, List list)
    {
        int l = i - k >> 2;
        int i1 = j - k >> 2;
        int j1 = i + k >> 2;
        int k1 = j + k >> 2;
        int l1 = (j1 - l) + 1;
        int i2 = (k1 - i1) + 1;
        int ai[] = genBiomes.func_35500_a(l, i1, l1, i2);
        for(int j2 = 0; j2 < l1 * i2; j2++)
        {
            BiomeGenBase biomegenbase = BiomeGenBase.field_35486_a[ai[j2]];
            if(!list.contains(biomegenbase))
            {
                return false;
            }
        }

        return true;
    }

    public ChunkPosition func_35556_a(int i, int j, int k, List list, Random random)
    {
        int l = i - k >> 2;
        int i1 = j - k >> 2;
        int j1 = i + k >> 2;
        int k1 = j + k >> 2;
        int l1 = (j1 - l) + 1;
        int i2 = (k1 - i1) + 1;
        int ai[] = genBiomes.func_35500_a(l, i1, l1, i2);
        ChunkPosition chunkposition = null;
        int j2 = 0;
        for(int k2 = 0; k2 < ai.length; k2++)
        {
            int l2 = l + k2 % l1 << 2;
            int i3 = i1 + k2 / l1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.field_35486_a[ai[k2]];
            if(list.contains(biomegenbase) && (chunkposition == null || random.nextInt(j2 + 1) == 0))
            {
                chunkposition = new ChunkPosition(l2, 0, i3);
                j2++;
            }
        }

        return chunkposition;
    }

    public void func_35561_b()
    {
        biomeCache.func_35724_a();
    }
}
