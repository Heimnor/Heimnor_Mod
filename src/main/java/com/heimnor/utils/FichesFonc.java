package com.heimnor.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class FichesFonc {

	private static File joueursFile = new File("Heimnor/Joueurs.dat");
	private static File permissions = new File("Heimnor/Permissions.dat");

	public static boolean isMJ(EntityPlayer player) {

		NBTTagCompound indexPerm = NbtCsFile.getData(permissions).getCompoundTag("index");
		if (permissions.exists()) {
			if (indexPerm.hasKey(player.getDisplayName())) {
				String status = indexPerm.getString(player.getDisplayName());
				if (status.equals("MJ")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static int getCuisine(EntityPlayer player) {

		if (NbtCsFile.getData(joueursFile).getCompoundTag("index").getCompoundTag(player.getDisplayName())
				.hasKey("perso")) {

			String persoName = NbtCsFile.getData(new File("Heimnor/Joueurs.dat")).getCompoundTag("index")
					.getCompoundTag(player.getDisplayName()).getString("perso");
			int cuisine = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index")
					.getCompoundTag(persoName).getInteger("cuisine");
			System.out.println("Cuisine : " + cuisine);
			return cuisine;
		} else {
			return 0;
		}

	}

	public static int throwOneComp(EntityPlayer player, String comp1Name, int comp1, World world) {

		Random rand = new Random();
		int jet = rand.nextInt(20) + 1;
		int resultat = jet + comp1;

		String formula = "(" + jet + "+" + comp1 + "=" + resultat + ")";

		IChatComponent chatMsg = new ChatComponentText(EnumChatFormatting.DARK_GRAY + "[" + comp1Name + "]" + formula
				+ EnumChatFormatting.GRAY + player.getDisplayName() + " obtient " + resultat + ".");
		player.addChatMessage(chatMsg);

		return resultat;
	}

	public static int throwTwoComp(EntityPlayer player, String comp1Name, int comp1, String comp2Name, int comp2) {

		Random rand = new Random();
		int jet = rand.nextInt(20);
		int resultat = jet + comp1 + comp2;

		String formula = "(" + jet + "+" + comp1 + "+" + comp2 + "=" + resultat + ")";
		IChatComponent chatMsg = new ChatComponentText(EnumChatFormatting.DARK_GRAY + "[" + comp1Name + " + "
				+ comp2Name + "]" + formula + EnumChatFormatting.GRAY + player.getDisplayName() + "obtient");
		player.addChatMessage(chatMsg);
		return resultat;
	}
}
