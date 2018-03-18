package com.heimnor.creativetabs;

import java.awt.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import registry.MiscRegistry;

public class HeimnorMiscCreativeTab extends CreativeTabs {

	private List list;

	public HeimnorMiscCreativeTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return MiscRegistry.des;
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
