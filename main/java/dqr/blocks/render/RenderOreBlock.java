package dqr.blocks.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQOres;
import dqr.blocks.base.DqmBlockOreBase;

@SideOnly(Side.CLIENT)
public class RenderOreBlock
  implements ISimpleBlockRenderingHandler
{
  public boolean renderWorldBlock(IBlockAccess iblockaccess, int blockX, int blockY, int blockZ, Block block, int renderType, RenderBlocks renderblocks)
  {
    if (renderType == DQR.blockRenderType.renderOreBlockID)
    {
      renderblocks.renderBlockLog(block, blockX, blockY, blockZ);

      boolean ret = renderOre(iblockaccess, blockX, blockY, blockZ, block, renderType, renderblocks);

      return true;
    }
    return true;
  }

  private boolean renderOre(IBlockAccess iblockaccess, int blockX, int blockY, int blockZ, Block block, int renderType, RenderBlocks renderblocks)
  {

    Block idXp = iblockaccess.getBlock(blockX + 1, blockY, blockZ);
    Block idXm = iblockaccess.getBlock(blockX - 1, blockY, blockZ);
    Block idZp = iblockaccess.getBlock(blockX, blockY, blockZ + 1);
    Block idZm = iblockaccess.getBlock(blockX, blockY, blockZ - 1);
    Block idYp = iblockaccess.getBlock(blockX, blockY + 1, blockZ);
    Block idYm = iblockaccess.getBlock(blockX, blockY - 1, blockZ);

    boolean nrXp = iblockaccess.getBlock(blockX + 1, blockY, blockZ).isNormalCube();
    boolean nrXm = iblockaccess.getBlock(blockX - 1, blockY, blockZ).isNormalCube();
    boolean nrZp = iblockaccess.getBlock(blockX, blockY, blockZ + 1).isNormalCube();
    boolean nrZm = iblockaccess.getBlock(blockX, blockY, blockZ - 1).isNormalCube();
    boolean nrYp = iblockaccess.getBlock(blockX, blockY + 1, blockZ).isNormalCube();
    boolean nrYm = iblockaccess.getBlock(blockX, blockY - 1, blockZ).isNormalCube();


    int meta = iblockaccess.getBlockMetadata(blockX, blockY, blockZ);

    Tessellator tessellator = Tessellator.instance;

    IIcon icon = null;

    BiomeGenBase biome = iblockaccess.getBiomeGenForCoords(blockX, blockZ);

    icon =  DQR.BiomeBlock.getBiomeBaseIIcon(biome.biomeID, 0);

    //System.out.println(icon.getIconName() + "/" + biome.biomeID);
    DqmBlockOreBase dqmOre = (DqmBlockOreBase)DQOres.BlockOreTekkouseki;
    if(block instanceof DqmBlockOreBase)
    {
    	dqmOre = (DqmBlockOreBase)block;

    }
    //IIcon icon = icon;


    tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX, blockY, blockZ));
    tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
    if (renderblocks.overrideBlockTexture != null) {
      icon = renderblocks.overrideBlockTexture;
    }
    if ((idXp == Blocks.air) || (!nrXp)) {
      renderblocks.renderFaceXPos(block, blockX, blockY, blockZ, icon);
      renderblocks.renderFaceXPos(block, blockX, blockY, blockZ, dqmOre.getTexture());

    }
    if ((idXm == Blocks.air) || (!nrXm)) {
    	renderblocks.renderFaceXNeg(block, blockX, blockY, blockZ, icon);
      renderblocks.renderFaceXNeg(block, blockX, blockY, blockZ, dqmOre.getTexture());
    }
    if ((idZp == Blocks.air) || (!nrZp)) {
    	renderblocks.renderFaceZPos(block, blockX, blockY, blockZ, icon);
      renderblocks.renderFaceZPos(block, blockX, blockY, blockZ, dqmOre.getTexture());
    }
    if ((idZm == Blocks.air) || (!nrZm)) {
    	renderblocks.renderFaceZNeg(block, blockX, blockY, blockZ, icon);
      renderblocks.renderFaceZNeg(block, blockX, blockY, blockZ, dqmOre.getTexture());
    }
    if ((idYp == Blocks.air) || (!nrYp)) {
    	renderblocks.renderFaceYPos(block, blockX, blockY, blockZ, icon);
      renderblocks.renderFaceYPos(block, blockX, blockY, blockZ, dqmOre.getTexture());
    }
    if ((idYm == Blocks.air) || (!nrYm)) {
    	renderblocks.renderFaceYNeg(block, blockX, blockY, blockZ, icon);
      renderblocks.renderFaceYNeg(block, blockX, blockY, blockZ, dqmOre.getTexture());
    }
    return true;
  }

  public void renderInventoryBlock(Block block, int i, int modelID, RenderBlocks renderblocks)
  {
    Tessellator tessellator = Tessellator.instance;


    block.setBlockBoundsForItemRender();
    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

    IIcon icon = null;

    //BiomeGenBase biome = iblockaccess.getBiomeGenForCoords(blockX, blockZ);

    //icon =  DQR.BiomeBlock.getBiomeBaseIIcon(biome.biomeID, 0);
    icon = Blocks.stone.getBlockTextureFromSide(0);

    DqmBlockOreBase dqmOre = (DqmBlockOreBase)DQOres.BlockOreTekkouseki;
    if(block instanceof DqmBlockOreBase)
    {
    	dqmOre = (DqmBlockOreBase)block;

    }

    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, -1.0F, 0.0F);
    renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
    renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    tessellator.draw();

    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 1.0F, 0.0F);
    renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
    renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    //renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
    //renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    tessellator.draw();




    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 0.0F, -1.0F);
    renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
    renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    tessellator.draw();

    tessellator.startDrawingQuads();
    tessellator.setNormal(0.0F, 0.0F, 1.0F);
    renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
    renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    tessellator.draw();

    tessellator.startDrawingQuads();
    tessellator.setNormal(-1.0F, 0.0F, 0.0F);
    renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
    renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    tessellator.draw();

    tessellator.startDrawingQuads();
    tessellator.setNormal(1.0F, 0.0F, 0.0F);
    renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
    renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
    tessellator.draw();


    GL11.glTranslatef(0.5F, 0.5F, 0.5F);


    renderblocks.clearOverrideBlockTexture();
  }

  public int getRenderId()
  {
    return DQR.blockRenderType.renderOreBlockID;
  }

  public boolean shouldRender3DInInventory(int modelId)
  {
    return true;
  }
}
