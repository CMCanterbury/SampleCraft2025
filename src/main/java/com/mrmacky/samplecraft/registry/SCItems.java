package com.mrmacky.samplecraft.registry;

import com.mrmacky.samplecraft.SampleCraft;
import com.mrmacky.samplecraft.items.ThronglerItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Optional;

public class SCItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SampleCraft.MOD_ID);

    //Items go here
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new ThronglerItem(new Item.Properties()));
//                    .stacksTo(200)
//                    .fireResistant()
//                    .food(
//                            new FoodProperties(10, 2, true, 5,
//                                    Optional.of(Items.DIAMOND.getDefaultInstance()),
//                                    List.of(new FoodProperties.PossibleEffect(() -> new MobEffectInstance(MobEffects.DARKNESS, 1000), 1))))
//                    ));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}