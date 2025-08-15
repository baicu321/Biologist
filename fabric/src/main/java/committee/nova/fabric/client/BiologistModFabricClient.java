package committee.nova.fabric.client;

import committee.nova.fabric.handler.GuideCritterHandler;
import committee.nova.fabric.handler.GuideEnvironmentalHandler;
import net.fabricmc.api.ClientModInitializer;

public final class BiologistModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GuideCritterHandler.register();
        GuideEnvironmentalHandler.register();

    }
}
