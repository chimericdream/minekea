package com.chimericdream.minekea.entity.block.furniture;

import com.chimericdream.lib.inventories.ImplementedInventory;
import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.block.furniture.armoires.ArmoireBlock;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class ArmoireBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory {
    private final BlockState cachedBlockState;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(16, ItemStack.EMPTY);
    private final List<ArmorStandEntity> armorStandEntities = new ArrayList<>();

    public ArmoireBlockEntity(BlockPos pos, BlockState state) {
        this(Armoires.ARMOIRE_BLOCK_ENTITY.get(), pos, state);
    }

    public ArmoireBlockEntity(BlockEntityType<? extends ArmoireBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        cachedBlockState = state;
    }

    @Override
    public void setWorld(World world) {
        super.setWorld(world);

        if (world instanceof ServerWorld && armorStandEntities.isEmpty()) {
            initializeArmorStands(cachedBlockState);
        }
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
        destroyArmorStands();
    }

    @Override
    public void cancelRemoval() {
        super.cancelRemoval();
        if (armorStandEntities.isEmpty()) {
            initializeArmorStands(cachedBlockState);
        }
    }

    private void updateArmorStands() {
        destroyArmorStands();
        initializeArmorStands(cachedBlockState);
    }

    public void initializeArmorStands(BlockState armoireState) {
        if (this.world == null) {
            return;
        }

        Triplet<Double, Double, Double> stand1Pos = getArmorStandPosition(0, armoireState);
        Triplet<Double, Double, Double> stand2Pos = getArmorStandPosition(1, armoireState);
        Triplet<Double, Double, Double> stand3Pos = getArmorStandPosition(2, armoireState);
        Triplet<Double, Double, Double> stand4Pos = getArmorStandPosition(3, armoireState);

        armorStandEntities.add(new ArmorStandEntity(this.world, stand1Pos.getA(), stand1Pos.getB(), stand1Pos.getC()));
        armorStandEntities.add(new ArmorStandEntity(this.world, stand2Pos.getA(), stand2Pos.getB(), stand2Pos.getC()));
        armorStandEntities.add(new ArmorStandEntity(this.world, stand3Pos.getA(), stand3Pos.getB(), stand3Pos.getC()));
        armorStandEntities.add(new ArmorStandEntity(this.world, stand4Pos.getA(), stand4Pos.getB(), stand4Pos.getC()));

        float yaw = getArmorStandYaw(armoireState);

        armorStandEntities.forEach(entity -> {
            entity.setInvisible(true);
            entity.setNoGravity(true);
            entity.setSmall(true);
            entity.setMarker(true);
            entity.setYaw(yaw);

            // Disable all in-world interactions
            entity.disabledSlots = 16191;

            world.spawnEntity(entity);
        });

        for (int i = 0; i < items.size(); i++) {
            if (i % 4 > 1) {
                continue;
            }

            EquipmentSlot itemSlot = i % 4 == 0 ? EquipmentSlot.CHEST : EquipmentSlot.LEGS;
            int armorStand = Math.floorDiv(i, 4);

            if (!items.get(i).isEmpty()) {
                armorStandEntities.get(armorStand).equipStack(itemSlot, items.get(i));
            }
        }
    }

    private float getArmorStandYaw(BlockState armoireState) {
        return switch (armoireState.get(ArmoireBlock.FACING)) {
            case NORTH -> -90.0f;
            case SOUTH -> 90.0f;
            case EAST -> 0.0f;
            case WEST -> -180.0f;
            default -> 0.0f;
        };
    }

    private Triplet<Double, Double, Double> getArmorStandPosition(int stand, BlockState armoireState) {
        double xOffset = switch (armoireState.get(ArmoireBlock.FACING)) {
            case NORTH -> 0.1875 + (0.21875 * stand);
            case SOUTH -> 0.8125 - (0.21875 * stand);
            case EAST -> 0.59375;
            case WEST -> 0.40625;
            default -> 0.0;
        };

        double zOffset = switch (armoireState.get(ArmoireBlock.FACING)) {
            case NORTH -> 0.40625;
            case SOUTH -> 0.59375;
            case EAST -> 0.1875 + (0.21875 * stand);
            case WEST -> 0.8125 - (0.21875 * stand);
            default -> 0.0;
        };

        return new Triplet<>(
            this.pos.getX() + xOffset,
            this.pos.getY() + 0.78125,
            this.pos.getZ() + zOffset
        );
    }

    public void destroyArmorStands() {
        armorStandEntities.forEach(entity -> {
            entity.remove(Entity.RemovalReason.DISCARDED);
        });

        armorStandEntities.clear();
    }

    public boolean hasItem(int slot) {
        return !items.get(slot).isEmpty();
    }

    public boolean canAccept(int slot, ItemStack item) {
        if (hasItem(slot) || !(item.getItem() instanceof ArmorItem armorItem)) {
            return false;
        }

        int slotType = slot % 4; // 0, 1, 2, 3 -> chestplate, leggings, helmet, boots

        return switch (slotType) {
            case 0 -> armorItem.getSlotType() == EquipmentSlot.CHEST;
            case 1 -> armorItem.getSlotType() == EquipmentSlot.LEGS;
            case 2 -> armorItem.getSlotType() == EquipmentSlot.HEAD;
            case 3 -> armorItem.getSlotType() == EquipmentSlot.FEET;
            default -> false;
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        items.clear();
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, items, registryLookup);

        if (this.world != null && this.world instanceof ServerWorld) {
            updateArmorStands();
        }

        markDirty();
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, items, registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        int[] result = new int[getItems().size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack items = Inventories.removeStack(getItems(), slot);

        if (!items.isEmpty()) {
            handleSuccessfulRemoval(slot);
        }

        return items;
    }

    @Override
    public ItemStack removeStack(int slot, int count) {
        ItemStack result = Inventories.splitStack(getItems(), slot, count);

        if (!result.isEmpty()) {
            handleSuccessfulRemoval(slot);
        }

        return result;
    }

    @Override
    public ItemStack tryInsert(int slot, ItemStack stack) {
        if (!canAccept(slot, stack)) {
            return stack;
        }

        ItemStack ret = stack.copy();
        ItemStack toInsert = stack.copy();
        toInsert.setCount(1);

        setStack(slot, toInsert);

        ret.decrement(1);

        if (!ItemStack.areEqual(ret, stack)) {
            handleSuccessfulInsert(slot, toInsert.copy());
        }

        return ret;
    }

    private void handleSuccessfulInsert(int slot, ItemStack inserted) {
        this.playAddItemSound(slot % 4);

        // Helmets and boots are rendered normally, so they shouldn't get equipped onto the hidden armor stands
        if (slot % 4 >= 2) {
            return;
        }

        int armorStandIndex = Math.floorDiv(slot, 4);
        EquipmentSlot itemSlot = slot % 4 == 0 ? EquipmentSlot.CHEST : EquipmentSlot.LEGS;

        if (armorStandIndex >= armorStandEntities.size()) {
            return;
        }

        armorStandEntities.get(armorStandIndex).equipStack(itemSlot, inserted);

        MinekeaMod.LOGGER.info("inserting into slot: {}, armor stand: {}", slot, armorStandIndex);
    }

    private void handleSuccessfulRemoval(int slot) {
        markDirty();

        if (slot % 4 >= 2) {
            return;
        }

        int armorStandIndex = Math.floorDiv(slot, 4);
        EquipmentSlot itemSlot = slot % 4 == 0 ? EquipmentSlot.CHEST : EquipmentSlot.LEGS;

        if (armorStandIndex >= armorStandEntities.size()) {
            return;
        }

        armorStandEntities.get(armorStandIndex).equipStack(itemSlot, ItemStack.EMPTY);
    }

    @Override
    public void markDirty() {
        if (this.world == null) {
            return;
        }

        markDirtyInWorld(this.world, this.pos, this.getCachedState());
    }

    protected void markDirtyInWorld(World world, BlockPos pos, BlockState state) {
        world.markDirty(pos);

        if (!world.isClient()) {
            ((ServerWorld) world).getChunkManager().markForUpdate(pos); // Mark changes to be synced to the client.
        }
    }

    public void playAddItemSound(int slot) {
        switch (slot) {
            case 0, 1 -> playSound(SoundEvents.ITEM_ARMOR_EQUIP_GENERIC.value());
            default -> playSound(SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM);
        }
    }

    public void playSound(SoundEvent soundEvent) {
        if (this.world == null) {
            return;
        }

        this.world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
