package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entity.block.containers.CrateBlockEntity;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;

public class TrappedCrateBlock extends CrateBlock {
    public final RegistrySupplier<Block> BASE_CRATE;

    public TrappedCrateBlock(Settings settings) {
        super(settings);
        BASE_CRATE = Crates.CRATES.get("oak");
    }

    public TrappedCrateBlock(BlockConfig config, RegistrySupplier<Block> baseCrate) {
        super(config);

        BLOCK_ID = makeId(config.getMaterial());
        BASE_CRATE = baseCrate;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("containers/crates/trapped/%s", material));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(Crates.CRATE_BLOCK_ENTITY.get(), pos, state, true);
    }

    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return MathHelper.clamp(CrateBlockEntity.getPlayersLookingInCrateCount(world, pos), 0, 15);
    }

    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.getWeakRedstonePower(world, pos, direction);
    }
}
