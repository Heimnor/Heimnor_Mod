package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class CTBlock extends HBlock {
	
	private String name;
	public String[] meta;
	private int renderID;
	private boolean normal;
	private int nbrTexture;
	
	public IIcon[][] icon;
	
	public CTBlock(String name, String[] meta, int nbrTexture, int renderID, boolean normal) {
		super(name);
		this.name = name;
		this.meta = meta;
		this.renderID = renderID;
		this.normal = normal;
		this.nbrTexture = nbrTexture;
		this.setCreativeTab(Heimnor.HeimnorBlockTabs);
		this.icon = new IIcon[meta.length][nbrTexture];
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
			for (int k = 0; k < this.nbrTexture; k++)
			{
				
				this.icon[i][k] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] + k);
				
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, IBlockAccess world, int x, int y, int z, Block block) {
		
		boolean connectedUp = HDirection.TOP.canConnect(world, x, y, z, block, false);
		
		if (metadata < this.meta.length)
		{
			
		}
		return this.icon[0][0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, int side) {
		return icon[0][0];
	}
	
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return this.renderID;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return true;
	}
}
