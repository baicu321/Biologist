package committee.nova.fabric.mixin;

import committee.nova.biologist.registry.ModItems;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlockMixin {

    @Inject(method = "onLandedUpon", at = @At("HEAD"), cancellable = true)
    private void preventTrampleWhenHasTrinket(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
        if (entity instanceof PlayerEntity player) {
            boolean hasTrinket = TrinketsApi.getTrinketComponent(player)
                    .map(comp -> comp.isEquipped(stack -> stack.isOf(ModItems.Guide_Environmental.get())))
                    .orElse(false);

            if (hasTrinket) {
                ci.cancel();
                entity.damage(world.getDamageSources().fall(), fallDistance);
            }
        }
    }
}
