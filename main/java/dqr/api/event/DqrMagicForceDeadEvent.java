package dqr.api.event;

import net.minecraft.entity.Entity;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import dqr.entity.magicEntity.magic.MagicEntity;

@Cancelable
public class DqrMagicForceDeadEvent extends Event{

	public MagicEntity magic;
	public Entity shootingEntity;
	public DqrMagicForceDeadEvent(MagicEntity magic, Entity shootingEntity)
	{
		this.magic = magic;
		this.shootingEntity = shootingEntity;
	}
}
