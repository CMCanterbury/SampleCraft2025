package com.yourname.yourmodid.events;


import com.yourname.yourmodid.YourModID;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = YourModID.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class YMIEvents {

    @SubscribeEvent
    public static void doAThing(LivingDamageEvent.Pre event) {

    }

}