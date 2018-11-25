package com.heimnor.renders;

import org.lwjgl.opengl.GL11;

import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.BlocksUtils;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import init.block.BlockConnectedTextureUpDown;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderRideau implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

		if(block instanceof BlockConnectedTextureUpDown) {
			BlockConnectedTextureUpDown blockH = (BlockConnectedTextureUpDown)block;
		
		
		
		final Tessellator tess = Tessellator.instance;
		blockH.setBlockBoundsForItemRender();
		renderer.setRenderBoundsFromBlock(block);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0f);
		tess.startDrawingQuads();
		GL11.glTranslatef(-0.6F, -0.6F, 0.0F);
		GL11.glScalef(1.2F, 1.2F, 0.0F);
		tess.setNormal(1.0f, 1.0f, 1.0f);
		renderer.flipTexture = true;
		renderer.renderFaceZNeg(blockH, 0.0f, 0.0f, 0.0f, blockH.getIcon(0, 0, false, false));
		renderer.flipTexture = false;
		renderer.renderFaceZPos(blockH, 0.0f,0.0f, 0.0f, blockH.getIcon(0, 0, false, false));
		tess.draw();
		
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		if (block instanceof BlockConnectedTextureUpDown) {
			BlockConnectedTextureUpDown blockCloth = (BlockConnectedTextureUpDown) block;
			Tessellator tessellator = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

			if (BlocksUtils.isNormalBlockAround(world, x, y, z)
					|| BlocksUtils.isSameBlockAround(world, blockCloth, x, y, z)) {

				float north1 = 0.51F;
				float south1 = 0.49F;
				float east1 = 0.51F;
				float west1 = 0.49F;

				float north2 = 0.51F;
				float south2 = 0.49F;
				float east2 = 0.51F;
				float west2 = 0.49F;

				if (BlocksUtils.isNormalBlockBehind(world, x, y, z)
						|| BlocksUtils.isSameBlockBehind(world, blockCloth, x, y, z)) {
					south2 = 0.0F;
				}

				if (BlocksUtils.isNormalBlockFront(world, x, y, z)
						|| BlocksUtils.isSameBlockFront(world, blockCloth, x, y, z)) {
					north2 = 1.0F;

				}
				
				if (BlocksUtils.isNormalBlockRight(world, x, y, z)
						|| BlocksUtils.isSameBlockRight(world, blockCloth, x, y, z)) {
					east1 = 1.0F;
					
				}
				
				if (BlocksUtils.isNormalBlockLeft(world, x, y, z)
						|| BlocksUtils.isSameBlockLeft(world, blockCloth, x, y, z)) {
					west1 = 0.0F;
					
				}

				boolean down = BlocksUtils.isSameBlockDown(world, blockCloth, x, y, z);
				boolean up = BlocksUtils.isSameBlockUp(world, blockCloth, x, y, z);

				renderer.setRenderBounds(west1, 0.0F, south1, east1, 1.0F, north1);
				renderer.flipTexture = true;
				renderer.renderFaceZNeg(block, x, y, z, blockCloth.getIcon(0, meta, up, down));
				renderer.flipTexture = false;
				renderer.renderFaceZPos(block, x, y, z, blockCloth.getIcon(0, meta, up, down));

				renderer.setRenderBounds(west2, 0.0F, south2, east2, 1.0F, north2);
				renderer.renderFaceXNeg(block, x, y, z, blockCloth.getIcon(0, meta, up, down));
				renderer.flipTexture = true;
				renderer.renderFaceXPos(block, x, y, z, blockCloth.getIcon(0, meta, up, down));
				renderer.flipTexture = true;
				/*tessellator.addVertexWithUV(x, y, z+ north2, (double) blockCloth.getIcon(0, meta, up, down).getMaxU(),
						(double) blockCloth.getIcon(0, meta, up, down).getMaxV());
				tessellator.addVertexWithUV(x, y + 1, z + north2, (double) blockCloth.getIcon(0, meta, up, down).getMaxU(),
						(double) blockCloth.getIcon(0, meta, up, down).getMinV());
				tessellator.addVertexWithUV(x, y + 1, z, (double) blockCloth.getIcon(0, meta, up, down).getMinU(),
						(double) blockCloth.getIcon(0, meta, up, down).getMinV());
				tessellator.addVertexWithUV(x , y, z, (double) blockCloth.getIcon(0, meta, up, down).getMinU(),
						(double) blockCloth.getIcon(0, meta, up, down).getMaxV());*/
				
				
			} else {

				this.neutralPos(world, x, y, z, blockCloth, modelId, renderer, meta);
			}
		}

		return false;
	}

	public void neutralPos(IBlockAccess world, int x, int y, int z, BlockConnectedTextureUpDown block, int modelId,
			RenderBlocks renderer, int meta) {

		boolean down = BlocksUtils.isSameBlockDown(world, block, x, y, z);
		boolean up = BlocksUtils.isSameBlockUp(world, block, x, y, z);

		renderer.setRenderBounds(0.0F, 0.0F, 0.49F, 1.0F, 1.0F, 0.51F);
		renderer.renderFaceZNeg(block, x, y, z, block.getIcon(0, meta, up, down));
		renderer.renderFaceZPos(block, x, y, z, block.getIcon(0, meta, up, down));

		renderer.setRenderBounds(0.51F, 0.0F, 0.0F, 0.49F, 1.0F, 1.0F);
		renderer.renderFaceXNeg(block, x, y, z, block.getIcon(0, meta, up, down));
		renderer.renderFaceXPos(block, x, y, z, block.getIcon(0, meta, up, down));
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {

		return true;
	}

	@Override
	public int getRenderId() {

		return ClientProxy.renderBanniereId;
	}

}
