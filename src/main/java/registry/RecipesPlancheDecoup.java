package registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.heimnor.common.Heimnor;

import net.minecraft.item.ItemStack;

public class RecipesPlancheDecoup {

	public static final RecipesPlancheDecoup cuttingBase = new RecipesPlancheDecoup();
	private Map recipes = new HashMap();

	public RecipesPlancheDecoup() {

		this.addRecipes(new ItemStack(BlockFoodRegistry.pain), new ItemStack(BlockFoodRegistry.tranchedepain, 3));
		this.addRecipes(new ItemStack(BlockFoodRegistry.viandeLaineux), new ItemStack(BlockFoodRegistry.viandehachee));
		this.addRecipes(new ItemStack(BlockFoodRegistry.viandeLainard), new ItemStack(BlockFoodRegistry.viandehachee));
	}

	private void addRecipes(ItemStack stack, ItemStack output) {
		this.recipes.put(stack, output);
	}

	public ItemStack getResult(ItemStack stack) {

		Iterator iterator = this.recipes.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.sameKey(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean sameKey(ItemStack stack1, ItemStack stack2) {
		boolean isSame = false;
		System.out.println("SameKey called");
		if (stack1.getItem() == stack2.getItem()) {
			isSame = true;
		} else {
			isSame = false;
		}
		
		return isSame;
	}
}
