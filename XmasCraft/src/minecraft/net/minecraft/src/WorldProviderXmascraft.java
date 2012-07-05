package net.minecraft.src;

import java.util.Random;

public class WorldProviderXmascraft extends WorldProviderBase

{

	public WorldProviderXmascraft()
	{

	}

	public int getDimensionID()
	{
		return 65;
	}

	public boolean renderClouds()
	{
		return true;
	}

	public boolean renderVoidFog()
	{
		return true;
	}

	public float setSunSize()
	{
		return 1.0F;
	}


	public float setMoonSize()
	{
		return 1.0F;
	}

	public String getSunTextre() {

		return "/sun.png";

	}

	public String getMoonTextre()
	{
		return "moon.png";
	}


	public boolean renderStars()
	{
		return true;
	}

	public boolean darkenSkyDuringRain()
	{
		return true;
	}

	public String getRespawnMessage()
	{
		return "Leaving The Northpole";
	}

	public void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.northpolepanes, 1.0F, 0.0F);
		worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.northpolehill, 1.0F, 0.0F);
	}

	public IChunkProvider getChunkProvider()
	{
		return new ChunkProviderGenerate (worldObj, worldObj.getSeed(), false);
	}


	public boolean canRespawnHere()
	{
		return false;
	}

	public float calculateCelestialAngle(long par1, float par3)
	{
		return 0.0F;
	}
	

    public boolean func_48218_b(int par1, int par2)
    {
        return true;
    }

}