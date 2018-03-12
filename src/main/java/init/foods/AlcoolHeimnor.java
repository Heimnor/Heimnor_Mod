package init.foods;

import com.heimnor.common.Heimnor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AlcoolHeimnor extends ItemFood {

	public AlcoolHeimnor(int format, String unlocalized, boolean isBottle, Item container) {
		super(0, 0.2F, false);
		this.setMaxDamage(format);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(unlocalized);
		this.setCreativeTab(Heimnor.HeimnorFoodTabs);
		this.setTextureName(Heimnor.MODID + ":" +unlocalized);
		this.setContainerItem(container);
		this.setAlwaysEdible();
	}
	@Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {

		player.inventory.decrStackSize(player.inventory.currentItem, 1);
		this.setDamage(stack, this.getDamage(stack) - 1);
		return stack;
	}
}