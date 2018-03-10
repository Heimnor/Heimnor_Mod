package init.foods;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CouteauCuisineHeimnor extends Item{

	public boolean hasContainerItem(ItemStack stack) {
		 
        return true;
 
    }
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		 
        return false;
 
    }
	
	public ItemStack getContainerItem(ItemStack stack) {
		 
        return new ItemStack(stack.getItem(), 1, stack.getItemDamage() + 1);
 
    }
}
