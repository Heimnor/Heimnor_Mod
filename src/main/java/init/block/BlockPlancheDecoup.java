package init.block;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.EnumSound;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.tileentity.TileEntityPlancheDecoup;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import init.foods.CouteauCuisineHeimnor;
import init.foods.IngredientsHeimnor;
import init.foods.ItemsFoodHeimnor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import registry.RecipesPlancheDecoup;

public class BlockPlancheDecoup extends Block {

	public BlockPlancheDecoup(Material material) {
		super(material);
		this.setResistance(0.8F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.06F, 1F);
	}

	@Override
	public TileEntity createTileEntity(World world, int p_149915_2_) {

		TileEntityPlancheDecoup tile = new TileEntityPlancheDecoup();
		return tile;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {

		TileEntityPlancheDecoup tile = (TileEntityPlancheDecoup) world.getTileEntity(x, y, z);
		if (player.getCurrentEquippedItem() != null) {

			if (player.getCurrentEquippedItem().getItem() instanceof ItemsFoodHeimnor
					|| player.getCurrentEquippedItem().getItem() instanceof IngredientsHeimnor) {

				// Add la bouffe
				ItemStack stack = player.getCurrentEquippedItem();
				ItemStack stackCop = stack.copy();
				stackCop.stackSize = 1;
				tile.setContent(stackCop);
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
				this.updateBlock(world, x, y, z);
				return true;
			} else if (tile.getContent() != null && player.getCurrentEquippedItem() != null
					&& player.getCurrentEquippedItem().getItem() instanceof CouteauCuisineHeimnor) {
				//crée la recette
				if (RecipesPlancheDecoup.cuttingBase.getResult(tile.getContent()) != null) {
					ItemStack ustensile = player.getCurrentEquippedItem();
					ustensile.setItemDamage(ustensile.getItemDamage() - 1);
					player.inventory.getCurrentItem().damageItem(1, player);
					
					ItemStack result = RecipesPlancheDecoup.cuttingBase.getResult(tile.getContent());
					tile.setContent(result.copy());
					world.playSoundAtEntity(player, EnumSound.CUTTINGVEG.toString(), 0.5F, 0.5F);
					this.updateBlock(world, x, y, z);
					return true;
				}
			}else if (tile.getContent() == null && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof CouteauCuisineHeimnor) {
				ItemStack stack = player.getCurrentEquippedItem();
				ItemStack stack1 = stack.copy();
				stack1.stackSize = 1;
				tile.setUstensile(stack1);
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
				this.updateBlock(world, x, y, z);
			}
		} else if (player.getCurrentEquippedItem() == null && player.isSneaking()) {
			// Drop la bouffe
			if (tile.getContent() != null && tile.getUstensile() == null) {

				ItemStack stack = tile.getContent();
				if (!world.isRemote) {
					EntityItem entItem = new EntityItem(world, x, y, z, stack);
					world.spawnEntityInWorld(entItem);
					this.updateBlock(world, x, y, z);
				}
				
				tile.setContent(null);
				return true;
			} else if (tile.getUstensile() != null) {
				// Recup l'ustensile
				ItemStack stack = tile.getUstensile();
				if (!world.isRemote) {
					EntityItem entItem = new EntityItem(world, x, y, z, stack);
					world.spawnEntityInWorld(entItem);
				}
				tile.setUstensile(null);
				this.updateBlock(world, x, y, z);
				return true;
			}
		}
		return false;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)

	{
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile instanceof TileEntityPlancheDecoup) {

			int direction = MathHelper.floor_double((double) (living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			System.out.println("direction" + direction);
			((TileEntityPlancheDecoup) tile).setDirection((byte) direction);
		}
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

	private void updateBlock(World world, int x, int y, int z) {
		world.markBlockForUpdate(x, y, z);
		TileEntity tile = world.getTileEntity(x, y, z);
		tile.markDirty();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.renderID;
	}

}
