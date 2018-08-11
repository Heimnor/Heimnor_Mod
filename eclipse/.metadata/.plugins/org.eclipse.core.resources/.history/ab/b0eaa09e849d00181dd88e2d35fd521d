package init.block;

import java.util.List;
import java.util.Random;

import com.heimnor.common.Heimnor;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.tileentity.TileEntityFourCuisine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import init.foods.IngredientsHeimnor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import registry.BlockFoodRegistry;

public class BlockFourCuisine extends BlockContainer {

	public BlockFourCuisine(Material material) {
		super(material);
		this.setResistance(0.8F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {

		TileEntityFourCuisine tile = new TileEntityFourCuisine();

		return tile;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {
		TileEntityFourCuisine tile = (TileEntityFourCuisine) world.getTileEntity(x, y, z);
		if (player.getCurrentEquippedItem() != null) {
			if (player.getCurrentEquippedItem().getItem() == Items.flint) {
				
				tile.setTextureRock((tile.getTexture()) ? false : true);
				this.updateBlock(world, x, y, z);
				return true;

			} else if (player.getCurrentEquippedItem() != null && !tile.getTexture()
					&& (player.getCurrentEquippedItem().getItem() == BlockFoodRegistry.casserole
							|| player.getCurrentEquippedItem().getItem() == BlockFoodRegistry.poele )
					&& tile.getPlaqueContent() == null) {
				ItemStack currentItem = player.getCurrentEquippedItem().copy();
				currentItem.stackSize = 1;
				tile.setPlaqueContent(currentItem);
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
				this.updateBlock(world, x, y, z);
				return true;
			} else if (player.getCurrentEquippedItem().getItem() instanceof IngredientsHeimnor
					&& tile.getPlaqueContent() != null && tile.getUstensileContent() == null) {

				ItemStack currentStack = player.getCurrentEquippedItem().copy();
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
				currentStack.stackSize = 1;
				tile.setUstensileContent(currentStack.copy());
				this.updateBlock(world, x, y, z);
				return true;
			}
		} else if (player.isSneaking() && player.getCurrentEquippedItem() == null && tile.getPlaqueContent() != null) {
			if (tile.getUstensileContent() == null) {
				ItemStack stack = tile.getPlaqueContent();
				if (!world.isRemote) {
					EntityItem entItem = new EntityItem(world, x, y, z, stack);
					world.spawnEntityInWorld(entItem);
				}
				tile.setPlaqueContent(null);
				this.updateBlock(world, x, y, z);
				return true;
			} else if (tile.getUstensileContent() != null) {
				ItemStack stack = tile.getUstensileContent();
				if (!world.isRemote) {
					EntityItem entItem = new EntityItem(world, x, y, z, stack);
					world.spawnEntityInWorld(entItem);
				}
				tile.setUstensileContent(null);
				this.updateBlock(world, x, y, z);
				return true;
			}
		} else if (!world.isRemote) {

			player.openGui(Heimnor.instance, 1, world, x, y, z);
			return true;
		}

		return false;
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {

		TileEntity tileentity = world.getTileEntity(x, y, z);

		if (tileentity instanceof IInventory) {

			IInventory inv = (IInventory) tileentity;

			for (int i1 = 0; i1 < inv.getSizeInventory(); i1++) {
				ItemStack stack = inv.getStackInSlot(i1);
				if (stack != null) {

					float f = world.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; stack.stackSize > 0; world
							.spawnEntityInWorld(entityitem)) {

						int j1 = world.rand.nextInt(21) + 10;

						if (j1 > stack.stackSize) {
							j1 = stack.stackSize;
						}

						stack.stackSize -= j1;

						entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
								(double) ((float) z + f2), new ItemStack(stack.getItem(), j1, stack.getItemDamage()));

						float f3 = 0.05F;

						entityitem.motionX = (double) world.rand.nextGaussian() * f3;
						entityitem.motionY = (double) world.rand.nextGaussian() * f3 + 0.2F;
						entityitem.motionZ = (double) world.rand.nextGaussian() * f3;

						if (stack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
						}
					}
				}
			}

			world.func_147453_f(x, y, z, block);

		}

		super.breakBlock(world, x, y, z, block, metadata);

	}

	@Override
	public boolean isNormalCube() {
		return this.blockMaterial.isOpaque() && this.renderAsNormalBlock() && !this.canProvidePower();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack) {
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile instanceof TileEntityFourCuisine) {

			int direction = MathHelper.floor_double((double) (living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			System.out.println("direction : " + direction);
			((TileEntityFourCuisine) tile).setDirection((byte) direction);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {

		double d0 = (double) ((float) x + 0.5F);
		double d1 = (double) ((float) y + 0.7F);
		double d2 = (double) ((float) z + 0.5F);
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;
		TileEntityFourCuisine tile = (TileEntityFourCuisine) world.getTileEntity(x, y, z);
		if (tile.getFireParticle()) {
			int direction = ((TileEntityFourCuisine) world.getTileEntity(x, y, z)).getDirection();

			if (direction == 0) {
				world.spawnParticle("smoke", d0 - d4 + 0.25D, d1 + d3 - 0.25D, d2 + 0.5D, 0.0D, 0.0D, 0.0D);
			} else if (direction == 1) {
				world.spawnParticle("smoke", d0 - d4 - 0.25D, d1 + d3 - 0.25D, d2, 0.0D, 0.0D, 0.0D);
			} else if (direction == 2) {
				world.spawnParticle("smoke", d0 - d4 + 0.25D, d1 + d3 - 0.25D, d2 - 0.5D, 0.0D, 0.0D, 0.0D);
			} else if (direction == 3) {
				world.spawnParticle("smoke", d0 - d4 + 0.75D, d1 + d3 - 0.25D, d2, 0.0D, 0.0D, 0.0D);
			}
			world.spawnParticle("flame", d0 - d4 + 0.25D, d1 + d3 - 0.7D, d2, 0.0D, 0.0D, 0.0D);
		}
		if(tile.isUstensileContentBurning()) {
			
			world.spawnParticle("smoke", d0 - d4 +0.25D, y + 1D, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	private void updateBlock(World world, int x, int y, int z) {
		world.markBlockForUpdate(x, y, z);
		TileEntity tile = world.getTileEntity(x, y, z);
		tile.markDirty();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderType() {
		return ClientProxy.renderID;
	}

}
