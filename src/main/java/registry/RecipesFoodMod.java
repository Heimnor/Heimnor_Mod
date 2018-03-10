package registry;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesFoodMod {

	public static void registerRecipes() {

		GameRegistry.addShapelessRecipe(new ItemStack(BlockFoodRegistry.tranchedepain, 3),
				new Object[] { new ItemStack(BlockFoodRegistry.pain),
						new ItemStack(BlockFoodRegistry.couteauCuisineSimple, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(BlockFoodRegistry.patesfromage), new Object[] {
				new ItemStack(BlockFoodRegistry.patescuites), new ItemStack(BlockFoodRegistry.fromagedoux)});
		GameRegistry.addShapelessRecipe(new ItemStack(BlockFoodRegistry.boulettes), new Object[] {
				new ItemStack(BlockFoodRegistry.viandehachee)});
		GameRegistry.addShapelessRecipe(new ItemStack(BlockFoodRegistry.sandLainard), new Object[] {
				new ItemStack(BlockFoodRegistry.tranchedepain), new ItemStack(BlockFoodRegistry.tranchedepain), new ItemStack(BlockFoodRegistry.lainardcuit)});
	}
}
