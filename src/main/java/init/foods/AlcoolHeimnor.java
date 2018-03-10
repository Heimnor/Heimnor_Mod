package init.foods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AlcoolHeimnor extends ItemFood {

	public AlcoolHeimnor(int gigot, float staturation, boolean wolf) {
		super(gigot, staturation, wolf);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {

		stack.stackSize--;
		return stack;
	}
}