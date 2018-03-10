package com.heimnor.creativetabs;

import java.awt.List;

import com.heimnor.common.Heimnor;

import init.drinks.ChopeBiere;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HeimnorMiscCreativeTab extends CreativeTabs {

	private List list;

	public HeimnorMiscCreativeTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Heimnor.itemdes;
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
