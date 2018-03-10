package com.heimnor.client;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import com.heimnor.utils.NbtCsFile;

import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class GuiScrollFile extends GuiScrollingList {

	private GuiScreen parent;
	private ArrayList list = new ArrayList();

	public GuiScrollFile(int width, int height, int top, int left, int entryHeight, GuiScreen parent) {
		super(Minecraft.getMinecraft(), width, height, top, top + height, left, entryHeight);

		
					
				}
	

	

	@Override
	protected int getSize() {

		return list.size();
	}

	@Override
	protected void drawBackground() {

	}

	@Override
	protected void elementClicked(int index, boolean doubleClick) {

	}

	@Override
	protected boolean isSelected(int index) {

		return false;
	}

	@Override
	protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {

		File indexf = new File("Heimnor/index.dat");
		
		
		
		FontRenderer font = Minecraft.getMinecraft().fontRenderer;
		
		
	}
	
	
}
