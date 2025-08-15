package committee.nova.forge.item.handler;


import committee.nova.biologist.BiologistMod;
import committee.nova.biologist.registry.ModItems;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.BlockTags;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber(modid = BiologistMod.MOD_ID)
public class GuideEnvironmentalHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        PlayerEntity player = event.getPlayer();
        if (player == null) return;

        if (!hasItemEquippedCurios(player, ModItems.Guide_Environmental.get().getDefaultStack().getItem())) return;

        BlockState state = event.getState();


        if (state.isIn(BlockTags.CROPS)
                || state.isIn(BlockTags.FLOWERS)
                || state.isIn(BlockTags.SAPLINGS)
                || state.isIn(BlockTags.LEAVES)
                || state.isIn(BlockTags.MAINTAINS_FARMLAND)
                || state.isIn(BlockTags.CORAL_PLANTS)) {
            event.setCanceled(true);
        }
    }
    private static boolean hasItemEquippedCurios(PlayerEntity player, Item targetItem) {
        return CuriosApi.getCuriosHelper().findFirstCurio(player, targetItem).isPresent();
    }
}
