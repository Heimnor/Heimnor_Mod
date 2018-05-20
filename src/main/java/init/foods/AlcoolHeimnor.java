package init.foods;

import java.util.List;
import java.util.Random;

import com.heimnor.common.Heimnor;
import com.heimnor.extendedentityproperties.EPAlcohol;
import com.heimnor.utils.FichesUtils;
import com.heimnor.utils.HMessageUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class AlcoolHeimnor extends ItemFood {

	private int alcohol;
	private int format;
	private int contenu;

	public AlcoolHeimnor(int format, String unlocalized, boolean isBottle, Item container, int alcohol) {
		super(0, 0.2F, false);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(unlocalized);
		this.setCreativeTab(Heimnor.HeimnorFoodTabs);
		this.setTextureName(Heimnor.MODID + ":" + unlocalized);
		this.setContainerItem(container);
		this.setAlwaysEdible();
		this.alcohol = alcohol;
		this.format = format;
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int var1, boolean var2) {
		super.onUpdate(stack, world, entity, var1, var2);

		if (!stack.hasTagCompound()) {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("contenu", this.format);
			stack.setTagCompound(compound);
		}
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean chepa) {

		lore.add(EnumChatFormatting.ITALIC.GRAY + "Taille de la bouteille : " + this.format);

		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("contenu")) {

			if (this.contenu > 1) {
				lore.add(EnumChatFormatting.ITALIC.GREEN + "Il reste l'équivalent de " + this.contenu + " verre.");
			} else {
				lore.add(EnumChatFormatting.ITALIC.GREEN + "Il reste l'équivalent de "
						+ stack.getTagCompound().getInteger("contenu") + " verre.");
			}
		}
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {

		if (!world.isRemote) {
			EPAlcohol props = EPAlcohol.get(player);
			props.addAlcohol(this.alcohol);
			System.out.println("Alcoolémie : " + props.getAlcohol());

			// Message d'effet
			int alc = props.getAlcohol();
			String effect = "";
			ChatStyle style = new ChatStyle().setColor(EnumChatFormatting.GRAY);
			Random rand = new Random();
			if (alc < 20) {
				String[] effect1 = { "Ca fait du bien !", "Il faudrait faire cela plus souvent !", "Hmmm",
						"Ca fait du bien de se poser de temps a autre...", };
				effect = effect1[rand.nextInt(effect1.length)];
			} else if (alc >= 20 && alc < 40) {
				String[] effect2 = { "Vous commencez a vous sentir plus a l'aise.", "Vos joues commencent a rougir." };
				effect = effect2[rand.nextInt(effect2.length)];
			} else if (alc >= 40 && alc < 50) {
				String[] effect4 = { "Vous commencez a etre etourdi(e).", "Vous commencez a begueier." };
				effect = effect4[rand.nextInt(effect4.length)];
			} else if (alc > 50) {
				int result = new FichesUtils(player).ThrowPhys(player);

				if (result < 6) {
					String[] effect5 = { "Vous vomissez vos tripes.",
							"Vous vous sentez vraiment pas bien d'un coup..." };
					effect = effect5[rand.nextInt(effect5.length)];
					props.resetAlcohol();
				} else if (result >= 6 && result < 18) {
					String[] effect6 = { "Vous retenez un haut-le-coeur.", "Vous sentez un rot imminent." };
					effect = effect6[rand.nextInt(effect6.length)];
				} else {
					String[] effect7 = { "Il est où le prochain ?!", "Un autre !" };
					effect = effect7[rand.nextInt(effect7.length)];
				}
			}
			ChatComponentText text = new ChatComponentText(effect);
			text.setChatStyle(style);

			if (text != null) {
				player.addChatMessage(text);
			}

			if (stack.hasTagCompound() && stack.getTagCompound().hasKey("contenu")) {
				NBTTagCompound compound = stack.getTagCompound();

				int content = compound.getInteger("contenu");
				content--;
				compound.setInteger("contenu", content);
				stack.setTagCompound(compound);
				if (content == 0) {
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
				}
			}
			return stack;
		}
		return stack;
	}
}