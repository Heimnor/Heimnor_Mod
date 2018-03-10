package com.heimnor.common;

import com.heimnor.client.FichesGui;
import com.heimnor.client.FourCuisineGUI;
import com.heimnor.client.GuiListCS;
import com.heimnor.container.ContainerFour;
import com.heimnor.tileentity.TileEntityFourCuisine;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CSGuiHandler implements IGuiHandler {

	public static final int CHARACTER_SHEET_GUI = 0;
	public static final int CONTAINER_FOURCUISINE = 1;
	public static final int CHARACTER_SHEET_LIST = 2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile instanceof TileEntityFourCuisine)

		{

			return new ContainerFour((TileEntityFourCuisine) tile, player.inventory);

		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);

		if (ID == CHARACTER_SHEET_GUI)
			return new FichesGui();

		if (ID == CONTAINER_FOURCUISINE) {

			if (tile instanceof TileEntityFourCuisine) {
				return new FourCuisineGUI((TileEntityFourCuisine) tile, player.inventory);
			} else {
				return null;
			}
		}

		if (ID == CHARACTER_SHEET_LIST)
			return new GuiListCS();

		return null;
	}

}
