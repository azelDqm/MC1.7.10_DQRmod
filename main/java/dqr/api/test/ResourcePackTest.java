package dqr.api.test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class ResourcePackTest implements IResourcePack{

	@Override
	public InputStream getInputStream(ResourceLocation p_110590_1_)
			throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean resourceExists(ResourceLocation p_110589_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public Set getResourceDomains() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public IMetadataSection getPackMetadata(IMetadataSerializer p_135058_1_,
			String p_135058_2_) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BufferedImage getPackImage() throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPackName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
