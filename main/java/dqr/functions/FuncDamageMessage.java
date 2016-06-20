package dqr.functions;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import dqr.DQR;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.mobEntity.DqmMobBase;

public class FuncDamageMessage {
	public FuncDamageMessage()
	{

	}

	public void message(EntityLivingBase elb, DamageSource p_94547_1_, float p_94547_2_, float p_94547_3_)
	{
		//System.out.println("DEBUG:" + p_94547_1_.getSourceOfDamage().getCommandSenderName());
		if(elb instanceof EntityPlayer)
		{

			//System.out.println("通過");
			EntityPlayer ep = (EntityPlayer)elb;
			float damageVal = p_94547_3_;

			if(p_94547_1_.getEntity() != null)
			{
				if(!ep.worldObj.isRemote)
				{
					if(!p_94547_1_.isProjectile())
					{
						if(p_94547_1_.getEntity() instanceof MagicEntity)
						{
							MagicEntity mob = (MagicEntity)p_94547_1_.getEntity();

							if(mob.shootingEntity != null)
							{
								if(mob.shootingEntity instanceof DqmMobBase)
								{
									DqmMobBase mob2 = (DqmMobBase)mob.shootingEntity;
									if (DQR.conf.damageDigits == 1)
									{
										ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob2.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
									}else
									{
										ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob2.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
									}
								}else
								{

									if (DQR.conf.damageDigits == 1)
									{
										ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
									}else
									{
										ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
									}
								}

							}else
							{

								if (DQR.conf.damageDigits == 1)
								{
									ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
								}else
								{
									ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
								}
							}
							//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
						}
						else if(p_94547_1_.getEntity() instanceof DqmMobBase)
						{
							DqmMobBase mob = (DqmMobBase)p_94547_1_.getEntity();
							if (DQR.conf.damageDigits == 1)
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
							}else
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
							}
							//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
						}else
						{
							if (DQR.conf.damageDigits == 1)
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {p_94547_1_.getEntity().getCommandSenderName(), damageVal}));
							}else
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {p_94547_1_.getEntity().getCommandSenderName(), (int)damageVal}));
							}
							//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { p_94547_1_.getEntity().getCommandSenderName(), damageVal}));
						}
					}else
					{
						if(p_94547_1_ != null && p_94547_1_.getSourceOfDamage() != null)
						{
							if(p_94547_1_.getEntity() instanceof MagicEntity)
							{
								MagicEntity mob = (MagicEntity)p_94547_1_.getEntity();

								if(mob.shootingEntity != null)
								{
									if(mob.shootingEntity instanceof DqmMobBase)
									{
										DqmMobBase mob2 = (DqmMobBase)mob.shootingEntity;
										if (DQR.conf.damageDigits == 1)
										{
											ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob2.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
										}else
										{
											ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob2.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
										}
									}else
									{

										if (DQR.conf.damageDigits == 1)
										{
											ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
										}else
										{
											ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
										}
									}

								}else
								{

									if (DQR.conf.damageDigits == 1)
									{
										ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
									}else
									{
										ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getCommandSenderName() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
									}
								}
								//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
							}
							else if(p_94547_1_.getSourceOfDamage() instanceof DqmMobBase)
							{
								DqmMobBase mob = (DqmMobBase)p_94547_1_.getSourceOfDamage();
								if (DQR.conf.damageDigits == 1)
								{
									ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
								}else
								{
									ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), (int)damageVal}));
								}
								//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS(), damageVal}));
							}else
							{
								if (DQR.conf.damageDigits == 1)
								{
									ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2.txt",new Object[] {p_94547_1_.getSourceOfDamage().getCommandSenderName(), damageVal}));
								}else
								{
									ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] {p_94547_1_.getSourceOfDamage().getCommandSenderName(), (int)damageVal}));
								}
								//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { p_94547_1_.getSourceOfDamage().getCommandSenderName(), damageVal}));
							}
						}
					}
				}

			}else
			{
				//ChatComponentTranslation test = new ChatComponentTranslation("msg.fromDamage2.", new Object[] {});
				//test.getUnformattedText()

				if(DQR.func.hasChatKey("msg.fromDamage." + p_94547_1_.getDamageType() + ".txt"))
				{
					if (DQR.conf.damageDigits == 1)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage2." + p_94547_1_.getDamageType() + ".txt",new Object[] {damageVal}));
					}else
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage." + p_94547_1_.getDamageType() + ".txt",new Object[] {(int)damageVal}));
					}
				}else
				{
					if (DQR.conf.damageDigits == 1)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.fromDamageNo2.txt",new Object[] {p_94547_1_.getDamageType(), damageVal}));
					}else
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.fromDamageNo.txt",new Object[] {p_94547_1_.getDamageType(), (int)damageVal}));
					}
				}
				//ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage." + p_94547_1_.getDamageType() + ".txt",new Object[] {damageVal}));
			}
		}
	}
}
