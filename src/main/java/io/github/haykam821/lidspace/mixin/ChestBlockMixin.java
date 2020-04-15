package io.github.haykam821.lidspace.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

@Mixin(ChestBlock.class)
public class ChestBlockMixin {
	@Redirect(method = "hasBlockOnTop", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isSimpleFullBlock(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z"))
	private static boolean hasLidRoom(BlockState blockState, BlockView blockView, BlockPos blockPos) {
		return blockState.isSideSolidFullSquare(blockView, blockPos, Direction.DOWN);
	}
}