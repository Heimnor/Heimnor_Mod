package com.heimnor.container;

import com.heimnor.tileentity.TileEntityFourCuisine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFour extends Container {

	private final TileEntityFourCuisine tileFour;

	public ContainerFour(TileEntityFourCuisine tile, InventoryPlayer inventory) {

		this.tileFour = tile;
		tile.openInventory();

		int p = 29;
		this.addSlotToContainer(new Slot(tile, 0, p + 30, 51));
		this.addSlotToContainer(new Slot(tile, 1, p + 48, 51));
		this.addSlotToContainer(new Slot(tile, 2, p + 66, 51));
		this.addSlotToContainer(new Slot(tile, 3, p + 30, 73));
		this.addSlotToContainer(new Slot(tile, 4, p + 48, 73));
		this.addSlotToContainer(new Slot(tile, 5, p +66, 73));

		this.bindPlayerInventory(inventory);
	}

	private void bindPlayerInventory(InventoryPlayer inventory) {

		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 4 + j * 18, 106 + i * 18));
			}
		}
		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventory, i, 4 + i * 18, 165));
		}

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {

		Slot slot = (Slot) this.inventorySlots.get(slotIndex);
		if (slot.getHasStack()) {
			ItemStack stack = slot.getStack();

			if (slot.inventory instanceof InventoryPlayer) {
				if (stack.stackSize == 1) {
					for (int i = 0; i < this.inventorySlots.size(); i++) {
						Slot slotSearch = (Slot) this.inventorySlots.get(i);
						if (slotSearch.getHasStack() == false
								&& slotSearch.inventory instanceof TileEntityFourCuisine) {
							slotSearch.putStack(stack);
							slot.putStack((ItemStack) null);
							i = this.inventorySlots.size();
							return null;
						}
					}
				} else if (stack.stackSize > 1) {
					ItemStack stack2 = stack.copy();

					for (int i = 0; i < this.inventorySlots.size(); i++) {
						Slot slotSearch = (Slot) this.inventorySlots.get(i);
						if (slotSearch.getHasStack() == false
								&& slotSearch.inventory instanceof TileEntityFourCuisine) {
							--stack.stackSize;
							slot.putStack(stack);
							stack2.stackSize = 1;
							slotSearch.putStack(stack2);
							i = this.inventorySlots.size();
							return null;
						}
					}
				}
			} else if (slot.inventory instanceof TileEntityFourCuisine) {

			}
		}
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {

		return this.tileFour.isUseableByPlayer(player);
	}

}
