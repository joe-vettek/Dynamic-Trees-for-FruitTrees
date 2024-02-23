package xueluoanping.dtfruittrees.data;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;


import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import xueluoanping.dtfruittrees.data.recipe.HybridingRecipeGen;


public class RecipeDataProvider extends RecipeProvider {
	public RecipeDataProvider(DataGenerator generator) {
		super(generator);
	}


	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		HybridingRecipeGen.register(consumer);
	}


	//
	// private void controlRecipe(Consumer<FinishedRecipe> consumer) {
	//
	// 	ConditionalRecipe.builder()
	// 			.addCondition(new ConfigCondition(General.class.getDeclaredFields()[3].getName()))
	// 			.addRecipe(
	// 					ShapedRecipeBuilder.shaped(Items.BREAD)
	//
}
