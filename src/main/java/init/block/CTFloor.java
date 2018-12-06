package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CTFloor extends CTBlock {
	
	private String[] meta;
	private boolean side;
	private boolean normal;
	private int nbrTexture;
	private String name;
	private IIcon[] sideIcon;
	
	public CTFloor(String name, String[] meta, int nbrTexture, int renderID, boolean normal, boolean side) {
		super(name, meta, nbrTexture, renderID, normal);
		
		this.meta = meta;
		this.side = side;
		this.normal = normal;
		this.nbrTexture = nbrTexture;
		this.name = name;
		sideIcon = new IIcon[meta.length];
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.06F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.meta.length; i++)
		{
			// + 1 pour l'icône de base
			for (int k = 1; k < this.nbrTexture + 1; k++)
			{
				
				this.icon[i][k - 1] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] +"/"+ k);

			}
			if(side)
			this.sideIcon[i] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] +"/side");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, IBlockAccess world, int x, int y, int z, Block block) {
		
		boolean north = HDirection.NORTH.canConnect(world, x, y, z, block, false);
		boolean south = HDirection.SOUTH.canConnect(world, x, y, z, block, false);
		boolean west = HDirection.WEST.canConnect(world, x, y, z, block, false);
		boolean east = HDirection.EAST.canConnect(world, x, y, z, block, false);
		boolean northWest = HDirection.NORTH_WEST.canConnect(world, x, y, z, block, false);
		boolean northEast = HDirection.NORTH_EAST.canConnect(world, x, y, z, block, false);
		boolean southWest = HDirection.SOUTH_WEST.canConnect(world, x, y, z, block, false);
		boolean southEast = HDirection.SOUTH_EAST.canConnect(world, x, y, z, block, false);
		
		if (metadata < this.meta.length && this.nbrTexture == 48)
		{
			if (!north && !south && !west && !east)
				return this.icon[metadata][0];
			
			else if (north && south && west && east)
			{
				if (northWest && northEast && southWest && southEast)
					return this.icon[metadata][47];
				
				else if (!northWest && !northEast && !southWest && !southEast)
					return this.icon[metadata][46];
				
				else if (northEast && !northWest && !southEast && !southWest)
					return this.icon[metadata][8];
				
				else if (!northEast && !northWest && southEast && !southWest)
					return this.icon[metadata][9];
				
				else if (!northEast && northWest && !southEast && !southWest)
					return this.icon[metadata][20];
				
				else if (!northEast && !northWest && !southEast && southWest)
					return this.icon[metadata][21];
				
				else if(!northEast && northWest && !southEast && southWest)
					return this.icon[metadata][10];
				
				else if(northEast && northWest && !southEast && !southWest)
					return this.icon[metadata][11];
				
				else if(!northEast && !northWest && southEast && southWest)
					return this.icon[metadata][22];
				
				else if(northEast && !northWest && southEast && !southWest)
					return this.icon[metadata][23];
				
				else if(northEast && !northWest && !southEast && southWest)
					return this.icon[metadata][34];
				
				else if(!northEast && northWest && southEast && !southWest)
					return this.icon[metadata][35];
				
				else if(northEast && northWest && !southEast && southWest)
					return this.icon[metadata][32];
				
				else if(northEast && northWest && southEast && !southWest)
					return this.icon[metadata][33];
				
				else if(!northEast && northWest && southEast && southWest)
					return this.icon[metadata][44];
				
				else if(northEast && !northWest && southEast && southWest)
					return this.icon[metadata][45];
				
			} else
			{
				if (!north && !south)
				{
					if (west && east)
						return icon[metadata][2];
					else if (!west && east)
						return icon[metadata][1];
					else if (west && !east)
						return icon[metadata][3];
					
				} else if (!west && !east)
				{
					if (north && south)
						return icon[metadata][24];
					else if (north && !south)
						return icon[metadata][36];
					else if (!north && south)
						return icon[metadata][12];
					
				} else if (!south && !west)
				{
					
					if (north && east && !northEast)
						return this.icon[metadata][16];
					else if (north && east && northEast)
						return this.icon[metadata][37];
					
				} else if (!north && !west)
				{
					
					if (east && south && !southEast)
						return this.icon[metadata][4];
					else if (east && south && southEast)
						return this.icon[metadata][13];
					
				} else if (!north && !east)
				{
					
					if (south && west && !southWest)
						return this.icon[metadata][5];
					else if (south && west && southWest)
						return this.icon[metadata][15];
					
				} else if (!south && !east)
				{
					if (north && west && !northWest)
						return this.icon[metadata][17];
					else if (north && west && northWest)
						return this.icon[metadata][39];
					
				} else if (north && west && east && !south)
				{
					if (!northWest && !northEast)
						return this.icon[metadata][18];
					
					else if(northWest && northEast)
						return this.icon[metadata][38];
					
					else if(!northWest && northEast)
						return this.icon[metadata][40];
					
					else if(northWest && !northEast)
						return this.icon[metadata][42];
					
				} else if (north && east && south && !west)
				{
					if (!northEast && !southEast)
						return this.icon[metadata][6];
					
					else if(northEast && southEast)
						return this.icon[metadata][25];
					
					else if(!northEast && southEast)
						return this.icon[metadata][28];
					
					else if(northEast && !southEast)
						return this.icon[metadata][30];
					
				} else if (east && south && west && !north)
				{
					if (!southEast && !southWest)
						return this.icon[metadata][7];
					
					else if(southEast && southWest)
						return this.icon[metadata][14];
					
					else if(!southEast && southWest)
						return this.icon[metadata][29];
					
					else if(southEast && !southWest)
						return this.icon[metadata][31];
					
				} else if (south && west && north && !east)
				{
					if (!southWest && !northWest)
						return this.icon[metadata][19];
					
					else if(southWest && northWest)
						return this.icon[metadata][27];
					
					else if(!southWest && northWest)
						return this.icon[metadata][41];
					
					else if(southWest && !northWest)
						return this.icon[metadata][43];
				}
			}
		}
		return this.icon[0][0];
	}
	
	public IIcon getSideIcon(int meta) {
		
		return this.sideIcon[meta];
	}
	
	public boolean renderAsNormalBlock() {
		return this.normal;
	}
	
	public boolean isOpaqueCube() {
		return this.normal;
	}
	
	public boolean hasSide() {
		return this.side;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
}
