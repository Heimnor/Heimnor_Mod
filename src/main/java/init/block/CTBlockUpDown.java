package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Override la méthode getRenderType()
 * 
 * @author Joe
 *
 */
public class CTBlockUpDown extends HBlock {
	
	private boolean normal;
	private String name;
	private String[] meta;
	public IIcon[][] icon;
	
	private int[] length;
	
	public CTBlockUpDown(String name, String[] meta, int[] length, boolean normal) {
		super(name);
		
		this.setResistance(0.5F);
		this.setBlockName(meta[0]);
		this.normal = normal;
		this.name = name;
		this.length = length;
		this.meta = meta;
		
		this.icon = new IIcon[meta.length][4];
	}
	
	public boolean renderAsNormalBlock() {
		return this.normal;
	}
	
	public boolean isOpaqueCube() {
		return this.normal;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.meta.length; i++)
		{
			// + 1 pour l'icône de base
			if (this.length[i] != 1)
			{
				for (int k = 0; k < this.length[i] + 1; k++)
				{
					this.icon[i][k] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] + k);
				}
			} else
			{
				this.icon[i][0] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] + 0);
			}
			
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, IBlockAccess world, int x, int y, int z, Block block) {
		
		boolean connectedUp = HDirection.TOP.canConnect(world, x, y, z, block, false);
		boolean connectedDown = HDirection.BOTTOM.canConnect(world, x, y, z, block, false);
		
		if (metadata < this.meta.length)
		{
			if (length[metadata] == 3)
			{
				if (connectedUp && connectedDown)
					return icon[metadata][2];
				else if (connectedUp && !connectedDown)
					return icon[metadata][1];
				else if (!connectedUp && connectedDown)
					return icon[metadata][3];
				else
					return icon[metadata][0];
			} else if (length[metadata] == 2)
			{
				if (connectedUp)
					return icon[metadata][2];
				else if (connectedDown)
					return icon[metadata][1];
				else
					return icon[metadata][0];
			} else if (length[metadata] == 1)
				return icon[metadata][0];
			else
				return this.icon[metadata][0];
		} else
			return this.icon[0][0];
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, int side) {
		return icon[0][0];
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return true;
	}
}
