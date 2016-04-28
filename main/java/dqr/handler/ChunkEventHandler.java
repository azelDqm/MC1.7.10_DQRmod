package dqr.handler;

import java.util.List;

import net.minecraftforge.event.world.ChunkEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.entity.petEntity.DqmPetBase;

public class ChunkEventHandler {

	@SubscribeEvent
	public void onChunkUnloadEvent(ChunkEvent.Unload event)
	{
		//System.out.println("TEST_1");
		if(!event.world.isRemote)
		{
			//System.out.println("TEST_2");
			List[] entityLists = event.getChunk().entityLists;

			if(entityLists != null && entityLists.length > 0)
			{

				for(int cnt1 = 0; cnt1 < entityLists.length; cnt1++)
				{
					List eList = entityLists[cnt1];

					if(eList != null && eList.size() > 0)
					{
						for(int cnt2 = 0; cnt2 < eList.size(); cnt2++)
						{

							if(eList.get(cnt2) instanceof DqmPetBase)
							{
								DqmPetBase pet = (DqmPetBase)eList.get(cnt2);
								//System.out.println("ChunkEventRun!!!!");
								DQR.petFunc.setUnloadPet(pet);
							}
						}
					}
				}
			}
		}
	}
}
