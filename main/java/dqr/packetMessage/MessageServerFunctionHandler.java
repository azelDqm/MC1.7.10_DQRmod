package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.DqrWorldData;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.MessagePlayerProperties;
import dqr.playerData.MessagePlayerProperties3;

public class MessageServerFunctionHandler implements IMessageHandler<MessageServerFunction, IMessage> {

    @Override//IMessageHandlerのメソッド
    public IMessage onMessage(MessageServerFunction message, MessageContext ctx) {
        //クライアントへ送った際に、EntityPlayerインスタンスはこのように取れる。
        //EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
    	EntityPlayer ep = ctx.getServerHandler().playerEntity;

        int pat = message.data;
        int value = message.data2;

        if(pat == EnumDqmFuncPacketCode.SyncWKimera.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー
        	DqrWorldData wd = (DqrWorldData)ep.worldObj.loadItemData(DqrWorldData.class, DQR.modID);

        	if(wd != null)
        	{
        		ExtendedPlayerProperties3.get(ep).setW_KimeraXA(wd.getKimeraXA());
        		ExtendedPlayerProperties3.get(ep).setW_KimeraYA(wd.getKimeraYA());
        		ExtendedPlayerProperties3.get(ep).setW_KimeraZA(wd.getKimeraZA());
        		ExtendedPlayerProperties3.get(ep).setW_KimeraDimA(wd.getKimeraDimA());
        		ExtendedPlayerProperties3.get(ep).setW_KimeraEnableA(wd.getKimeraEnableA());
        		//wd.getKimeraDimA()
        		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        	}
        }else if(pat == EnumDqmFuncPacketCode.SyncWRura.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー
        	DqrWorldData wd = (DqrWorldData)ep.worldObj.loadItemData(DqrWorldData.class, DQR.modID);

        	if(wd != null)
        	{
        		ExtendedPlayerProperties3.get(ep).setW_RuraXA(wd.getRuraXA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraYA(wd.getRuraYA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraZA(wd.getRuraZA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraDimA(wd.getRuraDimA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraEnableA(wd.getRuraEnableA());
        		//wd.getKimeraDimA()
        		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        	}
        }else if(pat == EnumDqmFuncPacketCode.SyncWBasirura.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー
        	DqrWorldData wd = (DqrWorldData)ep.worldObj.loadItemData(DqrWorldData.class, DQR.modID);

        	if(wd != null)
        	{
        		ExtendedPlayerProperties3.get(ep).setW_BasiRuraXA(wd.getBasiRuraXA());
        		ExtendedPlayerProperties3.get(ep).setW_BasiRuraYA(wd.getBasiRuraYA());
        		ExtendedPlayerProperties3.get(ep).setW_BasiRuraZA(wd.getBasiRuraZA());
        		ExtendedPlayerProperties3.get(ep).setW_BasiRuraDimA(wd.getBasiRuraDimA());
        		ExtendedPlayerProperties3.get(ep).setW_BasiRuraEnableA(wd.getBasiRuraEnableA());
        		//wd.getKimeraDimA()
        		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        	}
        }else if(pat == EnumDqmFuncPacketCode.SyncCKimera.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー

    		ExtendedPlayerProperties3.get(ep).setC_KimeraXA(DQR.conf.KimeraC_X);
    		ExtendedPlayerProperties3.get(ep).setC_KimeraYA(DQR.conf.KimeraC_Y);
    		ExtendedPlayerProperties3.get(ep).setC_KimeraZA(DQR.conf.KimeraC_Z);
    		ExtendedPlayerProperties3.get(ep).setC_KimeraDimA(DQR.conf.KimeraC_Dim);

    		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        }else if(pat == EnumDqmFuncPacketCode.SyncCRura.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー

    		ExtendedPlayerProperties3.get(ep).setC_RuraXA(DQR.conf.RuraC_X);
    		ExtendedPlayerProperties3.get(ep).setC_RuraYA(DQR.conf.RuraC_Y);
    		ExtendedPlayerProperties3.get(ep).setC_RuraZA(DQR.conf.RuraC_Z);
    		ExtendedPlayerProperties3.get(ep).setC_RuraDimA(DQR.conf.RuraC_Dim);

    		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        }else if(pat == EnumDqmFuncPacketCode.SyncCBasirura.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー

    		ExtendedPlayerProperties3.get(ep).setC_BasiRuraXA(DQR.conf.BasiRuraC_X);
    		ExtendedPlayerProperties3.get(ep).setC_BasiRuraYA(DQR.conf.BasiRuraC_Y);
    		ExtendedPlayerProperties3.get(ep).setC_BasiRuraZA(DQR.conf.BasiRuraC_Z);
    		ExtendedPlayerProperties3.get(ep).setC_BasiRuraDimA(DQR.conf.BasiRuraC_Dim);

    		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        }else if(pat == EnumDqmFuncPacketCode.SyncWRuraSin.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー
        	DqrWorldData wd = (DqrWorldData)ep.worldObj.loadItemData(DqrWorldData.class, DQR.modID);

        	if(wd != null)
        	{
        		ExtendedPlayerProperties3.get(ep).setW_RuraSinXA(wd.getRuraSinXA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraSinYA(wd.getRuraSinYA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraSinZA(wd.getRuraSinZA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraSinDimA(wd.getRuraSinDimA());
        		ExtendedPlayerProperties3.get(ep).setW_RuraSinEnableA(wd.getRuraSinEnableA());
        		//wd.getKimeraDimA()
        		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        	}
        }else if(pat == EnumDqmFuncPacketCode.SyncCRuraSin.getId())
        {
        	//キメラの翼の座標情報をクライアントへコピー

    		ExtendedPlayerProperties3.get(ep).setC_RuraSinXA(DQR.conf.RuraSinC_X);
    		ExtendedPlayerProperties3.get(ep).setC_RuraSinYA(DQR.conf.RuraSinC_Y);
    		ExtendedPlayerProperties3.get(ep).setC_RuraSinZA(DQR.conf.RuraSinC_Z);
    		ExtendedPlayerProperties3.get(ep).setC_RuraSinDimA(DQR.conf.RuraSinC_Dim);
    		ExtendedPlayerProperties3.get(ep).setC_RuraSinNameA(DQR.conf.RuraSinC_Name);

    		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        }else if(pat == EnumDqmFuncPacketCode.CasinoCoinMinus.getId())
        {

        	int COIN = ExtendedPlayerProperties3.get(ep).getCoin();
        	//System.out.println("TEST_Minus : " + value + " / " + COIN);
        	ExtendedPlayerProperties3.get(ep).setCoin(COIN - value);
        	PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        }else if(pat == EnumDqmFuncPacketCode.CasinoCoinPlus.getId())
        {
        	int COIN = ExtendedPlayerProperties3.get(ep).getCoin();
        	//System.out.println("TEST_Plus : " + value + " / " + COIN);

        	ExtendedPlayerProperties3.get(ep).setCoin(COIN + value);
        	PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
        }else if(pat == EnumDqmFuncPacketCode.MPchange.getId())
        {
        	int mp = ExtendedPlayerProperties.get(ep).getMP();
        	//System.out.println("TEST_Plus : " + value + " / " + COIN);

        	ExtendedPlayerProperties.get(ep).setMP(mp + value);
        	PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties((EntityPlayer)ep), (EntityPlayerMP)ep);
        }


        //サーバーへ送った際に、EntityPlayerインスタンス（EntityPlayerMPインスタンス）はこのように取れる。
        //EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
        //Do something.
        return null;//本来は返答用IMessageインスタンスを返すのだが、旧来のパケットの使い方をするなら必要ない。
    }
}
