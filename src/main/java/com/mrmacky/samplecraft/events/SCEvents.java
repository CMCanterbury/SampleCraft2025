package com.mrmacky.samplecraft.events;


import com.mrmacky.samplecraft.SampleCraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = SampleCraft.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class SCEvents {

    @SubscribeEvent
    public static void doAThing(LivingDamageEvent.Pre event) {

    }

}