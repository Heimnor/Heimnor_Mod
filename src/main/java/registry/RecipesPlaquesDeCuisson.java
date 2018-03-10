package registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class RecipesPlaquesDeCuisson {
	public static final RecipesPlaquesDeCuisson plaqueBase = new RecipesPlaquesDeCuisson();
	private Map recipesCasserole = new HashMap();
	private Map recipesPoele = new HashMap();

	public RecipesPlaquesDeCuisson() {
		this.addRecipes(new ItemStack(BlockFoodRegistry.viandehachee), new ItemStack(BlockFoodRegistry.viandehacheecuite),
				BlockFoodRegistry.poele);
		this.addRecipes(new ItemStack(BlockFoodRegistry.viandeLainard), new ItemStack(BlockFoodRegistry.lainardcuit),
				BlockFoodRegistry.poele);
		this.addRecipes(new ItemStack(BlockFoodRegistry.viandeLaineux), new ItemStack(BlockFoodRegistry.laineuxcuit),
				BlockFoodRegistry.poele);
		this.addRecipes(new ItemStack(BlockFoodRegistry.boulettes), new ItemStack(BlockFoodRegistry.boulettescuites),
				BlockFoodRegistry.poele);
		this.addRecipes(new ItemStack(BlockFoodRegistry.tartineFromage), new ItemStack(BlockFoodRegistry.toastFromageFondu), BlockFoodRegistry.poele);
	}

	private void addRecipes(ItemStack stack, ItemStack output, Item ustensile) {
		if (ustensile == BlockFoodRegistry.casserole)
			this.recipesCasserole.put(stack, output);
		if (ustensile == BlockFoodRegistry.poele)
			this.recipesPoele.put(stack, output);
	}

	public ItemStack getResult(ItemStack stack, Item ustensile) {

		if (ustensile == BlockFoodRegistry.casserole) {
			Iterator iterator = this.recipesCasserole.entrySet().iterator();
			Entry entry;

			do {
				if (!iterator.hasNext()) {
					return null;
				}

				entry = (Entry) iterator.next();
			} while (!this.sameKey(stack, (ItemStack) entry.getKey()));

			return (ItemStack) entry.getValue();
		} else if (ustensile == BlockFoodRegistry.poele) {

			Iterator iterator = this.recipesPoele.entrySet().iterator();
			Entry entry;

			do {
				if (!iterator.hasNext()) {
					return null;
				}

				entry = (Entry) iterator.next();
			} while (!this.sameKey(stack, (ItemStack) entry.getKey()));

			return (ItemStack) entry.getValue();
		}
		return null;
	}

	private boolean sameKey(ItemStack stack1, ItemStack stack2) {
		boolean isSame = false;
		if (stack1.getItem() == stack2.getItem()) {
			isSame = true;
		} else {
			isSame = false;
		}

		return isSame;
	}
}