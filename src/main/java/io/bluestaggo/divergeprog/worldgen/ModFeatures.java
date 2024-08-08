package io.bluestaggo.divergeprog.worldgen;

import io.bluestaggo.divergeprog.DivergentProgression;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;

public class ModFeatures {
    public static final Identifier FLINT_PEBBLES = DivergentProgression.id("flint_pebbles");

    public static void initialize() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, FLINT_PEBBLES)
        );
    }
}
