package init.drinks;

import com.heimnor.common.Heimnor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import registry.MiscRegistry;

public class ChopeBiere extends ItemFood {

	public ChopeBiere(int gigot, float saturation, boolean wolf) {
		super(gigot, saturation, wolf);
	}
	// En demi gigot !

	public static Item itemchope;
	{

		this.setHasSubtypes(false);
		this.maxStackSize = 1;
		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		this.setAlwaysEdible();
	

	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		
		par3EntityPlayer.getFoodStats();
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		-- par1ItemStack.stackSize;
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		
		return new ItemStack(MiscRegistry.chope_vide);
	}

}
