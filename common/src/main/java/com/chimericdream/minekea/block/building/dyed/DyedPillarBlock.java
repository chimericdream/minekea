package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DyedPillarBlock extends PillarBlock {
    public static final EnumProperty<Direction.Axis> AXIS;

    static {
        AXIS = Properties.AXIS;
    }

    public final Identifier BLOCK_ID;
    public final BlockConfig config;
    public final DyeColor color;

    public DyedPillarBlock(
        BlockConfig config,
        DyeColor color
    ) {
        super(config.getBaseSettings().mapColor(color));

        this.color = color;

        BLOCK_ID = makeId(config.getMaterial(), color);
        this.config = config;

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    public static Identifier makeId(String material, DyeColor color) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/dyed/%s/%s", material, color));
    }

    public BlockConfig getConfig() {
        return config;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        PotionContentsComponent potionContentsComponent = stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
        BlockState blockState = world.getBlockState(pos);
        if (hit.getSide() != Direction.DOWN && potionContentsComponent.matches(Potions.WATER)) {
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
            player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));

            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld) world;

                for (int i = 0; i < 5; ++i) {
                    serverWorld.spawnParticles(ParticleTypes.SPLASH, (double) pos.getX() + world.random.nextDouble(), pos.getY() + 1, (double) pos.getZ() + world.random.nextDouble(), 1, 0.0, 0.0, 0.0, 1.0);
                }
            }

            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            world.setBlockState(pos, config.getIngredient().getDefaultState().with(AXIS, blockState.get(AXIS)));
            return ItemActionResult.success(world.isClient);
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
