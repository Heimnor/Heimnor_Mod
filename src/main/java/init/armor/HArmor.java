package init.armor;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.EnumArmorHeimnor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import registry.ArmorRegistry.ArmorCategories;

public class HArmor extends ItemArmor {

	private float varMotionX = 1.0F;
	private float varMotionZ = 1.0F;

	private EnumArmorHeimnor armor;
	private float moveMin;
	private float moveMax;
	private int type;

	public HArmor(ArmorMaterial material, EnumArmorHeimnor texture, int type, ArmorCategories move, String unlocalized) {
		super(material, 0, type);
		this.armor = texture;
		this.moveMin = move.getMoveMin();
		this.moveMax = move.getMoveMax();
		this.type = type;
		this.setCreativeTab(Heimnor.HeimnorArmorCreativeTabs);
		this.setUnlocalizedName(unlocalized);
		this.setTextureName(Heimnor.MODID +":armors/" + unlocalized);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.type == 2 && !this.armor.getLayer2().equals("")) {
			return this.armor.getLayer2();
		}
		if (!this.armor.getLayer1().equals(""))
			return this.armor.getLayer1();
		return null;
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (this.armorType == 0 && player.onGround) {
			player.motionX *= varMotionX - this.moveMin;
			player.motionZ *= varMotionZ - this.moveMin;
		}
		if (this.armorType == 1 && player.onGround) {
			player.motionX *= varMotionX - this.moveMax;
			player.motionZ *= varMotionZ - this.moveMax;

		}
		if (this.armorType == 2 && player.onGround) {
			player.motionX *= varMotionX - this.moveMax;
			player.motionZ *= varMotionZ - this.moveMax;

		}
		if (this.armorType == 3 && player.onGround) {
			player.motionX *= varMotionX - this.moveMin;
			player.motionZ *= varMotionZ - this.moveMin;
		}
	}
}
