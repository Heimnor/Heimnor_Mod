package init.drinks;

import com.heimnor.common.Heimnor;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;



public class ItemsConsoBoisson extends ItemFood
{

	public ItemsConsoBoisson(int gigot, float saturation, boolean wolf) 
	{
		super(gigot, saturation, wolf);
		// TODO Auto-generated constructor stub
		this.setHasSubtypes(false);
	    this.maxStackSize = 64;
	    this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
	    this.setAlwaysEdible();
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
	return EnumAction.drink;
	}
	
}