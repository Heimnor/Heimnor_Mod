package registry;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityDirection;

import cpw.mods.fml.common.registry.GameRegistry;
import init.block.BlockConnectedTextureUpDown;
import init.block.BlockNoWebCollision;
import init.block.BlockTESRDeco;
import init.block.CurtainNoCollision;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksDecoRegistry {

	public static Block miroir, poissonSuspendu, pain, balais, rideaux;

	public static void registerFurnitures() {

		miroir = new BlockTESRDeco(Material.wood, "miroir", true);
		
		pain = new BlockTESRDeco(Material.wood, "pain", false);
		
		balais = new BlockTESRDeco(Material.wood, "balais", false);
		
		poissonSuspendu = new BlockNoWebCollision(Material.clay, "poisson", new String[] {"poisson1", "poisson2", "poisson3"});
		
		rideaux = new CurtainNoCollision(Material.cloth, "rideaux", new String[] {"noir", "altnoir", "rouge", "altrouge"}, false, true);
		
		GameRegistry.registerBlock(miroir, "block_miroir");
		GameRegistry.registerBlock(pain, "block_pain");
		GameRegistry.registerBlock(balais, "block_balais");
		GameRegistry.registerBlock(poissonSuspendu, "block_poisson");
		GameRegistry.registerBlock(rideaux, "block_rideaux");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDirection.class, Heimnor.MODID + ":direction_block");
	}
}
