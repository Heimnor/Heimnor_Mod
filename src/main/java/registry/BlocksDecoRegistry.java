package registry;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityDirection;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlocksDecoRegistry {
	
	
	public static void registerFurnitures() {
		
	}
	
	public static void registerTileEntities() {
		
		GameRegistry.registerTileEntity(TileEntityDirection.class, Heimnor.MODID + ":direction_block");
	}
}
