package registry;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.registry.GameRegistry;
import init.weapons.Armes;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class WeaponsRegistry {

	public static ToolMaterial improvise = EnumHelper.addToolMaterial("improviseMaterial", 3, 1000, 12.0F, 0.0F, 18);
	public static ToolMaterial military = EnumHelper.addToolMaterial("militaryMaterial", 3, 2000, 12.0F, 2.0F, 18);
	

	public static Item epeeClaymore, brazure, masseRhombe, matraque, patteDours, bodan, saif, espadondebraz,
			daguedebraz, guisarme, marteaudebraz, faux, lancedebraz, epeedebraz, bidentdebraz, marteaulourddebraz,
			hachoir, becdecorbin, khirve, epeelarge, daguerituelle, chapelier, sceptre, daguedos, hanche, espadon,
			dague, hallante, masseaailettes, massebenie, hallebarde, sceptreoronne, hallebardebenie, lancedefaille,
			vangarde, qian, yishi, epeebenie, hachedefjil, epeedorion, daguedefjil, massedos, lamedefjil, quadree,
			surin, malfif, tesson, bouteille, planche, massehectaire, hachedebataille, deuxmains, coutelas, zhang,
			hallebardebarbue, masseapointes, hachebarbue, lance, sceptredefer, hachepahinne, massedeguerre, katana,
			katar, kukri, marteau, sakran, espadondorion, epeeailee, epeedroite, becdemoinin, rapiere, sabre, fauchon,
			fleau, gantsdeguerre, griffesdefer, piquederoc, epeelongue, massederoc, zenjia, lancederoc, pontinne,
			maillet, piquard, daguederoc, pieu, torchere, gourdincercle, baton, canne, lanceenbois, piquetier, serpe,
			brigande, pilleuse, yanli, haida, epee, gourdin, balais, lamedobsidienne, hachederoc, hachedentrainement,
			epeedentrainement, hachebenie, marteaudeguerre, bipenne, epeebatarde, tsuri, hallebardeailee;

	public static void registerWeapons() {

		// Argument 1 : material(dura, degats etc...) Argument 2: nom de la texture sans
		// le ".png" et nom non localisé
		epeeClaymore = new Armes(military, "epeeclaymore");
		masseRhombe = new Armes(military, "masseRhombe");
		matraque = new Armes(improvise, "matraque");
		patteDours = new Armes(improvise, "patteDOurs");
		bodan = new Armes(improvise, "bodan");
		saif = new Armes(military, "saif");
		brazure = new Armes(military, "brazure");
		hachebenie = new Armes(military, "hachebenie");
		espadondebraz = new Armes(military, "espadonDeBraz");
		bipenne = new Armes(military, "bipenne");
		marteaudeguerre = new Armes(military, "marteaudeguerre");
		daguedebraz = new Armes(military, "dagueDeBraz");
		guisarme = new Armes(military, "guisarme");
		marteaudebraz = new Armes(military, "marteauDeBraz");
		faux = new Armes(improvise, "faux");
		lancedebraz = new Armes(military, "lanceDeBraz");
		epeedebraz = new Armes(military, "epeeDeBraz");
		bidentdebraz = new Armes(military, "bidentDeBraz");
		marteaulourddebraz = new Armes(military, "marteauLourdDeBraz");
		hachoir = new Armes(improvise, "hachoir");
		becdecorbin = new Armes(military, "becDeCorbin");
		khirve = new Armes(military, "khirve");
		epeelarge = new Armes(military, "epeeLarge");
		daguerituelle = new Armes(military, "dagueRituelle");
		chapelier = new Armes(improvise, "Chapelier");
		sceptre = new Armes(improvise, "Sceptre");
		daguedos = new Armes(improvise, "dagueDos");
		tsuri = new Armes(military, "tsuri");
		hallebardeailee = new Armes(military, "hallebardeAilee");
		epeebatarde = new Armes(military, "epeeBatarde");
		hanche = new Armes(military, "hanche");
		espadon = new Armes(military, "espadon");
		dague = new Armes(improvise, "dague");
		hallante = new Armes(military, "hallante");
		masseaailettes = new Armes(military, "masseAilettes");
		massebenie = new Armes(military, "masseBenie");
		hallebarde = new Armes(military, "hallebarde");
		sceptreoronne = new Armes(improvise, "sceptreOronne");
		hallebardebenie = new Armes(military, "hallebardeBenie");
		lancedefaille = new Armes(military, "lanceDeFaille");
		vangarde = new Armes(military, "vangarde");
		qian = new Armes(military, "qian");
		yishi = new Armes(military, "yishi");
		epeebenie = new Armes(military, "epeeBenie");
		hachedefjil = new Armes(military, "hacheDeFjil");
		epeedorion = new Armes(military, "epeeDorion");
		daguedefjil = new Armes(military, "dagueDeFjil");
		massedos = new Armes(military, "masseOs");
		lamedefjil = new Armes(military, "lameDeFjil");
		quadree = new Armes(military, "quadree");
		surin = new Armes(improvise, "surin");
		malfif = new Armes(improvise, "malfif");
		tesson = new Armes(improvise, "tesson");
		bouteille = new Armes(improvise, "bouteille");
		planche = new Armes(improvise, "planche");
		massehectaire = new Armes(military, "masseHectaire");
		hachedebataille = new Armes(military, "hacheDeBataille");
		deuxmains = new Armes(military, "deuxmains");
		coutelas = new Armes(military, "coutelas");
		zhang = new Armes(military, "zhang");
		hallebardebarbue = new Armes(military, "hallebardeBarbue");
		masseapointes = new Armes(military, "massePointes");
		hachebarbue = new Armes(military, "hacheBarbue");
		lance = new Armes(military, "lance");
		sceptredefer = new Armes(improvise, "sceptredefer");
		hachepahinne = new Armes(military, "hachePahinne");
		massedeguerre = new Armes(military, "masseDeGuerre");
		katana = new Armes(military, "katana");
		katar = new Armes(improvise, "katar");
		kukri = new Armes(military, "kukri");
		marteau = new Armes(military, "marteau");
		sakran = new Armes(military, "sakran");
		espadondorion = new Armes(military, "espadonDorion");
		epeeailee = new Armes(military, "epeeAilee");
		epeedroite = new Armes(military, "epeeDroite");
		becdemoinin = new Armes(military, "becDeMoinin");
		rapiere = new Armes(military, "rapiere");
		sabre = new Armes(military, "sabre");
		fauchon = new Armes(military, "fauchon");
		fleau = new Armes(military, "fleau");
		gantsdeguerre = new Armes(improvise, "gantsDeGuerre");
		griffesdefer = new Armes(improvise, "griffesDeFer");
		piquederoc = new Armes(improvise, "piqueDeRoc");
		epeelongue = new Armes(military, "epeeLongue");
		massederoc = new Armes(military, "masseDeRoc");
		zenjia = new Armes(military, "zenjia");
		lancederoc = new Armes(military, "lanceDeRoc");
		pontinne = new Armes(military, "pontinne");
		maillet = new Armes(improvise, "maillet");
		piquard = new Armes(improvise, "piquard");
		daguederoc = new Armes(improvise, "dagueDeRoc");
		pieu = new Armes(improvise, "pieu");
		torchere = new Armes(improvise, "torchere");
		gourdincercle = new Armes(improvise, "gourdinCercle");
		baton = new Armes(improvise, "baton");
		canne = new Armes(improvise, "canne");
		lanceenbois = new Armes(improvise, "lanceEnBois");
		piquetier = new Armes(improvise, "piquetier");
		serpe = new Armes(improvise, "serpe");
		brigande = new Armes(military, "brigande");
		pilleuse = new Armes(military, "pilleuse");
		yanli = new Armes(military, "yanli");
		haida = new Armes(military, "haida");
		epee = new Armes(military, "epee");
		gourdin = new Armes(improvise, "gourdin");
		balais = new Armes(improvise, "balais");
		lamedobsidienne = new Armes(military, "lameObsidienne");
		hachederoc = new Armes(improvise, "hacheDeRoc");
		hachedentrainement = new Armes(improvise, "hacheDentrainement");
		epeedentrainement = new Armes(improvise, "epeeDentrainement");

		GameRegistry.registerItem(epeeClaymore, "item_epeeClaymore");
		GameRegistry.registerItem(masseRhombe, "item_masse_rhombe");
		GameRegistry.registerItem(matraque, "item_matraque");
		GameRegistry.registerItem(patteDours, "item_patte_dours");
		GameRegistry.registerItem(bodan, "item_bodan");
		GameRegistry.registerItem(saif, "item_saif");
		GameRegistry.registerItem(brazure, "item_brazure");
		GameRegistry.registerItem(espadondebraz, "item_espadon_de_braz");
		GameRegistry.registerItem(daguedebraz, "item_dague_de_braz");
		GameRegistry.registerItem(guisarme, "item_guisarme");
		GameRegistry.registerItem(marteaudebraz, "item_marteau_de_braz");
		GameRegistry.registerItem(faux, "item_faux");
		GameRegistry.registerItem(lancedebraz, "item_lance_de_braz");
		GameRegistry.registerItem(epeedebraz, "item_epee_de_braz");
		GameRegistry.registerItem(bidentdebraz, "item_bident_de_braz");
		GameRegistry.registerItem(marteaulourddebraz, "item_marteau_lourd_de_braz");
		GameRegistry.registerItem(hachoir, "item_hachoir");
		GameRegistry.registerItem(becdecorbin, "item_bec_de_corbin");
		GameRegistry.registerItem(khirve, "item_khirve");
		GameRegistry.registerItem(epeelarge, "item_epee_large");
		GameRegistry.registerItem(daguerituelle, "item_dague_rituelle");
		GameRegistry.registerItem(chapelier, "item_chapelier");
		GameRegistry.registerItem(sceptre, "item_sceptre");
		GameRegistry.registerItem(daguedos, "item_dague_dos");
		GameRegistry.registerItem(hanche, "item_hanche");
		GameRegistry.registerItem(espadon, "item_espadon");
		GameRegistry.registerItem(dague, "item_dague");
		GameRegistry.registerItem(hallante, "item_hallante");
		GameRegistry.registerItem(masseaailettes, "item_masse_a_ailettes");
		GameRegistry.registerItem(massebenie, "item_masse_benie");
		GameRegistry.registerItem(hallebarde, "item_hallebarde");
		GameRegistry.registerItem(sceptreoronne, "item_sceptre_oronne");
		GameRegistry.registerItem(hallebardebenie, "item_hallebarde_benie");
		GameRegistry.registerItem(hachebenie, "item_hache_benie");
		GameRegistry.registerItem(marteaudeguerre, "item_marteau_de_guerre");
		GameRegistry.registerItem(bipenne, "item_bipenne");
		GameRegistry.registerItem(epeebatarde, "item_epee_batarde");
		GameRegistry.registerItem(tsuri, "item_tsuri");
		GameRegistry.registerItem(hallebardeailee, "item_hallebarde_ailee");
		GameRegistry.registerItem(lancedefaille, "item_lance_de_faille");
		GameRegistry.registerItem(vangarde, "item_vangarde");
		GameRegistry.registerItem(qian, "item_qian");
		GameRegistry.registerItem(yishi, "item_yishi");
		GameRegistry.registerItem(epeebenie, "item_epee_benie");
		GameRegistry.registerItem(hachedefjil, "item_hache_de_fjil");
		GameRegistry.registerItem(epeedorion, "item_epee_dorion");
		GameRegistry.registerItem(daguedefjil, "item_dague_de_fjil");
		GameRegistry.registerItem(massedos, "item_masse_dos");
		GameRegistry.registerItem(lamedefjil, "item_lame_de_fjil");
		GameRegistry.registerItem(quadree, "item_quadree");
		GameRegistry.registerItem(surin, "item_surin");
		GameRegistry.registerItem(malfif, "item_malfif");
		GameRegistry.registerItem(tesson, "item_tesson");
		GameRegistry.registerItem(bouteille, "item_bouteille");
		GameRegistry.registerItem(planche, "item_planche");
		GameRegistry.registerItem(massehectaire, "item_masse_hectaire");
		GameRegistry.registerItem(hachedebataille, "item_hache_de_bataille");
		GameRegistry.registerItem(deuxmains, "item_deuxmains");
		GameRegistry.registerItem(coutelas, "item_coutelas");
		GameRegistry.registerItem(zhang, "item_zhang");
		GameRegistry.registerItem(hallebardebarbue, "item_hallebarde_barbue");
		GameRegistry.registerItem(masseapointes, "item_masse_a_pointes");
		GameRegistry.registerItem(hachebarbue, "item_hache_barbue");
		GameRegistry.registerItem(lance, "item_lance");
		GameRegistry.registerItem(sceptredefer, "item_sceptre_de_fer");
		GameRegistry.registerItem(hachepahinne, "item_hache_pahinne");
		GameRegistry.registerItem(massedeguerre, "item_masse_de_guerre");
		GameRegistry.registerItem(katana, "item_katana");
		GameRegistry.registerItem(katar, "item_katar");
		GameRegistry.registerItem(kukri, "item_kukri");
		GameRegistry.registerItem(marteau, "item_marteau");
		GameRegistry.registerItem(sakran, "item_sakran");
		GameRegistry.registerItem(espadondorion, "item_espadon_dorion");
		GameRegistry.registerItem(epeeailee, "item_epee_ailee");
		GameRegistry.registerItem(epeedroite, "item_epee_droite");
		GameRegistry.registerItem(becdemoinin, "item_bec_de_moinin");
		GameRegistry.registerItem(rapiere, "item_rapiere");
		GameRegistry.registerItem(sabre, "item_sabre");
		GameRegistry.registerItem(fauchon, "item_fauchon");
		GameRegistry.registerItem(fleau, "item_fleau");
		GameRegistry.registerItem(gantsdeguerre, "item_gants_de_guerre");
		GameRegistry.registerItem(griffesdefer, "item_griffes_de_fer");
		GameRegistry.registerItem(piquederoc, "item_pique_de_roc");
		GameRegistry.registerItem(epeelongue, "item_epee_longue");
		GameRegistry.registerItem(massederoc, "item_masse_de_roc");
		GameRegistry.registerItem(zenjia, "item_zenjia");
		GameRegistry.registerItem(lancederoc, "item_lance_de_roc");
		GameRegistry.registerItem(pontinne, "item_pontinne");
		GameRegistry.registerItem(maillet, "item_maillet");
		GameRegistry.registerItem(piquard, "item_piquard");
		GameRegistry.registerItem(daguederoc, "item_dague_de_roc");
		GameRegistry.registerItem(pieu, "item_pieu");
		GameRegistry.registerItem(torchere, "item_torchere");
		GameRegistry.registerItem(gourdincercle, "item_gourdin_cercle");
		GameRegistry.registerItem(baton, "item_baton");
		GameRegistry.registerItem(canne, "item_canne");
		GameRegistry.registerItem(lanceenbois, "item_lance_en_bois");
		GameRegistry.registerItem(piquetier, "item_piquetier");
		GameRegistry.registerItem(serpe, "item_serpe");
		GameRegistry.registerItem(brigande, "item_brigande");
		GameRegistry.registerItem(pilleuse, "item_pilleuse");
		GameRegistry.registerItem(yanli, "item_yanli");
		GameRegistry.registerItem(haida, "item_haida");
		GameRegistry.registerItem(epee, "item_epee");
		GameRegistry.registerItem(gourdin, "item_gourdin");
		GameRegistry.registerItem(balais, "item_balais");
		GameRegistry.registerItem(lamedobsidienne, "item_lame_dobsidienne");
		GameRegistry.registerItem(hachederoc, "item_hache_de_roc");
		GameRegistry.registerItem(hachedentrainement, "item_hache_dentrainement");
		GameRegistry.registerItem(epeedentrainement, "item_epee_dentrainement");
	}
}
