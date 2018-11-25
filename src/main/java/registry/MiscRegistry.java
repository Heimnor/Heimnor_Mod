package registry;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.registry.GameRegistry;
import init.divers.ItemDes;
import init.divers.ItemHeimnor;
import init.divers.OutilDev;
import net.minecraft.item.Item;

public class MiscRegistry {

	public static Item cleanWater, dirtyWater, saltWater, des, drogue1, chope_vide, verre_vin_vide, bouteilleVide, aj, outilDev; 
	
	public static void registerMiscItems() {
		
		
		des = new ItemDes().setUnlocalizedName("des").setCreativeTab(Heimnor.HeimnorMiscCreativeTabs)
				.setTextureName(Heimnor.MODID + ":des");
		
		drogue1 = new ItemHeimnor("drogue1");
		chope_vide = new ItemHeimnor("chope_vide");
		verre_vin_vide = new ItemHeimnor("verre_vin_vide");
		bouteilleVide = new ItemHeimnor("bouteilleVide");
		aj = new ItemHeimnor("aj");
		cleanWater = new ItemHeimnor("cleanWater");
		dirtyWater = new ItemHeimnor("dirtyWater");
		saltWater = new ItemHeimnor("saltWater");
		outilDev = new OutilDev();
		
		
		GameRegistry.registerItem(des, "item_des");
		GameRegistry.registerItem(drogue1, "item_drogue1");
		GameRegistry.registerItem(aj, "item_AJ");
		GameRegistry.registerItem(verre_vin_vide, "item_verre_vin_vide");
		GameRegistry.registerItem(chope_vide, "item_chope_vide");
		GameRegistry.registerItem(bouteilleVide, "item_bouteilleVide");
		GameRegistry.registerItem(cleanWater, "item_cleanWater");
		GameRegistry.registerItem(dirtyWater, "item_dirtyWater");
		GameRegistry.registerItem(saltWater, "item_saltWater");
		GameRegistry.registerItem(outilDev, "item_outilDev");
	}
}
