package dqr.api.event;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class DqrBreakMGTEvent extends Event{

	public final EntityPlayer ep;
	public static Block block;
	public static int blockMeta;
	public static int blockX;
	public static int blockY;
	public static int blockZ;

    public DqrBreakMGTEvent(EntityPlayer player, Block par2, int meta, int par3, int par4, int par5) {
    	this.setCanceled(false);
        this.ep = player;
        this.block = par2;
        this.blockMeta = meta;
        this.blockX = par3;
        this.blockY = par4;
        this.blockZ = par5;

    }

    public static class unbreakCheck extends DqrBreakMGTEvent {
    	//破壊不可ブロックの場合は canceledにtrueをsetして処理を返す
		public unbreakCheck(EntityPlayer player, Block par2, int meta, int par3, int par4, int par5) {
			super(player, par2, meta, par3, par4, par5);

		}

    }
}
