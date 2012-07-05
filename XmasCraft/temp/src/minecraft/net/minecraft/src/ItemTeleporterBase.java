// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Item, ISpecialTeleportation, GuiIngame, World, 
//            ModLoader, EntityPlayerSP, DimensionAPI, EntityPlayer, 
//            Block, BlockPortal, ItemStack, WorldProviderBase, 
//            Teleporter, Achievement

public abstract class ItemTeleporterBase extends Item
    implements ISpecialTeleportation
{

    public ItemTeleporterBase(int i)
    {
        super(i);
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        GuiIngame.currentPortal = null;
        if(!world.field_1026_y)
        {
            DimensionAPI.setInPortal(getDimension(), ModLoader.getMinecraftInstance(), (EntityPlayerSP)entityplayer, this, null);
        }
        if(displayPortalOverlay())
        {
            GuiIngame.currentPortal = this;
            entityplayer.func_4039_q();
            if(entityplayer.field_28026_A >= 0.9F)
            {
                entityplayer.field_28026_A = 0.0F;
            }
        }
        return itemstack;
    }

    public abstract WorldProviderBase getDimension();

    public abstract Teleporter getTeleporter();

    public abstract String getEnteringMessage();

    public abstract String getLeavingMessage();

    public Teleporter getTeleporter(int i, int j)
    {
        return getTeleporter();
    }

    public boolean isPortalImmediate()
    {
        return true;
    }

    public boolean displayPortalOverlay()
    {
        return false;
    }

    public int getOverlayTexture()
    {
        return Block.field_4047_bf.field_378_bb;
    }

    public String getOverlayTextureOverride()
    {
        return "/terrain.png";
    }

    public List canTeleportFromDimension()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(0));
        return arraylist;
    }

    public int returnsPlayerToDimension()
    {
        return 0;
    }

    public double getDistanceRatio()
    {
        return 1.0D;
    }

    public int getPortalDelay()
    {
        return 0;
    }

    public Achievement triggerAchievement()
    {
        return null;
    }

    public void beforeTeleportToDimension(Minecraft minecraft, EntityPlayerSP entityplayersp)
    {
    }

    public void afterTeleportToDimension(Minecraft minecraft, EntityPlayerSP entityplayersp)
    {
    }

    public void beforeTeleportFromDimension(Minecraft minecraft, EntityPlayerSP entityplayersp)
    {
    }

    public void afterTeleportFromDimension(Minecraft minecraft, EntityPlayerSP entityplayersp)
    {
    }
}
