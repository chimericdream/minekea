package com.chimericdream.minekea.client.screen.crate;

import com.chimericdream.lib.screen.SimpleInventoryScreenHandler;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.crates.CrateBlock;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CrateScreenHandler extends SimpleInventoryScreenHandler {
    public static final Identifier SCREEN_ID = Identifier.of(ModInfo.MOD_ID, "screens/container/crate");
    public static final Identifier TRAPPED_SCREEN_ID = Identifier.of(ModInfo.MOD_ID, "screens/container/crate/trapped");

    public CrateScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(null, syncId, playerInventory, CrateBlock.ROW_COUNT);
    }

    public CrateScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory, CrateBlock.ROW_COUNT);
    }

    public CrateScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId, playerInventory, inventory, CrateBlock.ROW_COUNT);
    }
}
