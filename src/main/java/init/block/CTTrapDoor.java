package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.HDirection;
import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CTTrapDoor extends BlockTrapDoor {
	
	private String name;
	private int nbrTexture;
	private IIcon[] icon;
	private IIcon side;
	private int typeOfConnection;
	
	public CTTrapDoor(String name, int nbrTexture, int typeOfConnection) {
		super(Material.rock);
		
		this.typeOfConnection = typeOfConnection;
		this.name = name;
		this.nbrTexture = nbrTexture;
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		this.icon = new IIcon[nbrTexture];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return ClientProxy.renderTrapDoor;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.nbrTexture; i++)
		{
			this.icon[i] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + i);
		}
		
		this.side = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/side");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, IBlockAccess world, int x, int y, int z, Block block) {
		
		boolean top = HDirection.TOP.canConnect(world, x, y, z, block, true);
		boolean down = HDirection.BOTTOM.canConnect(world, x, y, z, block, true);
		
		if (this.typeOfConnection == 0)
			return this.icon[0];
		
		else if (this.typeOfConnection == 1 && this.nbrTexture > 1)
		{
			if (top && down)
				return this.icon[2];
			else if (top && !down)
				return this.icon[1];
			else if (!top && down)
				return this.icon[3];
			else
				return this.icon[0];
		}
		
		else
			return this.icon[0];
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, int side) {
		return icon[0];
	}
	
	public IIcon getSideIcon() {
		return this.side;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {}
	
	@Override
	public boolean canPlaceBlockOnSide(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
		return true;
	}
}