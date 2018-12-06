package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CurtainBlock extends HBlock {
	
	private boolean collision;
	private IIcon[] icon;
	private int nbrTexture;
	private boolean random;
	
	public CurtainBlock(String name, boolean collision, int nbrTexture, boolean random) {
		super(name);
		this.collision = collision;
		this.nbrTexture = nbrTexture;
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		this.random = random;
		this.icon = new IIcon[this.nbrTexture];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.nbrTexture; i++)
		{
			this.icon[i] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + i);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		
		if (!world.isRemote && this.random)
		{
			int meta = BlocksUtils.getRandomInt(nbrTexture);
			world.setBlockMetadataWithNotify(x, y, z, meta, 1);
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
		return this.icon[0];
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int meta, IBlockAccess world, int x, int y, int z, Block block) {
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (metadata < icon.length)
			return icon[meta];
		else
			return icon[0];
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		
		float[] f = BlocksUtils.boundingBoxFence(block, x, y, z);
		this.setBlockBounds(f[0], 0.0F, f[1], f[2], 1.0F, f[3]);
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
}
