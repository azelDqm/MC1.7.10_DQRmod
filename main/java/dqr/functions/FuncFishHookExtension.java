package dqr.functions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import dqr.api.event.DqrEntityFishHookEvent;

public class FuncFishHookExtension {


	public FuncFishHookExtension(){}


	/*
	public ItemStack hookFunc_146033_f(World world, EntityPlayer ep)
	{
		return this.hookFunc_146033_f(world, ep, null);
	}
	*/


	public ItemStack hookFunc_146033_f(World world, EntityPlayer ep)
	{
		DqrEntityFishHookEvent.hookDqrFunc_146033_f event = new DqrEntityFishHookEvent.hookDqrFunc_146033_f(world, ep, Items.fishing_rod);
		event.setHitItem(null);
		MinecraftForge.EVENT_BUS.post(event);

		//System.out.println("TESTB");
		return event.getHitItem();
	}

	/*
	public ItemStack hookGetRandomFishable(float chance, int luck, int speed)
	{
		System.out.println("TESTA");
		DqrEntityFishHookEvent.hookGetRandomFishable event = new DqrEntityFishHookEvent.hookGetRandomFishable(chance, luck, speed);
		MinecraftForge.EVENT_BUS.post(event);


		return event.getHitItem();
	}
	*/



	public ItemStack hookDqrFunc_146033_f(World world, EntityPlayer ep)
	{
		//System.out.println("TEST2");
		return this.hookDqrFunc_146033_f(world, ep, null);
	}

	public ItemStack hookDqrFunc_146033_f(World world, EntityPlayer ep, Item item)
	{
		//ここしか機能してない！！
		DqrEntityFishHookEvent.hookDqrFunc_146033_f event = new DqrEntityFishHookEvent.hookDqrFunc_146033_f(world, ep, item);
		event.setHitItem(null);
		MinecraftForge.EVENT_BUS.post(event);

		//System.out.println("TESTB");
		return event.getHitItem();
		//return null;
	}
}
