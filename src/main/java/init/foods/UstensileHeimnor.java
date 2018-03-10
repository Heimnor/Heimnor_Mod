package init.foods;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import registry.BlockFoodRegistry;

public class UstensileHeimnor extends Item {

	public String[] type;
	public IIcon[] iconArray;
	public int metadata;

	public UstensileHeimnor() {

		this.setHasSubtypes(false);
		this.setCreativeTab(Heimnor.HeimnorFoodTabs);

	}

	public int getMetadata(int metadata) {
		return metadata;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.getCurrentEquippedItem().getItem() == BlockFoodRegistry.casserole) {
			System.out.println("Metadata " + this.getDamage(stack));
			this.setDamage(stack, 1);
			System.out.println("Metadata 2 : " + this.getDamage(stack));
		}
		return stack;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lores, boolean par4) {
	}
}