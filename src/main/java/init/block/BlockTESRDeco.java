package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.tileentity.TileEntityDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import registry.BlocksDecoRegistry;

public class BlockTESRDeco extends Block {

	public boolean collision;

	public BlockTESRDeco(Material material, String name, boolean collision) {
		super(material);
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		this.setResistance(0.5F);
		this.setBlockName(name);
		this.collision = collision;
	}

	@Override
	public TileEntity createTileEntity(World world, int p_149915_2_) {

		TileEntityDirection tile = new TileEntityDirection();

		return tile;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)

	{
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile instanceof TileEntityDirection) {

			int direction = MathHelper.floor_double((double) (living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			((TileEntityDirection) tile).setDirection((byte) direction);
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
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		if (this.collision == false) {
			return null;

			// Collision Miroir
		} else if (this == BlocksDecoRegistry.miroir) {
			TileEntityDirection tile = (TileEntityDirection) world.getTileEntity(x, y, z);
			if (tile != null) {
				if (tile.getDirection() == 2 || tile.getDirection() == 0)
					return AxisAlignedBB.getBoundingBox((double) x + this.minX, (double) y + this.minY,
							(double) z + this.minZ, (double) x + this.maxX, (double) y + this.maxY,
							(double) z + this.maxZ);
				if (tile.getDirection() == 1 || tile.getDirection() == 3)
					return AxisAlignedBB.getBoundingBox((double) x + this.minX, (double) y + this.minY,
							(double) z + this.minZ, (double) x + this.maxX, (double) y + this.maxY,
							(double) z + this.maxZ);
			}

		}
		return AxisAlignedBB.getBoundingBox((double) x + this.minX, (double) y + this.minY, (double) z + this.minZ,
				(double) x + this.maxX, (double) y + this.maxY, (double) z + this.maxZ);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {

		TileEntityDirection tile = (TileEntityDirection) block.getTileEntity(x, y, z);
		if (this == BlocksDecoRegistry.miroir) {
			if (tile != null) {
				if (tile.getDirection() == 2 || tile.getDirection() == 0)
					this.setBlockBounds(0.0F, 0.0F, 0.4F, 1.0F, 1.0F, 0.6F);
				if (tile.getDirection() == 1 || tile.getDirection() == 3)
					this.setBlockBounds(0.4F, 0.0F, 0.0F, 0.6F, 1.0F, 1.0F);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.renderID;
	}
}
