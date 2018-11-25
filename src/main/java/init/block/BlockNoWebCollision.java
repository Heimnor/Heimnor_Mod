package init.block;

import com.heimnor.common.Heimnor;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNoWebCollision extends Block {

	public static String[] subBlock;
	public IIcon[] iconArray;

	public BlockNoWebCollision(Material material, String name, String[] nameArray) {
		super(material);
		this.setBlockTextureName(Heimnor.MODID + ":" + name);
		this.setBlockName(name);
		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		subBlock = new String[nameArray.length];
		
		for(int i =0 ; i < nameArray.length ; i++) {
			subBlock[i] = nameArray[i];
		}
		iconArray = new IIcon[subBlock.length];
	}

	@Override
	public int getRenderType() {

		return 1;
	}

	public void registerBlockIcons(IIconRegister iconRegister)
	    {
	        for(int i = 0; i < subBlock.length; i++)
	        {
	            this.iconArray[i] = iconRegister.registerIcon(Heimnor.MODID + ":cobweb/" + subBlock[i]);
	        }
	    }
	
	public IIcon getIcon(int side, int metadata)
    {
        if(metadata >= 0 && metadata < subBlock.length)
        {
            return this.iconArray[metadata];
        }
        return this.iconArray[0];
    }
	
	public int damageDropped(int metadata)
    {
        return metadata;
    }

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	// annuler la collision
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
}
