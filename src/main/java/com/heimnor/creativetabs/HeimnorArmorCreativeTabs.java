package com.heimnor.creativetabs;

import java.awt.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import registry.ArmorRegistry;

public class HeimnorArmorCreativeTabs extends CreativeTabs {

	private List list;

	public HeimnorArmorCreativeTabs(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return ArmorRegistry.bottesAdamante;
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
