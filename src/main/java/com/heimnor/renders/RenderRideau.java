package com.heimnor.renders;

import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import init.block.CTBlockUpDown;
import init.block.HBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderRideau implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		if (block instanceof HBlock)
		{
			HBlock blockCloth = (HBlock) block;
			Tessellator tessellator = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			
			if (BlocksUtils.isNormalBlockAround(world, x, y, z) || BlocksUtils.isSameBlockAround(world, blockCloth, x, y, z))
			{
				
				float north1 = 0.51F;
				float south1 = 0.49F;
				float east1 = 0.51F;
				float west1 = 0.49F;
				
				float north2 = 0.51F;
				float south2 = 0.49F;
				float east2 = 0.51F;
				float west2 = 0.49F;
				
				if (BlocksUtils.shouldConnectTexture(world, x, y, z, blockCloth, true, BlocksUtils.NORTH))
				{
					south2 = 0.0F;
				}
				
				if (BlocksUtils.shouldConnectTexture(world, x, y, z, blockCloth, true, BlocksUtils.SOUTH))
				{
					north2 = 1.0F;
					
				}
				
				if (BlocksUtils.shouldConnectTexture(world, x, y, z, blockCloth, true, BlocksUtils.EAST))
				{
					east1 = 1.0F;
					
				}
				
				if (BlocksUtils.shouldConnectTexture(world, x, y, z, blockCloth, true, BlocksUtils.WEST))
				{
					west1 = 0.0F;
					
				}
				
				renderer.setRenderBounds(west1, 0.0F, south1, east1, 1.0F, north1);
				renderer.flipTexture = true;
				renderer.renderFaceZNeg(block, x, y, z, blockCloth.getIcon(meta, world, x, y, z, block));
				renderer.flipTexture = false;
				renderer.renderFaceZPos(block, x, y, z, blockCloth.getIcon(meta, world, x, y, z, block));
				
				renderer.setRenderBounds(west2, 0.0F, south2, east2, 1.0F, north2);
				renderer.renderFaceXNeg(block, x, y, z, blockCloth.getIcon(meta, world, x, y, z, block));
				renderer.flipTexture = true;
				renderer.renderFaceXPos(block, x, y, z, blockCloth.getIcon(meta, world, x, y, z, block));
				renderer.flipTexture = true;
				/*
				 * tessellator.addVertexWithUV(x, y, z+ north2, (double)
				 * blockCloth.getIcon(meta, world, x, y, z, block).getMaxU(), (double)
				 * blockCloth.getIcon(meta, world, x, y, z, block).getMaxV());
				 * tessellator.addVertexWithUV(x, y + 1, z + north2, (double)
				 * blockCloth.getIcon(meta, world, x, y, z, block).getMaxU(), (double)
				 * blockCloth.getIcon(meta, world, x, y, z, block).getMinV());
				 * tessellator.addVertexWithUV(x, y + 1, z, (double) blockCloth.getIcon(meta,
				 * world, x, y, z, block).getMinU(), (double) blockCloth.getIcon(meta, world, x,
				 * y, z, block).getMinV()); tessellator.addVertexWithUV(x , y, z, (double)
				 * blockCloth.getIcon(meta, world, x, y, z, block).getMinU(), (double)
				 * blockCloth.getIcon(meta, world, x, y, z, block).getMaxV());
				 */
				
			} else
			{
				
				this.neutralPos(world, x, y, z, blockCloth, modelId, renderer, meta);
			}
		}
		
		return false;
	}
	
	public void neutralPos(IBlockAccess world, int x, int y, int z, HBlock block, int modelId, RenderBlocks renderer, int meta) {
		
		renderer.setRenderBounds(0.0F, 0.0F, 0.49F, 1.0F, 1.0F, 0.51F);
		renderer.renderFaceZNeg(block, x, y, z, block.getIcon(meta, world, x, y, z, block));
		renderer.renderFaceZPos(block, x, y, z, block.getIcon(meta, world, x, y, z, block));
		
		renderer.setRenderBounds(0.51F, 0.0F, 0.0F, 0.49F, 1.0F, 1.0F);
		renderer.renderFaceXNeg(block, x, y, z, block.getIcon(meta, world, x, y, z, block));
		renderer.renderFaceXPos(block, x, y, z, block.getIcon(meta, world, x, y, z, block));
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		
		return false;
	}
	
	@Override
	public int getRenderId() {
		
		return ClientProxy.renderCurtain;
	}
	
}
