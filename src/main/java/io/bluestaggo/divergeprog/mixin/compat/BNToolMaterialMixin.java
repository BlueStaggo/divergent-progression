package io.bluestaggo.divergeprog.mixin.compat;

import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@SuppressWarnings("UnresolvedMixinReference")
@Pseudo
@Mixin(targets = "org.betterx.betternether.items.materials.BNToolMaterial")
public abstract class BNToolMaterialMixin implements ToolMaterial {
    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 512),
            remap = false
    )
    private static int modifyCincinnasiteDurability(int constant) {
        return 1024;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2061),
            remap = false
    )
    private static int modifyCincinnasiteDiamondDurability(int constant) {
        return 2048;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2561),
            remap = false
    )
    private static int modifyNetherRubyDurability(int constant) {
        return 2560;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2861),
            remap = false
    )
    private static int modifyFlamingRubyDurability(int constant) {
        return 2880;
    }
}
