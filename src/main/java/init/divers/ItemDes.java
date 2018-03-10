package init.divers;

import java.util.Random;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageDes;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ItemDes extends Item {

	public ItemStack onItemRightClick(ItemStack itemdes, World world, EntityPlayer player) {
		if (!itemdes.hasTagCompound()) {
			itemdes.setTagCompound(new NBTTagCompound());
			itemdes.stackTagCompound.setInteger("timer", 0);
		}
		if (world.isRemote && itemdes.stackTagCompound.getInteger("timer") == 0) {
			Random rand = new Random();
			int resultatDes1 = rand.nextInt(6) + 1;
			int resultatDes2 = rand.nextInt(6) + 1;
			int resultatfinal = resultatDes1 + resultatDes2;
			String playerJet = Minecraft.getMinecraft().thePlayer.getDisplayName();

			Heimnor.network.sendToServer(new IMessageDes(playerJet, resultatfinal));
			itemdes.stackTagCompound.setInteger("timer", 1);
		}

		return itemdes;
	}

	public void onUpdate(ItemStack itemdes, World world, net.minecraft.entity.Entity entity, int var1, boolean var2) {
		super.onUpdate(itemdes, world, entity, var1, var2);

		if (entity != null && entity instanceof EntityPlayer) {

			if (itemdes.hasTagCompound()) {
				if (itemdes.stackTagCompound.getInteger("timer") > 0) {
					itemdes.stackTagCompound.setInteger("timer", (itemdes.stackTagCompound.getInteger("timer") + 1));
				}
				if (itemdes.stackTagCompound.getInteger("timer") >= (20))

					itemdes.stackTagCompound.setInteger("timer", 0);
			}
		}
	}
}