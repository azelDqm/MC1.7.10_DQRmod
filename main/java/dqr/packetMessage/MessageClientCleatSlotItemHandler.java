package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;

public class MessageClientCleatSlotItemHandler implements IMessageHandler<MessageClientCleatSlotItem, IMessage> {

    @Override//IMessageHandlerのメソッド
    public IMessage onMessage(MessageClientCleatSlotItem message, MessageContext ctx) {
        //クライアントへ送った際に、EntityPlayerインスタンスはこのように取れる。
        EntityPlayer player = DQR.proxy.getEntityPlayerInstance();


        	int pat = message.data;
        	//System.out.println("TEST" + pat);
        	player.inventory.setInventorySlotContents(pat, null);

        	//System.out.println("TEST:" + cnt + "/" + pat);

        //サーバーへ送った際に、EntityPlayerインスタンス（EntityPlayerMPインスタンス）はこのように取れる。
        //EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
        //Do something.
        return null;//本来は返答用IMessageインスタンスを返すのだが、旧来のパケットの使い方をするなら必要ない。
    }
}
