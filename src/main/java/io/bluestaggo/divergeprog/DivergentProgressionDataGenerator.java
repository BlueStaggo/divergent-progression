package io.bluestaggo.divergeprog;

import io.bluestaggo.divergeprog.data.ModBlockLootTableProvider;
import io.bluestaggo.divergeprog.data.ModBlockTagProvider;
import io.bluestaggo.divergeprog.data.ModModelProvider;
import io.bluestaggo.divergeprog.data.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DivergentProgressionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
