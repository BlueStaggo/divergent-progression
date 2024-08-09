package io.bluestaggo.divergeprog.mixin.compat;

import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@SuppressWarnings("UnresolvedMixinReference")
@Pseudo
@Mixin(targets = "org.betterx.betternether.items.materials.BNToolMaterial", remap = false)
public abstract class BNToolMaterialMixin implements ToolMaterial {
    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 512)
    )
    private static int modifyCincinnasiteDurability(int constant) {
        return 1024;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2061)
    )
    private static int modifyCincinnasiteDiamondDurability(int constant) {
        return 2048;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2561)
    )
    private static int modifyNetherRubyDurability(int constant) {
        return 2560;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2861)
    )
    private static int modifyFlamingRubyDurability(int constant) {
        return 2880;
    }
}
