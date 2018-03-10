package init.divers;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.EnumSound;
import com.heimnor.packet.PacketPerm;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ClochetteMJ extends Item {

	public ItemStack onItemRightClick(ItemStack itemclochette, World world, EntityPlayer player) {
		
		if (!itemclochette.hasTagCompound()) {
			itemclochette.setTagCompound(new NBTTagCompound());
			itemclochette.stackTagCompound.setInteger("timer", 0);
		}
		if (!world.isRemote && itemclochette.stackTagCompound.getInteger("timer") == 0) {
			
			world.playSoundAtEntity(player,EnumSound.CLOCHETTE.toString(), 1.0F, 1.0F);
		}
		return itemclochette;
		
	}
	
	public void onUpdate(ItemStack itemclochette, World world, net.minecraft.entity.Entity entity, int var1, boolean var2) {
		super.onUpdate(itemclochette, world, entity, var1, var2);

		if (entity != null && entity instanceof EntityPlayer) {

			if (itemclochette.hasTagCompound()) {
				if (itemclochette.stackTagCompound.getInteger("timer") > 0)

				{
					itemclochette.stackTagCompound.setInteger("timer", (itemclochette.stackTagCompound.getInteger("timer") + 1));
				}
				if (itemclochette.stackTagCompound.getInteger("timer") >= (10))

					itemclochette.stackTagCompound.setInteger("timer", 0);
			}
		}
	}
}
