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
			shaalJambieres_2, DjarnedinCasque_1, DjarnedinPlastron_1, DjarnedinBottes_1,
			cuirBouilliCasque, cuirBouilliPlastron, cuirBouilliJambieres, cuirBouilliBottes, armureImproviseeCasque,
			armureImproviseePlastron, armureImproviseeJambieres, armureImproviseeBottes, armureMercenaireCasque,
			armureMercenairePlastron, armureMercenaireJambieres, armureMercenaireBottes, cHaji,
			pHaji, jHaji, bHaji, armureToundraCasque, armureToundraPlastron, armureToundraJambieres, armureToundraBottes,
			armureGuerinneCasque, armureGuerinnePlastron, armureGuerinneJambieres, armureGuerinneBottes,
			cPlaques, pPlaques, jPlaques, bPlaques, cClericale, pClericale, jClericale, bClericale,
			sergentC, sergentP, sergentJ, sergentB, cCloute, pCloute, jCloute, bCloute, cHuscarl, pHuscarl, jHuscarl, bHuscarl, cMaille, pMaille, jMaille, bMaille, 
			cLamellaire, pLamellaire, jLamellaire, bLamellaire, cMaraudeur, pMaraudeur, jMaraudeur, bMaraudeur;

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

		cHaji = new HArmor(milLeger, HAJI, 0, ArmorCategories.MILITAIRELEGER, "CHaji");
		pHaji = new HArmor(milLeger, HAJI, 1, ArmorCategories.MILITAIRELEGER, "PHaji");
		jHaji = new HArmor(milLeger, HAJI, 2, ArmorCategories.MILITAIRELEGER, "JHaji");
		bHaji = new HArmor(milLeger, HAJI, 3, ArmorCategories.MILITAIRELEGER, "BHaji");


		armureToundraCasque = new HArmor(civilLeg, TOUNDRA, 0, ArmorCategories.CIVILLEGER, "toundraC");
		armureToundraPlastron = new HArmor(civilLeg, TOUNDRA, 1, ArmorCategories.CIVILLEGER, "toundraP");
		armureToundraJambieres = new HArmor(civilLeg, TOUNDRA, 2, ArmorCategories.CIVILLEGER, "toundraJ");
		armureToundraBottes = new HArmor(civilLeg, TOUNDRA, 3, ArmorCategories.CIVILLEGER, "toundraB");

		armureGuerinneCasque = new HArmor(milLourd, GUERIN, 0, ArmorCategories.MILITAIRELOURD, "guerinC");
		armureGuerinnePlastron = new HArmor(milLourd, GUERIN, 1, ArmorCategories.MILITAIRELOURD, "guerinP");
		armureGuerinneJambieres = new HArmor(milLourd, GUERIN, 2, ArmorCategories.MILITAIRELOURD, "guerinJ");
		armureGuerinneBottes = new HArmor(milLourd, GUERIN, 3, ArmorCategories.MILITAIRELOURD, "guerinB");

		cPlaques = new HArmor(milLourd, PLAQUES, 0, ArmorCategories.MILITAIRELOURD, "CPlaques");
		pPlaques = new HArmor(milLourd, PLAQUES, 1, ArmorCategories.MILITAIRELOURD, "PPlaques");
		jPlaques = new HArmor(milLourd, PLAQUES, 2, ArmorCategories.MILITAIRELOURD, "JPlaques");
		bPlaques = new HArmor(milLourd, PLAQUES, 3, ArmorCategories.MILITAIRELOURD, "BPlaques");
		
		cClericale = new HArmor(milLeger, CLERICALE, 0, ArmorCategories.MILITAIRELEGER, "CClericale");
		pClericale = new HArmor(milLeger, CLERICALE, 1, ArmorCategories.MILITAIRELEGER, "PClericale");
		jClericale = new HArmor(milLeger, CLERICALE, 2, ArmorCategories.MILITAIRELEGER, "JClericale");
		bClericale = new HArmor(milLeger, CLERICALE, 3, ArmorCategories.MILITAIRELEGER, "BClericales");
		
		sergentC = new HArmor(milLourd, SERGENT, 0, ArmorCategories.MILITAIRELOURD, "CSergent");
		sergentP = new HArmor(milLourd, SERGENT, 1, ArmorCategories.MILITAIRELOURD, "PSergent");
		sergentJ = new HArmor(milLourd, SERGENT, 2, ArmorCategories.MILITAIRELOURD, "JSergent");
		sergentB = new HArmor(milLourd, SERGENT, 3, ArmorCategories.MILITAIRELOURD, "BSergent");
		
		cCloute = new HArmor(milLeger, CLOUTE, 0, ArmorCategories.MILITAIRELEGER, "CCloute");
		pCloute = new HArmor(milLeger, CLOUTE, 1, ArmorCategories.MILITAIRELEGER, "PCloute");
		jCloute = new HArmor(milLeger, CLOUTE, 2, ArmorCategories.MILITAIRELEGER, "JCloute");
		bCloute = new HArmor(milLeger, CLOUTE, 3, ArmorCategories.MILITAIRELEGER, "BCloute");
		
		cHuscarl = new HArmor(milLeger, HUSCARL, 0, ArmorCategories.MILITAIRELEGER, "CGjermund");
		pHuscarl = new HArmor(milLeger, HUSCARL, 1, ArmorCategories.MILITAIRELEGER, "PHuscarl");
		jHuscarl = new HArmor(milLeger, HUSCARL, 2, ArmorCategories.MILITAIRELEGER, "JHuscarl");
		bHuscarl = new HArmor(milLeger, HUSCARL, 3, ArmorCategories.MILITAIRELEGER, "BHuscarl");
		
		cMaille = new HArmor(milLeger, MAILLE, 0, ArmorCategories.MILITAIRELEGER, "CMaille");
		pMaille = new HArmor(milLeger, MAILLE, 1, ArmorCategories.MILITAIRELEGER, "PMaille");
		jMaille = new HArmor(milLeger, MAILLE, 2, ArmorCategories.MILITAIRELEGER, "JMaille");
		bMaille = new HArmor(milLeger, MAILLE, 3, ArmorCategories.MILITAIRELEGER, "BMaille");
		
		cLamellaire = new HArmor(milLeger, LAMELLAIRE, 0, ArmorCategories.MILITAIRELEGER, "CLamellaire");
		pLamellaire = new HArmor(milLeger, LAMELLAIRE, 1, ArmorCategories.MILITAIRELEGER, "PLamellaire");
		jLamellaire = new HArmor(milLeger, LAMELLAIRE, 2, ArmorCategories.MILITAIRELEGER, "JLamellaire");
		bLamellaire = new HArmor(milLeger, LAMELLAIRE, 3, ArmorCategories.MILITAIRELEGER, "BLamellaire");
		
		cMaraudeur = new HArmor(milLourd, MARAUDEUR, 0, ArmorCategories.MILITAIRELOURD, "CMaraudeur");
		pMaraudeur = new HArmor(milLourd, MARAUDEUR, 1, ArmorCategories.MILITAIRELOURD, "PMaraudeur");
		jMaraudeur = new HArmor(milLourd, MARAUDEUR, 2, ArmorCategories.MILITAIRELOURD, "JMaraudeur");
		bMaraudeur = new HArmor(milLourd, MARAUDEUR, 3, ArmorCategories.MILITAIRELOURD, "BMaraudeur");

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
