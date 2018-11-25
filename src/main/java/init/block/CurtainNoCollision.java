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

public class CurtainNoCollision extends BlockConnectedTextureUpDown {

	private boolean alternative = false;
	private boolean aleatoire;

	public CurtainNoCollision(Material material, String name, String[] meta, boolean normal, boolean aleatoire) {
		super(material, name, meta, normal);
		this.aleatoire = aleatoire;
		this.name = name;
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {

		if (!world.isRemote && aleatoire) {
			this.alternative = BlocksUtils.getRandomIcon(60);
			if (this.alternative)
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 1);
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {

		return ClientProxy.renderBanniereId;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {

		float f1 = 1.0F;
		float f2 = 1.0F;
		if (block.getBlock(x, y, z + 1).isNormalCube()) {
			f2 = 0.5F;
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, f2, f1, f2);
	}
}
