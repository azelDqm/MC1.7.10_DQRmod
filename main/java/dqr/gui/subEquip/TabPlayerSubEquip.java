package dqr.gui.subEquip;

import net.minecraft.item.ItemStack;
import tconstruct.client.tabs.AbstractTab;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQAccessories;
import dqr.packetMessage.MessageServerGuiId;

public class TabPlayerSubEquip extends AbstractTab
{
    public TabPlayerSubEquip()
    {
        super(0, 0, 0, new ItemStack(DQAccessories.itemSuraimupiasu));
    }

    @Override
    public void onTabClicked()
    {
    	PacketHandler.INSTANCE.sendToServer(new MessageServerGuiId(DQR.conf.GuiID_SubEquip));
    	//SSPacketHandler.INSTANCE.sendToServer(new PacketGuiId(200));
        //GalacticraftCore.packetPipeline.sendToServer(new PacketSimple(EnumSimplePacket.S_OPEN_EXTENDED_INVENTORY, new Object[] { }));
        //ClientProxyCore.playerClientHandler.onBuild(0, FMLClientHandler.instance().getClientPlayerEntity());
    }

    @Override
    public boolean shouldAddToList()
    {
        return true;
    }

}
