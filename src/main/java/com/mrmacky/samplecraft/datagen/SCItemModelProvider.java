package com.mrmacky.samplecraft.datagen;

import com.mrmacky.samplecraft.registry.SCItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SCItemModelProvider extends ItemModelProvider {
    public SCItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(SCItems.EXAMPLE_ITEM.get());
    }
}
