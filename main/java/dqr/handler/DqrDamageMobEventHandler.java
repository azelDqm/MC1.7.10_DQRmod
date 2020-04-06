package dqr.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.event.DqrDamageMobEvent;

public class DqrDamageMobEventHandler {

    @SubscribeEvent
    public void onDamageMobEvent(DqrDamageMobEvent event)
    {
    	if(event.source.getDamageType().equalsIgnoreCase("DqmJSkillDamage_1_1"))
    	{
    		DQR.func.debugString("TESTTEST");
    		//遊び人:石投げ
    		event.absoluteDamage = 1.5f;
    		event.retAbsoluteDamage = 1.5f;
    		event.damage = 1.0f;
    	}
    }
}
