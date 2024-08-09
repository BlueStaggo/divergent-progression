package io.bluestaggo.divergeprog.mixin;

import net.minecraft.component.ComponentHolder;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.bluestaggo.divergeprog.item.ComponentHolderState.*;

@Mixin(ComponentHolder.class)
public interface ComponentHolderMixin {
    @SuppressWarnings("ConstantValue")
    @Inject(
            method = "get",
            at = @At("HEAD"),
            cancellable = true
    )
    default <T> void getForItemStack(ComponentType<? extends T> type, CallbackInfoReturnable<T> cir) {
        if (!((Object) this instanceof ItemStack itemStack)) return;

        if ((getBlockedBrokenComponents().contains(type)
                || type == DataComponentTypes.ENCHANTMENTS)
                && isItemStackBroken(itemStack)) {
            cir.setReturnValue(null);
        }
    }

    @SuppressWarnings("ConstantValue")
    @Inject(
            method = "getOrDefault",
            at = @At("HEAD"),
            cancellable = true
    )
    default <T> void getOrDefaultForItemStack(ComponentType<? extends T> type, T fallback, CallbackInfoReturnable<T> cir) {
        if (!((Object) this instanceof ItemStack itemStack)) return;

        if ((getBlockedBrokenComponents().contains(type)
                || type == DataComponentTypes.ENCHANTMENTS)
                && isItemStackBroken(itemStack)) {
            cir.setReturnValue(fallback);
        }
    }

    @SuppressWarnings("ConstantValue")
    @Inject(
            method = "contains",
            at = @At("HEAD"),
            cancellable = true
    )
    default void containsForItemStack(ComponentType<?> type, CallbackInfoReturnable<Boolean> cir) {
        if (!((Object) this instanceof ItemStack itemStack)) return;

        if (getBlockedBrokenComponents().contains(type)
                && isItemStackBroken(itemStack)) {
            cir.setReturnValue(false);
        }
    }
}
