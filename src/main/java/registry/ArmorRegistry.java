package registry;

import com.heimnor.henum.EnumArmorHeimnor;

import cpw.mods.fml.common.registry.GameRegistry;
import init.armor.HArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorRegistry {

	public static Item casqueAdamante, plastronAdamante, jambieresAdamante, bottesAdamante, casqueOronne_1,
			plastronOronne_1, jambieresOronnes_1, bottesOronnes_1, shaalCasque_1, shaalPlastron_1, shaalBottes_1,
			shaalJambieres_2, DjarnedinCasque_1, DjarnedinPlastron_1, DjarnedinBottes_1, cuirBouilliCasque,
			cuirBouilliPlastron, cuirBouilliJambieres, cuirBouilliBottes, armureImproviseeCasque,
			armureImproviseePlastron, armureImproviseeJambieres, armureImproviseeBottes, armureMercenaireCasque,
			armureMercenairePlastron, armureMercenaireJambieres, armureMercenaireBottes, cHaji, pHaji, jHaji, bHaji,
			armureToundraCasque, armureToundraPlastron, armureToundraJambieres, armureToundraBottes,
			armureGuerinneCasque, armureGuerinnePlastron, armureGuerinneJambieres, armureGuerinneBottes, cPlaques,
			pPlaques, jPlaques, bPlaques, cClericale, pClericale, jClericale, bClericale, sergentC, sergentP, sergentJ,
			sergentB, cCloute, pCloute, jCloute, bCloute, cHuscarl, pHuscarl, jHuscarl, bHuscarl, cMaille, pMaille,
			jMaille, bMaille, cLamellaire, pLamellaire, jLamellaire, bLamellaire, cMaraudeur, pMaraudeur, jMaraudeur,
			bMaraudeur;

	public static ArmorMaterial civilLeg = EnumHelper.addArmorMaterial("civilLegerMaterial", 50,
			new int[] { 1, 3, 2, 1 }, 20);
	public static ArmorMaterial civilLourd = EnumHelper.addArmorMaterial("civilLourdMaterial", 70,
			new int[] { 1, 4, 2, 1 }, 20);
	public static ArmorMaterial milLeger = EnumHelper.addArmorMaterial("militaireLegerMaterial", 90,
			new int[] { 2, 5, 2, 1 }, 20);
	public static ArmorMaterial milLourd = EnumHelper.addArmorMaterial("militaireLourdMaterial", 120,
			new int[] { 3, 6, 3, 2 }, 20);
	public static ArmorMaterial adamante = EnumHelper.addArmorMaterial("adamanteMaterial", 130,
			new int[] { 4, 6, 5, 3 }, 20);

	public static void registerArmors() {

		casqueAdamante = new HArmor(adamante, EnumArmorHeimnor.ADAMANTE, 0, ArmorCategories.BRAZ, "adamanteC");
		plastronAdamante = new HArmor(adamante, EnumArmorHeimnor.ADAMANTE, 1, ArmorCategories.BRAZ, "adamanteP");
		jambieresAdamante = new HArmor(adamante, EnumArmorHeimnor.ADAMANTE, 2, ArmorCategories.BRAZ, "adamanteJ");
		bottesAdamante = new HArmor(adamante, EnumArmorHeimnor.ADAMANTE, 3, ArmorCategories.BRAZ, "adamanteB");

		casqueOronne_1 = new HArmor(civilLourd, EnumArmorHeimnor.ORONNELEG, 0, ArmorCategories.CIVILLOURD, "oronne1C");
		plastronOronne_1 = new HArmor(civilLourd, EnumArmorHeimnor.ORONNELEG, 1, ArmorCategories.CIVILLOURD,
				"oronne1P");
		jambieresOronnes_1 = new HArmor(civilLourd, EnumArmorHeimnor.ORONNELEG, 2, ArmorCategories.CIVILLOURD,
				"oronne1J");
		bottesOronnes_1 = new HArmor(civilLourd, EnumArmorHeimnor.ORONNELEG, 3, ArmorCategories.CIVILLOURD, "oronne1B");

		shaalCasque_1 = new HArmor(milLeger, EnumArmorHeimnor.DUNES, 0, ArmorCategories.MILITAIRELEGER, "shaal1C");
		shaalPlastron_1 = new HArmor(milLeger, EnumArmorHeimnor.DUNES, 1, ArmorCategories.MILITAIRELEGER, "shaal1P");
		shaalBottes_1 = new HArmor(milLeger, EnumArmorHeimnor.DUNES, 3, ArmorCategories.MILITAIRELEGER, "shaal1B");

		shaalJambieres_2 = new HArmor(milLeger, EnumArmorHeimnor.SABLES, 2, ArmorCategories.MILITAIRELEGER, "shaal2J");

		DjarnedinCasque_1 = new HArmor(milLeger, EnumArmorHeimnor.STEPPES, 0, ArmorCategories.MILITAIRELEGER,
				"djarneddin1C");
		DjarnedinPlastron_1 = new HArmor(milLeger, EnumArmorHeimnor.STEPPES, 1, ArmorCategories.MILITAIRELEGER,
				"djarneddin1P");
		DjarnedinBottes_1 = new HArmor(milLeger, EnumArmorHeimnor.STEPPES, 3, ArmorCategories.MILITAIRELEGER,
				"djarneddin1B");

		cuirBouilliCasque = new HArmor(civilLourd, EnumArmorHeimnor.CUIRBOUILLI, 0, ArmorCategories.CIVILLOURD,
				"cuirBouilliC");
		cuirBouilliPlastron = new HArmor(civilLourd, EnumArmorHeimnor.CUIRBOUILLI, 1, ArmorCategories.CIVILLOURD,
				"cuirBouilliP");
		cuirBouilliJambieres = new HArmor(civilLourd, EnumArmorHeimnor.CUIRBOUILLI, 2, ArmorCategories.CIVILLOURD,
				"cuirBouilliJ");
		cuirBouilliBottes = new HArmor(civilLourd, EnumArmorHeimnor.CUIRBOUILLI, 3, ArmorCategories.CIVILLOURD,
				"cuirBouilliB");

		armureImproviseeCasque = new HArmor(civilLeg, EnumArmorHeimnor.IMPROVISEE, 0, ArmorCategories.CIVILLEGER,
				"improviseeC");
		armureImproviseePlastron = new HArmor(civilLeg, EnumArmorHeimnor.IMPROVISEE, 1, ArmorCategories.CIVILLEGER,
				"improviseeP");
		armureImproviseeJambieres = new HArmor(civilLeg, EnumArmorHeimnor.IMPROVISEE, 2, ArmorCategories.CIVILLEGER,
				"improviseeJ");
		armureImproviseeBottes = new HArmor(civilLeg, EnumArmorHeimnor.IMPROVISEE, 3, ArmorCategories.CIVILLEGER,
				"improviseeB");

		armureMercenaireCasque = new HArmor(milLeger, EnumArmorHeimnor.MERCENAIRE, 0, ArmorCategories.MILITAIRELEGER,
				"mercenaireC");
		armureMercenairePlastron = new HArmor(milLeger, EnumArmorHeimnor.MERCENAIRE, 1, ArmorCategories.MILITAIRELEGER,
				"mercenaireP");
		armureMercenaireJambieres = new HArmor(milLeger, EnumArmorHeimnor.MERCENAIRE, 2, ArmorCategories.MILITAIRELEGER,
				"mercenaireJ");
		armureMercenaireBottes = new HArmor(milLeger, EnumArmorHeimnor.MERCENAIRE, 3, ArmorCategories.MILITAIRELEGER,
				"mercenaireB");

		cHaji = new HArmor(milLeger, EnumArmorHeimnor.HAJI, 0, ArmorCategories.MILITAIRELEGER, "CHaji");
		pHaji = new HArmor(milLeger, EnumArmorHeimnor.HAJI, 1, ArmorCategories.MILITAIRELEGER, "PHaji");
		jHaji = new HArmor(milLeger, EnumArmorHeimnor.HAJI, 2, ArmorCategories.MILITAIRELEGER, "JHaji");
		bHaji = new HArmor(milLeger, EnumArmorHeimnor.HAJI, 3, ArmorCategories.MILITAIRELEGER, "BHaji");

		armureToundraCasque = new HArmor(civilLeg, EnumArmorHeimnor.TOUNDRA, 0, ArmorCategories.CIVILLEGER, "toundraC");
		armureToundraPlastron = new HArmor(civilLeg, EnumArmorHeimnor.TOUNDRA, 1, ArmorCategories.CIVILLEGER,
				"toundraP");
		armureToundraJambieres = new HArmor(civilLeg, EnumArmorHeimnor.TOUNDRA, 2, ArmorCategories.CIVILLEGER,
				"toundraJ");
		armureToundraBottes = new HArmor(civilLeg, EnumArmorHeimnor.TOUNDRA, 3, ArmorCategories.CIVILLEGER, "toundraB");

		armureGuerinneCasque = new HArmor(milLourd, EnumArmorHeimnor.GUERIN, 0, ArmorCategories.MILITAIRELOURD,
				"guerinC");
		armureGuerinnePlastron = new HArmor(milLourd, EnumArmorHeimnor.GUERIN, 1, ArmorCategories.MILITAIRELOURD,
				"guerinP");
		armureGuerinneJambieres = new HArmor(milLourd, EnumArmorHeimnor.GUERIN, 2, ArmorCategories.MILITAIRELOURD,
				"guerinJ");
		armureGuerinneBottes = new HArmor(milLourd, EnumArmorHeimnor.GUERIN, 3, ArmorCategories.MILITAIRELOURD,
				"guerinB");

		cPlaques = new HArmor(milLourd, EnumArmorHeimnor.PLAQUES, 0, ArmorCategories.MILITAIRELOURD, "CPlaques");
		pPlaques = new HArmor(milLourd, EnumArmorHeimnor.PLAQUES, 1, ArmorCategories.MILITAIRELOURD, "PPlaques");
		jPlaques = new HArmor(milLourd, EnumArmorHeimnor.PLAQUES, 2, ArmorCategories.MILITAIRELOURD, "JPlaques");
		bPlaques = new HArmor(milLourd, EnumArmorHeimnor.PLAQUES, 3, ArmorCategories.MILITAIRELOURD, "BPlaques");

		cClericale = new HArmor(milLeger, EnumArmorHeimnor.CLERICALE, 0, ArmorCategories.MILITAIRELEGER, "CClericale");
		pClericale = new HArmor(milLeger, EnumArmorHeimnor.CLERICALE, 1, ArmorCategories.MILITAIRELEGER, "PClericale");
		jClericale = new HArmor(milLeger, EnumArmorHeimnor.CLERICALE, 2, ArmorCategories.MILITAIRELEGER, "JClericale");
		bClericale = new HArmor(milLeger, EnumArmorHeimnor.CLERICALE, 3, ArmorCategories.MILITAIRELEGER, "BClericales");

		sergentC = new HArmor(milLourd, EnumArmorHeimnor.SERGENT, 0, ArmorCategories.MILITAIRELOURD, "CSergent");
		sergentP = new HArmor(milLourd, EnumArmorHeimnor.SERGENT, 1, ArmorCategories.MILITAIRELOURD, "PSergent");
		sergentJ = new HArmor(milLourd, EnumArmorHeimnor.SERGENT, 2, ArmorCategories.MILITAIRELOURD, "JSergent");
		sergentB = new HArmor(milLourd, EnumArmorHeimnor.SERGENT, 3, ArmorCategories.MILITAIRELOURD, "BSergent");

		cCloute = new HArmor(milLeger, EnumArmorHeimnor.CLOUTE, 0, ArmorCategories.MILITAIRELEGER, "CCloute");
		pCloute = new HArmor(milLeger, EnumArmorHeimnor.CLOUTE, 1, ArmorCategories.MILITAIRELEGER, "PCloute");
		jCloute = new HArmor(milLeger, EnumArmorHeimnor.CLOUTE, 2, ArmorCategories.MILITAIRELEGER, "JCloute");
		bCloute = new HArmor(milLeger, EnumArmorHeimnor.CLOUTE, 3, ArmorCategories.MILITAIRELEGER, "BCloute");

		cHuscarl = new HArmor(milLeger, EnumArmorHeimnor.HUSCARL, 0, ArmorCategories.MILITAIRELEGER, "CGjermund");
		pHuscarl = new HArmor(milLeger, EnumArmorHeimnor.HUSCARL, 1, ArmorCategories.MILITAIRELEGER, "PHuscarl");
		jHuscarl = new HArmor(milLeger, EnumArmorHeimnor.HUSCARL, 2, ArmorCategories.MILITAIRELEGER, "JHuscarl");
		bHuscarl = new HArmor(milLeger, EnumArmorHeimnor.HUSCARL, 3, ArmorCategories.MILITAIRELEGER, "BHuscarl");

		cMaille = new HArmor(milLeger, EnumArmorHeimnor.MAILLE, 0, ArmorCategories.MILITAIRELEGER, "CMaille");
		pMaille = new HArmor(milLeger, EnumArmorHeimnor.MAILLE, 1, ArmorCategories.MILITAIRELEGER, "PMaille");
		jMaille = new HArmor(milLeger, EnumArmorHeimnor.MAILLE, 2, ArmorCategories.MILITAIRELEGER, "JMaille");
		bMaille = new HArmor(milLeger, EnumArmorHeimnor.MAILLE, 3, ArmorCategories.MILITAIRELEGER, "BMaille");

		cLamellaire = new HArmor(milLeger, EnumArmorHeimnor.LAMELLAIRE, 0, ArmorCategories.MILITAIRELEGER,
				"CLamellaire");
		pLamellaire = new HArmor(milLeger, EnumArmorHeimnor.LAMELLAIRE, 1, ArmorCategories.MILITAIRELEGER,
				"PLamellaire");
		jLamellaire = new HArmor(milLeger, EnumArmorHeimnor.LAMELLAIRE, 2, ArmorCategories.MILITAIRELEGER,
				"JLamellaire");
		bLamellaire = new HArmor(milLeger, EnumArmorHeimnor.LAMELLAIRE, 3, ArmorCategories.MILITAIRELEGER,
				"BLamellaire");

		cMaraudeur = new HArmor(milLourd, EnumArmorHeimnor.MARAUDEUR, 0, ArmorCategories.MILITAIRELOURD, "CMaraudeur");
		pMaraudeur = new HArmor(milLourd, EnumArmorHeimnor.MARAUDEUR, 1, ArmorCategories.MILITAIRELOURD, "PMaraudeur");
		jMaraudeur = new HArmor(milLourd, EnumArmorHeimnor.MARAUDEUR, 2, ArmorCategories.MILITAIRELOURD, "JMaraudeur");
		bMaraudeur = new HArmor(milLourd, EnumArmorHeimnor.MARAUDEUR, 3, ArmorCategories.MILITAIRELOURD, "BMaraudeur");

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

		GameRegistry.registerItem(cHaji, "item_cHaji");
		GameRegistry.registerItem(pHaji, "item_pHaji");
		GameRegistry.registerItem(jHaji, "item_jHaji");
		GameRegistry.registerItem(bHaji, "item_bHaji");

		GameRegistry.registerItem(armureToundraCasque, "item_armureToundraCasque");
		GameRegistry.registerItem(armureToundraPlastron, "item_armureToundraPlastron");
		GameRegistry.registerItem(armureToundraJambieres, "item_armureToundraJambieres");
		GameRegistry.registerItem(armureToundraBottes, "item_armureToundraBottes");

		GameRegistry.registerItem(armureGuerinneCasque, "item_armureGuerinneCasque");
		GameRegistry.registerItem(armureGuerinnePlastron, "item_armureGuerinnePlastron");
		GameRegistry.registerItem(armureGuerinneJambieres, "item_armureGuerinneJambieres");
		GameRegistry.registerItem(armureGuerinneBottes, "item_armureGuerinneBottes");

		GameRegistry.registerItem(cPlaques, "item_armurePlaquesCasque");
		GameRegistry.registerItem(pPlaques, "item_armurePlaquesPlastron");
		GameRegistry.registerItem(jPlaques, "item_armurePlaquesJambieres");
		GameRegistry.registerItem(bPlaques, "item_armurePlaquesBottes");

		GameRegistry.registerItem(cClericale, "item_cClericale");
		GameRegistry.registerItem(pClericale, "item_pClericale");
		GameRegistry.registerItem(jClericale, "item_jClericale");
		GameRegistry.registerItem(bClericale, "item_bClericale");

		GameRegistry.registerItem(sergentC, "item_cSergent");
		GameRegistry.registerItem(sergentP, "item_pSergent");
		GameRegistry.registerItem(sergentJ, "item_jSergent");
		GameRegistry.registerItem(sergentB, "item_bSergent");

		GameRegistry.registerItem(cCloute, "item_cCloute");
		GameRegistry.registerItem(pCloute, "item_pCloute");
		GameRegistry.registerItem(jCloute, "item_jCloute");
		GameRegistry.registerItem(bCloute, "item_bCloute");

		GameRegistry.registerItem(cHuscarl, "item_cHuscarl");
		GameRegistry.registerItem(pHuscarl, "item_pHuscarl");
		GameRegistry.registerItem(jHuscarl, "item_jHuscarl");
		GameRegistry.registerItem(bHuscarl, "item_bHuscarl");

		GameRegistry.registerItem(cMaille, "item_cMaille");
		GameRegistry.registerItem(pMaille, "item_pMaille");
		GameRegistry.registerItem(jMaille, "item_jMaille");
		GameRegistry.registerItem(bMaille, "item_bMaille");

		GameRegistry.registerItem(cLamellaire, "item_cLamellaire");
		GameRegistry.registerItem(pLamellaire, "item_pLamellaire");
		GameRegistry.registerItem(jLamellaire, "item_jLamellaire");
		GameRegistry.registerItem(bLamellaire, "item_bLamellaire");

		GameRegistry.registerItem(cMaraudeur, "item_cMaraudeur");
		GameRegistry.registerItem(pMaraudeur, "item_pMaraudeur");
		GameRegistry.registerItem(jMaraudeur, "item_jMaraudeur");
		GameRegistry.registerItem(bMaraudeur, "item_bMaraudeur");

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
