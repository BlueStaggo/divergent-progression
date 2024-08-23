package io.bluestaggo.divergeprog.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

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
        return 1600;
    }

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(intValue = 2031)
    )
    private static int modifyNetheriteDurability(int constant) {
        return 2048;
    }

    @Redirect(
            method = "method_24361",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/item/Items;NETHERITE_INGOT:Lnet/minecraft/item/Item;"
            )
    )
    private static Item modifyNetheriteRepairMaterial() {
        return Items.NETHERITE_SCRAP;
    }
}