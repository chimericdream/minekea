package com.chimericdream.minekea.network;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.nbt.NbtHelpers;
import com.chimericdream.minekea.item.tools.BlockPainterItem;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.util.StreamUtils;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ServerNetworking {
    public static Identifier CYCLE_PAINTER_COLOR = Identifier.of(ModInfo.MOD_ID, "events/items/painter/cycle");

    public static void init() {
    }

    protected static void handleCyclePainterColorPacket(MinecraftServer server, ServerPlayerEntity player) {
        if (server != null && player != null) {
            server.execute(() -> {
                ItemStack heldItem = StreamUtils.asStream(player.getHandItems().iterator())
                    .filter((itemStack) -> itemStack.getItem() instanceof BlockPainterItem)
                    .findFirst()
                    .orElse(ItemStack.EMPTY);

                if (heldItem.isEmpty()) {
                    return;
                }

                ColoredBlocksRegistry.BlockColor nextColor = BlockPainterItem.getNextColor(heldItem);

                NbtCompound nbt = new NbtCompound();
                nbt.putString("current_color", nextColor.toString());
                heldItem.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
                heldItem.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(nextColor.getModelNumber()));

                NbtHelpers.setCustomDataFromNbt(heldItem, BlockPainterItem.makeNbt(nbt, nextColor));
            });
        }
    }
}
