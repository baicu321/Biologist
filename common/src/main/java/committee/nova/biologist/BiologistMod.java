package committee.nova.biologist;

import committee.nova.biologist.registry.ModItems;

public final class BiologistMod {
    public static final String MOD_ID = "biologist";
    public static void init() {
        ModItems.REGISTRY.register();
    }
}
