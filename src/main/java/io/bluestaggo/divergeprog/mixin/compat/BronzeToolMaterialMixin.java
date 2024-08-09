package io.bluestaggo.divergeprog.mixin.compat;

import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;

@Pseudo
@Mixin(targets = "com.seacroak.bronze.material.BronzeToolMaterial")
public abstract class BronzeToolMaterialMixin implements ToolMaterial {
    @Override
    public int getDurability() {
        return 640;
    }
}
