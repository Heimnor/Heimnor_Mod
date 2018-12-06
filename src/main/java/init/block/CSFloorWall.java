package init.block;

import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.TextureMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;

public class CSFloorWall extends ConnectedStructureBlock {
	
	private int renderID;
	
	public CSFloorWall(String name, TextureMap[] submaps, int renderId) {
		super(name, submaps, renderId);
		renderID = renderId;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		
		int meta = world.getBlockMetadata(x, y, z);
		
		switch (meta)
		{
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.89F, 1.0F, 1.0F, 1.0F);
			break;
		case 2:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.11F);
			break;
		case 3:
			this.setBlockBounds(0.89F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			break;
		case 4:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.11F, 1.0F, 1.0F);
			break;
		default:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.11F, 1.0F);
			break;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return this.renderID;
	}
}
