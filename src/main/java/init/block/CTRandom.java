package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class CTRandom extends CTBlockUpDown {
	
	private int renderID;
	private String name;
	private String[] meta;
	public IIcon[][] icon;
	public IIcon side;
	
	private int[] length;
	
	public CTRandom(String name, String[] meta, int[] length, boolean normal, int renderID) {
		super(name, meta, length, normal);
		
		this.name = name;
		this.setBlockName(name);
		this.meta = meta;
		this.length = length;
		this.renderID = renderID;
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		
		this.icon = new IIcon[4][16];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.meta.length; i++)
		{
			// + 1 pour l'icône de base
			for (int k = 0; k < this.length[i]; k++)
			{
				
				this.icon[i][k] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] + k);
			}
		}
		
		this.side = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/side");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, IBlockAccess world, int x, int y, int z, Block block) {
		
		boolean connectedUp = HDirection.TOP.canConnect(world, x, y, z, block, false);
		boolean connectedDown = HDirection.BOTTOM.canConnect(world, x, y, z, block, false);
		
		int max = this.length[metadata];
		int pos;
		
		if (connectedUp && connectedDown)
			pos = 2;
		else if (connectedUp && !connectedDown)
			pos = 1;
		else if (!connectedUp && connectedDown)
			pos = 3;
		else
			pos = 0;
		return icon[pos][BlocksUtils.getRandomInt(max)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, int side) {
		return icon[0][0];
	}
	
	public IIcon getSideIcon() {
		return this.side;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return this.renderID;
	}
	
}
