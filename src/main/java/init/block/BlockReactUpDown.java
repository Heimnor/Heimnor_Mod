package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * 
 * Block qui se connectent a la verticale
 * 
 * @author Joe 3 déc. 2018
 *
 */
public class BlockReactUpDown extends HBlock {
	
	private String name;
	private int renderID;
	private int textPerMeta;
	
	private IIcon[][] icon;
	private String[] meta;
	
	public BlockReactUpDown(String name, int renderID, String[] meta, int textPerMeta) {
		super(name);
		this.name = name;
		this.renderID = renderID;
		this.meta = meta;
		this.textPerMeta = textPerMeta;
		this.icon = new IIcon[meta.length][textPerMeta];
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.meta.length; i++)
		{
			for (int k = 0; k < this.textPerMeta; k++)
			{
				this.icon[i][k] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] + k);
			}
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, IBlockAccess world, int x, int y, int z) {
		
		boolean connectedTop = HDirection.TOP.canConnect(world, x, y, z, this, true);
		boolean connectedDown = HDirection.BOTTOM.canConnect(world, x, y, z, this, true);
		
		if (metadata < this.meta.length)
		{
			if (connectedDown && connectedTop)
				return this.icon[metadata][2];
			if (!connectedDown && !connectedTop)
				return this.icon[metadata][0];
			
			if (connectedDown)
			{
				return this.icon[metadata][1];
			}
			if (connectedTop)
				return this.icon[metadata][3];
			else
				return this.icon[metadata][0];
			
		} else
			return this.icon[0][0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		
		return this.icon[0][0];
	}
	
	@Override
	public int getRenderType() {

		return this.renderID;
	}
}
