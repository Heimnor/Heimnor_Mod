package init.foods;

import java.util.List;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.SyncFood;
import com.heimnor.utils.FichesUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemsFoodHeimnor extends ItemFood {

	public ItemsFoodHeimnor(int gigot, float saturation, boolean wolf) {
		super(gigot, saturation, wolf);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		
		stack.stackSize--;
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("qualityint")) {
				int qualityInt = stack.getTagCompound().getInteger("qualityint");
				int bonus = qualityInt;
				player.getFoodStats().addStats(bonus, 0.0F);
			}
		}

		return stack;
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean p_77624_4_) {
		
		if( stack.hasTagCompound()) {
			if(stack.getTagCompound().hasKey("quality")) {
				lore.add(EnumChatFormatting.GREEN + stack.getTagCompound().getString("quality"));
			}
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int slotID, boolean p_77663_5_) {

		if (player instanceof EntityPlayer) {
			if (!stack.hasTagCompound()) {
				stack.setTagCompound(new NBTTagCompound());
			}
			if (!world.isRemote) {

				if (!stack.getTagCompound().hasKey("quality")) {
					int result = FichesUtils.throwOneComp((EntityPlayer) player, "Cuisine",
							FichesUtils.getCuisine((EntityPlayer) player), world);

					System.out.println("Jet de dés :" + result);
					int i = 5;
					if (result == 1) {
						i = 0;
					} else if (result > 1 && result <= 10) {
						i = 1;
					} else if (result > 10 && result < 20) {
						i = 2;
					} else if (result >= 20) {
						i = 3;
					}
					String[] table = { "Même un lainard n'oserait pas y toucher ...", "Mouais ... ça se mange.",
							"Bien ! Ça ne doit pas être mauvais.", "Parfait !" };
					String stringNBT = table[i];

					if (stack.hasTagCompound()) {
						stack.getTagCompound().setInteger("qualityint", i);
						stack.getTagCompound().setString("quality", stringNBT);
						System.out.println("stack server : " + stack);
						Heimnor.network.sendTo(new SyncFood(stack, slotID), (EntityPlayerMP) player);
						System.out.println(stack.getTagCompound().getString("quality"));
					}
					((EntityPlayer) player).inventory.setInventorySlotContents(slotID, stack);
				}
			}
		}
	}

}