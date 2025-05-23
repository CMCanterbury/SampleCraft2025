package com.mrmacky.samplecraft.datagen;

import com.mrmacky.samplecraft.registry.SCBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SCBlockStateProvider extends BlockStateProvider {
    public SCBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(SCBlocks.EXAMPLE_BLOCK.get(), cubeAll(SCBlocks.EXAMPLE_BLOCK.get()));
    }
}
