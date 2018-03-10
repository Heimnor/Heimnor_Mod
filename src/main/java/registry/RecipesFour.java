package registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.heimnor.common.Heimnor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesFour {

	public static final RecipesFour smeltingBase = new RecipesFour();

	private Map smeltingList = new HashMap();

	public RecipesFour() {

		this.addRecipes(BlockFoodRegistry.tartineFromage, new ItemStack(BlockFoodRegistry.toastFromageFondu));
		this.addRecipes(BlockFoodRegistry.viandeLainard, new ItemStack(BlockFoodRegistry.lainardcuit));
		this.addRecipes(BlockFoodRegistry.viandeLaineux, new ItemStack(BlockFoodRegistry.laineuxcuit));
		
	}

	public void addRecipes(ItemStack input, ItemStack output) {

		this.smeltingList.put(input, output);
	}

	public void addRecipes(Item item1, ItemStack item2) {
		this.addRecipes(new ItemStack(item1), item2);
	}

	public ItemStack getSmeltingResult(ItemStack stack) {

		Iterator iterator = this.smeltingList.entrySet().iterator();
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

		if (stack1.getItem() == stack2.getItem()) {
			isSame = true;
		} else {
			isSame = false;
		}

		return isSame;

	}

	public Map getSmeltingList() {
		return this.smeltingList;
	}

	public static RecipesFour smelting() {
		return smeltingBase;
	}

}
