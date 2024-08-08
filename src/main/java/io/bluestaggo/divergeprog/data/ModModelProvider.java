package io.bluestaggo.divergeprog.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import java.util.List;
import java.util.Map;

import static io.bluestaggo.divergeprog.item.ModItems.*;

public class ModModelProvider extends FabricModelProvider {
    public static final Map<Model, List<Item>> ITEM_MODEL_LISTS = Map.ofEntries(
        Map.entry(Models.GENERATED, List.of(
                FLINT_BAR, COPPER_BAR, IRON_BAR, GOLD_BAR, DIAMOND_BAR, RAW_COPPER_BAR, RAW_IRON_BAR, RAW_GOLD_BAR
        )),
        Map.entry(Models.HANDHELD, List.of(
                FLINT_SWORD, FLINT_AXE, FLINT_PICKAXE, FLINT_SHOVEL, FLINT_HOE,
                COPPER_SWORD, COPPER_AXE, COPPER_PICKAXE, COPPER_SHOVEL, COPPER_HOE
        ))
    );

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        for (var items : ITEM_MODEL_LISTS.entrySet()) {
            Model model = items.getKey();
            for (Item item : items.getValue()) {
                generator.register(item, model);
            }
        }
    }
}
