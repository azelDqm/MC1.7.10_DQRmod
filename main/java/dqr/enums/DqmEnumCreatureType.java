package dqr.enums;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.IMob;
import net.minecraftforge.common.util.EnumHelper;
import dqr.DQR;

public class DqmEnumCreatureType {
	//private static final Class<?>[][] paramTypes = new Class[][] {{EnumCreatureType.class, Class.class, int.class, Material.class, boolean.class, boolean.class}};
	public static EnumCreatureType VanillaMonster = EnumHelper.addCreatureType("Vanillamonster", IMob.class, DQR.conf.VanillaMobSpawn, Material.air, false, false);
	public static EnumCreatureType DqmMonster = EnumHelper.addCreatureType("DQMmonster", IMob.class, DQR.conf.DqmMobSpawn, Material.air, false, false);

	public DqmEnumCreatureType()
	{
	}
}
