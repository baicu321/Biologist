package committee.nova.biologist.registry;

import committee.nova.biologist.BiologistMod;
import committee.nova.biologist.item.GuideCritter;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BiologistMod.MOD_ID, RegistryKeys.ITEM);


    public static final RegistrySupplier<Item> Guide_Critter = register("guide_critter", () -> new GuideCritter(new Item.Settings().maxCount(1)));
    public static final RegistrySupplier<Item> Guide_Environmental = register("guide_environmental", () -> new Item(new Item.Settings().maxCount(1)));


    public static <T extends Item> RegistrySupplier<T> register(String id, Supplier<T> supplier) {
        return REGISTRY.register(id, supplier);
    }
}
