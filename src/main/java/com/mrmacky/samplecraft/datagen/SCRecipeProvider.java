package com.mrmacky.samplecraft.datagen;

import com.mrmacky.samplecraft.registry.SCBlocks;
import com.mrmacky.samplecraft.registry.SCItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class SCRecipeProvider extends RecipeProvider {
    public SCRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SCBlocks.EXAMPLE_BLOCK.get(), 2)
                .pattern("EDE")
                .pattern("DED")
                .pattern("EDE")
                .define('D', Items.DIAMOND)
                .define('E', SCItems.EXAMPLE_ITEM.get())
                .unlockedBy("has_example_item", has(SCItems.EXAMPLE_ITEM.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SCItems.EXAMPLE_ITEM.get(), 10)
                .requires(SCBlocks.EXAMPLE_BLOCK)
                .requires(Items.FLINT)
                .unlockedBy("has_example_block", has(SCBlocks.EXAMPLE_BLOCK))
                .save(recipeOutput, "samplecraft:funky_recipe_name");
    }
}
