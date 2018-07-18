package dqr.items.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.functions.FuncPetHaigou;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmItemMagicHaigou extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicHaigou(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);

    }

    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
    	//System.out.println("line1");
    	NBTTagCompound haigouPet1 = ExtendedPlayerProperties3.get(p_77659_3_).getHaigouPet1();
		NBTTagCompound haigouPet2 = ExtendedPlayerProperties3.get(p_77659_3_).getHaigouPet2();

		if(!p_77659_3_.worldObj.isRemote)
		{
			if(haigouPet1 != null && !haigouPet1.hasNoTags())
			{
				DQR.func.doAddChatMessageFix(p_77659_3_, new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {haigouPet1.getString("PetName"), haigouPet1.getInteger("JobLv_0")}));
			}else
			{
				DQR.func.doAddChatMessageFix(p_77659_3_, new ChatComponentTranslation("dqm.iteminfo.petHaigou01",new Object[] {}));
			}

			if(haigouPet2 != null && !haigouPet2.hasNoTags())
			{
				DQR.func.doAddChatMessageFix(p_77659_3_, new ChatComponentTranslation("dqm.iteminfo.petHaigou2",new Object[] {haigouPet2.getString("PetName"), haigouPet2.getInteger("JobLv_0")}));
			}else
			{
				DQR.func.doAddChatMessageFix(p_77659_3_, new ChatComponentTranslation("dqm.iteminfo.petHaigou02",new Object[] {}));
			}

			//System.out.println("" + haigouPet1.getString("PetBaseName") + " / " + haigouPet2.getString("PetBaseName"));
			if(haigouPet1 != null && haigouPet2 != null && DQR.enumGetter.getEnumDqmPetHaigouSPFromName(haigouPet1.getString("PetMobName"), haigouPet2.getString("PetMobName")) != null)
			{
				DQR.func.doAddChatMessageFix(p_77659_3_, new ChatComponentTranslation("dqm.iteminfo.petHaigou3",new Object[] {}));
			}

			if((haigouPet1 != null && !haigouPet1.hasNoTags())|| (haigouPet2 != null && !haigouPet2.hasNoTags()))
			{
				DQR.func.doAddChatMessageFix(p_77659_3_, new ChatComponentTranslation("dqm.iteminfo.petHaigou4",new Object[] {}));
			}
		}
        return p_77659_1_;
    }

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int par4, int par5, int par6, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		//System.out.println("line2");
		if(!ep.worldObj.isRemote)
		{
			if(this.getDamage(par1ItemStack) == 0)
			{
				par1ItemStack.damageItem(50, ep);
				FuncPetHaigou func = new FuncPetHaigou();
				func.doHaogou(ep, par3World, par4, par5, par6, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
			}else
			{
        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
			}
		}

		return true;
    }

}
