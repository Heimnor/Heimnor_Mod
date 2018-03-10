package com.heimnor.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlancheDecoup extends TileEntity {

	public byte direction;
	public ItemStack content;
	public ItemStack ustensile;

	@Override
	public void writeToNBT(NBTTagCompound compound) {

		super.writeToNBT(compound);
		compound.setByte("Direction", this.direction);
		if (this.content != null) {
			NBTTagCompound compound1 = new NBTTagCompound();
			this.content.writeToNBT(compound1);
			if(compound1 != null) {
				compound.setTag("Content", compound1);
			}
		}
		if(ustensile != null) {
			NBTTagCompound compound2 = new NBTTagCompound();
			this.ustensile.writeToNBT(compound2);
			compound.setTag("Ustensile", compound2);
		}

	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {

		super.readFromNBT(compound);
		this.direction = compound.getByte("Direction");
		
		if(compound.hasKey("Content") && compound.getTag("Content") != null) {
			NBTTagCompound compound1 = (NBTTagCompound) compound.getTag("Content");
			this.content = ItemStack.loadItemStackFromNBT(compound1);
		}
		
		if(compound.hasKey("Ustensile") && compound.getTag("Ustensile") != null) {
			NBTTagCompound compound2 = (NBTTagCompound) compound.getTag("Ustensile");
			this.ustensile = ItemStack.loadItemStackFromNBT(compound2);
		}
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
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 5, nbttagcompound);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
		this.worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord,
				this.zCoord);
	}
	
	public void setContent(ItemStack stack) {
		this.content = stack;
	}

	public ItemStack getContent() {
		return this.content;
	}
	
	public void setUstensile(ItemStack stack) {
		this.ustensile = stack;
	}
	
	public ItemStack getUstensile() {
		return this.ustensile;
	}
}
