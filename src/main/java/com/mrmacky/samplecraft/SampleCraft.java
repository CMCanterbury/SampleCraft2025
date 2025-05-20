package com.mrmacky.samplecraft;

import com.mrmacky.samplecraft.registry.SCBlocks;
import com.mrmacky.samplecraft.registry.SCCreativeModeTabs;
import com.mrmacky.samplecraft.registry.SCItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(SampleCraft.MOD_ID)
public class SampleCraft {
    public static final String MOD_ID = "samplecraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SampleCraft(IEventBus modEventBus, ModContainer modContainer) {
        SCBlocks.register(modEventBus);
        SCItems.register(modEventBus);
        SCCreativeModeTabs.register(modEventBus);
    }

}