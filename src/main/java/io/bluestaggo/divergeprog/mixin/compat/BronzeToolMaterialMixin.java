package io.bluestaggo.divergeprog.mixin.compat;

import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@SuppressWarnings("UnresolvedMixinReference")
@Pseudo
@Mixin(targets = "com.seacroak.bronze.material.BronzeToolMaterial")
public abstract class BronzeToolMaterialMixin implements ToolMaterial {
    @ModifyConstant(
            method = "getDurability",
            constant = @Constant(intValue = 350)
    )
    private static int modifyBronzeDurability(int constant) {
        return 640;
    }
}
