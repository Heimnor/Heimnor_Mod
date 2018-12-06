package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CTBlockHorizontal extends CTBlock {
	
	private boolean collision;
	
	public CTBlockHorizontal(String name, String[] meta, int nbrTexture, int renderID, boolean normal , boolean collision) {
		super(name, meta, nbrTexture, renderID, normal);
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		this.collision = collision;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int meta, IBlockAccess world, int x, int y, int z, Block block) {
		
		boolean west = HDirection.WEST.canConnect(world, x, y, z, block, false);
		boolean east = HDirection.EAST.canConnect(world, x, y, z, block, false);
		boolean north = HDirection.NORTH.canConnect(world, x, y, z, block, false);
		boolean south = HDirection.SOUTH.canConnect(world, x, y, z, block, false);
		
		if (meta < this.meta.length)
		{
			if ((east && west) || (north && south))
				return this.icon[meta][2];
			else if ((east && !west) || (north && !south))
				return this.icon[meta][3];
			else if ((!east && west) || (!north && south))
				return this.icon[meta][1];
			else
				return this.icon[meta][0];
		}
		return this.icon[0][0];
		
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		
		if (this.collision)
			return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
		else
			return null;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		
		float[] f = BlocksUtils.boundingBoxFence(block, x, y, z);
		this.setBlockBounds(f[0], 0.0F, f[1], f[2], 1.0F, f[3]);
	}
	
}
