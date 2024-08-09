package io.bluestaggo.divergeprog.worldgen;

import io.bluestaggo.divergeprog.DivergentProgression;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModFeatures {
    public static final RegistryKey<PlacedFeature> FLINT_PEBBLES_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, DivergentProgression.id("flint_pebbles"));

    public static void initialize() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, FLINT_PEBBLES_KEY);
    }
}
