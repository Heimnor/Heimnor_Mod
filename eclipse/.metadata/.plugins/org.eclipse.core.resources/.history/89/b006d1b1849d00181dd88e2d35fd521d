package init.block;

import com.heimnor.proxy.ClientProxy;
import com.heimnor.tileentity.TileEntityFourCuisine;
import com.heimnor.tileentity.TileEntityMiroir;
import com.heimnor.tileentity.TileEntityPlancheDecoup;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDirection extends Block{
	
	public BlockDirection(Material material) {
		super(material);
	}
	
	@Override
	public TileEntity createTileEntity(World world, int p_149915_2_) {

		TileEntityMiroir tile = new TileEntityMiroir();

		return tile;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)

	{
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile instanceof TileEntityMiroir) {

			int direction = MathHelper.floor_double((double) (living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			System.out.println("direction" + direction);
			((TileEntityMiroir) tile).setDirection((byte) direction);
		}
	}
	
	@Override
	public boolean isNormalCube() {
		return this.blockMaterial.isOpaque() && this.renderAsNormalBlock() && !this.canProvidePower();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.renderID;
	}

}