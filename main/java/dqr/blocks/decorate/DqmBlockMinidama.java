package dqr.blocks.decorate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.enums.EnumDqmJob;
import dqr.blocks.decorate.tileEntity.DqmTileEntityMinidama;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmBlockMinidama extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockMinidama(Material var2)
    {
        super(var2);
        // this.setLightValue(0.9375F);
        // this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    public DqmBlockMinidama setmodel(String m)
    {
        model = m;
        return this;
    }
    //光を通す
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    public int getRenderType()
    {
        return -1;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:miniDama");
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int p_149915_2_)
    {

        return new DqmTileEntityMinidama();
    }

    /**
     * Called when the block is placed in the world.
     */

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        float var5 = 0.0F;
        //return AxisAlignedBB.getBoundingBox((double)((float)p_149633_2_ + var5), (double)p_149633_3_, (double)((float)p_149633_4_ + var5), (double)((float)(p_149633_2_ + 1) - var5), (double)(p_149633_3_ + 1), (double)((float)(p_149633_4_ + 1) - var5));
        return AxisAlignedBB.getBoundingBox(p_149633_2_, p_149633_3_, p_149633_4_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer ep, int par6, float par7, float par8, float par9)
    {
        if (!par1World.isRemote)
        {
        	int TabidachiFlg = ExtendedPlayerProperties.get(ep).getTabidachiFlg();
        	int playerJob = ExtendedPlayerProperties.get(ep).getJob();
        	int setJob = -1;
        	if(TabidachiFlg < 100)
        	{
	        	if (TabidachiFlg >= 20 && ep.isSneaking())
	        	{
	        		switch(TabidachiFlg)
	        		{
	        			case 20: setJob = 0; TabidachiFlg = 100; break;
	        			case 21: setJob = 1; TabidachiFlg = 101; break;
	        			case 22: setJob = 2; TabidachiFlg = 102; break;
	        			case 23: setJob = 5; TabidachiFlg = 103; break;
	        			case 24: setJob = 4; TabidachiFlg = 104; break;
	        			case 25: setJob = 14; TabidachiFlg = 105; break;
	        			case 26: setJob = 15; TabidachiFlg = 106; break;
	        			default: setJob = -1;
	        		}

	        		if(setJob != -1)
	        		{
		        		if(playerJob == setJob)
		        		{
		        		   	//String jobName = I18n.format("main.job." + setJob);
		        	    	//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.Set1.txt",new Object[] {jobName}));
		        		   	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.Set1.txt",new Object[] {new ChatComponentTranslation("main.job." + setJob)}));
		        		}else
		        		{
		        		   	//String jobName = I18n.format("main.job." + setJob);
		        	    	//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.Set2.txt",new Object[] {jobName}));
		        		   	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.Set2.txt",new Object[] {new ChatComponentTranslation("main.job." + setJob)}));
		        		}
	        		}

	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.tensyoku", 1.0F, 1.0F);
	        		JobChange(ep);

	        	}else
	        	{
	        		if(TabidachiFlg > 13)
	        		{
	        			int dispJob = -1;
		        		switch(TabidachiFlg)
		        		{
		        			case 20: dispJob = 1; break;
		        			case 21: dispJob = 2; break;
		        			case 22: dispJob = 5; break;
		        			case 23: dispJob = 4; break;
		        			case 24: dispJob = 14; break;
		        			case 25: dispJob = 15; break;
		        			case 26: dispJob = 0; break;
		        			default: dispJob = -1;
		        		}


	        			//mdamaB(ep, TabidachiFlg);
		        		//String jobName = I18n.format("main.job." + dispJob);
		            	//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.select.txt",new Object[] {jobName}));
		        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.select.txt",new Object[] {new ChatComponentTranslation("main.job." + dispJob)}));


		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		        		TabidachiFlg = TabidachiFlg + 1;
	        		}else if(TabidachiFlg >= 12)
		        	{
		        		//String message = I18n.format("msg.startingJob.messages." + TabidachiFlg + ".txt");
		        		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(message,new Object[] {}));
	        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.messages." + TabidachiFlg + ".txt",new Object[] {}));

		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		        		TabidachiFlg = TabidachiFlg + 1;
		        	}else if(TabidachiFlg >= 5)
		        	{
		        		EnumDqmJob jobEnum;
		        		switch(TabidachiFlg - 4)
		        		{
		        			case 1: jobEnum = EnumDqmJob.Senshi; break;
		        			case 2: jobEnum = EnumDqmJob.Budouka; break;
		        			case 3: jobEnum = EnumDqmJob.Souryo; break;
		        			case 4: jobEnum = EnumDqmJob.Mahoutukai; break;
		        			case 5: jobEnum = EnumDqmJob.Syounin; break;
		        			case 6: jobEnum = EnumDqmJob.Touzoku; break;
		        			case 7: jobEnum = EnumDqmJob.Asobinin; break;
		        			default :jobEnum = EnumDqmJob.Asobinin; break;
		        		}

		            	for (int cnt = 0; cnt <= jobEnum.getInfoLine(); cnt ++)
		            	{
		            		//String message = I18n.format("msg.startingJob.jobInfo." + (TabidachiFlg - 4) + "." + cnt + ".txt");
		            		String message = String.format("msg.startingJob.jobInfo." + (TabidachiFlg - 4) + "." + cnt + ".txt");
		            		//if (message.equalsIgnoreCase("msg.startingJob.jobInfo." + (TabidachiFlg - 4) + "." + cnt + ".txt")) break;
		            		//if (message.equalsIgnoreCase("msg.startingJob.jobInfo." + (TabidachiFlg - 4) + "." + cnt + ".txt")) break;

		            		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(message,new Object[] {}));
		            	}
		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		        		TabidachiFlg = TabidachiFlg + 1;
		        		//return true;
		        	}else{

		        		//String message = I18n.format("msg.startingJob.messages." + TabidachiFlg + ".txt");
		        		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(message,new Object[] {}));
		        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.messages." + TabidachiFlg + ".txt",new Object[] {}));

		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		        		TabidachiFlg = TabidachiFlg + 1;
		        		//return true;
		        	}

		        	if(TabidachiFlg == 14 || TabidachiFlg == 27)
		        	{
		        		TabidachiFlg = 20;
		        	}
	        	}
        	}
        	ExtendedPlayerProperties.get(ep).setTabidachiFlg(TabidachiFlg);

        	if(setJob != -1)
        	{
        		ExtendedPlayerProperties.get(ep).setJob(setJob);
        	}
        }


    	return true;
    }


    public void mdamaA(EntityPlayer ep, int Job, int pat)
    {
    	//String jobName = I18n.format("main.job." + Job);
    	//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.Set" + pat +".txt",new Object[] {jobName}));
    	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.Set" + pat +".txt",new Object[] {new ChatComponentTranslation("main.job." + Job)}));

    }

    public void mdamaB(EntityPlayer ep, int Job)
    {
    	for (int cnt = 0; cnt < 10; cnt ++)
    	{
    		//String message = I18n.format("msg.startingJob.jobInfo." + Job + "." + cnt + ".txt");
    		String message = String.format("msg.startingJob.jobInfo." + Job + "." + cnt + ".txt");
    		if (message.equalsIgnoreCase("")) break;

    		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(message,new Object[] {}));
    	}

    }

    public void mdamaC(EntityPlayer ep, int TabidachiFlg)
    {
		//String message = I18n.format("msg.startingJob.messages." + TabidachiFlg + ".txt");
		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(message,new Object[] {}));
    	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.messages." + TabidachiFlg + ".txt",new Object[] {}));
    }

    public void mdamaD(EntityPlayer ep, int TabidachiFlg, int Job)
    {
		//String message = I18n.format("msg.startingJob.messages." + TabidachiFlg + ".txt");
		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(message,new Object[] {}));
    	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.startingJob.messages." + TabidachiFlg + ".txt",new Object[] {}));
    }

    public void JobChange(EntityPlayer ep)
    {

    	/*
        if (ep.HP >= ep.HPMAX())
        {
            ep.HP = ep.HPMAX();
        }

        if (ep.MP >= ep.MPMAX())
        {
            ep.MP = ep.MPMAX();
        }
        */
/*
        ep.processCommandSword(ep, null);

        if (DQR.MALTI == 1)
        {
            ep.processCommandLV(ep, null);
        }

        if (ep.tate == 1)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Sabitatate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 2)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Urokonotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 3)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Haganenotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 4)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Oogasirudo.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 5)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Rotonotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 6)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Tenkuunotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 7)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Fuujinnnotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 8)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Honoonotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 9)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Howaitosirudo.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 10)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Kawanotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 11)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Koorinotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 12)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Mahounotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 13)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Metarukingnotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 14)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Mikagaminotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 15)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Puratinasirudo.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 16)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Seidounotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 17)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Tikaranotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 18)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Suraimutorei.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 19)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Megaminotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.tate == 20)
        {
            ep.tate = 0;
            ep.dropItem(DqmItemList.Uroborosunotate.itemID, 1);
            ep.TATEHazusi = 1;
        }

        if (ep.TATEHazusi == 1)
        {
            tate(ep, null);
            ep.TATEHazusi = 0;
        }

        tate(ep, null);
        */
    }
/*
    public void mdama11(ICommandSender var1, String[] var2)
    {
        String var13 = "[石碑に文字が書かれている]";
        var1.sendChatToPlayer(var13);
    }

    public void mdama12(ICommandSender var1, String[] var2)
    {
        String var13 = "これを読んでいる冒険者の方へ";
        var1.sendChatToPlayer(var13);
    }

    public void mdama13(ICommandSender var1, String[] var2)
    {
        String var13 = "この石碑に祈りを捧げることで、1度だけ好きな職業に転職することができます。";
        var1.sendChatToPlayer(var13);
    }

    public void mdama14(ICommandSender var1, String[] var2)
    {
        String var13 = "それぞれの職業の特徴を書いておきますので、どの職業が自分にふさわしいか";
        var1.sendChatToPlayer(var13);
    }

    public void mdama15(ICommandSender var1, String[] var2)
    {
        String var13 = "慎重に考えて職業を選んで下さい。";
        var1.sendChatToPlayer(var13);
    }

    public void mdama16(ICommandSender var1, String[] var2)
    {
    	String var13 = "";
        var13 = "「戦士」";
        var1.sendChatToPlayer(var13);

        var13 = "強適正武器は斧";
        var1.sendChatToPlayer(var13);

        var13 = "適正武器は剣・鎚・勇者剣・槍";
        var1.sendChatToPlayer(var13);

        var13 = "ステータスバランスが良く、防具が比較的揃えやすい";
        var1.sendChatToPlayer(var13);

        var13 = "また、強適正武器の斧には木の一括伐採機能がついているのが強み";
        var1.sendChatToPlayer(var13);

        var13 = "";
        var1.sendChatToPlayer(var13);
    }

    public void mdama17(ICommandSender var1, String[] var2)
    {
    	String var13 = "";
        var13 = "「武道家」";
        var1.sendChatToPlayer(var13);

        var13 = "強適正武器は棍・爪";
        var1.sendChatToPlayer(var13);

        var13 = "適正武器は拳・短剣・弓";
        var1.sendChatToPlayer(var13);

        var13 = "基本職の中では比較的HPが高く、攻撃力も高め";
        var1.sendChatToPlayer(var13);

        var13 = "また、強適正武器の爪にはスコップ機能がついているのが強み";
        var1.sendChatToPlayer(var13);

        var13 = "但し盾が装備できないため、防御力に若干の難あり";
        var1.sendChatToPlayer(var13);

        var13 = "";
        var1.sendChatToPlayer(var13);
    }

    public void mdama18(ICommandSender var1, String[] var2)
    {
    	String var13 = "";
        var13 = "「僧侶」";
        var1.sendChatToPlayer(var13);

        var13 = "強適正武器は槍";
        var1.sendChatToPlayer(var13);

        var13 = "適正武器は棍・短剣・弓";
        var1.sendChatToPlayer(var13);

        var13 = "HPと防御力は低めだが、回復魔法や補助魔法を覚えることができる";
        var1.sendChatToPlayer(var13);

        var13 = "また、複数ターゲット攻撃魔法も覚えるため、バランスは良い";
        var1.sendChatToPlayer(var13);

        var13 = "";
        var1.sendChatToPlayer(var13);
    }

    public void mdama19(ICommandSender var1, String[] var2)
    {
    	String var13 = "";
        var13 = "「魔法使い」";
        var1.sendChatToPlayer(var13);

        var13 = "強適正武器は棍・短剣";
        var1.sendChatToPlayer(var13);

        var13 = "適正武器は鞭";
        var1.sendChatToPlayer(var13);

        var13 = "HPと防御力はかなり低いものの、攻撃魔法を多く覚えるため";
        var1.sendChatToPlayer(var13);

        var13 = "序盤から大ダメージを狙うことができる";
        var1.sendChatToPlayer(var13);

        var13 = "";
        var1.sendChatToPlayer(var13);
    }

    public void mdama20(ICommandSender var1, String[] var2)
    {
    	String var13 = "";
        var13 = "「遊び人」";
        var1.sendChatToPlayer(var13);

        var13 = "強適正武器は鞭";
        var1.sendChatToPlayer(var13);

        var13 = "適正武器は爪・短剣・弓・投擲";
        var1.sendChatToPlayer(var13);

        var13 = "これと言った特徴はない";
        var1.sendChatToPlayer(var13);

        var13 = "しかし、この職業を選択してLv50まで育てると……";
        var1.sendChatToPlayer(var13);

        var13 = "";
        var1.sendChatToPlayer(var13);
    }

    public void mdama21(ICommandSender var1, String[] var2)
    {
        String var13 = "これで職業の説明は終わりです。";
        var1.sendChatToPlayer(var13);
    }

    public void mdama22(ICommandSender var1, String[] var2)
    {
        String var13 = "祈りを捧げたい職業を選んで祈りを捧げて下さい";
        var1.sendChatToPlayer(var13);
    }

    public void mdama1(ICommandSender var1, String[] var2)
    {
        String var13 = "職業:戦士の祈りを捧げますか？(「はい」=スニーク+右クリック)";
        var1.sendChatToPlayer(var13);
    }

    public void mdama2(ICommandSender var1, String[] var2)
    {
        String var13 = "職業:武道家の祈りを捧げますか？(「はい」=スニーク+右クリック)";
        var1.sendChatToPlayer(var13);
    }

    public void mdama3(ICommandSender var1, String[] var2)
    {
        String var13 = "職業:僧侶の祈りを捧げますか？(「はい」=スニーク+右クリック)";
        var1.sendChatToPlayer(var13);
    }

    public void mdama4(ICommandSender var1, String[] var2)
    {
        String var13 = "職業:魔法使いの祈りを捧げますか？(「はい」=スニーク+右クリック)";
        var1.sendChatToPlayer(var13);
    }

    public void mdama5(ICommandSender var1, String[] var2)
    {
        String var13 = "職業:遊び人の祈りを捧げますか？(「はい」=スニーク+右クリック)";
        var1.sendChatToPlayer(var13);
    }

    public void tate(ICommandSender var1, String var2)
    {
        String var13 = "---------------転職により盾が外された。---------------";
        var1.sendChatToPlayer(var13);
    }

    public void mdamaA(ICommandSender var1, String var2)
    {
        String var13 = "職業:" + var2 + "の祝福を受けた。";
        var1.sendChatToPlayer(var13);
    }

    public void mdamaB(ICommandSender var1, String var2)
    {
        String var13 = "職業:" + var2 + "の祝福を受けて" + var2 + "に転職した。";
        var1.sendChatToPlayer(var13);
    }
    */

}
