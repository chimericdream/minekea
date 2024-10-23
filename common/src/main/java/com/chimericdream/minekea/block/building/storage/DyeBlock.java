package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DyeBlock extends Block {
    public final Identifier BLOCK_ID;
    public final String color;

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);

    public DyeBlock(String color) {
        super(AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).mapColor(DyeColor.byName(color, DyeColor.WHITE)).jumpVelocityMultiplier(0.5F));

        this.color = color;

        BLOCK_ID = makeId(color);
    }

    public static Identifier makeId(String color) {
        return Identifier.of(ModInfo.MOD_ID, String.format("storage/dyes/%s", color));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
        if (entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall())) {
            entity.playSound(this.soundGroup.getFallSound(), this.soundGroup.getVolume() * 0.5F, this.soundGroup.getPitch() * 0.75F);
        }
    }
}
