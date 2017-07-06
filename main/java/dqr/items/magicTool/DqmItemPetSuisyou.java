package dqr.items.magicTool;

import java.util.List;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.items.base.DqmItemMagicToolBase;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmItemPetSuisyou extends DqmItemMagicToolBase{
    private EnumDqmMagic enumMagic;

	public DqmItemPetSuisyou()
	{
		super();
	}

    public DqmItemPetSuisyou(EnumDqmMagic par4)
    {
    	super();
        this.enumMagic = par4;
    }

    public EnumDqmMagic getEnumMagic()
    {
    	return this.enumMagic;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {

    	if(!world.isRemote)
    	{
	    	if(!player.onGround && player.isSneaking())
	    	{
	    		NBTTagCompound nbt = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
				if(nbt != null)
				{
			    	Set tags = nbt.func_150296_c();
			    	Object[] tagArray = tags.toArray();
			    	Arrays.sort(tagArray);

			    	int setCount = 0;
			    	//System.out.println("test2 : " + tags.size());

			    	String preUUID = "";
			        for(int cnt = 0; cnt < tagArray.length; cnt++)
			        {
		        		try
		        		{

		        			NBTTagCompound petData = nbt.getCompoundTag((String)tagArray[cnt]);
		        			//System.out.println("TEST1 : " + (String)tagArray[cnt]);
		        			if(petData != null)
		        			{
		        				//System.out.println("TEST2 : " + nbt.getString("PetName"));
		        				String uid = (String)tagArray[cnt];

		        	    		int locX = petData.getInteger("posX");
		        				int locY = petData.getInteger("posY");
		        				int locZ = petData.getInteger("posZ");
		        				int locDim = petData.getInteger("dimension");

		        				//System.out.println("TEST : " + uid + " / " + preUUID);
		        				if((locX == 0 && locY == 0 && locZ == 0 && locDim == 0) || preUUID.equalsIgnoreCase(uid))
		        				{
		        					ExtendedPlayerProperties3.get(player).minusPetCount(1);
		        		        	DQR.petFunc.removePetdata(player, uid);
		        		        	player.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petCommand.s0",new Object[] {petData.getString("PetName")}));
		        		        	setCount++;
		        		        	//flg = true;
		        				}
		        				preUUID = (String)tagArray[cnt];
		        			}
		        		}catch(Exception e)
		        		{

		        		}
			        	//items[cnt].
			        }

				}
	    	}else if(player.isInWater() && player.isSneaking())
	    	{
				//DQR.petFunc.clearPetdata(player);
				//player.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petCommand.s1",new Object[] {}));
	    	}else
	    	{
	    		player.openGui(DQR.instance, DQR.conf.GuiID_PetBook, world, (int)player.posX, (int)player.posY, (int)player.posZ);
	    	}
    	}

        return itemStack;


    }

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {



    	Minecraft mc;
    	String sneak = "";
    	String jump = "";
    	if(p_77624_2_.worldObj.isRemote)
    	{
    		mc = DQR.proxy.getMinecraft();
    		sneak = mc.gameSettings.getKeyDisplayString(mc.gameSettings.keyBindSneak.getKeyCode());
    		jump =  mc.gameSettings.getKeyDisplayString(mc.gameSettings.keyBindJump.getKeyCode());
    		//GameSettings.getKeyDisplayString
    	}

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.1.txt", new Object[]{}));
    	p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.2.txt", new Object[]{}));
    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.3.txt", new Object[]{}));
    	p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.4.txt", new Object[]{}));
    	//p_77624_3_.add("");
    	//p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.5.txt", new Object[]{}));
    	//p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.6.txt", new Object[]{}));

		NBTTagCompound nbt = p_77624_1_.getTagCompound();
		if(nbt != null)
		{
			int medalVal = nbt.getInteger("medalking");
			//System.out.println("TEST:" + medalVal);
			if(medalVal > 0)
			{

	    		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

				p_77624_3_.add(medalValue);
			}
		}
	 }
}
