package dqr.api.event;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.Event;

public class DqrFarmMGTEvent extends Event{

	public final EntityPlayer ep;
	public static Block block;
	public static ItemStack stack;
	public static int blockMeta;


    public DqrFarmMGTEvent(EntityPlayer player, Block par2, int blockMeta, ItemStack stack) {
        super();
        this.ep = player;
        this.block = par2;
        this.blockMeta = blockMeta;
        this.stack = stack;
    }

    public static class PrePlow extends DqrFarmMGTEvent {
    	public final int blockX;
    	public final int blockY;
    	public final int blockZ;
    	public final int blockFace;
    	public final float float1;
    	public final float float2;
    	public final float float3;

    	public PrePlow(EntityPlayer player, Block par2, int blockMeta, ItemStack stack, int par3, int par4, int par5, int par6, float f1, float f2, float f3)
    	{
    		super(player, par2, blockMeta, stack);
    		block = par2;
    		blockX = par3;
    		blockY = par4;
    		blockZ = par5;
    		blockFace = par6;
    		float1 = f1;
    		float2 = f2;
    		float3 = f3;
    	}
    }

    public static class PostPlow extends DqrFarmMGTEvent {
    	public final int blockX;
    	public final int blockY;
    	public final int blockZ;
    	public final int blockFace;
    	public final float float1;
    	public final float float2;
    	public final float float3;

    	public PostPlow(EntityPlayer player, Block par2, int blockMeta, ItemStack stack, int par3, int par4, int par5, int par6, float f1, float f2, float f3)
    	{
    		super(player, par2, blockMeta, stack);
    		block = par2;
    		blockX = par3;
    		blockY = par4;
    		blockZ = par5;
    		blockFace = par6;
    		float1 = f1;
    		float2 = f2;
    		float3 = f3;
    	}
    }
}

