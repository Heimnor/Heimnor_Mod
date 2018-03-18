package init.weapons;

import com.heimnor.common.Heimnor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class Armes extends ItemSword
{

	public Armes(ToolMaterial material, String name) {
		super(material);
		this.setCreativeTab(Heimnor.HeimnorWeaponCreativeTabs);
		this.setTextureName(Heimnor.MODID + ":weapons/" + name);
		this.setUnlocalizedName(name);
	}
}
