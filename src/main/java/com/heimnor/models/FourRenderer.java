package com.heimnor.models;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityFourCuisine;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import registry.BlockFoodRegistry;

public class FourRenderer extends TileEntitySpecialRenderer {

	public static ModelFour model = new ModelFour();
	public static ModelCasserole modelCasserole = new ModelCasserole();
	public static ModelPoele modelPoele = new ModelPoele();

	public static ResourceLocation textureCasserole = new ResourceLocation(Heimnor.MODID,
			"textures/models/block/Casserole.png");
	public static ResourceLocation texturePoele = new ResourceLocation(Heimnor.MODID,
			"textures/models/block/Poele.png");
	public static ResourceLocation textureRock = new ResourceLocation(Heimnor.MODID,
			"textures/models/block/fourcuisinerock.png");

	public static ResourceLocation textureMetal = new ResourceLocation(Heimnor.MODID,
			"textures/models/block/fourcuisinemetal.png");

	public FourRenderer() {
		this.func_147497_a(TileEntityRendererDispatcher.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialRenderTick) {

		this.renderTileEntityFourAt((TileEntityFourCuisine) tile, x, y, z, partialRenderTick);
	}

	public void renderTileEntityFourAt(TileEntityFourCuisine tile, double x, double y, double z,
			float partialRenderTick) {

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y - 0.2491F, (float) z + 0.5F);

		GL11.glRotatef(90F * tile.getDirection(), 0.0F, 1.0F, 0.0F);
		if (tile.getDirection() == 0 || tile.getDirection() == 2) {
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		}
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		if (tile.getTexture()) {
			this.bindTexture(textureRock);
		} else if (tile.getTexture() == false) {
			this.bindTexture(textureMetal);
		}
		model.renderAll();
		GL11.glPopMatrix();
		if (tile.getPlaqueContent() != null)
			this.renderUstensileInBlock(tile, x, y, z, partialRenderTick,
					(tile.getPlaqueContent().getItem() == BlockFoodRegistry.casserole) ? 1 : 2);
		this.renderItemInBlock(tile, x, y, z, partialRenderTick);
	}

	public void renderItemInBlock(TileEntityFourCuisine tile, double x, double y, double z, float partialRenderTick) {
		for (int i = 0; i < tile.contents.length; i++) {
			GL11.glPushMatrix();
			ItemStack stack = tile.contents[i];
			if (stack != null) {
				EntityItem entItem = new EntityItem(null, 0, 0, 0, stack);
				entItem.hoverStart = 0.0F;
				RenderItem.renderInFrame = true;
				float f;
				if (i <= 2)
					f = (i / 10.0F) * 3;
				else
					f = (i / 10.0F) * 3;
				float j;
				float c;
				if (tile.getDirection() == 1 || tile.getDirection() == 3)
					GL11.glTranslatef(
							(float) x + 0.90F + ((tile.getDirection() == 1) ? -0.45F : 0.0F)
									+ (j = (i > 2) ? -0.35F : 0.0F),
							(float) y + 0.32F, (float) z + 0.2F + f + (c = (i > 2) ? -0.9F : 0.0F));
				else
					GL11.glTranslatef((float) x + 0.8F - f + (c = (i > 2) ? 0.90F : 0.0F), (float) y + 0.32F,
							(float) z + 0.9F + (j = (i > 2) ? -0.35F : 0.0F));
				GL11.glScalef(0.65F, 0.65F, 0.65F);

				GL11.glRotatef(90 * tile.getDirection(), 0.0F, -0.5F, 0.0F);
				if (tile.getDirection() == 2)
					GL11.glTranslatef(0.0F, 0.0F, 0.7F);
				GL11.glRotatef(180, 0, 1, 1);
				GL11.glRotatef(180, 1, 0, 0);

				RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
			}
			GL11.glPopMatrix();
		}

	}

	public void renderUstensileInBlock(TileEntityFourCuisine tile, double x, double y, double z,
			float partialRenderTick, int id) {
		if (id == 1) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.27F, (float) z + 0.5F);

			GL11.glRotatef(90F * tile.getDirection(), 0.0F, 1.0F, 0.0F);
			GL11.glEnable(GL11.GL_BLEND);
			if (tile.getDirection() == 0 || tile.getDirection() == 2) {
				GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			}
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			if (id == 1)
				this.bindTexture(this.textureCasserole);
			if (id == 1)
				modelCasserole.renderAll();
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		} else if (id == 2) {

			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.4F, (float) z + 0.5F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glRotatef(90F * tile.getDirection(), 0.0F, 1.0F, 0.0F);
			if (tile.getDirection() == 0 || tile.getDirection() == 2) {
				GL11.glRotatef(125F, 0.0F, 1.0F, 0.0F);
			}
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			this.bindTexture(texturePoele);
			modelPoele.renderAll();
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}

		if (tile.getUstensileContent() != null) {

			if (tile.getPlaqueContent().getItem() == BlockFoodRegistry.casserole) {
				GL11.glPushMatrix();
				ItemStack stack = tile.getUstensileContent();
				if (stack != null) {
					EntityItem entItem = new EntityItem(null, 0, 0, 0, stack);
					entItem.hoverStart = 0.0F;
					RenderItem.renderInFrame = true;
					switch(tile.getDirection())
					{
					case 0:
						GL11.glTranslatef((float) x + 0.5F, (float) y + 1.14F, (float) z + 0.17F);
						break;
					case 1:
						GL11.glTranslatef((float) x + 0.85F, (float) y + 1.14F, (float) z + 0.5F);
						break;
					case 2:
						GL11.glTranslatef((float) x + 0.5F, (float) y + 1.14F, (float) z + 0.83F);
						break;
					case 3:
						GL11.glTranslatef((float) x + 0.17F, (float) y + 1.14F, (float) z + 0.525F);
						break;
					}
					GL11.glScalef(0.65F, 0.65F, 0.65F);
					GL11.glRotatef(90 * tile.getDirection(), 0.0F, -0.5F, 0.0F);
					GL11.glTranslatef(0.0F, 0.0F, 0.7F);
					GL11.glRotatef(180, 0, 1, 1);
					GL11.glRotatef(180, 1, 0, 0);

					RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
					RenderItem.renderInFrame = false;
				}
				GL11.glPopMatrix();

			} else if (tile.getPlaqueContent().getItem() == BlockFoodRegistry.poele) {
				GL11.glPushMatrix();
				ItemStack stack = tile.getUstensileContent();
				if (stack != null) {
					EntityItem entItem = new EntityItem(null, 0, 0, 0, stack);
					entItem.hoverStart = 0.0F;
					RenderItem.renderInFrame = true;
					switch(tile.getDirection())
					{
					case 0:
						GL11.glTranslatef((float) x + 0.5F, (float) y + 1.04F, (float) z + 0.17F);
						break;
					case 1:
						GL11.glTranslatef((float) x + 0.85F, (float) y + 1.04F, (float) z + 0.5F);
						break;
					case 2:
						GL11.glTranslatef((float) x + 0.5F, (float) y + 1.04F, (float) z + 0.83F);
						break;
					case 3:
						GL11.glTranslatef((float) x + 0.17F, (float) y + 1.04F, (float) z + 0.525F);
						break;
					}
					
					GL11.glScalef(0.65F, 0.65F, 0.65F);
					GL11.glRotatef(90 * tile.getDirection(), 0.0F, -0.5F, 0.0F);
					GL11.glTranslatef(0.0F, 0.0F, 0.7F);
					GL11.glRotatef(180, 0, 1, 1);
					GL11.glRotatef(180, 1, 0, 0);

					RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
					RenderItem.renderInFrame = false;
				}
				GL11.glPopMatrix();

			}
		}
	}
}
