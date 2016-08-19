package dqr;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import dqr.entity.magicEntity.MagicRegister;
import dqr.entity.mobEntity.MobRegister;
import dqr.entity.mobEntity.MobSpawnRegister;
import dqr.entity.petEntity.PetRegister;
import dqr.entity.throwingEntity.ThrowingRegister;

public class CommonProxy
{

	public File getDir()
	{
		return new File(".");
	}

	//@Override
	/*
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == DQR.conf.GuiID_FarmBook) {
            return new GuiFarmBookContainer(x, y, z);
        }
        return null;
    }


	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
    */

	public void registerClientInfo(){}

    public void registers(){
    	new MobRegister();
    	new MobSpawnRegister();
    	new MagicRegister();
    	new ThrowingRegister();
    	new PetRegister();
    	//new BlockTileEntityRegister();

    }

	public Minecraft getMinecraft(){return null;}

	public EntityPlayer getEntityPlayerInstance() {return null;}

    public void registerGUI(){}

    public int getNewRenderType()
    {
    	return -1;
    }

    public void registersItemRender(){

    }
    public void registerMCEconomy2Addon(){}

}
