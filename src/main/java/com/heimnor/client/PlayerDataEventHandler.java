package com.heimnor.client;

import java.io.File;
import java.io.IOException;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.proxy.CommonProxy;
import com.heimnor.utils.NbtCsFile;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class PlayerDataEventHandler {

	public CommonProxy proxy;

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {

		if (event.entity.worldObj.isRemote) {
			if (event.entity instanceof EntityPlayer) {
				Heimnor.network.sendToServer(new IMessageCSSync(new NBTTagCompound(), "perm",
						Minecraft.getMinecraft().thePlayer.getDisplayName(), "false"));
				String player = Minecraft.getMinecraft().thePlayer.getDisplayName();

				File ficheJoueur = new File("Heimnor/Joueurs.dat");
				File fiche = new File("Heimnor/Fiches.dat");

				try {
					if (!ficheJoueur.exists()) {

						System.out.println("test2");
						ficheJoueur.getParentFile().mkdirs();
						ficheJoueur.createNewFile();
						NBTTagCompound indextag = new NBTTagCompound();
						NBTTagCompound compound = new NBTTagCompound();
						indextag.setTag(player, compound);
						NbtCsFile.setNbtTagCompound(ficheJoueur, "index", indextag);
						Heimnor.network.sendToServer(new IMessageCSSync(indextag, "true", player, "false"));

					} else if (ficheJoueur.exists()) {

						Heimnor.network.sendToServer(new IMessageCSSync(
								NbtCsFile.getNbtTagCompound(ficheJoueur, "index"), "true", player, "false"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (!fiche.exists()) {
					try {
						fiche.createNewFile();
						NbtCsFile.setNbtTagCompound(fiche, "index", new NBTTagCompound());
						Heimnor.network.sendToServer(new IMessageCSSync(
								NbtCsFile.getData(fiche).getCompoundTag("index"), "false", player, "false"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (fiche.exists()) {

					Heimnor.network.sendToServer(new IMessageCSSync(NbtCsFile.getNbtTagCompound(fiche, "index"),
							"false",
							NbtCsFile.getNbtTagCompound(ficheJoueur, "index").getCompoundTag(player).getString("perso"),
							"false"));
				}
			}
		}
	}
}
