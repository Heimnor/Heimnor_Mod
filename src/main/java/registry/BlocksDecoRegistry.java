package registry;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.tileentity.TileEntityDirection;
import com.heimnor.utils.TextureMap;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockNoWebCollision;
import init.block.BlockReactUpDown;
import init.block.BlockTESRDeco;
import init.block.CSFloorWall;
import init.block.CTBlockHorizontal;
import init.block.CTCurtain;
import init.block.CTRandom;
import init.block.CTTrapDoor;
import init.block.CurtainBlock;
import init.block.FloorBlock;
import init.block.SlabHeimnor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksDecoRegistry {
	
	public static Block miroir, poissonSuspendu, pain, balais, rideaux_noir, rideaux_rouge, rideaux_bleu, rideaux_blanc, rideaux_magenta,
			rideaux_vert, rideaux_marron, roue, feuillage, rack, viande, fanion, assiette, armoireRiche, armoirePauvre, trappeRoche, barriere,
			trappePlanche, gravelSlab, plantesuspendue, lingesuspendu;
	
	public static void registerFurnitures() {
		
		miroir = new BlockTESRDeco(Material.wood, "miroir", true);
		
		pain = new BlockTESRDeco(Material.wood, "pain", false);
		
		balais = new BlockTESRDeco(Material.wood, "balais", false);
		
		poissonSuspendu = new BlockNoWebCollision(Material.clay, "poisson", new String[] { "poisson1", "poisson2", "poisson3" });
		
		roue = new CSFloorWall("roue",
				new TextureMap[] { new TextureMap(1, 1, "roue"), new TextureMap(2, 2, "roueI"), new TextureMap(3, 3, "roueG") },
				ClientProxy.renderFloorWallS);
		
		rideaux_noir = new CTCurtain("rideaux", new String[] { "noir", "altnoir" }, new int[] { 3, 3 }, false, true, false);
		rideaux_rouge = new CTCurtain("rideaux", new String[] { "rouge", "altrouge" }, new int[] { 3, 3 }, false, true, false);
		rideaux_bleu = new CTCurtain("rideaux", new String[] { "bleu", "altbleu" }, new int[] { 3, 3 }, false, true, false);
		rideaux_blanc = new CTCurtain("rideaux", new String[] { "blanc", "altblanc" }, new int[] { 3, 3 }, false, true, false);
		rideaux_magenta = new CTCurtain("rideaux", new String[] { "magenta", "altmagenta" }, new int[] { 3, 3 }, false, true, false);
		rideaux_vert = new CTCurtain("rideaux", new String[] { "vert", "altvert" }, new int[] { 3, 3 }, false, true, false);
		rideaux_marron = new CTCurtain("rideaux", new String[] { "marron", "altmarron" }, new int[] { 3, 3 }, false, true, false);
		
		barriere = new CTCurtain("barriere", new String[] { "planche", "planche_blanche", "roman", "romanAlt", "boiseau" },
				new int[] { 3, 3, 1, 1, 2 }, false, false, true);
		
		feuillage = new BlockReactUpDown("feuillage_tombant", ClientProxy.renderCobWeb, new String[] { "stalac" }, 4);
		
		rack = new CTCurtain("rack", new String[] { "hallebarde", "fuseur", "epee", "arbalete", "masse", "hache", "outil" },
				new int[] { 3, 2, 2, 1, 2, 2, 3 }, false, false, true);
		
		viande = new CTBlockHorizontal("viandesuspendue", new String[] { "viandebroche" }, 4, ClientProxy.renderCurtain, false, true);
		
		fanion = new CurtainBlock("fanion", true, 4, true);
		plantesuspendue = new CurtainBlock("plante_suspendue", false, 6, true);
		lingesuspendu = new CurtainBlock("linge_suspendu", true, 8, true);
		
		assiette = new FloorBlock("assiette", false, 9, false);
		
		armoireRiche = new CTRandom("armoire_riche", new String[] { "n", "b", "m", "h" }, new int[] { 2, 2, 2, 4 }, true, ClientProxy.renderRandom);
		armoirePauvre = new CTRandom("armoire_pauvre", new String[] { "n", "b", "m", "h" }, new int[] { 1, 1, 1, 1 }, true, ClientProxy.renderRandom);
		
		trappeRoche = new CTTrapDoor("trappe_roche", 1, 0);
		
		trappePlanche = new CTTrapDoor("trappe_planche", 4, 1);
		
		gravelSlab = new SlabHeimnor("gravel");
		
		GameRegistry.registerBlock(miroir, "block_miroir");
		GameRegistry.registerBlock(pain, "block_pain");
		GameRegistry.registerBlock(balais, "block_balais");
		GameRegistry.registerBlock(poissonSuspendu, "block_poisson");
		GameRegistry.registerBlock(rideaux_noir, "block_rideaux_noir");
		GameRegistry.registerBlock(rideaux_rouge, "block_rideaux_rouge");
		GameRegistry.registerBlock(rideaux_bleu, "block_rideaux_bleu");
		GameRegistry.registerBlock(rideaux_blanc, "block_rideaux_blanc");
		GameRegistry.registerBlock(rideaux_magenta, "block_rideaux_magenta");
		GameRegistry.registerBlock(rideaux_vert, "block_rideaux_vert");
		GameRegistry.registerBlock(rideaux_marron, "block_rideaux_marron");
		GameRegistry.registerBlock(roue, "block_roue");
		GameRegistry.registerBlock(feuillage, "block_feuillage");
		GameRegistry.registerBlock(rack, "block_rack");
		GameRegistry.registerBlock(viande, "block_viande");
		GameRegistry.registerBlock(fanion, "block_fanion");
		GameRegistry.registerBlock(plantesuspendue, "block_plantesuspendue");
		GameRegistry.registerBlock(lingesuspendu, "block_lingesuspendu");
		GameRegistry.registerBlock(assiette, "block_assiette");
		GameRegistry.registerBlock(armoireRiche, "block_armoireRiche");
		GameRegistry.registerBlock(armoirePauvre, "block_armoirePauvre");
		GameRegistry.registerBlock(trappeRoche, "block_trappeRoche");
		GameRegistry.registerBlock(trappePlanche, "block_trappePlanche");
		GameRegistry.registerBlock(gravelSlab, "block_gravelSlab");
		GameRegistry.registerBlock(barriere, "block_barriere");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDirection.class, Heimnor.MODID + ":direction_block");
	}
}
