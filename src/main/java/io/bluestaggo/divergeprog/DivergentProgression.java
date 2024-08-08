package io.bluestaggo.divergeprog;

import io.bluestaggo.divergeprog.block.ModBlocks;
import io.bluestaggo.divergeprog.item.ModItems;
import io.bluestaggo.divergeprog.worldgen.ModFeatures;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivergentProgression implements ModInitializer {
	public static final String MOD_ID = "divergeprog";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
		ModFeatures.initialize();
	}

	public static Identifier id(String name) {
		return Identifier.of(MOD_ID, name);
	}
}