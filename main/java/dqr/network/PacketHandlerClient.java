package dqr.network;

import io.netty.buffer.Unpooled;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.entity.throwingEntity.throwing.ThrowingEntityFishHook;

public class PacketHandlerClient implements IMessageHandler<SToCMessage, IMessage> {

	//Types of packets
	public static final int PUFFERFISH_SCARED = 1;
	public static final int SPAWN_HOOK = 2;
	public static final int HOOK_FISH = 3;
	public static final int BREAK_FISHING_ROD = 4;
	public static final int SET_INVENTORY_ITEM = 5;


	public IMessage onMessage(SToCMessage packet, MessageContext context)
	{
		PacketBuffer buff = new PacketBuffer(Unpooled.wrappedBuffer(packet.getData()));

		//System.out.println("hogehoge_A");
		EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
		World world = null;
		if(player != null) {
			world = player.worldObj;
		}

		int type = buff.readInt();

		switch(type) {
		case SPAWN_HOOK: {
			int playerID = buff.readInt();
			int hookID = buff.readInt();

			if(world != null) {
				Entity playerEntity = world.getEntityByID(playerID);
				Entity hookEntity = world.getEntityByID(hookID);

				if(playerEntity instanceof EntityPlayer && hookEntity instanceof ThrowingEntityFishHook) {
					((EntityPlayer) playerEntity).fishEntity = (ThrowingEntityFishHook) hookEntity;
					((ThrowingEntityFishHook) hookEntity).field_146042_b = (EntityPlayer) playerEntity;
				}
			}
			break;
		}
		case HOOK_FISH: {
			int entityID = buff.readInt();
			int hookID = buff.readInt();

			if(world != null) {
				Entity entity = world.getEntityByID(entityID);
				Entity hookEntity = world.getEntityByID(hookID);

				if(hookEntity instanceof ThrowingEntityFishHook) {
					((ThrowingEntityFishHook) hookEntity).field_146043_c = entity;
					((ThrowingEntityFishHook) hookEntity).strain = 0;
				}
			}
			break;
		}
		/*
		case BREAK_FISHING_ROD: {
			int itemID = buff.readInt();
			if(player != null) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);

				Item item = Item.getItemById(itemID);

				if(item instanceof ItemHookedFishingRod) {
					((ItemHookedFishingRod)item).givePlayerBrokenScraps(player);
				}
			}
			break;
		}
		*/
		case SET_INVENTORY_ITEM: {
			int slot = buff.readInt();
			ItemStack item = null;
			try {
				item = buff.readItemStackFromBuffer();
			}
			catch (IOException e) {
				System.out.println("[JAFF] Caught an IOException! Uh oh!");
				e.printStackTrace();
			}

			if(player != null) {
				player.inventory.setInventorySlotContents(slot, item);
			}
		}
		default:
			//Do nothing
		}

		//Don't return anything.
		return null;
	}
}
