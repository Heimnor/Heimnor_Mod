package init.drinks;

import com.heimnor.common.Heimnor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import registry.MiscRegistry;

public class VerreVin extends ItemFood {

	public VerreVin(int gigot, float saturation, boolean wolf) {
		super(gigot, saturation, wolf);
	}
	// En demi gigot !

	public static Item itemverre_vin, itemverre_vin_vide;
	{

		this.setHasSubtypes(false);
		this.maxStackSize = 64;
		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		this.setAlwaysEdible();
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.getFoodStats();
		par1ItemStack.stackSize--;
		 super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		 return new ItemStack(MiscRegistry.verre_vin_vide);
	}

}
