// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, ScaledResolution, EntityRenderer, EntityPlayerSP, 
//            FontRenderer, InventoryPlayer, GameSettings, ItemStack, 
//            Block, Potion, DimensionAPI, IRenderOverlay, 
//            PlayerController, RenderEngine, FoodStats, World, 
//            WorldInfo, Material, RenderHelper, MathHelper, 
//            Chunk, BiomeGenBase, EnumSkyBlock, EntityClientPlayerMP, 
//            KeyBinding, NetClientHandler, GuiPlayerInfo, ChatLine, 
//            RenderDragon, EntityDragon, Tessellator, BlockPortal, 
//            ISpecialTeleportation, RenderItem, ChatClickData, GuiChat, 
//            StringTranslate

public class GuiIngame extends Gui
{

    private static RenderItem field_930_d = new RenderItem();
    private java.util.List field_929_e;
    private java.util.List field_50016_f;
    private Random field_9423_f;
    private Minecraft field_9422_g;
    private int field_9421_h;
    private String field_9420_i;
    private int field_9419_j;
    private boolean field_22065_l;
    private int field_50017_n;
    private boolean field_50018_o;
    public float field_6446_b;
    float field_931_c;
    public static ISpecialTeleportation currentPortal;

    public GuiIngame(Minecraft p_i149_1_)
    {
        field_929_e = new ArrayList();
        field_50016_f = new ArrayList();
        field_9423_f = new Random();
        field_9421_h = 0;
        field_9420_i = "";
        field_9419_j = 0;
        field_22065_l = false;
        field_50017_n = 0;
        field_50018_o = false;
        field_931_c = 1.0F;
        field_9422_g = p_i149_1_;
    }

    public void func_4066_a(float p_4066_1_, boolean p_4066_2_, int p_4066_3_, int p_4066_4_)
    {
        ScaledResolution scaledresolution = new ScaledResolution(field_9422_g.field_6304_y, field_9422_g.field_6326_c, field_9422_g.field_6325_d);
        int i = scaledresolution.func_903_a();
        int j = scaledresolution.func_902_b();
        FontRenderer fontrenderer = field_9422_g.field_6314_o;
        field_9422_g.field_9243_r.func_905_b();
        GL11.glEnable(3042);
        if(Minecraft.func_22001_u())
        {
            func_4064_a(field_9422_g.field_6322_g.func_382_a(p_4066_1_), i, j);
        } else
        {
            GL11.glBlendFunc(770, 771);
        }
        ItemStack itemstack = field_9422_g.field_6322_g.field_778_b.func_492_d(3);
        if(field_9422_g.field_6304_y.field_1560_x == 0 && itemstack != null && itemstack.field_1617_c == Block.field_4055_bb.field_376_bc)
        {
            func_4063_a(i, j);
        }
        if(!field_9422_g.field_6322_g.func_35160_a(Potion.field_35684_k))
        {
            float f = field_9422_g.field_6322_g.field_28025_B + (field_9422_g.field_6322_g.field_28026_A - field_9422_g.field_6322_g.field_28025_B) * p_4066_1_;
            if(f > 0.0F)
            {
                func_4065_b(f, i, j);
            }
        }
        if(!DimensionAPI.overlayList.isEmpty())
        {
            for(int k = 0; k < DimensionAPI.overlayList.size(); k++)
            {
                ((IRenderOverlay)DimensionAPI.overlayList.get(k)).renderGameOverlay(field_9422_g, i, j);
            }

        }
        if(!field_9422_g.field_6327_b.func_35643_e())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/gui/gui.png"));
            InventoryPlayer inventoryplayer = field_9422_g.field_6322_g.field_778_b;
            field_923_k = -90F;
            func_550_b(i / 2 - 91, j - 22, 0, 0, 182, 22);
            func_550_b((i / 2 - 91 - 1) + inventoryplayer.field_847_d * 20, j - 22 - 1, 0, 22, 24, 22);
            GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            func_550_b(i / 2 - 7, j / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            boolean flag1 = (field_9422_g.field_6322_g.field_9306_bj / 3) % 2 == 1;
            if(field_9422_g.field_6322_g.field_9306_bj < 10)
            {
                flag1 = false;
            }
            int k1 = field_9422_g.field_6322_g.func_40114_aH();
            int i3 = field_9422_g.field_6322_g.field_9335_K;
            field_9423_f.setSeed(field_9421_h * 0x4c627);
            boolean flag2 = false;
            FoodStats foodstats = field_9422_g.field_6322_g.func_35191_at();
            int k4 = foodstats.func_35765_a();
            int j5 = foodstats.func_35769_b();
            func_41039_c();
            if(field_9422_g.field_6327_b.func_6469_d())
            {
                int k5 = i / 2 - 91;
                int k6 = i / 2 + 91;
                int k7 = field_9422_g.field_6322_g.func_35193_as();
                if(k7 > 0)
                {
                    char c = '\266';
                    int i9 = (int)(field_9422_g.field_6322_g.field_35211_aX * (float)(c + 1));
                    int l9 = (j - 32) + 3;
                    func_550_b(k5, l9, 0, 64, c, 5);
                    if(i9 > 0)
                    {
                        func_550_b(k5, l9, 0, 69, i9, 5);
                    }
                }
                int k8 = j - 39;
                int j9 = k8 - 10;
                int i10 = field_9422_g.field_6322_g.func_40119_ar();
                int j10 = -1;
                if(field_9422_g.field_6322_g.func_35160_a(Potion.field_35681_l))
                {
                    j10 = field_9421_h % 25;
                }
                for(int k10 = 0; k10 < 10; k10++)
                {
                    if(i10 > 0)
                    {
                        int j11 = k5 + k10 * 8;
                        if(k10 * 2 + 1 < i10)
                        {
                            func_550_b(j11, j9, 34, 9, 9, 9);
                        }
                        if(k10 * 2 + 1 == i10)
                        {
                            func_550_b(j11, j9, 25, 9, 9, 9);
                        }
                        if(k10 * 2 + 1 > i10)
                        {
                            func_550_b(j11, j9, 16, 9, 9, 9);
                        }
                    }
                    int k11 = 16;
                    if(field_9422_g.field_6322_g.func_35160_a(Potion.field_35689_u))
                    {
                        k11 += 36;
                    }
                    int j12 = 0;
                    if(flag1)
                    {
                        j12 = 1;
                    }
                    int i13 = k5 + k10 * 8;
                    int k13 = k8;
                    if(k1 <= 4)
                    {
                        k13 += field_9423_f.nextInt(2);
                    }
                    if(k10 == j10)
                    {
                        k13 -= 2;
                    }
                    byte byte3 = 0;
                    if(field_9422_g.field_6324_e.func_22144_v().func_40724_s())
                    {
                        byte3 = 5;
                    }
                    func_550_b(i13, k13, 16 + j12 * 9, 9 * byte3, 9, 9);
                    if(flag1)
                    {
                        if(k10 * 2 + 1 < i3)
                        {
                            func_550_b(i13, k13, k11 + 54, 9 * byte3, 9, 9);
                        }
                        if(k10 * 2 + 1 == i3)
                        {
                            func_550_b(i13, k13, k11 + 63, 9 * byte3, 9, 9);
                        }
                    }
                    if(k10 * 2 + 1 < k1)
                    {
                        func_550_b(i13, k13, k11 + 36, 9 * byte3, 9, 9);
                    }
                    if(k10 * 2 + 1 == k1)
                    {
                        func_550_b(i13, k13, k11 + 45, 9 * byte3, 9, 9);
                    }
                }

                for(int l10 = 0; l10 < 10; l10++)
                {
                    int l11 = k8;
                    int k12 = 16;
                    byte byte2 = 0;
                    if(field_9422_g.field_6322_g.func_35160_a(Potion.field_35691_s))
                    {
                        k12 += 36;
                        byte2 = 13;
                    }
                    if(field_9422_g.field_6322_g.func_35191_at().func_35760_d() <= 0.0F && field_9421_h % (k4 * 3 + 1) == 0)
                    {
                        l11 += field_9423_f.nextInt(3) - 1;
                    }
                    if(flag2)
                    {
                        byte2 = 1;
                    }
                    int l13 = k6 - l10 * 8 - 9;
                    func_550_b(l13, l11, 16 + byte2 * 9, 27, 9, 9);
                    if(flag2)
                    {
                        if(l10 * 2 + 1 < j5)
                        {
                            func_550_b(l13, l11, k12 + 54, 27, 9, 9);
                        }
                        if(l10 * 2 + 1 == j5)
                        {
                            func_550_b(l13, l11, k12 + 63, 27, 9, 9);
                        }
                    }
                    if(l10 * 2 + 1 < k4)
                    {
                        func_550_b(l13, l11, k12 + 36, 27, 9, 9);
                    }
                    if(l10 * 2 + 1 == k4)
                    {
                        func_550_b(l13, l11, k12 + 45, 27, 9, 9);
                    }
                }

                if(field_9422_g.field_6322_g.func_393_a(Material.field_1332_f))
                {
                    int i11 = field_9422_g.field_6322_g.func_41001_Z();
                    int i12 = (int)Math.ceil(((double)(i11 - 2) * 10D) / 300D);
                    int l12 = (int)Math.ceil(((double)i11 * 10D) / 300D) - i12;
                    for(int j13 = 0; j13 < i12 + l12; j13++)
                    {
                        if(j13 < i12)
                        {
                            func_550_b(k6 - j13 * 8 - 9, j9, 16, 18, 9, 9);
                        } else
                        {
                            func_550_b(k6 - j13 * 8 - 9, j9, 25, 18, 9, 9);
                        }
                    }

                }
            }
            GL11.glDisable(3042);
            GL11.glEnable(32826);
            RenderHelper.func_41089_c();
            for(int i6 = 0; i6 < 9; i6++)
            {
                int l6 = (i / 2 - 90) + i6 * 20 + 2;
                int l7 = j - 16 - 3;
                func_554_a(i6, l6, l7, p_4066_1_);
            }

            RenderHelper.func_1159_a();
            GL11.glDisable(32826);
        }
        if(field_9422_g.field_6322_g.func_22060_M() > 0)
        {
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int l = field_9422_g.field_6322_g.func_22060_M();
            float f2 = (float)l / 100F;
            if(f2 > 1.0F)
            {
                f2 = 1.0F - (float)(l - 100) / 10F;
            }
            int i2 = (int)(220F * f2) << 24 | 0x101020;
            func_551_a(0, 0, i, j, i2);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
        }
        if(field_9422_g.field_6327_b.func_35642_f() && field_9422_g.field_6322_g.field_35210_aY > 0)
        {
            boolean flag = false;
            int i1 = flag ? 0xffffff : 0x80ff20;
            String s = (new StringBuilder()).append("").append(field_9422_g.field_6322_g.field_35210_aY).toString();
            int j3 = (i - fontrenderer.func_871_a(s)) / 2;
            int l3 = j - 31 - 4;
            fontrenderer.func_873_b(s, j3 + 1, l3, 0);
            fontrenderer.func_873_b(s, j3 - 1, l3, 0);
            fontrenderer.func_873_b(s, j3, l3 + 1, 0);
            fontrenderer.func_873_b(s, j3, l3 - 1, 0);
            fontrenderer.func_873_b(s, j3, l3, i1);
        }
        if(field_9422_g.field_6304_y.field_22276_A)
        {
            GL11.glPushMatrix();
            if(Minecraft.field_28005_H > 0L)
            {
                GL11.glTranslatef(0.0F, 32F, 0.0F);
            }
            fontrenderer.func_50103_a((new StringBuilder()).append("Minecraft 1.2.5 (").append(field_9422_g.field_6292_I).append(")").toString(), 2, 2, 0xffffff);
            fontrenderer.func_50103_a(field_9422_g.func_6241_m(), 2, 12, 0xffffff);
            fontrenderer.func_50103_a(field_9422_g.func_6262_n(), 2, 22, 0xffffff);
            fontrenderer.func_50103_a(field_9422_g.func_6245_o(), 2, 32, 0xffffff);
            fontrenderer.func_50103_a(field_9422_g.func_21002_o(), 2, 42, 0xffffff);
            long l1 = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l4 = Runtime.getRuntime().freeMemory();
            long l5 = l2 - l4;
            String s1 = (new StringBuilder()).append("Used memory: ").append((l5 * 100L) / l1).append("% (").append(l5 / 1024L / 1024L).append("MB) of ").append(l1 / 1024L / 1024L).append("MB").toString();
            func_547_b(fontrenderer, s1, i - fontrenderer.func_871_a(s1) - 2, 2, 0xe0e0e0);
            s1 = (new StringBuilder()).append("Allocated memory: ").append((l2 * 100L) / l1).append("% (").append(l2 / 1024L / 1024L).append("MB)").toString();
            func_547_b(fontrenderer, s1, i - fontrenderer.func_871_a(s1) - 2, 12, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("x: ").append(field_9422_g.field_6322_g.field_611_ak).toString(), 2, 64, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("y: ").append(field_9422_g.field_6322_g.field_610_al).toString(), 2, 72, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("z: ").append(field_9422_g.field_6322_g.field_609_am).toString(), 2, 80, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("f: ").append(MathHelper.func_1108_b((double)((field_9422_g.field_6322_g.field_605_aq * 4F) / 360F) + 0.5D) & 3).toString(), 2, 88, 0xe0e0e0);
            int i7 = MathHelper.func_1108_b(field_9422_g.field_6322_g.field_611_ak);
            int i8 = MathHelper.func_1108_b(field_9422_g.field_6322_g.field_610_al);
            int l8 = MathHelper.func_1108_b(field_9422_g.field_6322_g.field_609_am);
            if(field_9422_g.field_6324_e != null && field_9422_g.field_6324_e.func_630_d(i7, i8, l8))
            {
                Chunk chunk = field_9422_g.field_6324_e.func_673_a(i7, l8);
                func_547_b(fontrenderer, (new StringBuilder()).append("lc: ").append(chunk.func_48498_h() + 15).append(" b: ").append(chunk.func_48490_a(i7 & 0xf, l8 & 0xf, field_9422_g.field_6324_e.func_4075_a()).field_6504_m).append(" bl: ").append(chunk.func_1025_a(EnumSkyBlock.Block, i7 & 0xf, i8, l8 & 0xf)).append(" sl: ").append(chunk.func_1025_a(EnumSkyBlock.Sky, i7 & 0xf, i8, l8 & 0xf)).append(" rl: ").append(chunk.func_1019_c(i7 & 0xf, i8, l8 & 0xf, 0)).toString(), 2, 96, 0xe0e0e0);
            }
            if(!field_9422_g.field_6324_e.field_1026_y)
            {
                func_547_b(fontrenderer, (new StringBuilder()).append("Seed: ").append(field_9422_g.field_6324_e.func_22138_q()).toString(), 2, 112, 0xe0e0e0);
            }
            GL11.glPopMatrix();
        }
        if(field_9419_j > 0)
        {
            float f1 = (float)field_9419_j - p_4066_1_;
            int j1 = (int)((f1 * 256F) / 20F);
            if(j1 > 255)
            {
                j1 = 255;
            }
            if(j1 > 0)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(i / 2, j - 48, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int j2 = 0xffffff;
                if(field_22065_l)
                {
                    j2 = Color.HSBtoRGB(f1 / 50F, 0.7F, 0.6F) & 0xffffff;
                }
                fontrenderer.func_873_b(field_9420_i, -fontrenderer.func_871_a(field_9420_i) / 2, -4, j2 + (j1 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, j - 48, 0.0F);
        func_50010_a(fontrenderer);
        GL11.glPopMatrix();
        if((field_9422_g.field_6322_g instanceof EntityClientPlayerMP) && field_9422_g.field_6304_y.field_35384_x.field_35965_e)
        {
            NetClientHandler netclienthandler = ((EntityClientPlayerMP)field_9422_g.field_6322_g).field_797_bg;
            java.util.List list = netclienthandler.field_35786_c;
            int k2 = netclienthandler.field_35785_d;
            int k3 = k2;
            int i4 = 1;
            for(; k3 > 20; k3 = ((k2 + i4) - 1) / i4)
            {
                i4++;
            }

            int j4 = 300 / i4;
            if(j4 > 150)
            {
                j4 = 150;
            }
            int i5 = (i - i4 * j4) / 2;
            byte byte0 = 10;
            func_551_a(i5 - 1, byte0 - 1, i5 + j4 * i4, byte0 + 9 * k3, 0x80000000);
            for(int j6 = 0; j6 < k2; j6++)
            {
                int j7 = i5 + (j6 % i4) * j4;
                int j8 = byte0 + (j6 / i4) * 9;
                func_551_a(j7, j8, (j7 + j4) - 1, j8 + 8, 0x20ffffff);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3008);
                if(j6 >= list.size())
                {
                    continue;
                }
                GuiPlayerInfo guiplayerinfo = (GuiPlayerInfo)list.get(j6);
                fontrenderer.func_50103_a(guiplayerinfo.field_35624_a, j7, j8, 0xffffff);
                field_9422_g.field_6315_n.func_1076_b(field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
                int k9 = 0;
                byte byte1 = 0;
                if(guiplayerinfo.field_35623_b < 0)
                {
                    byte1 = 5;
                } else
                if(guiplayerinfo.field_35623_b < 150)
                {
                    byte1 = 0;
                } else
                if(guiplayerinfo.field_35623_b < 300)
                {
                    byte1 = 1;
                } else
                if(guiplayerinfo.field_35623_b < 600)
                {
                    byte1 = 2;
                } else
                if(guiplayerinfo.field_35623_b < 1000)
                {
                    byte1 = 3;
                } else
                {
                    byte1 = 4;
                }
                field_923_k += 100F;
                func_550_b((j7 + j4) - 12, j8, 0 + k9 * 10, 176 + byte1 * 8, 10, 8);
                field_923_k -= 100F;
            }

        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    private void func_50010_a(FontRenderer p_50010_1_)
    {
        byte byte0 = 10;
        boolean flag = false;
        int i = 0;
        int j = field_929_e.size();
        if(j <= 0)
        {
            return;
        }
        if(func_50015_e())
        {
            byte0 = 20;
            flag = true;
        }
        for(int k = 0; k + field_50017_n < field_929_e.size() && k < byte0; k++)
        {
            if(((ChatLine)field_929_e.get(k)).field_1296_b >= 200 && !flag)
            {
                continue;
            }
            ChatLine chatline = (ChatLine)field_929_e.get(k + field_50017_n);
            double d = (double)chatline.field_1296_b / 200D;
            d = 1.0D - d;
            d *= 10D;
            if(d < 0.0D)
            {
                d = 0.0D;
            }
            if(d > 1.0D)
            {
                d = 1.0D;
            }
            d *= d;
            int l1 = (int)(255D * d);
            if(flag)
            {
                l1 = 255;
            }
            i++;
            if(l1 > 2)
            {
                byte byte1 = 3;
                int j2 = -k * 9;
                String s = chatline.field_1297_a;
                func_551_a(byte1, j2 - 1, byte1 + 320 + 4, j2 + 8, l1 / 2 << 24);
                GL11.glEnable(3042);
                p_50010_1_.func_50103_a(s, byte1, j2, 0xffffff + (l1 << 24));
            }
        }

        if(flag)
        {
            GL11.glTranslatef(0.0F, p_50010_1_.field_41063_b, 0.0F);
            int l = j * p_50010_1_.field_41063_b + j;
            int i1 = i * p_50010_1_.field_41063_b + i;
            int j1 = (field_50017_n * i1) / j;
            int k1 = (i1 * i1) / l;
            if(l != i1)
            {
                char c = j1 > 0 ? '\252' : '`';
                int i2 = field_50018_o ? 0xcc3333 : 0x3333aa;
                func_551_a(0, -j1, 2, -j1 - k1, i2 + (c << 24));
                func_551_a(2, -j1, 1, -j1 - k1, 0xcccccc + (c << 24));
            }
        }
    }

    private void func_41039_c()
    {
        if(RenderDragon.field_41038_a == null)
        {
            return;
        }
        EntityDragon entitydragon = RenderDragon.field_41038_a;
        RenderDragon.field_41038_a = null;
        FontRenderer fontrenderer = field_9422_g.field_6314_o;
        ScaledResolution scaledresolution = new ScaledResolution(field_9422_g.field_6304_y, field_9422_g.field_6326_c, field_9422_g.field_6325_d);
        int i = scaledresolution.func_903_a();
        char c = '\266';
        int j = i / 2 - c / 2;
        int k = (int)(((float)entitydragon.func_41010_ax() / (float)entitydragon.func_40117_c()) * (float)(c + 1));
        byte byte0 = 12;
        func_550_b(j, byte0, 0, 74, c, 5);
        func_550_b(j, byte0, 0, 74, c, 5);
        if(k > 0)
        {
            func_550_b(j, byte0, 0, 79, k, 5);
        }
        String s = "Boss health";
        fontrenderer.func_50103_a(s, i / 2 - fontrenderer.func_871_a(s) / 2, byte0 - 10, 0xff00ff);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
    }

    private void func_4063_a(int p_4063_1_, int p_4063_2_)
    {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("%blur%/misc/pumpkinblur.png"));
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(0.0D, p_4063_2_, -90D, 0.0D, 1.0D);
        tessellator.func_983_a(p_4063_1_, p_4063_2_, -90D, 1.0D, 1.0D);
        tessellator.func_983_a(p_4063_1_, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.func_983_a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_4064_a(float p_4064_1_, int p_4064_2_, int p_4064_3_)
    {
        p_4064_1_ = 1.0F - p_4064_1_;
        if(p_4064_1_ < 0.0F)
        {
            p_4064_1_ = 0.0F;
        }
        if(p_4064_1_ > 1.0F)
        {
            p_4064_1_ = 1.0F;
        }
        field_931_c += (double)(p_4064_1_ - field_931_c) * 0.01D;
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(field_931_c, field_931_c, field_931_c, 1.0F);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("%blur%/misc/vignette.png"));
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(0.0D, p_4064_3_, -90D, 0.0D, 1.0D);
        tessellator.func_983_a(p_4064_2_, p_4064_3_, -90D, 1.0D, 1.0D);
        tessellator.func_983_a(p_4064_2_, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.func_983_a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void func_4065_b(float p_4065_1_, int p_4065_2_, int p_4065_3_)
    {
        int i = Block.field_4047_bf.field_378_bb;
        String s = "/terrain.png";
        if(DimensionAPI.isInPortal(field_9422_g.field_6322_g, Block.field_4047_bf.field_376_bc))
        {
            currentPortal = null;
        }
        if(currentPortal != null)
        {
            i = currentPortal.getOverlayTexture();
            s = currentPortal.getOverlayTextureOverride();
        }
        if(p_4065_1_ < 1.0F)
        {
            p_4065_1_ *= p_4065_1_;
            p_4065_1_ *= p_4065_1_;
            p_4065_1_ = p_4065_1_ * 0.8F + 0.2F;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, p_4065_1_);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a(s));
        float f = (float)(i % 16) / 16F;
        float f1 = (float)(i / 16) / 16F;
        float f2 = (float)(i % 16 + 1) / 16F;
        float f3 = (float)(i / 16 + 1) / 16F;
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(0.0D, p_4065_3_, -90D, f, f3);
        tessellator.func_983_a(p_4065_2_, p_4065_3_, -90D, f2, f3);
        tessellator.func_983_a(p_4065_2_, 0.0D, -90D, f2, f1);
        tessellator.func_983_a(0.0D, 0.0D, -90D, f, f1);
        tessellator.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_554_a(int p_554_1_, int p_554_2_, int p_554_3_, float p_554_4_)
    {
        ItemStack itemstack = field_9422_g.field_6322_g.field_778_b.field_843_a[p_554_1_];
        if(itemstack == null)
        {
            return;
        }
        float f = (float)itemstack.field_1614_b - p_554_4_;
        if(f > 0.0F)
        {
            GL11.glPushMatrix();
            float f1 = 1.0F + f / 5F;
            GL11.glTranslatef(p_554_2_ + 8, p_554_3_ + 12, 0.0F);
            GL11.glScalef(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(p_554_2_ + 8), -(p_554_3_ + 12), 0.0F);
        }
        field_930_d.func_161_a(field_9422_g.field_6314_o, field_9422_g.field_6315_n, itemstack, p_554_2_, p_554_3_);
        if(f > 0.0F)
        {
            GL11.glPopMatrix();
        }
        field_930_d.func_164_b(field_9422_g.field_6314_o, field_9422_g.field_6315_n, itemstack, p_554_2_, p_554_3_);
    }

    public void func_555_a()
    {
        if(field_9419_j > 0)
        {
            field_9419_j--;
        }
        field_9421_h++;
        for(int i = 0; i < field_929_e.size(); i++)
        {
            ((ChatLine)field_929_e.get(i)).field_1296_b++;
        }

    }

    public void func_28097_b()
    {
        field_929_e.clear();
        field_50016_f.clear();
    }

    public void func_552_a(String p_552_1_)
    {
        boolean flag = func_50015_e();
        boolean flag1 = true;
        String s;
        for(Iterator iterator = field_9422_g.field_6314_o.func_50108_c(p_552_1_, 320).iterator(); iterator.hasNext(); field_929_e.add(0, new ChatLine(s)))
        {
            s = (String)iterator.next();
            if(flag && field_50017_n > 0)
            {
                field_50018_o = true;
                func_50011_a(1);
            }
            if(!flag1)
            {
                s = (new StringBuilder()).append(" ").append(s).toString();
            }
            flag1 = false;
        }

        for(; field_929_e.size() > 100; field_929_e.remove(field_929_e.size() - 1)) { }
    }

    public java.util.List func_50013_c()
    {
        return field_50016_f;
    }

    public void func_50014_d()
    {
        field_50017_n = 0;
        field_50018_o = false;
    }

    public void func_50011_a(int p_50011_1_)
    {
        field_50017_n += p_50011_1_;
        int i = field_929_e.size();
        if(field_50017_n > i - 20)
        {
            field_50017_n = i - 20;
        }
        if(field_50017_n <= 0)
        {
            field_50017_n = 0;
            field_50018_o = false;
        }
    }

    public ChatClickData func_50012_a(int p_50012_1_, int p_50012_2_)
    {
        if(!func_50015_e())
        {
            return null;
        }
        ScaledResolution scaledresolution = new ScaledResolution(field_9422_g.field_6304_y, field_9422_g.field_6326_c, field_9422_g.field_6325_d);
        p_50012_2_ = p_50012_2_ / scaledresolution.field_1368_a - 40;
        p_50012_1_ = p_50012_1_ / scaledresolution.field_1368_a - 3;
        if(p_50012_1_ < 0 || p_50012_2_ < 0)
        {
            return null;
        }
        int i = Math.min(20, field_929_e.size());
        if(p_50012_1_ <= 320 && p_50012_2_ < field_9422_g.field_6314_o.field_41063_b * i + i)
        {
            int j = p_50012_2_ / (field_9422_g.field_6314_o.field_41063_b + 1) + field_50017_n;
            return new ChatClickData(field_9422_g.field_6314_o, (ChatLine)field_929_e.get(j), p_50012_1_, (p_50012_2_ - (j - field_50017_n) * field_9422_g.field_6314_o.field_41063_b) + j);
        } else
        {
            return null;
        }
    }

    public void func_553_b(String p_553_1_)
    {
        field_9420_i = (new StringBuilder()).append("Now playing: ").append(p_553_1_).toString();
        field_9419_j = 60;
        field_22065_l = true;
    }

    public boolean func_50015_e()
    {
        return field_9422_g.field_6313_p instanceof GuiChat;
    }

    public void func_22064_c(String p_22064_1_)
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        String s = stringtranslate.func_20163_a(p_22064_1_);
        func_552_a(s);
    }

}
