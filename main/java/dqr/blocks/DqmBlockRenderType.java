package dqr.blocks;

import dqr.DQR;

public class DqmBlockRenderType {
	public static int renderOreBlockID;

	public DqmBlockRenderType()
	{
		renderOreBlockID = DQR.proxy.getNewRenderType();
	}
}
