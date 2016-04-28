package dqr.asm;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

// 必ずしも DummyModContainer を継承している必要はありません。
// cpw.mods.fml.common.ModContainer さえ実装していれば、どんなクラスでも構いません。

public class DqmModContainer extends DummyModContainer
{
    public DqmModContainer()
    {
        super(new ModMetadata());

        // 他のModと区別するための一意なIDやmodの名前など、MODのメタデータを設定します。
        ModMetadata meta = getMetadata();

        meta.modId       = "DQRCore";
        meta.name        = "DQRCore";
        meta.version     = "1.0.0";
        meta.authorList  = Arrays.asList("Azel");
        meta.description = "";
        meta.url         = "";
        meta.credits     = "";
        this.setEnabledState(true);
    }
    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
	bus.register(this);
	return true;
    }
}
