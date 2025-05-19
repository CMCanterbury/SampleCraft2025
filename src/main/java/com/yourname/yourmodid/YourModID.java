package com.yourname.yourmodid;

import com.yourname.yourmodid.registry.YMIBlocks;
import com.yourname.yourmodid.registry.YMICreativeModeTabs;
import com.yourname.yourmodid.registry.YMIItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(YourModID.MOD_ID)
public class YourModID {
    public static final String MOD_ID = "yourmodid";
    private static final Logger LOGGER = LogUtils.getLogger();

    public YourModID(IEventBus modEventBus, ModContainer modContainer) {
        YMIBlocks.register(modEventBus);
        YMIItems.register(modEventBus);
        YMICreativeModeTabs.register(modEventBus);
    }

}