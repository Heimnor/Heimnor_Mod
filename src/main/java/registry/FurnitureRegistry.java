package registry;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityMiroir;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FurnitureRegistry {

	public static Block miroir;

	public static void registerFurnitures() {

		miroir = new BlockMetadata(Material.wood).setResistance(0.5F)
				.setBlockTextureName(Heimnor.MODID + ":plandetravail").setBlockName("miroir")
				.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		
		GameRegistry.registerBlock(miroir, "block_miroir");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMiroir.class, Heimnor.MODID + ":miroir");
	}
}
