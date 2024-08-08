package io.bluestaggo.divergeprog.block;

import io.bluestaggo.divergeprog.DivergentProgression;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = of("incorrect_for_flint_tool");

    private static TagKey<Block> of(String name) {
        return TagKey.of(RegistryKeys.BLOCK, DivergentProgression.id(name));
    }
}
