package dqr.api.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import dqr.gui.itemBag.GuiItemBagContainer;

@Cancelable
public class DqmBagSlotClickEvent extends Event{

	public final int slotNo;
	public final int actionSubNo;
	public final int action;
	public final EntityPlayer entityPlayer;
	public final GuiItemBagContainer bag;

	public DqmBagSlotClickEvent (GuiItemBagContainer bag, int slotNo, int mouseButtonNo, int mouseAction, EntityPlayer entityPlayer)
	{
		//slotNo = -999 : null
		this.bag = bag;
		this.slotNo = slotNo;
		this.actionSubNo = mouseButtonNo;
		this.action = mouseAction;
		this.entityPlayer = entityPlayer;
	}
}
