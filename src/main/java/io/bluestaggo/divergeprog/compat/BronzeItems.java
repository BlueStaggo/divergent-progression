package io.bluestaggo.divergeprog.compat;

import io.bluestaggo.divergeprog.DivergentProgression;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class BronzeItems {
    public static Identifier BRONZE_INGOT_ID = Identifier.of("bronze", "bronze_ingot");
    public static Identifier BRONZE_BLEND_ID = Identifier.of("bronze", "bronze_blend");

    public static Identifier BRONZE_BAR_ID = DivergentProgression.id("bronze/bronze_bar");
    public static Item BRONZE_BAR;
    public static Identifier BRONZE_BLEND_BAR_ID = DivergentProgression.id("bronze/bronze_blend_bar");
    public static Item BRONZE_BLEND_BAR;

    public static void initialize() {
        BRONZE_BAR = register(new Item(new Item.Settings()), BRONZE_BAR_ID);
        BRONZE_BLEND_BAR = register(new Item(new Item.Settings()), BRONZE_BLEND_BAR_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(group -> {
                    group.addAfter(
                            itemStack -> Registries.ITEM.getId(itemStack.getItem()).equals(BRONZE_BLEND_ID),
                            List.of(BRONZE_BLEND_BAR.getDefaultStack()),
                            ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS
                    );
                    group.addAfter(
                            itemStack -> Registries.ITEM.getId(itemStack.getItem()).equals(BRONZE_INGOT_ID),
                            List.of(BRONZE_BAR.getDefaultStack()),
                            ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS
                    );
                });
    }

    private static Item register(Item item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }
}
