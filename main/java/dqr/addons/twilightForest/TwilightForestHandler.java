package dqr.addons.twilightForest;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import twilightforest.TFFeature;
import twilightforest.TFGenericPacketHandler;
import twilightforest.TwilightForestMod;
import twilightforest.entity.EntityTFIceSnowball;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.boss.EntityTFHydraHead;
import twilightforest.entity.boss.EntityTFHydraMortar;
import twilightforest.entity.boss.EntityTFHydraPart;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.boss.EntityTFThrownAxe;
import twilightforest.entity.boss.EntityTFThrownPick;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.boss.HydraHeadContainer;
import twilightforest.world.ChunkProviderTwilightForest;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.world.WorldProviderTwilightForest;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import dqr.DQR;
import dqr.api.event.DqrBreakMGTEvent;
import dqr.api.event.DqrCanDespawnEvent;
import dqr.api.event.DqrExplosionEvent;
import dqr.api.event.DqrMagicCoolTimeEvent;
import dqr.api.event.DqrMagicForceDeadEvent;
import dqr.api.event.DqrMobPrizeEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.mobEntity.DqmMobBase;

public class TwilightForestHandler {

	/*
    @SubscribeEvent
    public void onLivingDeathEvent(LivingSpawnEvent.CheckSpawn event)
    {
    	//System.out.println("LivingSpawnEvent.CheckSpawn");
    	if(!(event.entity instanceof DqmMobBase))
    	{
    		System.out.println("CheckSpawn" + event.entity.getCommandSenderName());
    	}
    }
    */

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
    	//System.out.println("LivingSpawnEvent.SpecialSpawn");
    	if(event.entity instanceof EntityTFHydra)
    	{
    		EntityTFHydra mob = (EntityTFHydra)event.entity;
    		if(mob.getMaxHealth() < 400)
    		{

    			try {
					Field targetField1 = mob.getClass().getDeclaredField("MAX_HEALTH");
					targetField1.setAccessible(true);
					targetField1.set(null, (int)(DQR.funcMob.getCalcHP2(250) * 4));

					Field targetField2 = mob.getClass().getDeclaredField("HEAD_MAX_DAMAGE");
					targetField2.setAccessible(true);
					targetField2.set(null, (int)(DQR.funcMob.getCalcPW(250)));
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

	    		mob.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000); // max health
	    		mob.setHealth(mob.getMaxHealth());

	    		HydraHeadContainer[] hc = mob.hc;
	    		for(int cnt = 0; cnt < hc.length; cnt++)
	    		{
	    			try {
	    				//System.out.println("TEST Hydra : " + cnt);
						Field targetField1 = hc[cnt].getClass().getDeclaredField("FLAME_DAMAGE");
						targetField1.setAccessible(true);
						targetField1.set(null, (int)DQR.funcMob.getCalcPW(130.0D));

						Field targetField2 = hc[cnt].getClass().getDeclaredField("BITE_DAMAGE");
						targetField2.setAccessible(true);
						targetField2.set(null, (int)DQR.funcMob.getCalcPW(140.0D));

						Field targetField3 = hc[cnt].getClass().getDeclaredField("FLAME_BREATH_TRACKING_SPEED");
						targetField3.setAccessible(true);
						targetField3.set(null, 0.1D);

					} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
	    		}
    		}
    	}/*
    	else if(event.entity instanceof EntityTFFallingIce)
    	{
    		EntityTFFallingIce mob = (EntityTFFallingIce)event.entity;
			try {
				Field targetField1 = mob.getClass().getDeclaredField("hurtAmount");
				targetField1.setAccessible(true);
				targetField1.set(null, (float)(DQR.funcMob.getCalcPW(100)));

				Field targetField2 = mob.getClass().getDeclaredField("hurtMax");
				targetField2.setAccessible(true);
				targetField2.set(null, (int)(DQR.funcMob.getCalcPW(999)));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}
    	else if(event.entity instanceof EntityTFHydraMortar)
    	{
			try {
				Field targetField1 = event.entity.getClass().getDeclaredField("DIRECT_DAMAGE");
				//targetField1.setAccessible(true);
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				modifiersField.setInt(targetField1,
						targetField1.getModifiers() & ~Modifier.PRIVATE & ~Modifier.STATIC & ~Modifier.FINAL);
				targetField1.set(null, (int)DQR.funcMob.getCalcPW(90));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}else if(event.entity instanceof EntityTFThrownAxe)
    	{
			try {
				Field targetField1 = event.entity.getClass().getDeclaredField("PROJECTILE_DAMAGE");
				//targetField1.setAccessible(true);
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				modifiersField.setInt(targetField1,
						targetField1.getModifiers() & ~Modifier.PRIVATE & ~Modifier.STATIC & ~Modifier.FINAL);
				targetField1.setFloat(null, (float)DQR.funcMob.getCalcPW(60));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}else if(event.entity instanceof EntityTFIceSnowball)
    	{
			try {
				Field targetField1 = event.entity.getClass().getDeclaredField("DAMAGE");

				//targetField1.setAccessible(true);
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				modifiersField.setInt(targetField1,
						targetField1.getModifiers() & ~Modifier.PRIVATE & ~Modifier.STATIC & ~Modifier.FINAL);
				targetField1.set(null, (int)DQR.funcMob.getCalcPW(88));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}else if(event.entity instanceof EntityTFThrownPick)
    	{
			try {
				Field targetField1 = event.entity.getClass().getDeclaredField("PROJECTILE_DAMAGE");
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				//targetField1.setAccessible(true);
				//targetField1.setAccessible(true);
				modifiersField.setAccessible(true);

				modifiersField.setInt(targetField1,
						targetField1.getModifiers() & ~Modifier.PRIVATE & ~Modifier.STATIC & ~Modifier.FINAL);

				targetField1.setFloat(null, (float)DQR.funcMob.getCalcPW(40));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}
*/


    	 EnumDqrTFMonster mobParam = getEnumTFMonsterFromEntity(event.entity);


    	 if(mobParam != null && !(event.entity instanceof EntityTFHydra) && event.entity instanceof EntityLivingBase)
    	 {
    		 EntityLivingBase ent = (EntityLivingBase)event.entity;
     		if(ent.getMaxHealth() < mobParam.getCheckhp())
     		{
     			/*
     	    	 if(mobParam != null)
     	    	 {
     	    		 System.out.println("TestParam : " + mobParam.getName());
     	    	 }
     	    	 */

     			if(mobParam.getMaxhp() > 0)
     			{
     				ent.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(DQR.funcMob.getCalcHP2(mobParam.getMaxhp())); // max health
     				ent.setHealth(ent.getMaxHealth());
     			}

     			if(mobParam.getAttack() > 0 && ent.getEntityAttribute(SharedMonsterAttributes.attackDamage) != null)
     			{
     				//System.out.println("TestParam : " + mobParam.getName() + " / " + ent.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue());
     				ent.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(DQR.funcMob.getCalcPW(mobParam.getAttack())); // attack damage

     				//System.out.println("TestParam : " + mobParam.getName() + " / " + ent.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() + " / " + DQR.funcMob.getCalcPW(mobParam.getAttack()));
     			}
     			//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D); // attack damage
     			//System.out.println("TEST : " + ent.getCommandSenderName());
     		}
    	 }

    }

	@SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event) {


    	if(event.entityLiving instanceof EntityTFMinoshroom)
    	{
    		EntityTFMinoshroom boss = (EntityTFMinoshroom)event.entityLiving;
    		//System.out.println("TEST1");
    		if(boss.isCharging())
    		{
    			//System.out.println("TEST2");
    			RegistryNamespaced rn = Block.blockRegistry;

    			boolean[][] breakFlg = new boolean[5][5];
    			//-2:0  -1:1  0:2  1:3  2:4
    			float face = DQR.func.getFace(boss, true);

    			double fixX = boss.posX < 0 ? -0.9D : 0.9D;
    			double fixZ = boss.posZ < 0 ? -0.9D : 0.9D;

    			int posX = (int)(boss.posX + fixX);
    			int posY = (int)(boss.posY);
    			int posZ = (int)(boss.posZ + fixZ);

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

    			//System.out.println("TEST0 : " + posX + " : " + posY + " : " + posZ);
    			for(int cntY = 0; cntY < 3; cntY++)
    			{
    				for(int cntX = -2; cntX <= 2; cntX++)
    				{
    					for(int cntZ = -2; cntZ <= 2 ; cntZ++)
    					{
    						if(breakFlg[cntX + 2][cntZ + 2])
    						{
    							//System.out.println("TEST0 : " + posX + " : " + posY + " : " + posZ);
    							//if(cntY == 0)System.out.println("TEST1 : " + (cntX + 2) + " / " + (cntZ + 2) + "[" + (posX + cntX) + " / " + (posZ + cntZ) + "] (" + face + ")");
    							World world = boss.worldObj;
    							Block block = world.getBlock(posX + cntX, posY + cntY, posZ + cntZ);
    							if(block.getBlockHardness(world, posX + cntX, posY + cntY, posZ + cntZ) >= 0)
    							{
    								if(rn.getNameForObject(block).indexOf("TwilightForest:") != 0)
    								{
    									world.func_147480_a(posX + cntX, posY + cntY, posZ + cntZ, true);
    								}
    							}
    						}
    					}
    				}
    			}

    			/*
    			for(int cntX = -2; cntX <= 2; cntX++)
    			{
        			for(int cntZ = -2; cntZ <= 2; cntZ++)
        			{
            			for(int cntY = 0; cntY <= 2; cntY++)
            			{
            				//System.out.println("TEST3");
		    				Block block1 = boss.worldObj.getBlock((int)boss.posX + cntX, (int)boss.posY + cntY, (int)boss.posZ + cntZ);

		    				if(rn.getNameForObject(block1).indexOf("TwilightForest:") != 0)
		    				{
		    					//System.out.println("TEST4");
		    					boss.worldObj.func_147480_a((int)boss.posX + cntX, (int)boss.posY + cntY, (int)boss.posZ + cntZ, true);
		    				}

            			}
        			}
    			}
    			*/
    		}
    	}
	}

    @SubscribeEvent
    public void onLivingAttackEvent(LivingHurtEvent event)
    {
    	//if(event.source.getEntity() instanceof EntityTFHydraMortar || event.source.getSourceOfDamage() instanceof EntityTFHydraMortar)
    	if(event.source.damageType.equalsIgnoreCase("FIREBALL") && event.source.getSourceOfDamage() instanceof EntityTFHydraHead)
    	{
    		//event.source.getEntity().
    		//System.out.println("TestParam 1");
    		event.ammount = (float)DQR.funcMob.getCalcPW(90);
    	}else if(event.source.getEntity() instanceof EntityTFThrownAxe || event.source.getSourceOfDamage() instanceof EntityTFThrownAxe)
    	{
    		event.ammount = (float)DQR.funcMob.getCalcPW(90);
    		//System.out.println("TestParam 2");
    	}else if(event.source.getEntity() instanceof EntityTFIceSnowball || event.source.getSourceOfDamage() instanceof EntityTFIceSnowball)
    	{
    		event.ammount = (float)DQR.funcMob.getCalcPW(123);
    		//System.out.println("TestParam 3");
    	}else if(event.source.getEntity() instanceof EntityTFThrownPick || event.source.getSourceOfDamage() instanceof EntityTFThrownPick)
    	{
    		event.ammount = (float)DQR.funcMob.getCalcPW(111);
    		//System.out.println("TestParam 4");
    	}else if(event.source.getEntity() instanceof EntityTFHydraMortar || event.source.getSourceOfDamage() instanceof EntityTFHydraMortar)
    	{
    		event.ammount = (float)DQR.funcMob.getCalcPW(99);
    		//System.out.println("TestParam 4");
    	}
    }

    @SubscribeEvent
    public void onLivingAttackEvent(LivingAttackEvent event)
    {

		if(event.entityLiving instanceof EntityPlayer)
		{
			//System.out.println("onLivingAttackEvent!!!!!!!!!!!!!!!");
			EntityPlayer ep = (EntityPlayer)event.entityLiving;
	    	if(event.source.getEntity() instanceof EntityTFNaga)
	    	{
		    	ep.addPotionEffect(new PotionEffect(DQPotionMinus.potionPoison.id, 10 * 20, 4));
	    	}


		}else if(event.entityLiving instanceof EntityMob)
		{
			EntityPlayer ep = null;
			if(event.source.getEntity() instanceof EntityPlayer)
			{
				ep = (EntityPlayer)event.source.getEntity();
			}else if(event.source.getSourceOfDamage() instanceof EntityPlayer)
			{
				ep = (EntityPlayer)event.source.getSourceOfDamage();
			}
		}

    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent event)
    {
    	//System.out.println("TEST0");
		MagicEntity magic = null;
		EntityPlayer ep = null;
		if(event.entityLiving instanceof EntityPlayer)
		{
			ep = (EntityPlayer)event.entityLiving;
			//[dqr.addons.twilightForest.TwilightForestHandler:onLivingHurtEvent:311]: onLivingHurtEvent!!!!!!!!!!!!!!!fireball / Carminite Ghastguard
			//System.out.println("onLivingHurtEvent!!!!!!!!!!!!!!!" + event.source.getDamageType() + " / " + event.source.getEntity().getCommandSenderName());
		}


		if(event.source.getEntity() instanceof EntityLargeFireball)
		{
			if(ep != null)
			{
				event.ammount = 200;
			}else
			{
				event.ammount = 100;
			}
		}else
		{
			if(event.source.getDamageType().equalsIgnoreCase("fireball"))
	    	{
	    		//System.out.println("EntityFireball!!!!!!!!!!!!!!!");
	    		//EntityFireball fireBall = (EntityFireball)event.source.getEntity();
	    		if(event.source.getEntity() instanceof EntityTFMiniGhast)
	    		{
	    			//System.out.println("EntityTFMiniGhast!!!!!!!!!!!!!");
	    			event.ammount = 100;
	    		}else if(event.source.getEntity() instanceof EntityTFUrGhast)
	    		{
	    			//System.out.println("EntityTFTowerGhast!!!!!!!!!!!!!");
	    			event.ammount = 200;
	    		}else if(event.source.getEntity() instanceof EntityTFTowerGhast)
	    		{
	    			//System.out.println("EntityTFTowerGhast!!!!!!!!!!!!!");
	    			event.ammount = 100;
	    		}else if(event.source.getEntity() instanceof EntityTFHydraHead)
	    		{
	    			//System.out.println("EntityTFTowerGhast!!!!!!!!!!!!!");
	    			event.ammount = (float)DQR.funcMob.getCalcPW(90);
	    		}
	    	}
		}

		if(event.source.getEntity() instanceof MagicEntity)
		{
			magic = (MagicEntity)event.source.getEntity();
		}

		if(event.entityLiving instanceof EntityTFMinoshroom)
		{
			if(magic != null)
			{
				event.ammount = (float)(magic.getDamage() / 2);
			}
		}else if(event.entityLiving instanceof EntityTFKnightPhantom)
		{
			if(magic != null)
			{
				event.ammount = (float)(magic.getDamage() / 4);
			}
		}else if(event.entityLiving instanceof EntityTFUrGhast)
		{
			if(magic != null)
			{
				event.entityLiving.heal(event.ammount / 2);
				event.ammount = 0;

			}
		}else if(event.entityLiving instanceof EntityTFSnowQueen)
		{

			//System.out.println("TEST1");
			if(event.source.getEntity() instanceof DqmMobBase || event.source.getSourceOfDamage() instanceof DqmMobBase)
			{
				event.ammount = 0;
			}

			if(magic != null && magic instanceof MagicEntityHyado)
			{
				event.entityLiving.heal(event.ammount * 2);
				event.ammount = 0;
			}
			//System.out.println("TEST_XXXXXXXXXX");
			//絶対零度の雨
			Random rand = new Random();
			MagicEntityHyado[] hyado = null;
			hyado = new MagicEntityHyado[32];
			//System.out.println("TEST3");
			for(int cnt = 0;cnt < 32; cnt++)
			{
				hyado[cnt] = new MagicEntityHyado(event.entityLiving.worldObj, event.entityLiving, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)hyado[cnt].setWorldFlg(4);
			}

			if(hyado != null)
			{
				//System.out.println("TEST4 : " + hyado.length);
				int attackDam = 450;

				//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

	    		for(int cnt = 0; cnt < hyado.length; cnt++)
	    		{
	    			//System.out.println("TEST5 : " + cnt);
	    			hyado[cnt].setDamage(attackDam);
	    			hyado[cnt].setFallSpeed(0.3F);
	    			hyado[cnt].shootingEntity = event.entityLiving;
		        	if(!event.entityLiving.worldObj.isRemote)
		        	{
		        		//magic[cnt].setWorldFlg(this.isSneaking());
		        		event.entityLiving.worldObj.spawnEntityInWorld(hyado[cnt]);
		        	}
	    		}
			}
		}
    	//if(event.entityLiving)
    }

    @SubscribeEvent
    public void onBreakMGTEvent(DqrExplosionEvent event)
    {
    	List<ChunkPosition> chunkPositions = event.getAffectedBlocks();

    	if(event.explodeSource instanceof EntityPlayer)
    	{
    		EntityPlayer ep = (EntityPlayer)event.explodeSource;
	    	for(int cnt = 0; cnt < chunkPositions.size(); cnt++)
	    	{
	    		ChunkPosition pos = chunkPositions.get(cnt);
	    		//System.out.println("TEST : " + pos.chunkPosX + " / " + pos.chunkPosY + " / " + pos.chunkPosZ + " / ");
	        	if(!ep.capabilities.isCreativeMode &&
	        	   isAreaProtected(event.worldObj, ep, pos.chunkPosX, pos.chunkPosY, pos.chunkPosZ) &&
	               isBlockProtectedFromBreaking(event.worldObj, pos.chunkPosX, pos.chunkPosY, pos.chunkPosZ))
	        	{
	        		//System.out.println("TFAddon : TEST2");
	        		//event.setCanceled(true);
	        		event.setExplode(false);
	        		return;
	        	}
	    	}
    	}
    }

    @SubscribeEvent
    public void onBreakMGTEvent(DqrBreakMGTEvent.unbreakCheck event)
    {
    	//System.out.println("TFAddon : TEST1");
    	if(!event.ep.capabilities.isCreativeMode &&
    		isAreaProtected(event.ep.worldObj, event.ep, event.blockX, event.blockY, event.blockZ) &&
    		isBlockProtectedFromBreaking(event.ep.worldObj, event.blockX, event.blockY, event.blockZ))
    	{
    		//System.out.println("TFAddon : TEST2");
    		event.setCanceled(true);
    		return;
    	}
    }

	private boolean isAreaProtected(World world, EntityPlayer player, int x, int y, int z) {
		if (world.getGameRules().getGameRuleBooleanValue(TwilightForestMod.ENFORCED_PROGRESSION_RULE) && world.provider instanceof WorldProviderTwilightForest) {

			ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)world.provider).getChunkProvider();

			if (chunkProvider != null && chunkProvider.isBlockInStructureBB(x, y, z)) {
				// what feature is nearby?  is it one the player has not unlocked?
				TFFeature nearbyFeature = ((TFWorldChunkManager)world.provider.worldChunkMgr).getFeatureAt(x, z, world);

				if (!nearbyFeature.doesPlayerHaveRequiredAchievement(player) && chunkProvider.isBlockProtected(x, y, z)) {

					// send protection packet
					StructureBoundingBox sbb = chunkProvider.getSBBAt(x, y, z);
					sendAreaProtectionPacket(world, x, y, z, sbb);

					// send a hint monster?
					nearbyFeature.trySpawnHintMonster(world, player, x, y, z);

					return true;
				}
			}
		}
		return false;
	}

	private boolean isBlockProtectedFromBreaking(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);

		// graves are okay!
		if (block.getUnlocalizedName().equals("tile.openblocks.grave")) {
			return false;
		}

		return true;
	}

	private void sendAreaProtectionPacket(World world, int x, int y, int z, StructureBoundingBox sbb) {
		// send packet
		FMLProxyPacket message = TFGenericPacketHandler.makeAreaProtectionPacket(sbb, x, y, z);

		NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.provider.dimensionId, x, y, z, 64);

		TwilightForestMod.genericChannel.sendToAllAround(message, targetPoint);
	}

    @SubscribeEvent
    public void onCalcCoolTimeDecreaseEvent(DqrMagicCoolTimeEvent.calcCoolTimeDecrease event)
    {
    	if(event.entity instanceof EntityPlayer && event.entity.dimension == TwilightForestMod.dimensionID)
    	{
    		EntityPlayer ep = (EntityPlayer)event.entity;
        	if(!ep.capabilities.isCreativeMode &&
            	isAreaProtected(ep.worldObj, ep, (int)ep.posX, (int)ep.posY, (int)ep.posZ) &&
            	isBlockProtectedFromBreaking(ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ))
        	{
        		//System.out.println("TFAddon : TEST2");
        		event.setFixDamage(0);
        	}else
        	{
        		event.setFixDamage(event.getFixDamage() / 2);
        	}

    	}
	}

    @SubscribeEvent
    public void onMagicForceDeadEvent(DqrMagicForceDeadEvent event)
    {
        List listX = event.magic.worldObj.getEntitiesWithinAABBExcludingEntity(
        		event.magic, event.magic.boundingBox.addCoord(event.magic.motionX, event.magic.motionY, event.magic.motionZ).
        		expand(3.0D, 3.0D, 3.0D));
        if (listX != null && !listX.isEmpty())
        {
        	for (int n = 0 ; n < listX.size() ; n++)
        	{
        		Entity target = (Entity)listX.get(n);

        		if(target instanceof EntityTFHydra || target instanceof EntityTFHydraPart)
        		{
        			event.setCanceled(true);
        		}

        		if(target instanceof EntityTFSnowQueen && !(event.magic instanceof MagicEntityMera) &&
        												  !(event.magic instanceof MagicEntityMerami) &&
        												  !(event.magic instanceof MagicEntityMerazoma) &&
        												  !(event.magic instanceof MagicEntityMeragaia) &&
        												  !(event.magic instanceof MagicEntityHyado))
        		{
        			event.setCanceled(true);
        		}

        		/*
        		if(!(target instanceof EntityPlayer) && event.magic.shootingEntity instanceof EntityTFSnowQueen)
        		{
        			event.setCanceled(true);
        		}
        		*/
        	}
        }
    }


    @SubscribeEvent
    public void onDqrMobPrizeEvent(DqrMobPrizeEvent event)
    {
    	EnumDqrTFMonster ret = null;

    	EnumDqrTFMonster[] params = EnumDqrTFMonster.values();

    	for(int cnt = 0; cnt < params.length; cnt++)
    	{
    		EnumDqrTFMonster param = params[cnt];

    		//System.out.println("className : " + par1.getClass().getName());
    		//if(par1.getClass().getName().equalsIgnoreCase(param.getName()))
    		if(event.entityLiving.getClass() == param.getCls())
    		{
    			//System.out.println("className : " + event.entityLiving.getClass().getName() + " / " + param.getExp() + " / " + param.getGold());
    			event.setExp(DQR.funcMob.getCalcEXP(param.getExp()));
    			event.setGold(DQR.funcMob.getCalcGOLD(param.getGold()));
    			break;
    		}
    	}
    }


    @SubscribeEvent
    public void onCanDespawnEvent(DqrCanDespawnEvent event)
    {
    	if(event.entityLiving instanceof EntityTFSnowQueen || event.entityLiving instanceof EntityTFHydraPart)
    	{
    		event.setResultCode(0);
    	}
    }

    public EnumDqrTFMonster getEnumTFMonsterFromEntity(Entity par1)
    {
    	EnumDqrTFMonster ret = null;

    	EnumDqrTFMonster[] params = EnumDqrTFMonster.values();

    	for(int cnt = 0; cnt < params.length; cnt++)
    	{
    		EnumDqrTFMonster param = params[cnt];

    		//System.out.println("className : " + par1.getClass().getName());
    		//if(par1.getClass().getName().equalsIgnoreCase(param.getName()))
    		if(par1.getClass() == param.getCls())
    		{
    			//System.out.println("className : " + par1.getClass().getName());
    			ret = param;
    			break;
    		}
    	}

    	return ret;
    }
}
