package committee.nova.forge.item.handler;

import committee.nova.biologist.BiologistMod;
import committee.nova.biologist.registry.ModItems;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber(modid = BiologistMod.MOD_ID)
public class GuideCritterHandler {
    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        if (event.getEntity().getWorld().isClient) return;

        boolean hasCurio = CuriosApi.getCuriosHelper()
                .findEquippedCurio(ModItems.Guide_Critter.get(), event.getEntity())
                .isPresent();

        if (hasCurio && event.getTarget() instanceof AnimalEntity) {
            event.setCanceled(true);
        }
    }

}
