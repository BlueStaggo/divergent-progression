package io.bluestaggo.divergeprog.data;

import io.bluestaggo.divergeprog.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(
                        ModItems.FLINT_SWORD,
                        ModItems.COPPER_SWORD
                );
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(
                        ModItems.FLINT_AXE,
                        ModItems.COPPER_AXE
                );
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(
                        ModItems.FLINT_PICKAXE,
                        ModItems.COPPER_PICKAXE
                );
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(
                        ModItems.FLINT_SHOVEL,
                        ModItems.COPPER_SHOVEL
                );
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(
                        ModItems.FLINT_HOE,
                        ModItems.COPPER_HOE
                );
    }
}
