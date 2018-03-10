package registry;

import com.heimnor.common.Heimnor;
import static com.heimnor.henum.EnumArmorHeimnor.*;

import cpw.mods.fml.common.registry.GameRegistry;
import init.armor.HArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorRegistry {

	public static Item casqueAdamante, plastronAdamante, jambieresAdamante, bottesAdamante, casqueOronne_1,
			plastronOronne_1, jambieresOronnes_1, bottesOronnes_1, shaalCasque_1, shaalPlastron_1, shaalBottes_1,
			shaalJambieres_2, lamellaireJambieres, DjarnedinCasque_1, DjarnedinPlastron_1, DjarnedinBottes_1,
			cuirBouilliCasque, cuirBouilliPlastron, cuirBouilliJambieres, cuirBouilliBottes, armureImproviseeCasque,
			armureImproviseePlastron, armureImproviseeJambieres, armureImproviseeBottes, armureMercenaireCasque,
			armureMercenairePlastron, armureMercenaireJambieres, armureMercenaireBottes, armureHajiCasque,
			armureHajiPlastron, armureToundraCasque, armureToundraPlastron, armureToundraJambieres, armureToundraBottes,
			armureGuerinneCasque, armureGuerinnePlastron, armureGuerinneJambieres, armureGuerinneBottes,
			armurePlaquesCasque, armurePlaquesPlastron, armurePlaquesJambieres, armurePlaquesBottes, cClericale, pClericale, jClericale, bClericale;

	public static ArmorMaterial civilLeg = EnumHelper.addArmorMaterial("armureLourdeMaterial", 50,
			new int[] { 1, 3, 2, 1 }, 20);
	public static ArmorMaterial civilLourd = EnumHelper.addArmorMaterial("armureMoyMaterial", 70,
			new int[] { 1, 4, 2, 1 }, 20);
	public static ArmorMaterial milLeger = EnumHelper.addArmorMaterial("armureLegereMaterial", 90,
			new int[] { 2, 5, 2, 1 }, 20);
	public static ArmorMaterial milLourd = EnumHelper.addArmorMaterial("armureLegereMaterial", 120,
			new int[] { 3, 6, 3, 2 }, 20);
	public static ArmorMaterial adamante = EnumHelper.addArmorMaterial("armureLegereMaterial", 130,
			new int[] { 4, 6, 5, 3 }, 20);

	public static void registerArmors() {

		casqueAdamante = new HArmor(adamante, ADAMANTE, 0, ArmorCategories.BRAZ, "adamanteC");
		plastronAdamante = new HArmor(adamante, ADAMANTE, 1, ArmorCategories.BRAZ, "adamanteP");
		jambieresAdamante = new HArmor(adamante, ADAMANTE, 2, ArmorCategories.BRAZ, "adamanteJ");
		bottesAdamante = new HArmor(adamante, ADAMANTE, 3, ArmorCategories.BRAZ, "adamanteB");

		casqueOronne_1 = new HArmor(civilLourd, ORONNELEG, 0, ArmorCategories.CIVILLOURD, "oronne1C");
		plastronOronne_1 = new HArmor(civilLourd, ORONNELEG, 1, ArmorCategories.CIVILLOURD, "oronne1P");
		jambieresOronnes_1 = new HArmor(civilLourd, ORONNELEG, 2, ArmorCategories.CIVILLOURD, "oronne1J");
		bottesOronnes_1 = new HArmor(civilLourd, ORONNELEG, 3, ArmorCategories.CIVILLOURD, "oronne1B");

		shaalCasque_1 = new HArmor(milLeger, DUNES, 0, ArmorCategories.MILITAIRELEGER, "shaal1C");
		shaalPlastron_1 = new HArmor(milLeger, DUNES, 1, ArmorCategories.MILITAIRELEGER, "shaal1P");
		shaalBottes_1 = new HArmor(milLeger, DUNES, 3, ArmorCategories.MILITAIRELEGER, "shaal1B");

		shaalJambieres_2 = new HArmor(milLeger, SABLES, 2, ArmorCategories.MILITAIRELEGER, "shaal2J");

		lamellaireJambieres = new HArmor(milLeger, LAMELLAIRE, 2, ArmorCategories.MILITAIRELEGER, "lamellaireJ");

		DjarnedinCasque_1 = new HArmor(milLeger, STEPPES, 0, ArmorCategories.MILITAIRELEGER, "djarneddin1C");
		DjarnedinPlastron_1 = new HArmor(milLeger, STEPPES, 1, ArmorCategories.MILITAIRELEGER, "djarneddin1P");
		DjarnedinBottes_1 = new HArmor(milLeger, STEPPES, 3, ArmorCategories.MILITAIRELEGER, "djarneddin1B");

		cuirBouilliCasque = new HArmor(civilLourd, CUIRBOUILLI, 0, ArmorCategories.CIVILLOURD, "cuirBouilliC");
		cuirBouilliPlastron = new HArmor(civilLourd, CUIRBOUILLI, 1, ArmorCategories.CIVILLOURD, "cuirBouilliP");
		cuirBouilliJambieres = new HArmor(civilLourd, CUIRBOUILLI, 2, ArmorCategories.CIVILLOURD, "cuirBouilliJ");
		cuirBouilliBottes = new HArmor(civilLourd, CUIRBOUILLI, 3, ArmorCategories.CIVILLOURD, "cuirBouilliB");

		armureImproviseeCasque = new HArmor(civilLeg, IMPROVISEE, 0, ArmorCategories.CIVILLEGER, "improviseeC");
		armureImproviseePlastron = new HArmor(civilLeg, IMPROVISEE, 1, ArmorCategories.CIVILLEGER, "improviseeP");
		armureImproviseeJambieres = new HArmor(civilLeg, IMPROVISEE, 2, ArmorCategories.CIVILLEGER, "improviseeJ");
		armureImproviseeBottes = new HArmor(civilLeg, IMPROVISEE, 3, ArmorCategories.CIVILLEGER, "improviseeB");

		armureMercenaireCasque = new HArmor(milLeger, MERCENAIRE, 0, ArmorCategories.MILITAIRELEGER, "mercenaireC");
		armureMercenairePlastron = new HArmor(milLeger, MERCENAIRE, 1, ArmorCategories.MILITAIRELEGER, "mercenaireP");
		armureMercenaireJambieres = new HArmor(milLeger, MERCENAIRE, 2, ArmorCategories.MILITAIRELEGER, "mercenaireJ");
		armureMercenaireBottes = new HArmor(milLeger, MERCENAIRE, 3, ArmorCategories.MILITAIRELEGER, "mercenaireB");

		armureHajiCasque = new HArmor(milLeger, HAJI, 0, ArmorCategories.MILITAIRELEGER, "hajiC");
		armureHajiPlastron = new HArmor(milLeger, HAJI, 1, ArmorCategories.MILITAIRELEGER, "hajiP");

		armureToundraCasque = new HArmor(civilLeg, TOUNDRA, 0, ArmorCategories.CIVILLEGER, "toundraC");
		armureToundraPlastron = new HArmor(civilLeg, TOUNDRA, 1, ArmorCategories.CIVILLEGER, "toundraP");
		armureToundraJambieres = new HArmor(civilLeg, TOUNDRA, 2, ArmorCategories.CIVILLEGER, "toundraJ");
		armureToundraBottes = new HArmor(civilLeg, TOUNDRA, 3, ArmorCategories.CIVILLEGER, "toundraB");

		armureGuerinneCasque = new HArmor(milLourd, GUERIN, 0, ArmorCategories.MILITAIRELOURD, "guerinC");
		armureGuerinnePlastron = new HArmor(milLourd, GUERIN, 1, ArmorCategories.MILITAIRELOURD, "guerinP");
		armureGuerinneJambieres = new HArmor(milLourd, GUERIN, 2, ArmorCategories.MILITAIRELOURD, "guerinJ");
		armureGuerinneBottes = new HArmor(milLourd, GUERIN, 3, ArmorCategories.MILITAIRELOURD, "guerinB");

		armurePlaquesCasque = new HArmor(milLourd, PLAQUES, 0, ArmorCategories.MILITAIRELOURD, "plaquesC");
		armurePlaquesPlastron = new HArmor(milLourd, PLAQUES, 1, ArmorCategories.MILITAIRELOURD, "plaquesP");
		armurePlaquesJambieres = new HArmor(milLourd, PLAQUES, 2, ArmorCategories.MILITAIRELOURD, "plaquesJ");
		armurePlaquesBottes = new HArmor(milLourd, PLAQUES, 3, ArmorCategories.MILITAIRELOURD, "plaquesB");
		
		cClericale = new HArmor(milLeger, CLERICALE, 0, ArmorCategories.MILITAIRELEGER, "CClericale");
		pClericale = new HArmor(milLeger, CLERICALE, 1, ArmorCategories.MILITAIRELEGER, "PClericale");
		jClericale = new HArmor(milLeger, CLERICALE, 2, ArmorCategories.MILITAIRELEGER, "JClericale");
		bClericale = new HArmor(milLeger, CLERICALE, 3, ArmorCategories.MILITAIRELEGER, "BClericales");

		GameRegistry.registerItem(casqueAdamante, "item_casqueAdamante");
		GameRegistry.registerItem(plastronAdamante, "item_plastronAdamante");
		GameRegistry.registerItem(jambieresAdamante, "item_jambieresAdamante");
		GameRegistry.registerItem(bottesAdamante, "item_bottesAdamante");

		GameRegistry.registerItem(casqueOronne_1, "item_casqueOronne_1");
		GameRegistry.registerItem(plastronOronne_1, "item_plastronOronne_1");
		GameRegistry.registerItem(jambieresOronnes_1, "item_jambieresOronne_1");
		GameRegistry.registerItem(bottesOronnes_1, "item_bottesOronne_1");

		GameRegistry.registerItem(shaalCasque_1, "item_shaalCasque_1");
		GameRegistry.registerItem(shaalPlastron_1, "item_shaalPlastron_1");
		GameRegistry.registerItem(shaalBottes_1, "item_shaalBottes_1");

		GameRegistry.registerItem(shaalJambieres_2, "item_shaalJambieres_2");

		GameRegistry.registerItem(lamellaireJambieres, "item_lamellaireJambieres");

		GameRegistry.registerItem(DjarnedinCasque_1, "item_djarnedinCasque_1");
		GameRegistry.registerItem(DjarnedinPlastron_1, "item_djarnedinPlastron_1");
		GameRegistry.registerItem(DjarnedinBottes_1, "item_djarnedinBottes_1");

		GameRegistry.registerItem(cuirBouilliCasque, "item_cuirBouilliCasque");
		GameRegistry.registerItem(cuirBouilliPlastron, "item_cuirBouilliPlastron");
		GameRegistry.registerItem(cuirBouilliJambieres, "item_cuirBouilliJambieres");
		GameRegistry.registerItem(cuirBouilliBottes, "item_cuirBouilliBottes");

		GameRegistry.registerItem(armureImproviseeCasque, "item_armureImproviseeCasque");
		GameRegistry.registerItem(armureImproviseePlastron, "item_armureImproviseePlastron");
		GameRegistry.registerItem(armureImproviseeJambieres, "item_armureImproviseeJambieres");
		GameRegistry.registerItem(armureImproviseeBottes, "item_armureImproviseeBottes");

		GameRegistry.registerItem(armureMercenaireCasque, "item_armureMercenaireCasque");
		GameRegistry.registerItem(armureMercenairePlastron, "item_armureMercenairePlastron");
		GameRegistry.registerItem(armureMercenaireJambieres, "item_armureMercenaireJambieres");
		GameRegistry.registerItem(armureMercenaireBottes, "item_armureMercenaireBottes");

		GameRegistry.registerItem(armureHajiCasque, "item_armureHajiCasque");
		GameRegistry.registerItem(armureHajiPlastron, "item_armureHajiPlastron");

		GameRegistry.registerItem(armureToundraCasque, "item_armureToundraCasque");
		GameRegistry.registerItem(armureToundraPlastron, "item_armureToundraPlastron");
		GameRegistry.registerItem(armureToundraJambieres, "item_armureToundraJambieres");
		GameRegistry.registerItem(armureToundraBottes, "item_armureToundraBottes");

		GameRegistry.registerItem(armureGuerinneCasque, "item_armureGuerinneCasque");
		GameRegistry.registerItem(armureGuerinnePlastron, "item_armureGuerinnePlastron");
		GameRegistry.registerItem(armureGuerinneJambieres, "item_armureGuerinneJambieres");
		GameRegistry.registerItem(armureGuerinneBottes, "item_armureGuerinneBottes");

		GameRegistry.registerItem(armurePlaquesCasque, "item_armurePlaquesCasque");
		GameRegistry.registerItem(armurePlaquesPlastron, "item_armurePlaquesPlastron");
		GameRegistry.registerItem(armurePlaquesJambieres, "item_armurePlaquesJambieres");
		GameRegistry.registerItem(armurePlaquesBottes, "item_armurePlaquesBottes");
		
		GameRegistry.registerItem(cClericale, "item_cClericale" );
		GameRegistry.registerItem(pClericale, "item_pClericale" );
		GameRegistry.registerItem(jClericale, "item_jCleircale" );
		GameRegistry.registerItem(bClericale, "item_bCleircale" );

	}

	public enum ArmorCategories {
		CIVILLEGER(0.0F, 0.0F),
		CIVILLOURD(0.0F, 0.0F),
		MILITAIRELEGER(0.006F, 0.0115F),
		MILITAIRELOURD(0.015F, 0.02F),
		BRAZ(0.02F, 0.025F);

		private float moveMin;
		private float moveMax;

		ArmorCategories(float moveMin, float moveMax) {

			this.moveMin = moveMin;
			this.moveMax = moveMax;
		}

		public float getMoveMin() {
			return this.moveMin;
		}

		public float getMoveMax() {
			return this.moveMax;
		}
	}
}
