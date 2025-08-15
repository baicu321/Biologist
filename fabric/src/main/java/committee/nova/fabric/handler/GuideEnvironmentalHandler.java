package committee.nova.fabric.handler;

import committee.nova.biologist.registry.ModItems;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.registry.tag.BlockTags;

public class GuideEnvironmentalHandler {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (world.isClient) return true;

            boolean hasTrinket = TrinketsApi.getTrinketComponent(player)
                    .map(comp -> comp.isEquipped(stack -> stack.isOf(ModItems.Guide_Environmental.get())))
                    .orElse(false);


            if (hasTrinket && (
                    state.isIn(BlockTags.FLOWERS) ||
                            state.isIn(BlockTags.LEAVES) ||
                            state.isIn(BlockTags.SAPLINGS) ||
                            state.isIn(BlockTags.CROPS)
            )) {
                return false;
            }

            return true;
        });
    }
}
