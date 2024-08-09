package io.bluestaggo.divergeprog.compat;

import io.bluestaggo.divergeprog.DivergentProgression;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BetterNetherItems {
    public static Identifier CINCINNASITE_BAR_ID = DivergentProgression.id("betternether/cincinnasite_bar");
    public static Item CINCINNASITE_BAR;
    public static Identifier RAW_CINCINNASITE_BAR_ID = DivergentProgression.id("betternether/raw_cincinnasite_bar");
    public static Item RAW_CINCINNASITE_BAR;
    public static Identifier NETHER_RUBY_BAR_ID = DivergentProgression.id("betternether/nether_ruby_bar");
    public static Item NETHER_RUBY_BAR;

    public static void initialize() {
        CINCINNASITE_BAR = register(new Item(new Item.Settings()), CINCINNASITE_BAR_ID);
        RAW_CINCINNASITE_BAR = register(new Item(new Item.Settings()), RAW_CINCINNASITE_BAR_ID);
        NETHER_RUBY_BAR = register(new Item(new Item.Settings()), NETHER_RUBY_BAR_ID);

        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("betternether", "items_tab")))
                .register(group -> {
                    group.add(CINCINNASITE_BAR);
                    group.add(RAW_CINCINNASITE_BAR);
                    group.add(NETHER_RUBY_BAR);
                });
    }

    private static Item register(Item item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }
}
