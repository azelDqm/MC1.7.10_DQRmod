package dqr.api.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Event;

public class DqrEntityFishHookEvent extends Event{



	//釣れたアイテムをセット
	public ItemStack item;

	public DqrEntityFishHookEvent ()
	{
		this.item = null;
	}

	/*
    public static class hookFunc_146033_f extends DqrEntityFishHookEvent {
    	public World world;
    	public EntityPlayer ep;
    	public Item rodType;
    	public hookFunc_146033_f(World world, EntityPlayer ep, Item rodType)
    	{
    		this.world = world;
    		this.ep = ep;
    		this.item = null;
    		this.rodType = rodType;
    	}
    }
    */

    public static class hookDqrFunc_146033_f extends DqrEntityFishHookEvent {
    	public World world;
    	public EntityPlayer ep;
    	public Item rodType;
    	public hookDqrFunc_146033_f(World world, EntityPlayer ep, Item rodType)
    	{
    		this.world = world;
    		this.ep = ep;
    		this.item = null;
    		this.rodType = rodType;
    	}
    }

    /*
    public static class hookGetRandomFishable extends DqrEntityFishHookEvent {
    	public float chance;
    	public int luck;
    	public int speed;
		public hookGetRandomFishable (float chance, int luck, int speed)
		{
			this.chance = chance;
			this.luck = luck;
			this.speed = speed;

			this.item = null;
		}
    }
    */

	public ItemStack getHitItem()
	{
		return this.item;
	}

	public void setHitItem(ItemStack item)
	{
		this.item = item;
	}
}
