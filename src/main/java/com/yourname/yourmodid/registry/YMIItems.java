package com.yourname.yourmodid.registry;

import com.yourname.yourmodid.YourModID;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class YMIItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YourModID.MOD_ID);

    //Items go here

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}