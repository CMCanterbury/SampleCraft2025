package com.mrmacky.samplecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BoomBlock extends Block {

    public BoomBlock(Properties p) {
        super(p);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (!entity.isSteppingCarefully() && !level.isClientSide) {
            PrimedTnt primedTnt = new PrimedTnt(level, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, null);
            primedTnt.setFuse(0);
            level.addFreshEntity(primedTnt);
            level.playSound(null, primedTnt.getX(), primedTnt.getY(), primedTnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        super.stepOn(level, pos, state, entity);
    }

}
