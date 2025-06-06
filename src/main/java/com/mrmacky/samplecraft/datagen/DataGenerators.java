package com.mrmacky.samplecraft.datagen;

import com.mrmacky.samplecraft.SampleCraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = SampleCraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(),
                new SCBlockStateProvider(packOutput, SampleCraft.MOD_ID, existingFileHelper));

        generator.addProvider(event.includeClient(),
                new SCItemModelProvider(packOutput, SampleCraft.MOD_ID, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new SCBlockTagProvider(packOutput, lookupProvider,
                        SampleCraft.MOD_ID, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new SCRecipeProvider(packOutput, lookupProvider));

    }

}
