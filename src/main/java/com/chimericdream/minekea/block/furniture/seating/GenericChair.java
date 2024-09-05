//package com.chimericdream.minekea.block.furniture.seating;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.entities.mounts.SeatEntity;
//import com.chimericdream.minekea.item.ItemGroups;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.MinekeaTags;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
//import net.fabricmc.fabric.api.registry.FuelRegistry;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.ShapeContext;
//import net.minecraft.block.Waterloggable;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemPlacementContext;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.BooleanProperty;
//import net.minecraft.state.property.DirectionProperty;
//import net.minecraft.state.property.Properties;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Box;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.util.shape.VoxelShapes;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//public class GenericChair extends Block implements MinekeaBlock, Waterloggable {
//    public static final DirectionProperty FACING;
//
//    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
//
//    private static final VoxelShape SEAT_SHAPE;
//    private static final VoxelShape[] LEG_SHAPES;
//    private static final Map<String, VoxelShape> SEAT_BACKS;
//
//    static {
//        FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
//
//        SEAT_SHAPE = Block.createCuboidShape(2.0, 8.0, 2.0, 14.0, 10.0, 14.0);
//        LEG_SHAPES = new VoxelShape[]{
//            Block.createCuboidShape(2.0, 0.0, 2.0, 4.0, 8.0, 4.0), // north-west
//            Block.createCuboidShape(12.0, 0.0, 2.0, 14.0, 8.0, 4.0), // north-east
//            Block.createCuboidShape(12.0, 0.0, 12.0, 14.0, 8.0, 14.0), // south-east
//            Block.createCuboidShape(2.0, 0.0, 12.0, 4.0, 8.0, 14.0) // south-west
//        };
//        SEAT_BACKS = Map.of(
//            "north", Block.createCuboidShape(2.0, 10.0, 2.0, 14.0, 22.0, 4.0),
//            "south", Block.createCuboidShape(2.0, 10.0, 12.0, 14.0, 22.0, 14.0),
//            "east", Block.createCuboidShape(12.0, 10.0, 2.0, 14.0, 22.0, 14.0),
//            "west", Block.createCuboidShape(2.0, 10.0, 2.0, 4.0, 22.0, 14.0)
//        );
//    }
//
//    public GenericChair(ChairSettings settings) {
//        super(settings);
//
//        this.setDefaultState(
//            this.stateManager.getDefaultState()
//                .with(FACING, Direction.NORTH)
//                .with(WATERLOGGED, false)
//        );
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((ChairSettings) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//        Registry.register(Registries.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroups.FURNITURE)));
//
//        if (isFlammable) {
//            FuelRegistry.INSTANCE.add(this, 300);
//            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
//        }
//
//        setupResources();
//    }
//
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(FACING, WATERLOGGED);
//    }
//
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        Direction dir = Direction.NORTH;
//        if (ctx.getPlayer() != null) {
//            dir = ctx.getPlayer().getHorizontalFacing();
//        }
//
//        return this.getDefaultState()
//            .with(FACING, dir)
//            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
//    }
//
//    @Override
//    public FluidState getFluidState(BlockState state) {
//        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
//    }
//
//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        if (state.get(WATERLOGGED)) {
//            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
//    }
//
//    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return super.getCollisionShape(state, world, pos, context);
//    }
//
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (world.isClient()) {
//            return ActionResult.SUCCESS;
//        }
//
//        List<SeatEntity> seats = world.getEntitiesByClass(SeatEntity.class, new Box(pos), (Object) -> true);
//
//        if (seats.size() == 0 && player.isSneaking()) {
//            world.setBlockState(pos, state.with(FACING, state.get(FACING).rotateYClockwise()));
//
//            return ActionResult.SUCCESS;
//        } else if (seats.size() == 0) {
//            SeatEntity seat = Seats.SEAT_ENTITY.create(world);
//            Vec3d seatPos = new Vec3d(hit.getBlockPos().getX() + 0.5d, hit.getBlockPos().getY() + 1.15d, hit.getBlockPos().getZ() + 0.5d);
//
//            seat.updatePosition(seatPos.getX(), seatPos.getY(), seatPos.getZ());
//            world.spawnEntity(seat);
//            player.startRiding(seat);
//
//            return ActionResult.SUCCESS;
//        }
//
//        return ActionResult.PASS;
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        Direction facing = state.get(FACING);
//
//        if (facing == Direction.SOUTH) {
//            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("north"));
//        }
//
//        if (facing == Direction.EAST) {
//            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("west"));
//        }
//
//        if (facing == Direction.WEST) {
//            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("east"));
//        }
//
//        return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("south"));
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.CHAIRS.add(getBlockID(), settings.isWooden());
//        MinekeaTags.SEATING.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier PLANK_MATERIAL = settings.getMaterial("planks");
//        Identifier LOG_MATERIAL = settings.getMaterial("log");
//
//        Identifier plankTexture = settings.getBlockTexture("planks");
//        Identifier logTexture = settings.getBlockTexture("log");
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("P  ", "PP ", "LL "),
//                JKeys.keys()
//                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL.toString()))
//                    .key("L", JIngredient.ingredient().item(LOG_MATERIAL.toString())),
//                JResult.stackedResult(getBlockID().toString(), 2)
//            )
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        JTextures textures = new JTextures()
//            .var("log", logTexture.toString())
//            .var("planks", plankTexture.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/seating/chair").textures(textures),
//            MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:item/furniture/seating/chair").textures(textures),
//            ITEM_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("facing=north", new JBlockModel(MODEL_ID).y(90))
//                    .put("facing=south", new JBlockModel(MODEL_ID).y(270))
//                    .put("facing=east", new JBlockModel(MODEL_ID).y(180))
//                    .put("facing=west", new JBlockModel(MODEL_ID))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class ChairSettings extends MinekeaBlockSettings<ChairSettings> {
//        public ChairSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Chair");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%sfurniture/seating/chairs/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
//}
