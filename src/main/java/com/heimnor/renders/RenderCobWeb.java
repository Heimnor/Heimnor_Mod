package com.heimnor.renders;

import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import init.block.CTBlockUpDown;
import init.block.BlockReactUpDown;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderCobWeb implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		if (block instanceof BlockReactUpDown)
		{
			BlockReactUpDown blockH = (BlockReactUpDown) block;
			Tessellator tessellator = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			
			tessellator.addVertexWithUV(x + 1, y, z, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			tessellator.addVertexWithUV(x + 1, y + 1, z, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x, y + 1, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x, y, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			
			tessellator.addVertexWithUV(x, y, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			tessellator.addVertexWithUV(x, y + 1, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x + 1, y + 1, z, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x + 1, y, z, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			
			tessellator.addVertexWithUV(x + 1, y, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			tessellator.addVertexWithUV(x + 1, y + 1, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x, y + 1, z, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x, y, z, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			
			tessellator.addVertexWithUV(x, y, z, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
			tessellator.addVertexWithUV(x, y + 1, z, (double) blockH.getIcon(meta, world, x, y, z).getMaxU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x + 1, y + 1, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMinV());
			tessellator.addVertexWithUV(x + 1, y, z + 1, (double) blockH.getIcon(meta, world, x, y, z).getMinU(),
					(double) blockH.getIcon(meta, world, x, y, z).getMaxV());
		}
		return false;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}
	
	@Override
	public int getRenderId() {
		return ClientProxy.renderCobWeb;
	}
	
}
