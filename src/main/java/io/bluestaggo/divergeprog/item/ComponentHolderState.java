package io.bluestaggo.divergeprog.item;

import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;

import java.util.Set;

public final class ComponentHolderState {
    private ComponentHolderState() {
    }

    private static Set<ComponentType<?>> blockedBrokenComponents;

    public static Set<ComponentType<?>> getBlockedBrokenComponents() {
        if (blockedBrokenComponents == null) {
            ComponentType<?> ignored = DataComponentTypes.getDefault(null); // Force initialize DataComponentTypes
            blockedBrokenComponents = Set.of(
                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                    DataComponentTypes.FOOD,
                    DataComponentTypes.TOOL
            );
        }
        return blockedBrokenComponents;
    }

    public static boolean isItemStackBroken(ItemStack itemStack) {
        return itemStack.isDamageable() && itemStack.getDamage() >= itemStack.getMaxDamage();
    }
}
