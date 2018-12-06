package registry;

import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockDirectionLog;
import init.block.CTFloor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksRegistry{
	
	public static Block burnedLog, tapis_vert, mousse,paille, peaux, tapis_vertClair, filet_sol;

	public static void registerBlocks() {


		burnedLog = new BlockDirectionLog("burned_log");
		
		tapis_vert = new CTFloor("tapis", new String[] {"tapis_vert"}, 48, ClientProxy.renderFloor, false, true);
		tapis_vertClair =  new CTFloor("tapis", new String[] {"tapis_vertClair"}, 48, ClientProxy.renderFloor, false, true);
		paille = new CTFloor("paille_sol", new String[] {"paille"}, 48, ClientProxy.renderFloor, false, false);
		peaux = new CTFloor("peaux", new String[] {"peau_ours", "peau_loup", "peau_mouton"}, 48, ClientProxy.renderFloor, false, false);
		mousse = new CTFloor("mousse", new String[] {"mousse_verte", "herbe_verte"}, 48, ClientProxy.renderFloor, false, false);
		filet_sol = new CTFloor("filet", new String[] {"filet"}, 1, ClientProxy.renderFloor, false, false);
		
		GameRegistry.registerBlock(burnedLog, "block_burnedlog");
		GameRegistry.registerBlock(tapis_vert, "block_tapisVert");
		GameRegistry.registerBlock(tapis_vertClair, "block_tapisVertClair");
		GameRegistry.registerBlock(paille, "block_paille");
		GameRegistry.registerBlock(peaux, "block_peau");
		GameRegistry.registerBlock(mousse, "block_mousse");
		GameRegistry.registerBlock(filet_sol, "block_filetSol");
	}
	
	public static void registerTileEntities() {
		
	}
}
