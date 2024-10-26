package com.chimericdream.minekea.block.decorations;

import com.chimericdream.lib.text.TextHelpers;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FakeCakeBlock extends CakeBlock {
    public final static String TOOLTIP_KEY = "block.minekea.decorations.misc.fake_cake.tooltip";
    public final static Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/misc/fake_cake");

    public FakeCakeBlock() {
        super(AbstractBlock.Settings.copy(Blocks.CAKE));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(TextHelpers.getTooltip(TOOLTIP_KEY));
    }
}
