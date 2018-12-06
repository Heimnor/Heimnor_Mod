package init.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class HBlock extends Block{

	public String name;
	
	public HBlock(String name) {
		
		super(Material.rock);
		this.setBlockName(name);
		this.name = name;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int meta, IBlockAccess world, int x, int y, int z, Block block) {
		return this.blockIcon;
	}
}
