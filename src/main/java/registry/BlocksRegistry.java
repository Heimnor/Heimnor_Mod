package registry;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockDirectionLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksRegistry{
	
	public static Block burnedLog;

	public static void registerBlocks() {


		burnedLog = new BlockDirectionLog(Material.wood, "burned_log");
		
		GameRegistry.registerBlock(burnedLog, "block_burnedlog");
	}
	
	public static void registerTileEntities() {
		
	}
}
