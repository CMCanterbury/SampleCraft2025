package com.mrmacky.samplecraft.registry;

import com.mrmacky.samplecraft.SampleCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber(modid = SampleCraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SCCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SampleCraft.MOD_ID);

    //Creative mode tabs go here
    public static final Supplier<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register(
            "example_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(SCItems.EXAMPLE_ITEM.get()))
                    .title(Component.translatable("creativetab.samplecraft.example_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(SCItems.EXAMPLE_ITEM);
                        output.accept(Items.ACACIA_FENCE);
                        output.accept(SCBlocks.EXAMPLE_BLOCK);
                    })
                    .build()
    );

    public static final Supplier<CreativeModeTab> TAB_NUMBER_TWO = CREATIVE_MODE_TABS.register(
            "tab_2",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(SCItems.EXAMPLE_ITEM.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SampleCraft.MOD_ID, "example_tab"))
                    .title(Component.translatable("creativetab.samplecraft.tab_2"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.DOLPHIN_SPAWN_EGG);
                        output.accept(Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
                    })
                    .build()
    );

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }

    @SubscribeEvent
    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(SCItems.EXAMPLE_ITEM);
        }
    }

}