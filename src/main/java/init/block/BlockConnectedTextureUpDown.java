package init.block;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Override la méthode getRenderType()
 * 
 * @author Joe
 *
 */
public class BlockConnectedTextureUpDown extends Block {

	public boolean normal;
	public String name;
	public static String[] meta;
	public IIcon[][] icon;
	public IIcon test;


	public BlockConnectedTextureUpDown(Material material, String name, String[] meta, boolean normal) {
		super(material);

		this.setResistance(0.5F);
		this.setBlockName(name);
		this.normal = normal;
		this.name = name;
		

		this.meta = new String[meta.length];

		for (int i = 0; i < meta.length; i++) {
			this.meta[i] = meta[i];
		}
		this.icon = new IIcon[16][4];
	}

	public boolean renderAsNormalBlock() {
		return this.normal;
	}

	public boolean isOpaqueCube() {
		return this.normal;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {

		for (int i = 0; i < this.meta.length; i++) {
			for (int k = 0; k < 4; k++) {

				this.icon[i][k] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + this.meta[i] + k);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata, boolean connectedTop, boolean connectedDown) {

		if (metadata < this.meta.length) {
			if (connectedDown && connectedTop)
				return this.icon[metadata][1];
			if (!connectedDown && !connectedTop)
				return this.icon[metadata][3];

			if (connectedDown) {
				return this.icon[metadata][0];
			}
			if (connectedTop)
				return this.icon[metadata][2];
			else
				return this.icon[metadata][0];
			
		}else
			return this.icon[0][0];
	}

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
