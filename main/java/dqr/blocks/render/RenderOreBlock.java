package dqr.blocks.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import dqr.DQR;
import dqr.api.Blocks.DQOres;
import dqr.blocks.base.DqmBlockOreBase;

public class RenderOreBlock implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

        GL11.glPushMatrix();

        Tessellator tessellator = Tessellator.instance;
        renderer.setOverrideBlockTexture(Blocks.stone.getIcon(0, 0));
        renderer.setRenderBounds(0.0001D, 0.0001D, 0.0001D, 0.9999D, 0.9999D, 0.9999D);

        DqmBlockOreBase dqmOre = (DqmBlockOreBase)DQOres.BlockOreTekkouseki;
        if(block instanceof DqmBlockOreBase)
        {
        	dqmOre = (DqmBlockOreBase)block;
        }

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        GL11.glPopMatrix();

        GL11.glPushMatrix();

        renderer.clearOverrideBlockTexture();
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

        metadata = 8;

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, dqmOre.getTexture());
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        GL11.glPopMatrix();

    }

    /*
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        if (this.getRenderId() != modelId) return false;

        double s = 0.0001D;

        //renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        //renderer.setRenderBounds(-0.0001D, -0.0001D, -0.0001D, 1.0001D, 1.0001D, 1.0001D);
        //renderer.renderStandardBlock(block, x, y, z);

        //renderer.renderAllFaces = true;

        //renderer.setOverrideBlockTexture(Blocks.stone.getIcon(0, 0));
        //renderer.setRenderBounds(0.0001D, 0.0001D, 0.0001D, 0.9999D, 0.9999D, 0.9999D);
        //renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        ////renderer.renderStandardBlock(block, x, y, z);
        //renderer.renderAllFaces = false;

        //renderer.clearOverrideBlockTexture();

        ////int metadata = 8;//world.getBlockMetadata(x, y, z);

        //int mixedBrightness = block.getMixedBrightnessForBlock(world, x, y, z);

        ////Tessellator tesselator = Tessellator.instance;

        //tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        //tesselator.setColorOpaque_F(0.6F, 0.6F, 0.6F);
        //tesselator.setColorOpaque_F(1.0F, 1.0F, 1.0F);


//        if (block.shouldSideBeRendered(world, x, y - 1, z, 0)) {
//        	tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x, y - 1, z));
//        	tesselator.setColorOpaque_F(0.45F, 0.45F, 0.45F);
//        	renderer.renderFaceYNeg(block, x, y, z, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
//        }
//
//        if (block.shouldSideBeRendered(world, x, y + 1, z, 1)) {
//        	tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x, y + 1, z));
//        	tesselator.setColorOpaque_F(0.88F, 0.88F, 0.88F);
//        	renderer.renderFaceYPos(block, x, y, z, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
//        }
//
//        if (block.shouldSideBeRendered(world, x, y, z - 1, 2)) {
//        	tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z - 1));
//        	tesselator.setColorOpaque_F(0.7F, 0.7F, 0.7F);
//        	renderer.renderFaceZNeg(block, x, y, z, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
//        }
//
//        if (block.shouldSideBeRendered(world, x, y, z + 1, 3)) {
//        	tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z + 1));
//        	tesselator.setColorOpaque_F(0.7F, 0.7F, 0.7F);
//        	renderer.renderFaceZPos(block, x, y, z, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
//        }
//
//        if (block.shouldSideBeRendered(world, x - 1, y, z, 4)) {
//        	tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x - 1, y, z));
//        	tesselator.setColorOpaque_F(0.6F, 0.6F, 0.6F);
//        	renderer.renderFaceXNeg(block, x, y, z, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
//        }
//
//        if (block.shouldSideBeRendered(world, x + 1, y, z, 5)) {
//        	tesselator.setBrightness(block.getMixedBrightnessForBlock(world, x + 1, y, z));
//        	tesselator.setColorOpaque_F(0.6F, 0.6F, 0.6F);
//        	renderer.renderFaceXPos(block, x, y, z, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
//        }



        GL11.glPushMatrix();
        renderer.renderStandardBlock(Blocks.stone, x, y, z);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        renderer.renderStandardBlock(block, x, y, z);
        GL11.glPopMatrix();

        return true;

    }
    */

    public boolean renderWorldBlock(IBlockAccess iblockaccess, int blockX, int blockY, int blockZ, Block block, int renderType, RenderBlocks renderblocks)
    {
      if (renderType == DQR.blockRenderType.renderOreBlockID)
      {
        renderblocks.renderBlockLog(block, blockX, blockY, blockZ);

        /*
        GL11.glPushMatrix();
        renderblocks.renderStandardBlock(Blocks.stone, blockX, blockY, blockZ);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        renderblocks.renderStandardBlock(block, blockX, blockY, blockZ);
        GL11.glPopMatrix();
        */

        boolean ret = renderOre(iblockaccess, blockX, blockY, blockZ, block, renderType, renderblocks);

        return ret;
      }
      return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return DQR.blockRenderType.renderOreBlockID;
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

      Block icon = null;

      BiomeGenBase biome = iblockaccess.getBiomeGenForCoords(blockX, blockZ);

      icon =  DQR.BiomeBlock.getBiomeBaseBlock(biome.biomeID, 0);

      //System.out.println(icon.getIconName() + "/" + biome.biomeID);
      DqmBlockOreBase dqmOre = (DqmBlockOreBase)DQOres.BlockOreTekkouseki;
      if(block instanceof DqmBlockOreBase)
      {
      	dqmOre = (DqmBlockOreBase)block;

      }
      //IIcon icon = icon;


      tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX, blockY, blockZ));
      tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
      /*
      if (renderblocks.overrideBlockTexture != null) {
        icon = renderblocks.overrideBlockTexture;
      }
      */

      if ((idXp == Blocks.air) || (!nrXp)) {
    	  tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX + 1, blockY, blockZ));
    	  tessellator.setColorOpaque_F(0.6F, 0.6F, 0.6F);
        renderblocks.renderFaceXPos(block, blockX, blockY, blockZ, renderblocks.getBlockIconFromSideAndMetadata(icon, 5, meta));
        renderblocks.renderFaceXPos(block, blockX, blockY, blockZ, dqmOre.getTexture());
      }
      if ((idXm == Blocks.air) || (!nrXm)) {
      	//renderblocks.renderFaceXNeg(block, blockX, blockY, blockZ, icon);
    	  tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX - 1, blockY, blockZ));
    	  tessellator.setColorOpaque_F(0.6F, 0.6F, 0.6F);
    	  renderblocks.renderFaceXNeg(block, blockX, blockY, blockZ, renderblocks.getBlockIconFromSideAndMetadata(icon, 4, meta));
        renderblocks.renderFaceXNeg(block, blockX, blockY, blockZ, dqmOre.getTexture());
      }
      if ((idZp == Blocks.air) || (!nrZp)) {
      	//renderblocks.renderFaceZPos(block, blockX, blockY, blockZ, icon);
    	  tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX, blockY, blockZ + 1));
      	tessellator.setColorOpaque_F(0.7F, 0.7F, 0.7F);
    	  renderblocks.renderFaceZPos(block, blockX, blockY, blockZ, renderblocks.getBlockIconFromSideAndMetadata(icon, 3, meta));
        renderblocks.renderFaceZPos(block, blockX, blockY, blockZ, dqmOre.getTexture());
      }
      if ((idZm == Blocks.air) || (!nrZm)) {
      	//renderblocks.renderFaceZNeg(block, blockX, blockY, blockZ, icon);
    	  tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX, blockY, blockZ - 1));
    	  tessellator.setColorOpaque_F(0.7F, 0.7F, 0.7F);
    	renderblocks.renderFaceZNeg(block, blockX, blockY, blockZ, renderblocks.getBlockIconFromSideAndMetadata(icon, 2, meta));
        renderblocks.renderFaceZNeg(block, blockX, blockY, blockZ, dqmOre.getTexture());
      }
      if ((idYp == Blocks.air) || (!nrYp)) {
      	//renderblocks.renderFaceYPos(block, blockX, blockY, blockZ, icon);
    	  tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX, blockY + 1, blockZ));
    	  tessellator.setColorOpaque_F(0.88F, 0.88F, 0.88F);
    	renderblocks.renderFaceYPos(block, blockX, blockY, blockZ, renderblocks.getBlockIconFromSideAndMetadata(icon, 1, meta));
        renderblocks.renderFaceYPos(block, blockX, blockY, blockZ, dqmOre.getTexture());
      }
      if ((idYm == Blocks.air) || (!nrYm)) {
      	//renderblocks.renderFaceYNeg(block, blockX, blockY, blockZ, icon);
    	  tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, blockX, blockY - 1, blockZ));
    	  tessellator.setColorOpaque_F(0.45F, 0.45F, 0.45F);
    	  renderblocks.renderFaceYNeg(block, blockX, blockY, blockZ, renderblocks.getBlockIconFromSideAndMetadata(icon, 0, 0));
        renderblocks.renderFaceYNeg(block, blockX, blockY, blockZ, dqmOre.getTexture());
      }
      return true;
    }


}
