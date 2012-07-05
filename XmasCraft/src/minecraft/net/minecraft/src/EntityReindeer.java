package net.minecraft.src;

import java.util.*;

public class EntityReindeer extends EntityAgeable {

	private int randomTickProvider;
	private boolean isMatingFlag;
	private boolean isPlayingFlag;

	public EntityReindeer(World par1World) { 
		
		this(par1World, 0);
		
	}
	
	public EntityReindeer(World par1World, int par2) {
		
		super(par1World);
		texture = "/Xmascraft/Mobs/Reindeer.png";
		randomTickProvider = 0;
		isMatingFlag = false;
		isPlayingFlag = false;
		moveSpeed = 0.5F;
		getNavigator().func_48664_a(true);
		
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8F, 0.3F, 0.35F));
		tasks.addTask(2, new EntityAIWander(this, 0.3F));
		
	}
	
	public boolean isAIEnabled() {
		
		return true;
	}
	
	protected void entityInit() {
		
		super.entityInit();
		
		dataWatcher.addObject(16, Integer.valueOf(0));
	}

}