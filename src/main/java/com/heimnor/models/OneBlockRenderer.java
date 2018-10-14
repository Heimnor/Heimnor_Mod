package com.heimnor.models;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityDirection;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import registry.BlocksDecoRegistry;

public class OneBlockRenderer extends TileEntitySpecialRenderer {

	public static TESRBlocksModels render;

	public OneBlockRenderer() {

		this.func_147497_a(TileEntityRendererDispatcher.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTick) {
		this.renderTileEntityDirectionAt((TileEntityDirection) tile, x, y, z, partialTick);
	}

	public void renderTileEntityDirectionAt(TileEntityDirection tile, double x, double y, double z, float partialTick) {

		int render = this.prepareSources(tile.getBlockType());
		ModelBaseH model = this.render.getModel();
		ResourceLocation location = this.render.getResource();

		GL11.glPushMatrix();

		if (render == 0)
			GL11.glTranslatef((float) x + 0.5F, (float) y - 0.15F, (float) z + 0.5F);
		if (render == 1)
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.1F, (float) z + 0.5F);
		if (render == 2)
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.70F, (float) z + 0.5F);

		GL11.glRotatef(90F * tile.getDirection(), 0.0F, 1.0F, 0.0F);
		if (tile.getDirection() == 0 || tile.getDirection() == 2) {
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		}
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

		GL11.glScalef(0.5F, 0.5F, 0.5F);

		this.bindTexture(location);
		if (model != null) {
			model.renderAll();
		}

		GL11.glPopMatrix();

	}

	public int prepareSources(Block block) {

		if (block == BlocksDecoRegistry.pain) {
			this.render = this.render.PAIN;
			return 0;
		} else if (block == BlocksDecoRegistry.balais) {
			this.render = this.render.BALAIS;
			return 1;
		} else if (block == BlocksDecoRegistry.miroir) {
			this.render = this.render.MIROIR;
			return 2;
		}
		return 0;
	}

	public enum TESRBlocksModels {

		PAIN(new ModelPain(), "pain"), BALAIS(new ModelBalais(), "balais"), MIROIR(new ModelMiroir(), "miroir");

		public String name;
		public ModelBaseH model;

		TESRBlocksModels(ModelBaseH model, String string) {
			this.model = model;
			this.name = string;
		}

		public ModelBaseH getModel() {
			return this.model;
		}

		public ResourceLocation getResource() {

			return new ResourceLocation(Heimnor.MODID, "textures/models/block/" + this.name + ".png");
		}
	}
}