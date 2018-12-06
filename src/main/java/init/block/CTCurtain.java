package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * 
 * @author Joe 25 nov. 2018
 *
 */

public class CTCurtain extends CTBlockUpDown {
	
	private boolean alternative = false;
	private boolean aleatoire;
	private String name;
	private String[] meta;
	private boolean collision;
	
	public CTCurtain(String name, String[] meta, int[] height, boolean normal, boolean aleatoire, boolean collision) {
		super(name, meta, height, normal);
		this.aleatoire = aleatoire;
		this.name = name;
		this.meta = meta;
		this.collision = collision;
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		
		if (!world.isRemote && aleatoire)
		{
			this.alternative = BlocksUtils.getRandomBool(60);
			if (this.alternative)
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 1);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return ClientProxy.renderCurtain;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		
		if (this.collision)
			return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
		else
			return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int metadata, int side) {
		return super.icon[0][0];
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		
		float[] f = BlocksUtils.boundingBoxFence(block, x, y, z);
		this.setBlockBounds(f[0], 0.0F, f[1], f[2], 1.0F, f[3]);
	}
}
