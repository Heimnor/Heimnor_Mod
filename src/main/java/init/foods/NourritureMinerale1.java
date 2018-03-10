package init.foods;

import com.heimnor.common.Heimnor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NourritureMinerale1 extends ItemFood {
	
	public NourritureMinerale1(int gigot, float saturation, boolean wolf) {
		
		super(gigot, saturation, wolf);
	}
	// En demi gigot !

	public static Item itemnourritureminerale1;
	{
		this.setHasSubtypes(false);
		this.maxStackSize = 64;
		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(stack.stackSize < 1) {
			stack = null;
		}
		return super.onEaten(stack, world, player);
	}
}
