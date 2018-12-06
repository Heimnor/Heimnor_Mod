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

public class FloorBlock extends HBlock {
	
	private boolean collision;
	private IIcon[] icon;
	private int nbrTexture;
	private IIcon sideIcon;
	private boolean side;
	
	public FloorBlock(String name, boolean collision, int nbrTexture, boolean side) {
		super(name);
		this.collision = collision;
		this.nbrTexture = nbrTexture;
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
		
		this.side = side;
		this.icon = new IIcon[this.nbrTexture];
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < this.nbrTexture; i++)
		{
			this.icon[i] = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/" + i);
		}
		
		if (side)
			this.sideIcon = iconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/side");
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		
		if (!world.isRemote)
		{
			int meta = BlocksUtils.getRandomInt(nbrTexture);
			world.setBlockMetadataWithNotify(x, y, z, meta, 1);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		
		return ClientProxy.renderFloor;
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
	
	public boolean hasSide() {
		return this.side;
	}
	
	public IIcon getSideIcon() {
		return this.sideIcon;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
}
