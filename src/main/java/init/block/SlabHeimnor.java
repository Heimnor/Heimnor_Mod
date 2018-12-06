package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class SlabHeimnor extends HBlock {
	
	private IIcon icon;
	private String name;
	
	public SlabHeimnor(String name) {
		super(name);
		
		this.name = name;
		this.setBlockName(name);
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return ClientProxy.renderSlab;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		this.icon = iconRegister.registerIcon(Heimnor.MODID + ":slabs/" + this.name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, int side) {
		return this.icon;
	}
}
