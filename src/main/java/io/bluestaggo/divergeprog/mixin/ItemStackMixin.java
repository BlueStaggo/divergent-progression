package io.bluestaggo.divergeprog.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.bluestaggo.divergeprog.DivergentProgression;
import io.bluestaggo.divergeprog.item.ComponentHolderState;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.minecraft.block.BlockState;
import net.minecraft.component.ComponentHolder;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ComponentHolder, FabricItemStack {
    @Unique private static final Text BROKEN_TEXT = Text.translatable(Util.createTranslationKey(
            "item", DivergentProgression.id("tooltip.broken"))).formatted(Formatting.RED);

    @Shadow public abstract boolean isDamageable();
    @Shadow public abstract int getDamage();
    @Shadow public abstract int getMaxDamage();
    @Shadow public abstract Item getItem();
    @Shadow public abstract void decrement(int amount);
    @Shadow public abstract ComponentMap getComponents();

    @Unique
    private boolean isBroken() {
        return isDamageable() && getDamage() >= getMaxDamage();
    }

    @Inject(
            method = "damage(ILnet/minecraft/server/world/ServerWorld;Lnet/minecraft/server/network/ServerPlayerEntity;Ljava/util/function/Consumer;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;decrement(I)V",
                    shift = At.Shift.BEFORE
            ),
            cancellable = true
    )
    private void damageRestrictDecrement(int amount, ServerWorld world, @Nullable ServerPlayerEntity player,
                                         Consumer<Item> breakCallback, CallbackInfo ci, @Local(ordinal = 1) int i) {
        Item item = getItem();
        boolean noDestroy = item instanceof ToolItem || item instanceof ArmorItem || item instanceof ShieldItem;
        if (!noDestroy) {
            decrement(amount);
        }
        if (!noDestroy || i - amount < this.getMaxDamage()) {
            breakCallback.accept(item);
        }
        ci.cancel();
    }

    @Inject(
            method = "getTooltip",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Item;appendTooltip(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/item/tooltip/TooltipType;)V",
                    ordinal = 0,
                    shift = At.Shift.BEFORE
            )
    )
    private void getBrokenTooltip(Item.TooltipContext context, @Nullable PlayerEntity player, TooltipType type,
                                  CallbackInfoReturnable<List<Text>> cir, @Local Consumer<Text> tooltip) {
        if (isBroken()) {
            tooltip.accept(BROKEN_TEXT);
        }
    }

    @Inject(
            method = "useOnBlock",
            at = @At("HEAD"),
            cancellable = true
    )
    private void useOnBlockIfNotBroken(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (isBroken()) {
            cir.setReturnValue(ActionResult.PASS);
        }
    }

    @Inject(
            method = "getMiningSpeedMultiplier",
            at = @At("HEAD"),
            cancellable = true
    )
    private void getMiningSpeedMultiplierIfNotBroken(BlockState state, CallbackInfoReturnable<Float> cir) {
        if (isBroken()) {
            cir.setReturnValue(1.0f);
        }
    }

    @Inject(
            method = "use",
            at = @At("HEAD"),
            cancellable = true
    )
    private void useIfNotBroken(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (isBroken()) {
            cir.setReturnValue(TypedActionResult.fail((ItemStack) (Object) this));
        }
    }

    @Inject(
            method = "finishUsing",
            at = @At("HEAD"),
            cancellable = true
    )
    private void finishUsingIfNotBroken(World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (isBroken()) {
            cir.setReturnValue((ItemStack) (Object) this);
        }
    }

    @Inject(
            method = "postHit",
            at = @At("HEAD"),
            cancellable = true
    )
    private void postHitIfNotBroken(LivingEntity target, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (isBroken()) {
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = "postDamageEntity",
            at = @At("HEAD"),
            cancellable = true
    )
    private void postDamageEntityIfNotBroken(LivingEntity target, PlayerEntity player, CallbackInfo ci) {
        if (isBroken()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "postMine",
            at = @At("HEAD"),
            cancellable = true
    )
    private void postMineIfNotBroken(World world, BlockState state, BlockPos pos, PlayerEntity miner, CallbackInfo ci) {
        if (isBroken()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "isSuitableFor",
            at = @At("HEAD"),
            cancellable = true
    )
    private void isSuitableForIfNotBroken(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (isBroken()) {
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = "getUseAction",
            at = @At("HEAD"),
            cancellable = true
    )
    private void getUseActionIfNotBroken(CallbackInfoReturnable<UseAction> cir) {
        if (isBroken()) {
            cir.setReturnValue(UseAction.NONE);
        }
    }

    @Inject(
            method = "onStoppedUsing",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onStoppedUsingIfNotBroken(World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        if (isBroken()) {
            ci.cancel();
        }
    }

    @Inject(
            method = "applyAttributeModifiers",
            at = @At("HEAD"),
            cancellable = true
    )
    private void applyAttributeModifiersIfNotBroken(EquipmentSlot slot, BiConsumer<RegistryEntry<EntityAttribute>, EntityAttributeModifier> attributeModifierConsumer, CallbackInfo ci) {
        if (isBroken()) {
            ci.cancel();
        }
    }

    @Override
    public <T> T get(ComponentType<? extends T> type) {
        if ((ComponentHolderState.getBlockedBrokenComponents().contains(type) || type == DataComponentTypes.ENCHANTMENTS) && isBroken()) {
            return null;
        }
        return this.getComponents().get(type);
    }

    @Override
    public <T> T getOrDefault(ComponentType<? extends T> type, T fallback) {
        if ((ComponentHolderState.getBlockedBrokenComponents().contains(type) || type == DataComponentTypes.ENCHANTMENTS) && isBroken()) {
            return fallback;
        }
        return this.getComponents().getOrDefault(type, fallback);
    }

    @Override
    public boolean contains(ComponentType<?> type) {
        if (ComponentHolderState.getBlockedBrokenComponents().contains(type) && isBroken()) {
            return false;
        }
        return this.getComponents().contains(type);
    }
}
