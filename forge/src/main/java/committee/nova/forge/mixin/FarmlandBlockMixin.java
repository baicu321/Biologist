package committee.nova.forge.mixin;

import committee.nova.biologist.registry.ModItems;
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
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlockMixin {
    @Inject(method = "onLandedUpon", at = @At("HEAD"), cancellable = true)
    private void preventTrampleWhenHasTrinket(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
        if (!(entity instanceof PlayerEntity player)) return;

        boolean hasEnvGuide = CuriosApi.getCuriosHelper()
                .findEquippedCurio(ModItems.Guide_Environmental.get(), player)
                .isPresent();

        if (hasEnvGuide) {
            ci.cancel();
        }
    }
}