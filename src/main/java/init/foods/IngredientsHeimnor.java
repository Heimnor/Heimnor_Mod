package init.foods;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import registry.BlockFoodRegistry;

public class IngredientsHeimnor extends ItemFood {

	public IngredientsHeimnor(int gigot, float staturation, boolean wolf) {
		super(gigot, staturation, wolf);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {

		stack.stackSize--;
		return stack;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean p_77624_4_) {

		if (stack.getItem() == BlockFoodRegistry.fromagedoux) {
			lore.add(EnumChatFormatting.GRAY + "Son apparence et son");
			lore.add(EnumChatFormatting.GRAY + "odeur vous laisse penser");
			lore.add(EnumChatFormatting.GRAY + "que presque tout le monde");
			lore.add(EnumChatFormatting.GRAY + "peut l'apprecier.");
		} else if (stack.getItem() == BlockFoodRegistry.pain) {
			lore.add(EnumChatFormatting.GRAY + "Du pain ... Que dire de plus si ce n'est");
			lore.add(EnumChatFormatting.GRAY + "que c'est la base de l'alimentation");
			lore.add(EnumChatFormatting.GRAY + "de beaucoup de monde...");
		} else if (stack.getItem() == BlockFoodRegistry.tranchedepain) {
			lore.add(EnumChatFormatting.GRAY + "Du pain en tranche..");
			lore.add(EnumChatFormatting.GRAY + "Une tranche de pain quoi.");
		} else if (stack.getItem() == BlockFoodRegistry.viandeLaineux) {
			lore.add(EnumChatFormatting.RED + "Une viande coriace mais au gout intense.");
			lore.add(EnumChatFormatting.RED + "Gros morceau, pour les gros appetits.");
		} else if (stack.getItem() == BlockFoodRegistry.viandeLainard) {
			lore.add(EnumChatFormatting.RED + "Une viande grasse et tres agreable en bouche.");
			lore.add(EnumChatFormatting.RED + "Petite portion mais succulente.");
		} else if (stack.getItem() == BlockFoodRegistry.pouletFermier) {
			lore.add(EnumChatFormatting.GRAY + "Un poulet de bonne taille et ");
			lore.add(EnumChatFormatting.GRAY + "au gout surement plus que correct.");
			lore.add(EnumChatFormatting.GRAY + "Basique mais sert à la base de nombreux plats.");
		} else if (stack.getItem() == BlockFoodRegistry.laineuxcuit) {
			lore.add(EnumChatFormatting.RED + "Viande devenue plus tendre apres cuisson.");
			lore.add(EnumChatFormatting.RED + "Impossible d'avoir faim apres un tel morceau.");
		} else if (stack.getItem() == BlockFoodRegistry.pouletcuit) {
			lore.add(EnumChatFormatting.GRAY + "Un beau poulet bien dore.");
			lore.add(EnumChatFormatting.GRAY + "Serait surement meilleur avec un peu de ");
			lore.add(EnumChatFormatting.GRAY + "beurre, voir avec quelques epices.");
		} else if (stack.getItem() == BlockFoodRegistry.lainardcuit) {
			lore.add(EnumChatFormatting.RED + "Viande vraiment grasse, on peut voir");
			lore.add(EnumChatFormatting.RED + "le gras briller apres la cuisson.");
		} else if (stack.getItem() == BlockFoodRegistry.boulettes) {
			lore.add(EnumChatFormatting.RED + "Quelques boulettes qui aident les viandes");
			lore.add(EnumChatFormatting.RED + "moins tendre a avoir une texture bien");
			lore.add(EnumChatFormatting.RED + " plus agreable.");
		} else if (stack.getItem() == BlockFoodRegistry.boulettescuites) {
			lore.add(EnumChatFormatting.RED + "Un plat plutot basique mais qui");
			lore.add(EnumChatFormatting.RED + "satisfait presque tout le monde pour");
			lore.add(EnumChatFormatting.RED + "peu qu'on aime la viande.");
		} else if (stack.getItem() == BlockFoodRegistry.viandehachee) {
			lore.add(EnumChatFormatting.RED + "De la viande coupée finement");
			lore.add(EnumChatFormatting.RED + "Idéal pour mélanger à autre chose");
			lore.add(EnumChatFormatting.RED + "facilement ou pour cuire de la viande");
			lore.add(EnumChatFormatting.RED + "plus vite tout simplement.");
		} else if (stack.getItem() == BlockFoodRegistry.viandehacheecuite) {
			lore.add(EnumChatFormatting.RED + "Viande prete a etre consommee");
			lore.add(EnumChatFormatting.RED + "tel quel ou pour rajouter a autre");
			lore.add(EnumChatFormatting.RED + "chose.");
		}
	}
}
