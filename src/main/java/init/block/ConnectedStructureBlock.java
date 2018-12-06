package init.block;

import java.util.HashMap;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.TextureMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * 
 * @author Joe 27 nov. 2018
 *
 */
public class ConnectedStructureBlock extends HBlock {
	
	public HashMap dirs;
	public TextureMap[] submaps;
	
	public int structure = 0;
	public int position = 0;
	private int renderID;
	
	public ConnectedStructureBlock(String name, TextureMap[] submaps, int renderId) {
		super(name);
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		this.submaps = submaps;
		this.renderID = renderId;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		
		if (side == 5)
			return 4;
		else if (side == 4)
			return 3;
		else if (side == 3)
			return 2;
		else if (side == 2)
			return 1;
		else
			return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		int nbrIcons;
		
		for (int i = 0; i < submaps.length; i++)
		{
			submaps[i].registerIcons(iconRegister, this.name);
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, Block block) {
		
		int meta = world.getBlockMetadata(x, y, z);
		int f1 = 0;
		int f2 = 0;
		int f3 = 0;
		int posX = 0;
		int posY = 0;
		IIcon[][] icons;
		
		int masterX;
		int masterY;
		
		if (meta == 1)
		{
			while (world.getBlock(x + 1 + posX, y, z) == block)
				posX++;
			
			while (world.getBlock(x, y + 1 + posY, z) == block)
				posY++;
			
			masterX = x + posX;
			masterY = y + posY;
			
			if (world.getBlock(masterX, masterY, z) == block)
			{
				ConnectedStructureBlock master = (ConnectedStructureBlock) world.getBlock(masterX, masterY, z);
				
				int structureMaster = master.getStructureType(world, masterX, masterY, z, block);
				TextureMap order = submaps[structureMaster];
				int width = order.getWidth() - 1;
				int height = order.getHeight() - 1;
				if (posX <= width && posY <= height)
				{
					icons = submaps[structureMaster].getTextureMap();
					return icons[posX][posY];
				}
			}
			
		} else if (meta == 2)
		{
			while (world.getBlock(x - 1 - posX, y, z) == block)
				posX++;
			
			while (world.getBlock(x, y + 1 + posY, z) == block)
				posY++;
			
			masterX = x - posX;
			masterY = y + posY;
			
			if (world.getBlock(masterX, masterY, z) == block)
			{
				ConnectedStructureBlock master = (ConnectedStructureBlock) world.getBlock(masterX, masterY, z);
				
				int structureMaster = master.getStructureType(world, masterX, masterY, z, block);
				TextureMap order = submaps[structureMaster];
				int width = order.getWidth() - 1;
				int height = order.getHeight() - 1;
				if (posX <= width && posY <= height)
				{
					icons = submaps[structureMaster].getTextureMap();
					return icons[posX][posY];
				}
			}
			
		} else if (meta == 3)
		{
			while (world.getBlock(x, y, z - 1 - posX) == block)
				posX++;
			
			while (world.getBlock(x, y + 1 + posY, z) == block)
				posY++;
			
			masterX = z - posX;
			masterY = y + posY;
			
			if (world.getBlock(x, masterY, masterX) == block)
			{
				ConnectedStructureBlock master = (ConnectedStructureBlock) world.getBlock(x, masterY, masterX);
				
				int structureMaster = master.getStructureType(world, x, masterY, masterX, block);
				TextureMap order = submaps[structureMaster];
				int width = order.getWidth() - 1;
				int height = order.getHeight() - 1;
				if (posX <= width && posY <= height)
				{
					icons = submaps[structureMaster].getTextureMap();
					return icons[posX][posY];
				}
			}
			
		} else if (meta == 4)
		{
			while (world.getBlock(x, y, z + 1 + posX) == block)
				posX++;
			
			while (world.getBlock(x, y + 1 + posY, z) == block)
				posY++;
			
			masterX = z + posX;
			masterY = y + posY;
			
			if (world.getBlock(x, masterY, masterX) == block)
			{
				ConnectedStructureBlock master = (ConnectedStructureBlock) world.getBlock(x, masterY, masterX);
				
				int structureMaster = master.getStructureType(world, x, masterY, masterX, block);
				TextureMap order = submaps[structureMaster];
				int width = order.getWidth() - 1;
				int height = order.getHeight() - 1;
				if (posX <= width && posY <= height)
				{
					icons = submaps[structureMaster].getTextureMap();
					return icons[posX][posY];
				}
			}
			
		} else
		// Au SOL
		{
			while (world.getBlock(x - 1 - posX, y, z) == block)
				posX++;
			
			while (world.getBlock(x, y, z - 1 - posY) == block)
				posY++;
			
			masterX = x - posX;
			masterY = z - posY;
			if (world.getBlock(masterX, y, masterY) == block)
			{
				ConnectedStructureBlock master = (ConnectedStructureBlock) world.getBlock(masterX, y, masterY);
				int structureMaster = master.getStructureType(world, masterX, y, masterY, block);
				TextureMap order = submaps[structureMaster];
				int width = order.getWidth() - 1;
				int height = order.getHeight() - 1;
				
				if (posX <= width && posY <= height)
				{
					icons = submaps[structureMaster].getTextureMap();
					return icons[posX][posY];
				}
			}
		}
		icons = submaps[0].getTextureMap();
		return icons[0][0];
	}
	
	/**
	 * retourne l'icone de base
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		
		IIcon[][] icons = submaps[0].getTextureMap();
		
		return icons[0][0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return this.renderID;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return true;
	}
	
	public int getStructureType(IBlockAccess world, int x, int y, int z, Block block) {
		
		Block[][] context = null;
		int success = 0;
		int requiredsuccess = 0;
		int meta = world.getBlockMetadata(x, y, z);
		for (int k = 0; k < submaps.length; k++)
		{
			success = 0;
			requiredsuccess = this.submaps[k].getRequiredSuccess();
			context = new Block[submaps[k].getWidth()][submaps[k].getHeight()];
			
			for (int l = 0; l < context.length; l++)
			{
				for (int h = 0; h < context[l].length; h++)
				{
					switch (meta)
					{
					case 1:
						context[l][h] = world.getBlock(x - l, y - h, z);
						
						break;
					case 2:
						context[l][h] = world.getBlock(x + l, y - h, z);
						break;
					case 3:
						context[l][h] = world.getBlock(x, y - h, z + l);
						break;
					case 4:
						context[l][h] = world.getBlock(x, y - h, z - l);
						break;
					default:
						context[l][h] = world.getBlock(x + l, y, z + h);
						break;
					}
					
				}
			}
			
			Block[][] ref = submaps[k].getSchematic(block);
			for (int l = 0; l < context.length; l++)
			{
				for (int h = 0; h < context[l].length; h++)
				{
					if (context[l][h] == ref[l][h])
					{
						success++;
						
					}
				}
			}
			if (success >= requiredsuccess)
			{
				this.structure = k;
			}
		}
		return this.structure;
	}
}
