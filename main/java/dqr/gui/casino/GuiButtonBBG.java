package dqr.gui.casino;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.settings.GameSettings.Options;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiButtonBBG extends GuiOptionButton{

	protected static final ResourceLocation buttonTextures = new ResourceLocation("dqr:textures/casino/widgets5.png");
	public int height = 15;
	public int newFlg = 0;

	public GuiButtonBBG(int p_i45011_1_, int p_i45011_2_, int p_i45011_3_,
			String p_i45011_4_) {
		super(p_i45011_1_, p_i45011_2_, p_i45011_3_, p_i45011_4_);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public GuiButtonBBG(int p_i45012_1_, int p_i45012_2_, int p_i45012_3_,
			int p_i45012_4_, int p_i45012_5_, String p_i45012_6_) {
		super(p_i45012_1_, p_i45012_2_, p_i45012_3_, p_i45012_4_, p_i45012_5_,
				p_i45012_6_);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public GuiButtonBBG(int p_i45012_1_, int p_i45012_2_, int p_i45012_3_,
			int p_i45012_4_, int p_i45012_5_, String p_i45012_6_, int flg) {
		super(p_i45012_1_, p_i45012_2_, p_i45012_3_, p_i45012_4_, p_i45012_5_,
				p_i45012_6_);
		newFlg = flg;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public GuiButtonBBG(int p_i45013_1_, int p_i45013_2_, int p_i45013_3_,
			Options p_i45013_4_, String p_i45013_5_) {
		super(p_i45013_1_, p_i45013_2_, p_i45013_3_, p_i45013_4_, p_i45013_5_);
		// TODO 自動生成されたコンストラクター・スタブ
	}


	@Override
    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            p_146112_1_.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            k = newFlg + k;
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0 + k * 15, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 0 + k * 15, this.width / 2, this.height);
            this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = 14737632;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.field_146123_n)
            {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        	/*
            FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            p_146112_1_.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            k = newFlg + k;
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = 14737632;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.field_146123_n)
            {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
            */
        }
    }
}
