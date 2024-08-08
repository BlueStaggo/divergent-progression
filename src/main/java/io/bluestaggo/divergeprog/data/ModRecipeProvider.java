package io.bluestaggo.divergeprog.data;

import io.bluestaggo.divergeprog.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        // Bars

        offerBarRecipe(exporter, Items.FLINT, ModItems.FLINT_BAR);
        offerBarRecipe(exporter, Items.COPPER_INGOT, ModItems.COPPER_BAR);
        offerBarRecipe(exporter, Items.IRON_INGOT, ModItems.IRON_BAR);
        offerBarRecipe(exporter, Items.GOLD_INGOT, ModItems.GOLD_BAR);
        offerBarRecipe(exporter, Items.DIAMOND, ModItems.DIAMOND_BAR);
        offerBarRecipe(exporter, Items.RAW_COPPER, ModItems.RAW_COPPER_BAR);
        offerBarRecipe(exporter, Items.RAW_IRON, ModItems.RAW_IRON_BAR);
        offerBarRecipe(exporter, Items.RAW_GOLD, ModItems.RAW_GOLD_BAR);

        offerSmelting(exporter, List.of(ModItems.RAW_COPPER_BAR), RecipeCategory.MISC, ModItems.COPPER_BAR, 2.1f, 200, "copper_bar");
        offerSmelting(exporter, List.of(ModItems.RAW_IRON_BAR), RecipeCategory.MISC, ModItems.IRON_BAR, 2.1f, 200, "iron_bar");
        offerSmelting(exporter, List.of(ModItems.RAW_GOLD_BAR), RecipeCategory.MISC, ModItems.GOLD_BAR, 3.0f, 200, "gold_bar");
        offerBlasting(exporter, List.of(ModItems.RAW_COPPER_BAR), RecipeCategory.MISC, ModItems.COPPER_BAR, 2.1f, 100, "copper_bar");
        offerBlasting(exporter, List.of(ModItems.RAW_IRON_BAR), RecipeCategory.MISC, ModItems.IRON_BAR, 2.1f, 100, "iron_bar");
        offerBlasting(exporter, List.of(ModItems.RAW_GOLD_BAR), RecipeCategory.MISC, ModItems.GOLD_BAR, 3.0f, 100, "gold_bar");

        // Flint Tools

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FLINT_SWORD)
                .input('#', Items.STICK)
                .input('X', ModItems.FLINT_BAR)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion(hasItem(ModItems.FLINT_BAR), conditionsFromItem(ModItems.FLINT_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_SHOVEL)
                .input('#', Items.STICK)
                .input('X', ModItems.FLINT_BAR)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(ModItems.FLINT_BAR), conditionsFromItem(ModItems.FLINT_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_PICKAXE)
                .input('#', Items.STICK)
                .input('X', ModItems.FLINT_BAR)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion(hasItem(ModItems.FLINT_BAR), conditionsFromItem(ModItems.FLINT_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_AXE)
                .input('#', Items.STICK)
                .input('X', ModItems.FLINT_BAR)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion(hasItem(ModItems.FLINT_BAR), conditionsFromItem(ModItems.FLINT_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_HOE)
                .input('#', Items.STICK)
                .input('X', ModItems.FLINT_BAR)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion(hasItem(ModItems.FLINT_BAR), conditionsFromItem(ModItems.FLINT_BAR))
                .offerTo(exporter);

        // Copper Tools

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                .input('#', Items.STICK)
                .input('X', ModItems.COPPER_BAR)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion(hasItem(ModItems.COPPER_BAR), conditionsFromItem(ModItems.COPPER_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .input('#', Items.STICK)
                .input('X', ModItems.COPPER_BAR)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(ModItems.COPPER_BAR), conditionsFromItem(ModItems.COPPER_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .input('#', Items.STICK)
                .input('X', ModItems.COPPER_BAR)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion(hasItem(ModItems.COPPER_BAR), conditionsFromItem(ModItems.COPPER_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .input('#', Items.STICK)
                .input('X', ModItems.COPPER_BAR)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion(hasItem(ModItems.COPPER_BAR), conditionsFromItem(ModItems.COPPER_BAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .input('#', Items.STICK)
                .input('X', ModItems.COPPER_BAR)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion(hasItem(ModItems.COPPER_BAR), conditionsFromItem(ModItems.COPPER_BAR))
                .offerTo(exporter);

        // Chainmail Armor

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                .input('X', Items.IRON_INGOT)
                .pattern("XXX")
                .pattern("X X")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .input('X', Items.IRON_INGOT)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .input('X', Items.IRON_INGOT)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .input('X', Items.IRON_INGOT)
                .pattern("X X")
                .pattern("X X")
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        // Iron Armor

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_HELMET),
                        Ingredient.ofItems(ModItems.IRON_BAR),
                        RecipeCategory.COMBAT,
                        Items.IRON_HELMET)
                .criterion(hasItem(ModItems.IRON_BAR), conditionsFromItem(ModItems.IRON_BAR))
                .offerTo(exporter, "iron_helmet_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_CHESTPLATE),
                        Ingredient.ofItems(ModItems.IRON_BAR),
                        RecipeCategory.COMBAT,
                        Items.IRON_CHESTPLATE)
                .criterion(hasItem(ModItems.IRON_BAR), conditionsFromItem(ModItems.IRON_BAR))
                .offerTo(exporter, "iron_chestplate_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_LEGGINGS),
                        Ingredient.ofItems(ModItems.IRON_BAR),
                        RecipeCategory.COMBAT,
                        Items.IRON_LEGGINGS)
                .criterion(hasItem(ModItems.IRON_BAR), conditionsFromItem(ModItems.IRON_BAR))
                .offerTo(exporter, "iron_leggings_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_BOOTS),
                        Ingredient.ofItems(ModItems.IRON_BAR),
                        RecipeCategory.COMBAT,
                        Items.IRON_BOOTS)
                .criterion(hasItem(ModItems.IRON_BAR), conditionsFromItem(ModItems.IRON_BAR))
                .offerTo(exporter, "iron_boots_smithing");

        // Golden Armor

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_HELMET),
                        Ingredient.ofItems(ModItems.GOLD_BAR),
                        RecipeCategory.COMBAT,
                        Items.GOLDEN_HELMET)
                .criterion(hasItem(ModItems.GOLD_BAR), conditionsFromItem(ModItems.GOLD_BAR))
                .offerTo(exporter, "golden_helmet_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_CHESTPLATE),
                        Ingredient.ofItems(ModItems.GOLD_BAR),
                        RecipeCategory.COMBAT,
                        Items.GOLDEN_CHESTPLATE)
                .criterion(hasItem(ModItems.GOLD_BAR), conditionsFromItem(ModItems.GOLD_BAR))
                .offerTo(exporter, "golden_chestplate_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_LEGGINGS),
                        Ingredient.ofItems(ModItems.GOLD_BAR),
                        RecipeCategory.COMBAT,
                        Items.GOLDEN_LEGGINGS)
                .criterion(hasItem(ModItems.GOLD_BAR), conditionsFromItem(ModItems.GOLD_BAR))
                .offerTo(exporter, "golden_leggings_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_BOOTS),
                        Ingredient.ofItems(ModItems.GOLD_BAR),
                        RecipeCategory.COMBAT,
                        Items.GOLDEN_BOOTS)
                .criterion(hasItem(ModItems.GOLD_BAR), conditionsFromItem(ModItems.GOLD_BAR))
                .offerTo(exporter, "golden_boots_smithing");

        // Diamond Armor

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_HELMET),
                        Ingredient.ofItems(ModItems.DIAMOND_BAR),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_HELMET)
                .criterion(hasItem(ModItems.DIAMOND_BAR), conditionsFromItem(ModItems.DIAMOND_BAR))
                .offerTo(exporter, "diamond_helmet_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_CHESTPLATE),
                        Ingredient.ofItems(ModItems.DIAMOND_BAR),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_CHESTPLATE)
                .criterion(hasItem(ModItems.DIAMOND_BAR), conditionsFromItem(ModItems.DIAMOND_BAR))
                .offerTo(exporter, "diamond_chestplate_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_LEGGINGS),
                        Ingredient.ofItems(ModItems.DIAMOND_BAR),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_LEGGINGS)
                .criterion(hasItem(ModItems.DIAMOND_BAR), conditionsFromItem(ModItems.DIAMOND_BAR))
                .offerTo(exporter, "diamond_leggings_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.CHAINMAIL_BOOTS),
                        Ingredient.ofItems(ModItems.DIAMOND_BAR),
                        RecipeCategory.COMBAT,
                        Items.DIAMOND_BOOTS)
                .criterion(hasItem(ModItems.DIAMOND_BAR), conditionsFromItem(ModItems.DIAMOND_BAR))
                .offerTo(exporter, "diamond_boots_smithing");
    }

    private void offerBarRecipe(RecipeExporter exporter, Item material, Item bar) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, bar)
                .input('X', material)
                .pattern("XXX")
                .pattern("   ")
                .pattern("XXX")
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
}
