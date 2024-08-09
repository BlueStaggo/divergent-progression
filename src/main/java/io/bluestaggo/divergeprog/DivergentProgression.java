package io.bluestaggo.divergeprog;

import io.bluestaggo.divergeprog.block.ModBlocks;
import io.bluestaggo.divergeprog.compat.CompatMods;
import io.bluestaggo.divergeprog.item.ModItems;
import io.bluestaggo.divergeprog.worldgen.ModFeatures;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

public class DivergentProgression implements ModInitializer {
	public static final String MOD_ID = "divergeprog";

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
		ModFeatures.initialize();
		CompatMods.initialize();
	}

	public static Identifier id(String name) {
		return Identifier.of(MOD_ID, name);
	}
}