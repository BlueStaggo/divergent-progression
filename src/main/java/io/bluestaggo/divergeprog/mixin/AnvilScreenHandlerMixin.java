package io.bluestaggo.divergeprog.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {
    @Unique private final Property isRepairing = Property.create();

    @Shadow @Final private Property levelCost;

    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Inject(
            method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/screen/AnvilScreenHandler;addProperty(Lnet/minecraft/screen/Property;)Lnet/minecraft/screen/Property;"
            )
    )
    private void addRepairProperty(int syncId, PlayerInventory inventory, ScreenHandlerContext context, CallbackInfo ci) {
        addProperty(isRepairing);
    }

    @Inject(
            method = "canTakeOutput",
            at = @At("HEAD"),
            cancellable = true
    )
    private void canTakeFreeRepair(PlayerEntity player, boolean present, CallbackInfoReturnable<Boolean> cir) {
        if (isRepairing.get() != 0) {
            cir.setReturnValue(true);
        }
    }

    @ModifyConstant(
            method = "method_24922",
            constant = @Constant(floatValue = 0.12f)
    )
    private static float reduceBreakChance(float constant) {
        return 0.1f;
    }

    @Inject(
            method = "updateResult",
            at = @At(value = "HEAD")
    )
    private void resetRepair(CallbackInfo ci) {
        isRepairing.set(0);
    }

    @Inject(
            method = "updateResult",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/screen/AnvilScreenHandler;repairItemUsage:I",
                    ordinal = 1,
                    shift = At.Shift.AFTER
            ),
            cancellable = true
    )
    private void freeRepairs(CallbackInfo ci, @Local(ordinal = 1) ItemStack itemStack2) {
        isRepairing.set(1);
        levelCost.set(0);
        output.setStack(0, itemStack2);
        this.sendContentUpdates();
        ci.cancel();
    }
}
