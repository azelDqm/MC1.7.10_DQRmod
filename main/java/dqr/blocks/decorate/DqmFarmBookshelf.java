package dqr.blocks.decorate;

import java.util.Random;

import net.minecraft.block.BlockBookshelf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.api.enums.EnumStatFarmingBook;
import dqr.items.base.DqmItemSeedBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties2;

public class DqmFarmBookshelf extends BlockBookshelf
{
    public DqmFarmBookshelf()
    {
        super();
        //this.setCreativeTabs(DQR.tabs.DqmTabDecorate);
    }


    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 3;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        for (int l = par2 - 2; l <= par2 + 2; ++l)
        {
            for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
            {
                if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
                {
                    i1 = par4 + 2;
                }

                if (par5Random.nextInt(16) == 0)
                {
                    for (int j1 = par3; j1 <= par3 + 1; ++j1)
                    {
                        if (true)
                        {
                            if (!par1World.isAirBlock((l - par2) / 2 + par2, j1, (i1 - par4) / 2 + par4))
                            {
                                break;
                            }

                            par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(l - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(j1 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(i1 - par4) + par5Random.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ != 1 && p_149691_1_ != 0 ? super.getIcon(p_149691_1_, p_149691_2_) : Blocks.crafting_table.getBlockTextureFromSide(p_149691_1_);
    }
    /*
    public Icon getIcon(int par1, int par2)
    {
        //return par1 != 1 && par1 != 0 ? super.getIcon(par1, par2) : Block.planks.getBlockTextureFromSide(par1);
    	return par1 != 1 && par1 != 0 ? super.getIcon(par1, par2) : Block.workbench.getBlockTextureFromSide(par1);
    }
    */

    /*
    public ItemStack getBook()
    {

        ItemStack book = new ItemStack(Items.written_book, 1, 0);
        NBTTagList pages = new NBTTagList();
        pages.
        pages.appendTag(new NBTTagString("1"));
        NBTTagString page1 = (NBTTagString)pages.tagAt(0);
        //page1.data = "test\ntest2";
        //book.setTagInfo("pages", pages);
        //book.setTagInfo("author", new NBTTagString("author", "unknown"));
        //book.setTagInfo("title", new NBTTagString("title", "Treasure Room"));

        return book;

    }
    */


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float disX, float disY, float disZ)
    {

    	boolean getBook = false;

    	//System.out.println("DEBUG3" + player.isSneaking());
    	if(player.isSneaking())
    	{
    		ItemStack var2 = player.inventory.getCurrentItem();

    		if(var2 == null)
    		{
    			ItemStack book = new ItemStack(DQMiscs.itemFarmBook, 1, 0);

    			player.inventory.mainInventory[player.inventory.currentItem] = book;
    		}

    	}else
    	{
    		int flg = ExtendedPlayerProperties.get(player).getNpcTalk(EnumDqmNpcTalk.FARMBOOK.getId());

    		if(!player.worldObj.isRemote)
    		{

    			ItemStack var2 = player.inventory.getCurrentItem();

    			if(var2 != null)
    			{
    				//System.out.println(var2.getDisplayName());
    			}
    			if(var2 != null && var2.getItem() instanceof DqmItemSeedBase && var2.getItem() != DQSeeds.itemOugonSeed4)
    			{
    				int openFlg = 0;
    				int enumId = -1;
    				if(var2.getItem() == DQSeeds.itemYakusouSeed)
    				{
    					enumId = EnumStatFarmingBook.YAKUSOU2.getId();
    				}
    				else if(var2.getItem() == DQSeeds.itemYakusouSeed2)
    				{
    					enumId = EnumStatFarmingBook.YAKUSOU3.getId();
    				}
    				else if(var2.getItem() == DQSeeds.itemDokukesisouSeed)
    				{
    					enumId = EnumStatFarmingBook.DOKUKESHI2.getId();

    				}else if(var2.getItem() == DQSeeds.itemDokukesisouSeed2)
    				{
    					enumId = EnumStatFarmingBook.DOKUKESHI3.getId();

    				}else if(var2.getItem() == DQSeeds.itemTikaraSeed)
    				{
    					enumId = EnumStatFarmingBook.TIKARA2.getId();
    				}else if(var2.getItem() == DQSeeds.itemTikaraSeed2)
    				{
    					enumId = EnumStatFarmingBook.TIKARA3.getId();
    				}else if(var2.getItem() == DQSeeds.itemMamoriSeed)
    				{
    					enumId = EnumStatFarmingBook.MAMORI2.getId();
    				}else if(var2.getItem() == DQSeeds.itemMamoriSeed2)
    				{
    					enumId = EnumStatFarmingBook.MAMORI3.getId();
    				}else if(var2.getItem() == DQSeeds.itemSubayasaSeed)
    				{
    					enumId = EnumStatFarmingBook.SUBAYASA2.getId();
    				}else if(var2.getItem() == DQSeeds.itemSubayasaSeed2)
    				{
    					enumId = EnumStatFarmingBook.SUBAYASA3.getId();
    				}else if(var2.getItem() == DQSeeds.itemIyasiSeed)
    				{
    					enumId = EnumStatFarmingBook.IYASHI2.getId();
    				}else if(var2.getItem() == DQSeeds.itemIyasiSeed2)
    				{
    					enumId = EnumStatFarmingBook.IYASHI3.getId();
    				}else if(var2.getItem() == DQSeeds.itemHonooSeed)
    				{
    					enumId = EnumStatFarmingBook.HONOO2.getId();
    				}else if(var2.getItem() == DQSeeds.itemHonooSeed2)
    				{
    					enumId = EnumStatFarmingBook.HONOO3.getId();
    				}else if(var2.getItem() == DQSeeds.itemMahounomiseed)
    				{
    					enumId = EnumStatFarmingBook.MAHOUNOMI2.getId();
    				}else if(var2.getItem() == DQSeeds.itemMahounomiseed2)
    				{
    					enumId = EnumStatFarmingBook.MAHOUNOMI3.getId();
    				}else if(var2.getItem() == DQSeeds.itemMaryokunotaneseed)
    				{
    					enumId = EnumStatFarmingBook.MARYOKUNOMI2.getId();
    				}else if(var2.getItem() == DQSeeds.itemMaryokunotaneseed2)
    				{
    					enumId = EnumStatFarmingBook.MARYOKUNOMI3.getId();
    				}else if(var2.getItem() == DQSeeds.itemOugonSeed)
    				{
    					enumId = EnumStatFarmingBook.OUGON2.getId();
    				}else if(var2.getItem() == DQSeeds.itemOugonSeed2)
    				{
    					enumId = EnumStatFarmingBook.OUGON3.getId();
    				}else if(var2.getItem() == DQSeeds.itemOugonSeed3)
    				{
    					enumId = EnumStatFarmingBook.OUGON4.getId();
    				}

    				//System.out.println("DEBUG2" + enumId);
    				if(enumId != -1)
    				{
    					//通常種系
    					if(ExtendedPlayerProperties2.get(player).getFarmRecipe(enumId) == 0)
    					{
    						ExtendedPlayerProperties2.get(player).setFarmRecipe(enumId, 1);
    						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
    						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
    						var2.stackSize--;
    					}else
    					{
    						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
    						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
    					}
    				}else
    				{
    					//変則種系
    					int param = -1;
    					if(var2.getItem() == DQSeeds.itemYakusouSeed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.IYASHI1.getId());

        					if(param % 10 != 2)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.IYASHI1.getId(), param + 2);
        						if(param == 10)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemDokukesisouSeed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.MARYOKUNOMI1.getId());

        					if(param % 10 != 2)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.MARYOKUNOMI1.getId(), param + 2);
        						if(param == 10)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}


        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.MAHOUNOMI1.getId());

        					if(param % 10 != 2)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.MAHOUNOMI1.getId(), param + 2);
        						if(param == 10)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						//var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}


        				}else if(var2.getItem() == DQSeeds.itemTikaraSeed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.HONOO1.getId());

        					if(param % 10 != 2)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.HONOO1.getId(), param + 2);
        						if(param == 10)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemMamoriSeed3)
        				{
           					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.IYASHI1.getId());

        					if(param / 10 != 1)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.IYASHI1.getId(), param + 10);
        						if(param == 2)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemSubayasaSeed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.HONOO1.getId());

        					if(param / 10 != 1)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.HONOO1.getId(), param + 10);
        						if(param == 2)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemIyasiSeed3)
        				{

        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.MAHOUNOMI1.getId());

        					if(param / 10 != 1)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.MAHOUNOMI1.getId(), param + 10);
        						if(param == 2)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemHonooSeed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.MARYOKUNOMI1.getId());

        					if(param / 10 != 1)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.MARYOKUNOMI1.getId(), param + 10);
        						if(param == 2)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemMahounomiseed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.OUGON1.getId());

        					if(param % 10 != 2)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.OUGON1.getId(), param + 2);
        						if(param == 10)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}else if(var2.getItem() == DQSeeds.itemMaryokunotaneseed3)
        				{
        					param = ExtendedPlayerProperties2.get(player).getFarmRecipe(EnumStatFarmingBook.OUGON1.getId());

        					if(param / 10 != 1)
        					{
        						ExtendedPlayerProperties2.get(player).setFarmRecipe(EnumStatFarmingBook.OUGON1.getId(), param + 10);
        						if(param == 2)
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.complete.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}else
        						{
            						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.getParts.txt",new Object[] {}));
            						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
            						var2.stackSize--;
        						}
        					}else
        					{
        						DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages.completeYet.txt",new Object[] {}));
        						player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        					}
        				}
    				}
    			}else
    			{
	    			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.FarmBookshelf.messages." + flg + ".txt",new Object[] {}));
	        		ExtendedPlayerProperties.get(player).setNpcTalk(EnumDqmNpcTalk.FARMBOOK.getId(), flg == 4 ? 0 : flg + 1);
	    			player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
    			}
    		}


    	}
    	//player.
        //ブロックが右クリックされた時
    	ItemStack var2 = player.inventory.getCurrentItem();
    	int currentEnv = player.inventory.currentItem;



    	if (var2 == null)
    	{
    		return false;
    	}

    	/*
        ItemStack book = new ItemStack(Item.writtenBook, 1, 0);
        NBTTagList pages = new NBTTagList("pages");
        pages.appendTag(new NBTTagString("1", ""));
        NBTTagString page1 = (NBTTagString)pages.tagAt(0);

        if(var2.itemID == DqmItemList.Yakusou.itemID)
        {
	        page1.data = "超薬草の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：薬草\nＢの位置：毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超薬草の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Yakusou2.itemID)
        {
	        page1.data = "極薬草の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超薬草\nＢの位置：超毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極薬草の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Dokukesisou.itemID)
        {
	        page1.data = "超毒消し草の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：毒消し草\nを植える\n\nＡＡＡ\nＡ〇Ａ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超毒消し草の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Dokukesisou2.itemID)
	    {
	        page1.data = "極毒消し草の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超毒消し草\nを植える\n\nＡＡＡ\nＡ〇Ａ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極毒消し草の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Subayasanotane.itemID)
	    {
	        page1.data = "超素早さの種の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：素早さの種\nＢの位置：毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超素早さの種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Subayasanotane2.itemID)
	    {
	        page1.data = "極素早さの種の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超素早さの種\nＢの位置：超毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極素早さの種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Tikaranotane.itemID)
	    {
	        page1.data = "超力の種の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：力の種\nＢの位置：毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超力の種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Tikaranotane2.itemID)
	    {
	        page1.data = "極力の種の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超力の種\nＢの位置：超毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極力の種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Mamorinotane.itemID)
	    {
	        page1.data = "超守りの種の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：守りの種\nＢの位置：毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超守りの種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Mamorinotane2.itemID)
	    {
	        page1.data = "極守りの種の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超守りの種\nＢの位置：超毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極守りの種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Yakusou3.itemID || var2.itemID == DqmItemList.Tikaranotane3.itemID)
	    {
	        page1.data = "癒しの実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超力の種\nＢの位置：超毒消し草\nＣの位置：超薬草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＣＣＣ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "癒しの実の種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Iyasinomi.itemID)
	    {
	        page1.data = "超癒しの実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：癒しの実\nＢの位置：超毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超癒しの実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Iyasinomi2.itemID)
	    {
	        page1.data = "極癒しの実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超癒しの実\nＢの位置：極毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極癒しの実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Subayasanotane3.itemID || var2.itemID == DqmItemList.Mamorinotane3.itemID)
	    {
	        page1.data = "炎の実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超守りの種\nＢの位置：超毒消し草\nＣの位置：超素早さの種\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＣＣＣ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "炎の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Honoonomi.itemID)
	    {
	        page1.data = "超炎の実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：炎の実\nＢの位置：超毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超炎の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Honoonomi2.itemID)
	    {
	        page1.data = "極炎の実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：超炎の実\nＢの位置：極毒消し草\nを植える\n\nＡＡＡ\nＢ〇Ｂ\nＡＡＡ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極炎の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Iyasinomi3.itemID)
	    {
	        page1.data = "魔法の実の作り方\n\n中央の土壌を豊穣な土に\n×の土壌をほしのカケラブロックに\nＡの位置：極癒しの実\nを植える\n\nＡ×Ａ\n×〇×\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "魔法の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.MahounomiI.itemID)
	    {
        	page1.data = "超魔法の実の作り方\n\n中央の土壌を豊穣な土に\n×の土壌を月のダイヤブロックに\nＡの位置：魔法の実\nを植える\n\nＡ×Ａ\n×〇×\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超魔法の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.MahounomiI2.itemID)
	    {
        	page1.data = "極魔法の実の作り方\n\n中央の土壌を豊穣な土に\n×の土壌をたいようの石ブロックに\nＡの位置：超魔法の実\nを植える\n\nＡ×Ａ\n×〇×\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極魔法の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Honoonomi3.itemID)
	    {
	        page1.data = "魔力の種の作り方\n\n中央の土壌を豊穣な土に\n×の土壌をこおりの結晶ブロックに\nＡの位置：極炎の実\nを植える\n\nＡ×Ａ\n×〇×\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "魔力の種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.MaryokunotaneI.itemID)
	    {
        	page1.data = "超魔力の種の作り方\n\n中央の土壌を豊穣な土に\n×の土壌をかがみの石ダイヤブロックに\nＡの位置：魔力の実\nを植える\n\nＡ×Ａ\n×〇×\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超魔力の種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.MaryokunotaneI2.itemID)
	    {
        	page1.data = "極魔力の種の作り方\n\n中央の土壌を豊穣な土に\n×の土壌をミスリルブロックに\nＡの位置：超魔力の実\nを植える\n\nＡ×Ａ\n×〇×\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極魔力の種の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.MaryokunotaneI3.itemID || var2.itemID == DqmItemList.MahounomiI3.itemID)
	    {
	        page1.data = "黄金の実の作り方\n\n中央の土壌を豊穣な土に\n×の土壌を光の石ブロックに\n△の土壌をオリハルコンブロックに\nＡの位置：極魔力の種\nＢの位置：極魔法の実\nを植える\n\nＡ×Ｂ\n△〇△\nＢ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "黄金の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Ougon.itemID)
	    {
        	page1.data = "超黄金の実の作り方\n\n中央の土壌を豊穣な土に\n×の土壌を光の石ブロックに\n△の土壌をオリハルコンブロックに\nＡの位置：黄金の実\nを植える\n\nＡ×Ａ\n△〇△\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "超黄金の実の作り方"));
	        getBook = true;
        }else if(var2.itemID == DqmItemList.Ougon2.itemID)
	    {
        	page1.data = "極黄金の実の作り方\n\n中央の土壌を豊穣な土に\n×の土壌を光の石ブロックに\n△の土壌をオリハルコンブロックに\nＡの位置：超黄金の実\nを植える\n\nＡ×Ａ\n△〇△\nＡ×Ａ\n\n希に中央に生えてくる。";
	        book.setTagInfo("title", new NBTTagString("title", "極黄金の実の作り方"));
	        getBook = true;
	    }else if(var2.itemID == DqmItemList.Ougon3.itemID)
		{
			page1.data = "真・極黄金の実の作り方\n\n中央の土壌を豊穣な土に\nＡの位置：極黄金の実\nを植える\n\nＡＡＡ\nＡ〇Ａ\nＡＡＡ\n\n希に中央に生えてくる。";
		    book.setTagInfo("title", new NBTTagString("title", "真・極黄金の実の作り方"));
		    getBook = true;
		}


        if(getBook == true)
        {
        	 --var2.stackSize;
            if (!player.worldObj.isRemote)
            {
	            if (var2.stackSize > 0)
	            {
	            	player.dropItem(var2.itemID, var2.stackSize);
	            }
            }
            player.worldObj.playSoundAtEntity(player, "DQM_Sound.Pi", 1.0F, 1.0F);
	        book.setTagInfo("pages", pages);
	        book.setTagInfo("author", new NBTTagString("author", "農夫スティーブ"));


	        //System.out.println("Num:" + currentEnv);
	        //player.setCurrentItemOrArmor(currentEnv + 4, book);

	        player.inventory.mainInventory[currentEnv] = book;
	        //player.inventory.currentItem(book);
        }
        */
        return false;
    }
}
