package init.block;

import java.util.Random;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDirectionLog extends HBlock {

	public String name;

	private IIcon top;
	private IIcon side;
	private IIcon side2;
	private IIcon top2;

	private int var1;

	public BlockDirectionLog(String name) {
		super(name);
		this.name = name;
		this.setCreativeTab(Heimnor.HeimnorBlockTabs);
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {

		this.var1 = this.getRandomIcon();
		if (var1 == 0) {
			if (side == 1 || side == 0) {
				return 1;
			} else if (side == 4 || side == 5) {
				return 2;
			} else if (side == 3 || side == 2) {
				return 3;
			}
			return 0;
		} else {
			if (side == 1 || side == 0) {
				return 5;
			} else if (side == 4 || side == 5) {
				return 6;
			} else if (side == 3 || side == 2) {
				return 7;
			}
			return 4;
		}

	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata) {

		if ((side == 1 && metadata == 1) || (side == 0 && metadata == 1))
			return this.top;
		if ((side == 5 && metadata == 2) || (side == 4 && metadata == 2))
			return this.top;
		if ((side == 2 && metadata == 3) || (side == 3 && metadata == 3))
			return this.top;
		if ((side == 1 && metadata == 5) || (side == 0 && metadata == 5))
			return this.top2;
		if ((side == 5 && metadata == 6) || (side == 4 && metadata == 6))
			return this.top2;
		if ((side == 2 && metadata == 7) || (side == 3 && metadata == 7))
			return this.top2;

		if (metadata <=3)
			return this.side;
		else
			return this.side2;
	}

	public int getRandomIcon() {

		Random rand = new Random();
		int result;
		result = rand.nextInt(99);

		if (result <= 74)
			return 0;
		else
			return 1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iIconRegister) {
		this.side = iIconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/1");
		this.side2 = iIconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/2");
		this.top = iIconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/3");
		this.top2 = iIconRegister.registerIcon(Heimnor.MODID + ":" + this.name + "/4");
	}
}
