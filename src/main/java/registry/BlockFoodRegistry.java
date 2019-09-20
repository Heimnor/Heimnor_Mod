package registry;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.registry.GameRegistry;
import init.foods.AlcoolHeimnor;
import init.foods.UstensileHeimnor;
import net.minecraft.item.Item;

public class BlockFoodRegistry {

	public static Item casserole, poele;
	
	public static Item rhumAmbre, vinRougePremium, vodka, whisky;

	public static void registerBlock() {

		rhumAmbre = new AlcoolHeimnor(4, "rhumAmbre", true, MiscRegistry.bouteilleVide, 8);
		vinRougePremium = new AlcoolHeimnor(5, "vinRougePremium", true, MiscRegistry.bouteilleVide, 5);
		vodka = new AlcoolHeimnor(4, "vodka", true, MiscRegistry.bouteilleVide, 7);
		whisky = new AlcoolHeimnor(4, "whisky", true, MiscRegistry.bouteilleVide, 7);
		
		casserole = new UstensileHeimnor().setUnlocalizedName("casserole").setTextureName(Heimnor.MODID + ":casserole");
		poele = new UstensileHeimnor().setUnlocalizedName("poele").setTextureName(Heimnor.MODID + ":poele");

		GameRegistry.registerItem(casserole, "item_casserole");
		GameRegistry.registerItem(poele, "item_poele");

		GameRegistry.registerItem(rhumAmbre, "item_rhumAmbre");
		GameRegistry.registerItem(vinRougePremium, "item_vinRougePremium");
		GameRegistry.registerItem(vodka, "item_vodka");
		GameRegistry.registerItem(whisky, "item_whisky");

	}

	public static void registerTileEntity() {
	}
}
