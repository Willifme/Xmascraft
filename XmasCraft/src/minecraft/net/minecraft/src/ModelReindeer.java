// Date: 04/07/2012 21:02:17
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.minecraft.src;

public class ModelReindeer extends ModelBase
{
  //fields
    ModelRenderer Leg_1;
    ModelRenderer Leg_2;
    ModelRenderer Leg_3;
    ModelRenderer Leg_4;
    ModelRenderer Body_1;
    ModelRenderer Tail_1;
    ModelRenderer Tail_2;
    ModelRenderer Tail_3;
    ModelRenderer Neck_1;
    ModelRenderer Neck_2;
    ModelRenderer Neck_3;
    ModelRenderer Neck_4;
    ModelRenderer Head_1;
    ModelRenderer Head_2;
    ModelRenderer Head_3;
    ModelRenderer Left_Antler_1;
    ModelRenderer Left_Antler_2;
    ModelRenderer Left_Antler_3;
    ModelRenderer Right_Antler_1;
    ModelRenderer Right_Antler_2;
    ModelRenderer Right_Antler_3;
  
  public ModelReindeer()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Leg_1 = new ModelRenderer(this, 0, 0);
      Leg_1.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg_1.setRotationPoint(0F, 0F, 0F);
      Leg_1.setTextureSize(64, 32);
      Leg_1.mirror = true;
      setRotation(Leg_1, 0F, 0F, 0F);
      Leg_2 = new ModelRenderer(this, 0, 0);
      Leg_2.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg_2.setRotationPoint(-6F, 0F, 0F);
      Leg_2.setTextureSize(64, 32);
      Leg_2.mirror = true;
      setRotation(Leg_2, 0F, 0F, 0F);
      Leg_3 = new ModelRenderer(this, 0, 0);
      Leg_3.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg_3.setRotationPoint(0F, 0F, -10F);
      Leg_3.setTextureSize(64, 32);
      Leg_3.mirror = true;
      setRotation(Leg_3, 0F, 0F, 0F);
      Leg_4 = new ModelRenderer(this, 0, 0);
      Leg_4.addBox(0F, 0F, 0F, 4, 12, 4);
      Leg_4.setRotationPoint(-6F, 0F, -10F);
      Leg_4.setTextureSize(64, 32);
      Leg_4.mirror = true;
      setRotation(Leg_4, 0F, 0F, 0F);
      Body_1 = new ModelRenderer(this, 0, 0);
      Body_1.addBox(0F, 0F, 0F, 10, 7, 14);
      Body_1.setRotationPoint(-6F, -7F, -10F);
      Body_1.setTextureSize(64, 32);
      Body_1.mirror = true;
      setRotation(Body_1, 0F, 0F, 0F);
      Tail_1 = new ModelRenderer(this, 0, 0);
      Tail_1.addBox(0F, 0F, 0F, 4, 4, 1);
      Tail_1.setRotationPoint(-3F, -5F, 4F);
      Tail_1.setTextureSize(64, 32);
      Tail_1.mirror = true;
      setRotation(Tail_1, 0F, 0F, 0F);
      Tail_2 = new ModelRenderer(this, 0, 0);
      Tail_2.addBox(0F, 0F, 0F, 2, 2, 1);
      Tail_2.setRotationPoint(-2F, -4F, 5F);
      Tail_2.setTextureSize(64, 32);
      Tail_2.mirror = true;
      setRotation(Tail_2, 0F, 0F, 0F);
      Tail_3 = new ModelRenderer(this, 0, 0);
      Tail_3.addBox(0F, 0F, 0F, 2, 2, 1);
      Tail_3.setRotationPoint(-2F, -3F, 6F);
      Tail_3.setTextureSize(64, 32);
      Tail_3.mirror = true;
      setRotation(Tail_3, 0F, 0F, 0F);
      Neck_1 = new ModelRenderer(this, 0, 0);
      Neck_1.addBox(0F, 0F, 0F, 8, 5, 2);
      Neck_1.setRotationPoint(-5F, -6F, -12F);
      Neck_1.setTextureSize(64, 32);
      Neck_1.mirror = true;
      setRotation(Neck_1, 0F, 0F, 0F);
      Neck_2 = new ModelRenderer(this, 0, 0);
      Neck_2.addBox(0F, 0F, 0F, 6, 5, 2);
      Neck_2.setRotationPoint(-4F, -7F, -13F);
      Neck_2.setTextureSize(64, 32);
      Neck_2.mirror = true;
      setRotation(Neck_2, 0F, 0F, 0F);
      Neck_3 = new ModelRenderer(this, 0, 0);
      Neck_3.addBox(0F, 0F, 0F, 4, 5, 2);
      Neck_3.setRotationPoint(-3F, -8F, -14F);
      Neck_3.setTextureSize(64, 32);
      Neck_3.mirror = true;
      setRotation(Neck_3, 0F, 0F, 0F);
      Neck_4 = new ModelRenderer(this, 0, 0);
      Neck_4.addBox(0F, 0F, 0F, 2, 3, 2);
      Neck_4.setRotationPoint(-2F, -9F, -15F);
      Neck_4.setTextureSize(64, 32);
      Neck_4.mirror = true;
      setRotation(Neck_4, 0F, 0F, 0F);
      Head_1 = new ModelRenderer(this, 0, 0);
      Head_1.addBox(0F, 0F, 0F, 6, 6, 6);
      Head_1.setRotationPoint(-4F, -9F, -18F);
      Head_1.setTextureSize(64, 32);
      Head_1.mirror = true;
      setRotation(Head_1, 0F, 0F, 0F);
      Head_2 = new ModelRenderer(this, 0, 0);
      Head_2.addBox(0F, 0F, 0F, 2, 2, 3);
      Head_2.setRotationPoint(-2F, -7F, -17F);
      Head_2.setTextureSize(64, 32);
      Head_2.mirror = true;
      setRotation(Head_2, 0F, 0F, 0F);
      Head_3 = new ModelRenderer(this, 0, 0);
      Head_3.addBox(0F, 0F, 0F, 2, 2, 1);
      Head_3.setRotationPoint(-2F, -6F, -19F);
      Head_3.setTextureSize(64, 32);
      Head_3.mirror = true;
      setRotation(Head_3, 0F, 0F, 0F);
      Left_Antler_1 = new ModelRenderer(this, 0, 0);
      Left_Antler_1.addBox(0F, 0F, 0F, 1, 5, 1);
      Left_Antler_1.setRotationPoint(0F, -14F, -15F);
      Left_Antler_1.setTextureSize(64, 32);
      Left_Antler_1.mirror = true;
      setRotation(Left_Antler_1, 0F, 0F, 0F);
      Left_Antler_2 = new ModelRenderer(this, 0, 0);
      Left_Antler_2.addBox(0F, 0F, 0F, 1, 1, 2);
      Left_Antler_2.setRotationPoint(0F, -11F, -17F);
      Left_Antler_2.setTextureSize(64, 32);
      Left_Antler_2.mirror = true;
      setRotation(Left_Antler_2, 0F, 0F, 0F);
      Left_Antler_3 = new ModelRenderer(this, 0, 0);
      Left_Antler_3.addBox(0F, 0F, 0F, 1, 1, 4);
      Left_Antler_3.setRotationPoint(0F, -14F, -18F);
      Left_Antler_3.setTextureSize(64, 32);
      Left_Antler_3.mirror = true;
      setRotation(Left_Antler_3, 0F, 0F, 0F);
      Right_Antler_1 = new ModelRenderer(this, 0, 0);
      Right_Antler_1.addBox(0F, 0F, 0F, 1, 5, 1);
      Right_Antler_1.setRotationPoint(-3F, -14F, -15F);
      Right_Antler_1.setTextureSize(64, 32);
      Right_Antler_1.mirror = true;
      setRotation(Right_Antler_1, 0F, 0F, 0F);
      Right_Antler_2 = new ModelRenderer(this, 0, 0);
      Right_Antler_2.addBox(0F, 0F, 0F, 1, 1, 2);
      Right_Antler_2.setRotationPoint(-3F, -11F, -17F);
      Right_Antler_2.setTextureSize(64, 32);
      Right_Antler_2.mirror = true;
      setRotation(Right_Antler_2, 0F, 0F, 0F);
      Right_Antler_3 = new ModelRenderer(this, 0, 0);
      Right_Antler_3.addBox(0F, 0F, 0F, 1, 1, 4);
      Right_Antler_3.setRotationPoint(-3F, -14F, -18F);
      Right_Antler_3.setTextureSize(64, 32);
      Right_Antler_3.mirror = true;
      setRotation(Right_Antler_3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Leg_1.render(f5);
    Leg_2.render(f5);
    Leg_3.render(f5);
    Leg_4.render(f5);
    Body_1.render(f5);
    Tail_1.render(f5);
    Tail_2.render(f5);
    Tail_3.render(f5);
    Neck_1.render(f5);
    Neck_2.render(f5);
    Neck_3.render(f5);
    Neck_4.render(f5);
    Head_1.render(f5);
    Head_2.render(f5);
    Head_3.render(f5);
    Left_Antler_1.render(f5);
    Left_Antler_2.render(f5);
    Left_Antler_3.render(f5);
    Right_Antler_1.render(f5);
    Right_Antler_2.render(f5);
    Right_Antler_3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
