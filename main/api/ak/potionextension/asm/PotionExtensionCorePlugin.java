package ak.potionextension.asm;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

/**
 * Created by A.K. on 14/07/07.
 */
public class PotionExtensionCorePlugin implements IFMLLoadingPlugin {
    public static final Logger LOGGER = Logger.getLogger("potionextension");
    public static int maxPotionArray = 128;
    static File location;

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"ak.potionextension.asm.PotionEffectTransformer","ak.potionextension.asm.PotionArrayTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "ak.potionextension.asm.PotionExtensionCoreContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        for (String key : data.keySet()) {
            System.out.println("val : " + data.get(key) + "/key : " + key);
        }

        if (data.containsKey("coremodLocation"))
        {
        	if(data.get("coremodLocation") != null)
        	{
        		location = (File) data.get("coremodLocation");
        	}else
        	{
        		//location = (File) new File("C:/Users/root/AppData/Roaming/.minecraft/mods/1.7.10/PotionExtension-1.0.1.jar");
        		location = (File) new File("C:/Users/root/AppData/Roaming/.minecraft/mods/modid-1.0.jar");
        	}

        }
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }


}
