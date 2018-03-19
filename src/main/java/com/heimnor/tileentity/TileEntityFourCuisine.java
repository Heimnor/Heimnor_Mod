package com.heimnor.tileentity;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.models.FourRenderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import init.block.BlockFourCuisine;
import init.foods.IngredientsHeimnor;
import init.foods.ItemsFoodHeimnor;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import registry.RecipesFour;
import registry.RecipesPlaquesDeCuisson;

public class TileEntityFourCuisine extends TileEntity implements IInventory {

	private byte direction;
	private boolean rockText = true;
	private boolean fireParticle = false;
	private ItemStack plaqueContent = null;
	private ItemStack ustensileContent = null;
	public ItemStack[] contents = new ItemStack[6];
	private int cuisson[] = { 0, 0, 0, 0, 0, 0 };
	private int cuissonPlaque = 0;
	private int cuissonMax = 800;

	@Override
	public void readFromNBT(NBTTagCompound compound) {

		super.readFromNBT(compound);
		this.direction = compound.getByte("Direction");
		this.fireParticle = compound.getBoolean("isBurning");
		this.rockText = compound.getBoolean("isRock");
		NBTTagList list = compound.getTagList("Items", 10);
		this.contents = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound1 = list.getCompoundTagAt(i);

			this.contents[i] = ItemStack.loadItemStackFromNBT(compound1);
		}

		if (compound.hasKey("PlaqueContent")) {
			NBTTagCompound compoundUstensile = compound.getCompoundTag("PlaqueContent");
			this.plaqueContent = ItemStack.loadItemStackFromNBT(compoundUstensile);
			this.cuissonPlaque = compoundUstensile.getInteger("cuissonPlaque");
			if (compoundUstensile.hasKey("content")) {
				this.ustensileContent = ItemStack.loadItemStackFromNBT(compoundUstensile.getCompoundTag("content"));
			}
		}

		for (int i = 0; i <= 5; i++) {
			this.cuisson[i] = compound.getShort("cuisson" + i);
		}

		this.cuissonMax = compound.getShort("cuissonMax");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {

		super.writeToNBT(compound);
		compound.setByte("Direction", this.direction);

		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.contents.length; i++) {
			if (contents[i] != null) {
				NBTTagCompound compound1 = new NBTTagCompound();

				compound1.setByte("Slot", (byte) i);
				compound1.setBoolean("isBurning", this.fireParticle);

				this.contents[i].writeToNBT(compound1);
				list.appendTag(compound1);
			}
		}
		compound.setTag("Items", list);
		compound.setBoolean("isRock", this.rockText);
		if (this.plaqueContent != null) {
			NBTTagCompound compound1 = new NBTTagCompound();
			this.plaqueContent.writeToNBT(compound1);
			compound1.setInteger("cuissonPlaque", this.cuissonPlaque);
			if (this.ustensileContent != null) {
				NBTTagCompound compound2 = new NBTTagCompound();
				this.ustensileContent.writeToNBT(compound2);
				compound1.setTag("content", compound2);
			}
			compound.setTag("PlaqueContent", compound1);
		}

		for (int i = 0; i <= 5; i++) {
			compound.setShort("cuisson" + i, (short) this.cuisson[i]);
		}

		compound.setShort("cuissonMax", (short) this.cuissonMax);

	}

	public byte getDirection() {
		return direction;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {

		this.readFromNBT(pkt.func_148857_g());
		this.worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord,
				this.zCoord);
	}

	@Override
	public int getSizeInventory() {

		return this.contents.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex) {

		return this.contents[slotIndex];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount) {

		if (this.contents[slotIndex] != null) {
			ItemStack stack;

			if (this.contents[slotIndex].stackSize <= amount) {
				stack = this.contents[slotIndex];
				this.contents[slotIndex] = null;
				this.updateBlock();
				return stack;
			} else {

				stack = this.contents[slotIndex].splitStack(amount);
				if (this.contents[slotIndex].stackSize == 0) {
					this.contents[slotIndex] = null;
				}

				this.updateBlock();
				return stack;
			}
		} else {

			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {

		if (this.contents[slotIndex] != null) {

			ItemStack stack = this.contents[slotIndex];
			this.contents[slotIndex] = null;
			return stack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack stack) {

		this.contents[slotIndex] = stack;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
		this.updateBlock();

	}

	@Override
	public String getInventoryName() {

		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {

		return false;
	}

	@Override
	public int getInventoryStackLimit() {

		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {

		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false
				: player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
						(double) this.zCoord + 0.5D) <= 64.0D;

	}

	public void setTextureRock(boolean isRock) {
		this.rockText = isRock;
	}

	public boolean getTexture() {
		return this.rockText;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack stack) {

		if (stack.getItem() instanceof ItemsFoodHeimnor || stack.getItem() instanceof IngredientsHeimnor) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isUstensileContentBurning() {
		return this.cuissonPlaque > 0;
	}

	public boolean isBurning(int slot) {
		return this.cuisson[slot] > 0;
	}

	public boolean canSmelt(int slot) {

		if (contents[slot] == null) {

			return false;

		} else {
			ItemStack stack = RecipesFour.smelting().getSmeltingResult(this.contents[slot]);
			if (stack == null) {
				return false;
			}

			if (contents[slot].isItemEqual(stack)) {
				return false;
			}

			return true;
		}
	}

	public boolean canCook() {

		if (this.ustensileContent == null) {
			return false;
		} else {
			ItemStack stack = RecipesPlaquesDeCuisson.plaqueBase.getResult(this.ustensileContent, this.plaqueContent.getItem());
			if (stack == null) {
				return false;
			}

			if (this.ustensileContent.isItemEqual(stack)) {
				return false;
			}
		}
		return true;
	}

	public void smeltItem(int slot) {

		if (this.canSmelt(slot)) {
			if (contents[slot] != null && cuisson[slot] == this.cuissonMax) {
				ItemStack stack = RecipesFour.smelting().getSmeltingResult(this.contents[slot]);
				this.contents[slot] = stack.copy();
				this.cuisson[slot] = 0;
				--this.contents[slot].stackSize;
				if (this.contents[slot].stackSize <= 0)
					this.contents[slot] = null;
				this.setInventorySlotContents(slot, stack.copy());
			}
		}

	}

	public void cookItem() {
		if (this.canCook()) {
			if (this.ustensileContent != null && this.cuissonPlaque == this.cuissonMax) {
				ItemStack stack = RecipesPlaquesDeCuisson.plaqueBase.getResult(this.ustensileContent , this.plaqueContent.getItem());
				this.cuissonPlaque = 0;
				--this.ustensileContent.stackSize;
				if (this.ustensileContent.stackSize <= 0)
					this.ustensileContent = null;
				this.ustensileContent = stack.copy();
			}
		}
	}

	public void updateEntity() {

		if (this.isUstensileContentBurning() && this.canCook()) {
			this.markDirty();
			++this.cuissonPlaque;
		}

		if (this.canCook() && !this.isUstensileContentBurning()) {
			this.cuissonPlaque = 1;
		}

		if (this.canCook() && this.cuissonPlaque == this.cuissonMax) {
			this.cookItem();
			this.updateBlock();
		}

		if (!this.canCook())
			this.cuissonPlaque = 0;
		
		for (int i = 0; i <= 5; i++) {

			if (this.isBurning(i) && this.canSmelt(i)) {
				this.fireParticle = true;
				this.updateBlock();
				
				++this.cuisson[i];
			}

			if (this.canSmelt(i) && !this.isBurning(i)) {
				this.cuisson[i] = 1;
				this.fireParticle = true;
			}

			if (this.canSmelt(i) && this.cuisson[i] == this.cuissonMax) {
				this.fireParticle = false;

				this.smeltItem(i);
				this.updateBlock();
			}

			if (this.cuisson[i] > 0 && !this.canSmelt(i)) {
				this.fireParticle = false;
			}

			if (!this.canSmelt(i)) {
				this.cuisson[i] = 0;
			}
		}
	}

	public boolean getFireParticle() {
		return this.fireParticle;
	}

	public ItemStack getPlaqueContent() {
		return this.plaqueContent;
	}

	public void setPlaqueContent(ItemStack stack) {
		this.plaqueContent = stack;
	}

	public ItemStack getUstensileContent() {
		return this.ustensileContent;
	}

	public void setUstensileContent(ItemStack stack) {
		this.ustensileContent = stack;
	}
	
	public void updateBlock() {
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		this.markDirty();
	}
}