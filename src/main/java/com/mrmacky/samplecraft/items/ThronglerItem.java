package com.mrmacky.samplecraft.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.*;
import net.minecraft.world.phys.Vec3;

public class ThronglerItem extends Item {

    public ThronglerItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity victim, LivingEntity attacker) {
        if (attacker instanceof ServerPlayer serverPlayer) {
            ServerLevel serverLevel = (ServerLevel) attacker.level();

            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
            lightningBolt.setPos(victim.getX(), victim.getY(), victim.getZ());
            serverLevel.addFreshEntity(lightningBolt);

            Chicken chicken = new Chicken(EntityType.CHICKEN, serverLevel);
            chicken.setChickenJockey(true);
            chicken.setPos(Vec3.atLowerCornerOf(victim.getOnPos().above()));
            serverLevel.addFreshEntity(chicken);

        }
        attacker.level().playSound(victim, attacker.getOnPos().above().above(), SoundEvents.WITHER_SPAWN, SoundSource.BLOCKS, 100F, 1F);
        return true;
    }

}
