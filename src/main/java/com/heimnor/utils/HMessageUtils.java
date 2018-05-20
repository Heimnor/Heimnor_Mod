package com.heimnor.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class HMessageUtils {

	
	public static void showError(String string, EntityPlayer player) {
		
		ChatComponentText text = new ChatComponentText(string);
		text.setChatStyle(new ChatStyle().setBold(true).setColor(EnumChatFormatting.RED));
		player.addChatMessage(text);
	}
}
