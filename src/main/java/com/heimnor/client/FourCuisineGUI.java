package com.heimnor.client;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.container.ContainerFour;
import com.heimnor.tileentity.TileEntityFourCuisine;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class FourCuisineGUI extends GuiContainer{
	
	private static final ResourceLocation textures = new ResourceLocation(Heimnor.MODID + ":textures/gui/fourcontainer.png");
	
	private TileEntityFourCuisine tile;
	private IInventory inventory;

	public FourCuisineGUI(TileEntityFourCuisine tile, InventoryPlayer inventory) {
		
		 super(new ContainerFour(tile, inventory));
		 this.tile = tile;
		 this.inventory = inventory;
		 this.allowUserInput = false;
		 this.ySize = 250;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialRenderTick, int x, int y) {
		
		this.mc.getTextureManager().bindTexture(textures);
		this.drawTexturedModalRect(this.width/2 - 90, this.height /2 - 80, 0, 0, 250, 512);
		
	}
	
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		
		
	}

}
