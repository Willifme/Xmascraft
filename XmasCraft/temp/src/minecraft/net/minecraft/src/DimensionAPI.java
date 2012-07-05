// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            WorldProviderBase, EntityPlayerSP, BlockPortalBase, ISpecialTeleportation, 
//            World, Teleporter, RenderGlobal, WorldProvider, 
//            ModLoader, TextureCustomPortalFX, Block, RenderEngine, 
//            EntityCustomPortalFX, EffectRenderer, Entity, IItemUse, 
//            IItemRightClick, IBlockAdded, IBlockRemoval, IRenderOverlay

public class DimensionAPI
{

    public static int timeInPortal = 0;
    public static HashMap dimensionMap = new HashMap();
    public static HashMap itemUseMap = new HashMap();
    public static HashMap itemRightClickMap = new HashMap();
    public static HashMap blockAddedMap = new HashMap();
    public static HashMap blockRemovalMap = new HashMap();
    public static ArrayList overlayList = new ArrayList();

    public DimensionAPI()
    {
    }

    public static void registerDimension(WorldProviderBase worldproviderbase)
    {
        int i = worldproviderbase.getDimensionID();
        dimensionMap.put(worldproviderbase, Integer.valueOf(i));
    }

    public static void setInPortal(WorldProviderBase worldproviderbase, Minecraft minecraft, Entity entity, ISpecialTeleportation ispecialteleportation, BlockPortalBase blockportalbase)
    {
        EntityPlayerSP entityplayersp = (EntityPlayerSP)entity;
        int i = entityplayersp.field_4129_m;
        if(blockportalbase != null && !isInPortal(entityplayersp, blockportalbase.field_376_bc))
        {
            timeInPortal = 0;
            return;
        }
        if(ispecialteleportation.canTeleportFromDimension().contains(Integer.valueOf(i)) || i == worldproviderbase.getDimensionID())
        {
            if(ispecialteleportation.isPortalImmediate())
            {
                usePortal(worldproviderbase, minecraft, entityplayersp, ispecialteleportation);
            } else
            {
                timeInPortal++;
                if(timeInPortal == ispecialteleportation.getPortalDelay() && entityplayersp.field_28024_y <= 0)
                {
                    timeInPortal = 0;
                    entityplayersp.field_28024_y = 10;
                    usePortal(worldproviderbase, minecraft, entityplayersp, ispecialteleportation);
                }
            }
        }
    }

    public static boolean isInPortal(EntityPlayerSP entityplayersp, int i)
    {
        int j = (int)Math.floor(entityplayersp.field_611_ak);
        int k = (int)Math.floor(entityplayersp.field_610_al);
        int l = (int)Math.floor(entityplayersp.field_609_am);
        return entityplayersp.field_615_ag.func_600_a(j, k, l) == i || entityplayersp.field_615_ag.func_600_a(j, k - 1, l) == i;
    }

    public static void usePortal(WorldProviderBase worldproviderbase, Minecraft minecraft, EntityPlayerSP entityplayersp, ISpecialTeleportation ispecialteleportation)
    {
        int i = entityplayersp.field_4129_m;
        if(entityplayersp.field_4129_m != worldproviderbase.getDimensionID())
        {
            teleportToDimension(worldproviderbase, minecraft, entityplayersp, ispecialteleportation);
        } else
        if(entityplayersp.field_4129_m == worldproviderbase.getDimensionID())
        {
            teleportFromDimension(worldproviderbase, minecraft, entityplayersp, ispecialteleportation, false, 0);
        }
    }

    public static void teleportToDimension(WorldProviderBase worldproviderbase, Minecraft minecraft, EntityPlayerSP entityplayersp, ISpecialTeleportation ispecialteleportation)
    {
        ispecialteleportation.beforeTeleportToDimension(minecraft, entityplayersp);
        int i = entityplayersp.field_4129_m;
        minecraft.field_6324_e.func_607_d(entityplayersp);
        entityplayersp.field_646_aA = false;
        double d = 1.0D / ispecialteleportation.getDistanceRatio();
        double d1 = entityplayersp.field_611_ak;
        double d2 = entityplayersp.field_609_am;
        d1 *= d;
        d2 *= d;
        entityplayersp.func_365_c(d1, entityplayersp.field_610_al, d2, entityplayersp.field_605_aq, entityplayersp.field_604_ar);
        if(entityplayersp.func_354_B())
        {
            minecraft.field_6324_e.func_4084_a(entityplayersp, false);
        }
        minecraft.field_6323_f = worldproviderbase.getGlobalRenderer(minecraft, minecraft.field_6315_n);
        World world = null;
        world = new World(minecraft.field_6324_e, worldproviderbase);
        String s = ispecialteleportation.getEnteringMessage();
        minecraft.func_6256_a(world, s, entityplayersp);
        entityplayersp.field_4129_m = worldproviderbase.getDimensionID();
        entityplayersp.field_615_ag = minecraft.field_6324_e;
        if(entityplayersp.func_354_B())
        {
            entityplayersp.func_365_c(entityplayersp.field_611_ak, entityplayersp.field_610_al, entityplayersp.field_609_am, entityplayersp.field_605_aq, entityplayersp.field_604_ar);
            minecraft.field_6324_e.func_4084_a(entityplayersp, false);
            ispecialteleportation.getTeleporter(i, entityplayersp.field_4129_m).func_4107_a(minecraft.field_6324_e, entityplayersp);
        }
        if(ispecialteleportation.triggerAchievement() != null)
        {
            entityplayersp.func_25058_a(ispecialteleportation.triggerAchievement(), 1);
        }
        ispecialteleportation.afterTeleportToDimension(minecraft, entityplayersp);
    }

    public static void teleportFromDimension(WorldProviderBase worldproviderbase, Minecraft minecraft, EntityPlayerSP entityplayersp, ISpecialTeleportation ispecialteleportation, boolean flag, int i)
    {
        int j = entityplayersp.field_4129_m;
        if(!flag)
        {
            ispecialteleportation.beforeTeleportFromDimension(minecraft, entityplayersp);
            i = ispecialteleportation.returnsPlayerToDimension();
        }
        minecraft.field_6324_e.func_607_d(entityplayersp);
        entityplayersp.field_646_aA = false;
        double d = 1.0D;
        if(!flag)
        {
            d = ispecialteleportation.getDistanceRatio();
        }
        double d1 = entityplayersp.field_611_ak;
        double d2 = entityplayersp.field_609_am;
        d1 *= d;
        d2 *= d;
        entityplayersp.func_365_c(d1, entityplayersp.field_610_al, d2, entityplayersp.field_605_aq, entityplayersp.field_604_ar);
        if(entityplayersp.func_354_B())
        {
            minecraft.field_6324_e.func_4084_a(entityplayersp, false);
        }
        minecraft.field_6323_f = new RenderGlobal(minecraft, minecraft.field_6315_n);
        World world = null;
        world = new World(minecraft.field_6324_e, minecraft.field_6324_e.field_4209_q.func_4101_a(i));
        String s = "Respawning";
        if(!flag)
        {
            s = ispecialteleportation.getLeavingMessage();
        } else
        {
            s = worldproviderbase.getRespawnMessage();
        }
        minecraft.func_6256_a(world, s, entityplayersp);
        entityplayersp.field_4129_m = i;
        entityplayersp.field_615_ag = minecraft.field_6324_e;
        if(entityplayersp.func_354_B() && !flag)
        {
            entityplayersp.func_365_c(entityplayersp.field_611_ak, entityplayersp.field_610_al, entityplayersp.field_609_am, entityplayersp.field_605_aq, entityplayersp.field_604_ar);
            minecraft.field_6324_e.func_4084_a(entityplayersp, false);
            ispecialteleportation.getTeleporter(j, entityplayersp.field_4129_m).func_4107_a(minecraft.field_6324_e, entityplayersp);
        }
        if(!flag)
        {
            ispecialteleportation.afterTeleportFromDimension(minecraft, entityplayersp);
        }
    }

    public static Object getKeyFromValue(Map map, Object obj)
    {
        for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            Object obj1 = iterator.next();
            if(map.get(obj1).equals(obj))
            {
                return obj1;
            }
        }

        return null;
    }

    public static WorldProvider getProviderByDimension(int i)
    {
        WorldProvider worldprovider = (WorldProvider)getKeyFromValue(dimensionMap, new Integer(i));
        return worldprovider;
    }

    public static void respawnPlayer(Minecraft minecraft)
    {
        WorldProviderBase worldproviderbase = (WorldProviderBase)minecraft.field_6324_e.field_4209_q;
        int i = worldproviderbase.respawnInDimension();
        worldproviderbase.beforeRespawnTeleportation(minecraft);
        teleportFromDimension(worldproviderbase, minecraft, minecraft.field_6322_g, null, true, i);
        worldproviderbase.afterRespawnTeleportation(minecraft);
        minecraft.func_6239_p(false, i, false);
    }

    public static void registerPortalTexture(Block block, float f, float f1, float f2, float f3)
    {
        ModLoader.getMinecraftInstance().field_6315_n.func_1066_a(new TextureCustomPortalFX(block.field_378_bb, f, f1, f2, f3));
    }

    public static void addItemUseIntercept(int i, IItemUse iitemuse)
    {
        itemUseMap.put(Integer.valueOf(i), iitemuse);
    }

    public static void addItemRightClickIntercept(int i, IItemRightClick iitemrightclick)
    {
        itemRightClickMap.put(Integer.valueOf(i), iitemrightclick);
    }

    public static void addBlockAddedIntercept(int i, IBlockAdded iblockadded)
    {
        blockAddedMap.put(Integer.valueOf(i), iblockadded);
    }

    public static void addBlockRemovalIntercept(int i, IBlockRemoval iblockremoval)
    {
        blockRemovalMap.put(Integer.valueOf(i), iblockremoval);
    }

    public static void spawnPortalParticle(World world, float f, float f1, float f2, double d, double d1, 
            double d2, double d3, double d4, double d5)
    {
        ModLoader.getMinecraftInstance().field_6321_h.func_1192_a(new EntityCustomPortalFX(world, f, f1, f2, d, d1, d2, d5, d4, d5));
    }

    public static void registerOverlay(IRenderOverlay irenderoverlay)
    {
        overlayList.add(irenderoverlay);
    }

}
