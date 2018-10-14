package registry;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityDirection;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockNoWebCollision;
import init.block.BlockTESRDeco;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksDecoRegistry {

	public static Block miroir, bouteille, pain, balais;

	public static void registerFurnitures() {

		miroir = new BlockTESRDeco(Material.wood, "miroir", true);
		
		pain = new BlockTESRDeco(Material.wood, "pain", false);
		
		balais = new BlockTESRDeco(Material.wood, "balais", false);
		
		bouteille = new BlockNoWebCollision(Material.clay, "bouteille");
		
		GameRegistry.registerBlock(miroir, "block_miroir");
		GameRegistry.registerBlock(pain, "block_pain");
		GameRegistry.registerBlock(balais, "block_balais");
		GameRegistry.registerBlock(bouteille, "block_bouteille");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDirection.class, Heimnor.MODID + ":direction_block");
	}
}
