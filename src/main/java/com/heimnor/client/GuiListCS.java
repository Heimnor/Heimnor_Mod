package com.heimnor.client;

import java.io.File;
import java.util.ArrayList;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.utils.NbtCsFile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;

public class GuiListCS extends GuiScreen {

	private float currentScroll = 0;

	protected GuiScreen guiScreen;
	private boolean isScrolling;
	private GuiListCS.List listClass;
	private GuiScrollFile scroll;
	private boolean wasClicking;
	private ArrayList listfiches;
	private boolean mouseClicked;
	private GuiButton importButton;
	private GuiButton supprimerButton;
	private GuiButton confirmButton;
	private boolean smthgSelected;
	private boolean confirmDelete;
	private String nameSelected;
	public int idSlotSupress;
	private boolean imported = false;

	public GuiListCS() {

		this.allowUserInput = true;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.listClass.drawScreen(mouseX, mouseY, partialTicks);

		if (this.smthgSelected == true) {
			this.drawCenteredString(fontRendererObj, this.nameSelected, this.width / 2, this.height / 2 + 70, 0x01DF3A);
			this.importButton.enabled = true;
			this.supprimerButton.enabled = true;
		}
		if (this.confirmDelete == true) {
			this.buttonList.add(
					new GuiButton(2, this.width / 2 + 70, this.height / 2 + 20, 100, 20, "Confirmer la suppression"));
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	public void initGui() {
		this.buttonList
				.add(importButton = new GuiButton(0, this.width / 2 - 60, this.height / 2 + 90, 60, 20, "Importer"));
		this.buttonList.add(
				this.supprimerButton = new GuiButton(1, this.width / 2, this.height / 2 + 90, 60, 20, "Supprimer"));
		this.buttonList.add(this.confirmButton = new GuiButton(2, this.width / 2 + 70, this.height / 2 - 115, 140, 20,
				"Confirmer la suppression"));
		this.listClass = new GuiListCS.List();
		this.listClass.registerScrollButtons(7, 8);
		this.importButton.enabled = false;
		this.supprimerButton.enabled = false;
		this.confirmButton.enabled = false;

		super.initGui();
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		super.keyTyped(par1, par2);
	}

	@Override
	public void updateScreen() {
		super.updateScreen();

	}

	@Override
	protected void mouseClicked(int x, int y, int btn) {
		super.mouseClicked(x, y, btn);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		NBTTagCompound index = NbtCsFile.getData(new File("Heimnor/Joueurs.dat")).getCompoundTag("index");
		NBTTagCompound nbtJoueur = index.getCompoundTag(this.mc.thePlayer.getDisplayName());

		NBTTagCompound indexf = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index");
		if (button.id == 0) {

			nbtJoueur.setString("perso", this.nameSelected);
			index.setTag(this.mc.thePlayer.getDisplayName(), nbtJoueur);
			Heimnor.network.sendToServer(new IMessageCSSync(index, "true", this.mc.thePlayer.getDisplayName(), "true"));
			this.mc.displayGuiScreen(null);
			this.mc.displayGuiScreen(new FichesGui());
		}
		if (button.id == 1) {
			this.confirmButton.enabled = true;

		}

		if (button.id == 2) {

			NBTTagList tagList = indexf.getTagList("list", NBT.TAG_STRING);
			tagList.removeTag(this.idSlotSupress);
			indexf.removeTag(this.nameSelected);
			indexf.setTag("list", tagList);

			Heimnor.network.sendToServer(new IMessageCSSync(indexf, "false", this.nameSelected, "delete"));
			this.initGui();
			this.mc.displayGuiScreen(new FichesGui());

		}

		super.actionPerformed(button);
	}

	class List extends GuiSlot {

		public ArrayList list = new ArrayList<String>();
		public int idSlotSupress;

		public List() {
			super(Minecraft.getMinecraft(), GuiListCS.this.width, GuiListCS.this.height, 32,
					GuiListCS.this.height - 65 + 4, 20);
			NBTTagCompound index = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index");
			NBTTagList list = (NBTTagList) index.getTag("list");

			for (int i = 0; i <= list.tagCount(); i++) {

				this.list.add(list.getStringTagAt(i));
				if (this.list.contains("") || this.list.contains(" ")) {
					this.list.remove("");
					this.list.remove(" ");
				}
			}

		}

		@Override
		protected int getSize() {

			return this.list.size();
		}

		@Override
		protected void elementClicked(int idSlot, boolean flag, int mouseX, int mouseY) {

			GuiListCS.this.nameSelected = (String) this.list.get(idSlot);
			GuiListCS.this.smthgSelected = true;
			GuiListCS.this.idSlotSupress = idSlot;
		}

		@Override
		protected boolean isSelected(int p_148131_1_) {
			return false;
		}

		@Override
		protected void drawBackground() {

			GuiListCS.this.drawDefaultBackground();

		}

		@Override
		protected void drawSlot(int idSlot, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator tess,
				int p_148126_6_, int p_148126_7_) {

			GuiListCS.this.drawCenteredString(fontRendererObj, (String) this.list.get(idSlot), this.width / 2,
					p_148126_3_ + 1, 0xFFFFFF);

		}

	}
}
