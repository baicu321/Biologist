package committee.nova.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import committee.nova.biologist.BiologistMod;

@Mod(BiologistMod.MOD_ID)
public final class BiologistModForge {
    public BiologistModForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(BiologistMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        BiologistMod.init();
    }
}
