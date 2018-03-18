package registry;

import java.util.HashMap;
import java.util.Map;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityFourCuisine;
import com.heimnor.tileentity.TileEntityPlancheDecoup;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockFourCuisine;
import init.block.BlockGlass;
import init.block.BlockPlanDeTravail;
import init.block.BlockPlancheDecoup;
import init.foods.IngredientsHeimnor;
import init.foods.ItemsFoodHeimnor;
import init.foods.UstensileHeimnor;
import init.foods.AlcoolHeimnor;
import init.foods.CouteauCuisineHeimnor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockFoodRegistry {

	public static Block planDeTravail, fourCuisine, plancheDecoup, verre;

	public static Item couteauCuisineSimple;

	public static Item fromagedoux, pain, tranchedepain, chocolat, algues, bacon, jambon, banane, beurre,
			saucisseEpicee, citron, mais, noixDeCoco, oignon, orange, peche, poire, raisin, truite, patescuites,
			patesfromage, boulettes, boulettescuites, sandLainard;

	public static Item tartineFromage, toastFromageFondu, viandeLaineux, laineuxcuit, viandeLainard, lainardcuit,
			pouletFermier, pouletcuit, viandehachee, viandehacheecuite;

	public static Item casserole, poele;
	
	public static Item rhumAmbre, vinRougePremium, vodka, whisky;

	public static void registerBlock() {

		rhumAmbre = new AlcoolHeimnor(4, "rhumAmbre", true, MiscRegistry.bouteilleVide, 8);
		vinRougePremium = new AlcoolHeimnor(5, "vinRougePremium", true, MiscRegistry.bouteilleVide, 5);
		vodka = new AlcoolHeimnor(4, "vodka", true, MiscRegistry.bouteilleVide, 7);
		whisky = new AlcoolHeimnor(4, "whisky", true, MiscRegistry.bouteilleVide, 7);
		
		casserole = new UstensileHeimnor().setUnlocalizedName("casserole").setTextureName(Heimnor.MODID + ":casserole");
		poele = new UstensileHeimnor().setUnlocalizedName("poele").setTextureName(Heimnor.MODID + ":poele");

		pain = new IngredientsHeimnor(4, 0.6F, true).setUnlocalizedName("pain").setCreativeTab(Heimnor.HeimnorFoodTabs)
				.setTextureName(Heimnor.MODID + ":pain");
		tranchedepain = new IngredientsHeimnor(1, 0.1F, true).setUnlocalizedName("tranchedepain")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":tranchedepain");

		couteauCuisineSimple = new CouteauCuisineHeimnor().setUnlocalizedName("couteauCuisineSimple")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":couteaucuisinesimple")
				.setMaxDamage(40);

		viandeLainard = new IngredientsHeimnor(5, 0.6F, true).setUnlocalizedName("viandlainard")
				.setTextureName(Heimnor.MODID + ":viandlainard").setCreativeTab(Heimnor.HeimnorFoodTabs);

		lainardcuit = new IngredientsHeimnor(8, 0.8F, true).setUnlocalizedName("lainardcuit")
				.setTextureName(Heimnor.MODID + ":lainardcuit").setCreativeTab(Heimnor.HeimnorFoodTabs);

		laineuxcuit = new IngredientsHeimnor(10, 0.9F, true).setUnlocalizedName("laineuxcuit")
				.setTextureName(Heimnor.MODID + ":laineuxcuit").setCreativeTab(Heimnor.HeimnorFoodTabs);

		viandehachee = new IngredientsHeimnor(6, 0.6F, true).setUnlocalizedName("viandehachee")
				.setTextureName(Heimnor.MODID + ":viandehachee").setCreativeTab(Heimnor.HeimnorFoodTabs);

		viandehacheecuite = new IngredientsHeimnor(10, 0.9F, true).setUnlocalizedName("viandehacheecuite")
				.setTextureName(Heimnor.MODID + ":viandehacheecuite").setCreativeTab(Heimnor.HeimnorFoodTabs);

		pouletcuit = new IngredientsHeimnor(9, 0.9F, true).setUnlocalizedName("pouletcuit")
				.setTextureName(Heimnor.MODID + ":pouletcuit").setCreativeTab(Heimnor.HeimnorFoodTabs);

		boulettes = new IngredientsHeimnor(5, 0.9F, true).setUnlocalizedName("boulettes")
				.setTextureName(Heimnor.MODID + ":boulettes").setCreativeTab(Heimnor.HeimnorFoodTabs);

		boulettescuites = new IngredientsHeimnor(4, 0.9F, true).setUnlocalizedName("boulettescuites")
				.setTextureName(Heimnor.MODID + ":boulettescuites").setCreativeTab(Heimnor.HeimnorFoodTabs);

		viandeLaineux = new IngredientsHeimnor(6, 0.8F, false).setUnlocalizedName("viandlaineux")
				.setTextureName(Heimnor.MODID + ":viandlaineux").setCreativeTab(Heimnor.HeimnorFoodTabs);

		pouletFermier = new IngredientsHeimnor(5, 0.5F, false).setUnlocalizedName("pouletfermier")
				.setTextureName(Heimnor.MODID + ":pouletfermier").setCreativeTab(Heimnor.HeimnorFoodTabs);

		truite = new IngredientsHeimnor(1, 0.1F, false).setUnlocalizedName("truite")
				.setTextureName(Heimnor.MODID + ":truite").setCreativeTab(Heimnor.HeimnorFoodTabs);

		raisin = new IngredientsHeimnor(2, 0.2F, false).setUnlocalizedName("raisin")
				.setTextureName(Heimnor.MODID + ":raisin").setCreativeTab(Heimnor.HeimnorFoodTabs);

		poire = new IngredientsHeimnor(2, 0.1F, false).setUnlocalizedName("poire")
				.setTextureName(Heimnor.MODID + ":poire").setCreativeTab(Heimnor.HeimnorFoodTabs);

		peche = new IngredientsHeimnor(2, 0.1F, false).setUnlocalizedName("peche")
				.setTextureName(Heimnor.MODID + ":peche").setCreativeTab(Heimnor.HeimnorFoodTabs);

		orange = new IngredientsHeimnor(2, 0.3F, false).setUnlocalizedName("orange")
				.setTextureName(Heimnor.MODID + ":orange").setCreativeTab(Heimnor.HeimnorFoodTabs);

		oignon = new IngredientsHeimnor(1, 0.1F, false).setUnlocalizedName("oignon")
				.setTextureName(Heimnor.MODID + ":oignon").setCreativeTab(Heimnor.HeimnorFoodTabs);

		noixDeCoco = new IngredientsHeimnor(2, 0.2F, false).setUnlocalizedName("noixDeCoco")
				.setTextureName(Heimnor.MODID + ":noixDeCoco").setCreativeTab(Heimnor.HeimnorFoodTabs);

		mais = new IngredientsHeimnor(3, 0.3F, false).setUnlocalizedName("mais").setTextureName(Heimnor.MODID + ":mais")
				.setCreativeTab(Heimnor.HeimnorFoodTabs);

		citron = new IngredientsHeimnor(1, 0.1F, false).setUnlocalizedName("citron")
				.setTextureName(Heimnor.MODID + ":citron").setCreativeTab(Heimnor.HeimnorFoodTabs);

		saucisseEpicee = new IngredientsHeimnor(5, 0.5F, false).setUnlocalizedName("saucisseEpicee")
				.setTextureName(Heimnor.MODID + ":saucisseEpicee").setCreativeTab(Heimnor.HeimnorFoodTabs);

		beurre = new IngredientsHeimnor(1, 0.1F, false).setUnlocalizedName("beurre")
				.setTextureName(Heimnor.MODID + ":beurre").setCreativeTab(Heimnor.HeimnorFoodTabs);

		banane = new IngredientsHeimnor(2, 0.2F, false).setUnlocalizedName("banane")
				.setTextureName(Heimnor.MODID + ":banane").setCreativeTab(Heimnor.HeimnorFoodTabs);

		jambon = new IngredientsHeimnor(4, 0.4F, false).setUnlocalizedName("jambon")
				.setTextureName(Heimnor.MODID + ":jambon").setCreativeTab(Heimnor.HeimnorFoodTabs);

		bacon = new IngredientsHeimnor(3, 0.3F, false).setUnlocalizedName("bacon")
				.setTextureName(Heimnor.MODID + ":bacon").setCreativeTab(Heimnor.HeimnorFoodTabs);

		algues = new IngredientsHeimnor(1, 0.1F, false).setUnlocalizedName("algues")
				.setTextureName(Heimnor.MODID + ":algues").setCreativeTab(Heimnor.HeimnorFoodTabs);

		fromagedoux = new IngredientsHeimnor(3, 0.5F, false).setUnlocalizedName("fromagedoux")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":fromagedoux");

		chocolat = new IngredientsHeimnor(2, 0.2F, false).setUnlocalizedName("chocolat")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":chocolat");

		patescuites = new IngredientsHeimnor(4, 0.4F, false).setUnlocalizedName("patescuites")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":patescuites");

		patesfromage = new IngredientsHeimnor(6, 0.6F, false).setUnlocalizedName("patesfromage")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":patesfromage");

		sandLainard = new ItemsFoodHeimnor(9, 0.9F, false).setUnlocalizedName("sandLainard")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":sandlainard");

		planDeTravail = new BlockPlanDeTravail(Material.wood).setBlockName("plandetravail")
				.setBlockTextureName(Heimnor.MODID + ":plandetravail").setCreativeTab(Heimnor.HeimnorFoodTabs);
		verre = new BlockGlass(Material.glass).setBlockName("verre").setBlockTextureName(Heimnor.MODID + ":verre");
		fourCuisine = new BlockFourCuisine(Material.glass).setBlockName("fourCuisine")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setBlockTextureName(Heimnor.MODID + ":fourmaterialrock");
		plancheDecoup = new BlockPlancheDecoup(Material.wood).setBlockName("plancheDecoup")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setBlockTextureName(Heimnor.MODID + ":plancheDecoup");

		tartineFromage = new IngredientsHeimnor(5, 0.6F, false).setUnlocalizedName("tartinefrom")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":tartinefrom");
		toastFromageFondu = new ItemsFoodHeimnor(6, 0.8F, false).setUnlocalizedName("toastfrom")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":toastfrom");

		GameRegistry.registerItem(couteauCuisineSimple, "item_couteaucuisinesimple");
		GameRegistry.registerItem(casserole, "item_casserole");
		GameRegistry.registerItem(poele, "item_poele");
		
		GameRegistry.registerItem(rhumAmbre, "item_rhumAmbre");
		GameRegistry.registerItem(vinRougePremium, "item_vinRougePremium");
		GameRegistry.registerItem(vodka, "item_vodka");
		GameRegistry.registerItem(whisky, "item_whisky");

		GameRegistry.registerItem(viandeLainard, "item_viandeLainard");
		GameRegistry.registerItem(viandeLaineux, "item_viandeLaineux");
		GameRegistry.registerItem(viandehachee, "item_viandehachee");
		GameRegistry.registerItem(viandehacheecuite, "item_viandehacheecuite");
		GameRegistry.registerItem(pouletFermier, "item_pouletFermier");
		GameRegistry.registerItem(pain, "item_pain");
		GameRegistry.registerItem(tranchedepain, "item_tranchedepain");
		GameRegistry.registerItem(fromagedoux, "item_fromagedoux");
		GameRegistry.registerItem(chocolat, "item_chocolat");
		GameRegistry.registerItem(truite, "item_truite");
		GameRegistry.registerItem(raisin, "item_raisin");
		GameRegistry.registerItem(algues, "item_algues");
		GameRegistry.registerItem(orange, "item_orange");
		GameRegistry.registerItem(bacon, "item_bacon");
		GameRegistry.registerItem(banane, "item_banane");
		GameRegistry.registerItem(beurre, "item_beurre");
		GameRegistry.registerItem(citron, "item_citron");
		GameRegistry.registerItem(jambon, "item_jambon");
		GameRegistry.registerItem(saucisseEpicee, "item_saucisseEpicee");
		GameRegistry.registerItem(mais, "item_mais");
		GameRegistry.registerItem(noixDeCoco, "item_noixDeCoco");
		GameRegistry.registerItem(oignon, "item_oignon");
		GameRegistry.registerItem(peche, "item_peche");
		GameRegistry.registerItem(poire, "item_poire");
		GameRegistry.registerItem(patescuites, "item_patescuites");
		GameRegistry.registerItem(patesfromage, "item_patesfromage");
		GameRegistry.registerItem(boulettescuites, "item_boulettescuites");
		GameRegistry.registerItem(lainardcuit, "item_lainardcuit");
		GameRegistry.registerItem(boulettes, "item_boulettes");
		GameRegistry.registerItem(laineuxcuit, "item_laineuxcuit");
		GameRegistry.registerItem(pouletcuit, "item_pouletcuit");
		GameRegistry.registerItem(sandLainard, "item_sandlainard");

		GameRegistry.registerItem(tartineFromage, "item_tartinefrom");
		GameRegistry.registerItem(toastFromageFondu, "item_toastfromfondu");

		GameRegistry.registerBlock(fourCuisine, "block_fourcuisine");
		GameRegistry.registerBlock(planDeTravail, "block_plandetravail");
		GameRegistry.registerBlock(plancheDecoup, "block_planchedecoup");
		GameRegistry.registerBlock(verre, "block_verre");
	}

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityFourCuisine.class, Heimnor.MODID + ":fourcuisine");
		GameRegistry.registerTileEntity(TileEntityPlancheDecoup.class, Heimnor.MODID + ":plancheDecoup");
	}
}
