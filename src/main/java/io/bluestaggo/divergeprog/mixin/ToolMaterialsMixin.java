package io.bluestaggo.divergeprog.mixin;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ToolMaterials.class)
public abstract class ToolMaterialsMixin implements ToolMaterial {
    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 59)
    )
    private static int modifyWoodDurability(int constant) {
        return 96;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 131)
    )
    private static int modifyStoneDurability(int constant) {
        return 192;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 250)
    )
    private static int modifyIronDurability(int constant) {
        return 480;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 32)
    )
    private static int modifyGoldDurability(int constant) {
        return 128;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 1561)
    )
    private static int modifyDiamondDurability(int constant) {
        return 1560;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2031)
    )
    private static int modifyNetheriteDurability(int constant) {
        return 2032;
    }
}