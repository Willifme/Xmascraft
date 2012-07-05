package net.minecraft.src;

import java.util.Random;
import java.util.List;
import java.util.jar.*;


public class mod_Xmascraft extends BaseMod
{

	//Declares multi texutre variables

	public static int XmascraftCandyCaneGreenTopandBottom = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/CandyCaneGreenBackground.png"); 
	public static int XmascraftCandyCaneRedTopandBottom = ModLoader.addOverride("/terrain.png",  "/Xmascraft/Block/CandyCaneBackground.png");

	//Declares the Blocks

	public static Block XmascraftSnow = new BlockXmascraftSnow(210, 0).setHardness(1.0F).setResistance(1.0F).setBlockName("Xmascraft Snow");
	public static Block XmascraftIce = new BlockXmascraftIce(211, 0).setHardness(1.0F).setResistance(6000.0F).setLightValue(1.0F).setBlockName("Xmascraft Ice");
	public static Block XmascraftStone = new BlockXmascraftStone(213, 0).setHardness(0.2F).setBlockName("Xmascraft Stone");
	public static final BlockXmascraftPortal XmascraftPortal = (BlockXmascraftPortal)(new BlockXmascraftPortal(212).setHardness(1.0F).setResistance(6000.0F).setBlockName("Xmascraft Portal"));
	public static Block XmascraftCandyCaneRed = new BlockXmascraftCandyCaneRed(215, 0).setHardness(1.0F).setResistance(2000.0F).setBlockName("Xmascraft CC Red");
	public static Block XmascraftCandyCaneGreen = new BlockXmascraftCandyCaneGreen(216, 0).setHardness(1.0F).setResistance(2000.0F).setBlockName("Xmascraft CC Green");
	public static Block XmascraftStoneOre = new BlockXmascraftStoneOre(217, 0).setHardness(1.0F).setResistance(10.0F).setBlockName("Xmascraft Snow");

	//Declares the Items
	public static final Item XmascraftCandyCaneRedFood = new ItemFood(601, 2, false).setItemName("Red CC");
	public static final Item XmascraftCandyCaneGreenFood = new ItemFood(602, 2, false).setItemName("Green CC");
	public static final Item XmascraftXmasShards = new Item(603).setItemName("Xmas shards");

	public void load()
	{


		//Registers the blocks with modloader
		ModLoader.registerBlock(XmascraftSnow);
		ModLoader.registerBlock(XmascraftIce);
		ModLoader.registerBlock(XmascraftPortal);
		ModLoader.registerBlock(XmascraftStone);
		ModLoader.registerBlock(XmascraftCandyCaneGreen);
		ModLoader.registerBlock(XmascraftCandyCaneRed);
		ModLoader.registerBlock(XmascraftStoneOre);

		//Adds name to blocks & Items in modloader
		ModLoader.addName(XmascraftStone, "Xmas Stone");
		ModLoader.addName(XmascraftPortal, "Xmas Portal");
		ModLoader.addName(XmascraftSnow, "Snow");
		ModLoader.addName(XmascraftCandyCaneGreen, "Green Candycane");
		ModLoader.addName(XmascraftCandyCaneRed, "Red Candycane");
		ModLoader.addName(XmascraftCandyCaneRedFood, "Red Candycane");
		ModLoader.addName(XmascraftCandyCaneGreenFood, "Green Candycane");
		ModLoader.addName(XmascraftStoneOre, "Xmasite");
		ModLoader.addName(XmascraftXmasShards, "Xmas Shards");
		
		//Declares Entities
		ModLoader.registerEntityID(EntityReindeer.class, "Reindeer", ModLoader.getUniqueEntityId());
		
		//Makes mob spawnable
		ModLoader.addSpawn(EntityReindeer.class, 15, 5, 7, EnumCreatureType.creature);

		//Adds block textures
		XmascraftSnow.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/SnowBlock.png");
		XmascraftStone.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/XmascraftStone.png");
		XmascraftPortal.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/XmascraftPortal.png");
		XmascraftCandyCaneGreen.blockIndexInTexture  = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/XmascraftPortal.png");
		XmascraftCandyCaneRed.blockIndexInTexture  = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/CandyCaneRed.png");
		XmascraftCandyCaneGreen.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/CandyCaneGreen.png");
		XmascraftStoneOre.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/Xmascraft/Block/XmascraftStoneOre.png");

		//Adds item textures
		XmascraftCandyCaneRedFood.iconIndex = ModLoader.addOverride("/gui/items.png", "/Xmascraft/Item/CandyCaneRed.png");
		XmascraftCandyCaneGreenFood.iconIndex = ModLoader.addOverride("/gui/items.png", "/Xmascraft/Item/CandyCaneGreen.png");
		XmascraftXmasShards.iconIndex = ModLoader.addOverride("/gui/items.png", "/Xmascraft/Item/XmasShards.png");

		//Adds crafting recipe to Items and blocks Shapeless or not
	/* For debugging and accessing the dimension*/	ModLoader.addRecipe(new ItemStack(XmascraftStone, 1), new Object[] {"d", Character.valueOf('d'), Block.dirt, Character.valueOf('X'), Block.sand, Character.valueOf('Z'), Block.planks});
		ModLoader.addRecipe(new ItemStack(XmascraftStone, 1), new Object[] {"ddd","ddd","ddd", Character.valueOf('d'),mod_Xmascraft.XmascraftXmasShards});
	}
	

	public void generateSurface(World world, Random rand, int y , int z) {
		
			for(int i3 = 0; i3 < 20; i3++) {
				
				int j6 = y + rand.nextInt(10);
				int y9 = rand.nextInt(128);
				int j12 = z + rand.nextInt(10);
				new WorldGenMinable(XmascraftStoneOre.blockID, 10).generate(world, rand, j6, y9, j12);
			}
		
			//For Green candy cane
			for(int a = 0; a < 25; a++) {

				int RandPosX = y + rand.nextInt(16);
				int RandPosY = rand.nextInt(64);
				int RandPosZ = z + rand.nextInt(16);
				(new WorldGenGreenCandyCane()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
			}


			for (int a = 0; a < 90; a++) {

				int RandPosX = y + rand.nextInt(16);
				int RandPosY = rand.nextInt(200);
				int RandPosZ = z + rand.nextInt(16);

				(new WorldGenGreenCandyCane()).generate(world, rand, RandPosX, RandPosY, RandPosZ);

			}

			//For Red candy cane
			for(int a = 0; a < 90; a++) {

				int RandPosX = y + rand.nextInt(16);
				int RandPosY = rand.nextInt(150);
				int RandPosZ = z + rand.nextInt(16);
				(new WorldGenRedCandyCane()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
			}


			for (int a = 0; a < 10; a++) {

				int RandPosX = y + rand.nextInt(16);
				int RandPosY = rand.nextInt(200);
				int RandPosZ = z + rand.nextInt(16);

				(new WorldGenRedCandyCane()).generate(world, rand, RandPosX, RandPosY, RandPosZ);


			}

		}
		



	public String getVersion()
	{
		return "Xmascraft | 0.10 | MC: 1.2.5";
	}



}