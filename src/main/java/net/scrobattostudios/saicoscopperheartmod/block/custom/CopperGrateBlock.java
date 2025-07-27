package net.scrobattostudios.saicoscopperheartmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;

import javax.annotation.Nullable;
import java.util.Optional;

public class CopperGrateBlock extends WeatheringCopperFullBlock implements BucketPickup, LiquidBlockContainer {
    public CopperGrateBlock(WeatherState pWeatherState, Properties pProperties) {
        super(pWeatherState, pProperties.noOcclusion().strength(3.0F).randomTicks());
    }

    public static Block getNextStage(Block currentBlock) {
        if (currentBlock == ModBlocks.COPPER_GRATE.get()) return ModBlocks.EXPOSED_COPPER_GRATE.get();
        if (currentBlock == ModBlocks.EXPOSED_COPPER_GRATE.get()) return ModBlocks.WEATHERED_COPPER_GRATE.get();
        if (currentBlock == ModBlocks.WEATHERED_COPPER_GRATE.get()) return ModBlocks.OXIDIZED_COPPER_GRATE.get();
        return null;
    }

    public static Block getPreviousStage(Block currentBlock) {
        if (currentBlock == ModBlocks.OXIDIZED_COPPER_GRATE.get()) return ModBlocks.WEATHERED_COPPER_GRATE.get();
        if (currentBlock == ModBlocks.WEATHERED_COPPER_GRATE.get()) return ModBlocks.EXPOSED_COPPER_GRATE.get();
        if (currentBlock == ModBlocks.EXPOSED_COPPER_GRATE.get()) return ModBlocks.COPPER_GRATE.get();
        return null;
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            serverLevel.scheduleTick(pos, this, 200); // ≈10 segundos
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        Block currentBlock = state.getBlock();
        Block nextBlock = getNextStage(currentBlock);

        if (nextBlock != null) {
            boolean wasWaterlogged = state.getValue(BlockStateProperties.WATERLOGGED);
            BlockState newState = nextBlock.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED,wasWaterlogged);
            level.setBlock(pos, newState,Block.UPDATE_ALL);
            level.scheduleTick(pos, newState.getBlock(), 150); // Programamos el siguiente paso oxidativo
        }
    }

    @Override
    public boolean skipRendering(BlockState thisState, BlockState adjacentState, Direction face){
        return adjacentState.is(thisState.getBlock());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getItem() instanceof AxeItem) {
            Block previousBlock = getPreviousStage(state.getBlock());

            if (previousBlock != null && !level.isClientSide) {
                boolean wasWaterlogged = state.getValue(BlockStateProperties.WATERLOGGED);
                BlockState newState = previousBlock.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, wasWaterlogged);

                level.setBlock(pos, newState, Block.UPDATE_ALL);
                level.levelEvent(3005, pos, 0); // partículas
                itemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                level.playSound(null, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    /* waterlogging property */

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(BlockStateProperties.WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        boolean isWater = fluid.getType() == Fluids.WATER;
        return defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, isWater);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (state.getValue(BlockStateProperties.WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
    }

    @Override
    public @Nullable ItemStack pickupBlock(LevelAccessor level, BlockPos pos, BlockState state){
        if (state.getValue(BlockStateProperties.WATERLOGGED)){
            level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, false),Block.UPDATE_ALL);
            return new ItemStack(Items.WATER_BUCKET);
        }
        return ItemStack.EMPTY;
    }

    public boolean canPlaceLiquid(BlockGetter level, BlockPos pos, BlockState state, Fluid fluid){
        return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
    }

    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState){
        if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluidState.getType() ==Fluids.WATER){
            level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, true), Block.UPDATE_ALL);
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            return true;
        }
        return false;
    }
    @Override
    public java.util.Optional<SoundEvent> getPickupSound(){
        return  Optional.of(SoundEvents.BUCKET_FILL);
    }
}