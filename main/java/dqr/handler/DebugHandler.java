package dqr.handler;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;

public class DebugHandler {

	@SubscribeEvent
	public void onSpecialBoostDamageEvent(PlaceEvent event) {

		//180以上になったら -360する

		double fixX = event.player.posX < 0 ? -0.9D : 0.9D;
		double fixZ = event.player.posZ < 0 ? -0.9D : 0.9D;

		int posX = (int)(event.player.posX + fixX);
		int posY = (int)(event.player.posY);
		int posZ = (int)(event.player.posZ + fixZ);

		if(event.player.isSneaking())System.out.println("TEST-X : " + posX + "/" + posZ + "  |  " + event.x + "/" + event.z);
		//System.out.println("TEST0 : " + event.x + " / " + event.y + " / " + event.z + "(" + DQR.func.getFace(event.player, true) + ")");
		//System.out.println("TEST2 : " + event.player.rotationYaw + " / " + DQR.func.getFace(event.player, true));
		/*
		System.out.println("TEST1 : " + Block.blockRegistry.getNameForObject(event.block));
		System.out.println("TEST2 : " + event.player.rotationYaw + " / " + DQR.func.getFace(event.player, true));
		System.out.println("TEST3 : " + Block.blockRegistry.getNameForObject(event.block).indexOf("TwilightForest:"));
		*/
	}

	/*
	@SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event) {
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;

			System.out.println("TEST1 : " + ep.serverPosX + " / " + ep.serverPosZ + " : " + ep.worldObj);
		}
	}
	*/

	@SubscribeEvent(priority=EventPriority.HIGH)
	public void onSpecialBoostDamageEvent(BreakEvent event) {
	//
		if(!event.getPlayer().isSneaking()){return;}
		//if(event.getPlayer().worldObj.isRemote){return;}
		boolean[][] breakFlg = new boolean[5][5];
		//-2:0  -1:1  0:2  1:3  2:4
		float face = DQR.func.getFace(event.getPlayer(), true);

		double fixX = event.getPlayer().posX < 0 ? -0.9D : 0.9D;
		double fixZ = event.getPlayer().posZ < 0 ? -0.9D : 0.9D;

		int posX = (int)(event.getPlayer().posX + fixX);
		int posY = (int)(event.getPlayer().posY);
		int posZ = (int)(event.getPlayer().posZ + fixZ);

		for(int cnt1 = 0; cnt1 < 5; cnt1++)
		{
			for(int cnt2 = 0; cnt2 < 5; cnt2++)
			{
				breakFlg[cnt1][cnt2] = false;
			}
		}


		if(face == 0.0f)
		{
			breakFlg[1][4] = true;
			breakFlg[2][4] = true;
			breakFlg[3][4] = true;
			breakFlg[1][3] = true;
			breakFlg[2][3] = true;
			breakFlg[3][3] = true;
		}else if(face == 0.5f)
		{
			breakFlg[0][4] = true;
			breakFlg[1][4] = true;
			breakFlg[0][3] = true;
			breakFlg[1][3] = true;
			breakFlg[2][3] = true;
			breakFlg[1][2] = true;
		}else if(face == 1.0f)
		{
			breakFlg[0][3] = true;
			breakFlg[1][3] = true;
			breakFlg[0][2] = true;
			breakFlg[1][2] = true;
			breakFlg[0][1] = true;
			breakFlg[1][1] = true;
		}else if(face == 1.5f)
		{
			breakFlg[1][2] = true;
			breakFlg[0][1] = true;
			breakFlg[1][1] = true;
			breakFlg[2][1] = true;
			breakFlg[0][0] = true;
			breakFlg[1][0] = true;
		}else if(face == 2.0f)
		{
			breakFlg[1][1] = true;
			breakFlg[2][1] = true;
			breakFlg[3][1] = true;
			breakFlg[1][0] = true;
			breakFlg[2][0] = true;
			breakFlg[3][0] = true;
		}else if(face == 2.5f)
		{
			breakFlg[3][2] = true;
			breakFlg[3][0] = true;
			breakFlg[2][1] = true;
			breakFlg[3][1] = true;
			breakFlg[4][1] = true;
			breakFlg[4][0] = true;
		}else if(face == 3.0f)
		{
			breakFlg[3][3] = true;
			breakFlg[4][3] = true;
			breakFlg[3][2] = true;
			breakFlg[4][2] = true;
			breakFlg[3][1] = true;
			breakFlg[4][1] = true;
		}else if(face == 3.5f)
		{
			breakFlg[3][4] = true;
			breakFlg[4][4] = true;
			breakFlg[2][3] = true;
			breakFlg[3][3] = true;
			breakFlg[4][3] = true;
			breakFlg[3][2] = true;
		}

		System.out.println("TEST0 : " + posX + " : " + posY + " : " + posZ);
		for(int cntY = 0; cntY < 2; cntY++)
		{
			for(int cntX = -2; cntX <= 2; cntX++)
			{
				for(int cntZ = -2; cntZ <= 2 ; cntZ++)
				{
					if(breakFlg[cntX + 2][cntZ + 2])
					{
						//System.out.println("TEST0 : " + posX + " : " + posY + " : " + posZ);
						if(cntY == 0)System.out.println("TEST1 : " + (cntX + 2) + " / " + (cntZ + 2) + "[" + (posX + cntX) + " / " + (posZ + cntZ) + "] (" + face + ")");
						World world = event.getPlayer().worldObj;
						Block block = world.getBlock(posX + cntX, posY + cntY, posZ + cntZ);
						if(block.getBlockHardness(world, posX + cntX, posY + cntY, posZ + cntZ) >= 0)
						{
							world.func_147480_a(posX + cntX, posY + cntY, posZ + cntZ, true);
						}
					}
				}
			}
		}
		/*.isExplosion
		if(event.entityLiving instanceof EntityPlayer)
		{
			System.out.println("TEST1 : " + event.source.isExplosion());
			System.out.println("TEST2 : " + event.source.damageType);
			System.out.println("TEST3 : " + event.source.getDamageType());


				event.ammount = 0;
		}
		*/

	}

	@SubscribeEvent(priority=EventPriority.HIGH)
	public void onSpecialBoostDamageEvent(LivingHurtEvent event)
	{

	}
}
