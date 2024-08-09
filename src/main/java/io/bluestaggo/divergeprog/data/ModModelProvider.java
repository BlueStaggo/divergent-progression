package io.bluestaggo.divergeprog.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

import static io.bluestaggo.divergeprog.item.ModItems.*;
import static io.bluestaggo.divergeprog.compat.BronzeItems.*;
import static io.bluestaggo.divergeprog.compat.BetterNetherItems.*;

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
    public static final Map<Model, List<Identifier>> COMPAT_ITEM_MODEL_LISTS = Map.ofEntries(
            Map.entry(Models.GENERATED, List.of(
                    BRONZE_BAR_ID, BRONZE_BLEND_BAR_ID,
                    CINCINNASITE_BAR_ID, RAW_CINCINNASITE_BAR_ID, NETHER_RUBY_BAR_ID
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

        for (var items : COMPAT_ITEM_MODEL_LISTS.entrySet()) {
            Model model = items.getKey();
            for (Identifier item : items.getValue()) {
                Identifier itemModelId = item.withPrefixedPath("item/");
                model.upload(itemModelId, TextureMap.layer0(itemModelId), generator.writer);
            }
        }
    }
}
