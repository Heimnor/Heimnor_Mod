package init.divers;

import java.util.List;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import registry.MiscRegistry;

public class ItemHeimnor extends Item {


	public ItemHeimnor(String name) {
		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		this.setUnlocalizedName(name);
		this.setTextureName(Heimnor.MODID + ":" + name);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lores, boolean par4) {

		if(stack.getItem() == MiscRegistry.aj) {
		lores.add(EnumChatFormatting.BLUE + "Vous pourriez avoir une longue journee devant vous.");
		lores.add(EnumChatFormatting.BLUE + "Chacune d'elles comptent.");
		lores.add(EnumChatFormatting.BLUE + "Utilisez votre temps avec sagesse.");
		}
	}
}
