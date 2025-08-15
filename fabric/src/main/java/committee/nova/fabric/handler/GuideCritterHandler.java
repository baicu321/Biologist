package committee.nova.fabric.handler;

import committee.nova.biologist.registry.ModItems;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.util.ActionResult;

public class GuideCritterHandler {
    public static void register() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClient) return ActionResult.PASS;


            boolean hasTrinket = TrinketsApi.getTrinketComponent(player)
                    .map(comp -> comp.isEquipped(stack -> stack.isOf(ModItems.Guide_Critter.get())))
                    .orElse(false);

            if (hasTrinket && entity instanceof PassiveEntity) {

                return ActionResult.FAIL;
            }

            return ActionResult.PASS;
        });
    }
}
