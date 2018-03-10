package com.heimnor.command.player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.heimnor.common.Heimnor;
import com.heimnor.utils.NbtCsFile;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CommandAJ extends CommandBase {

	private final List aliases;

	public CommandAJ() {

		aliases = new ArrayList();
		aliases.add("aj");
		aliases.add("AJ");
		aliases.add("Aj");
		aliases.add("aJ");
	}

	@Override
	public int compareTo(Object arg0) {

		return 0;
	}

	@Override
	public String getCommandName() {

		return "aj";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {

		World world = sender.getEntityWorld();
		EntityPlayerMP player = this.getCommandSenderAsPlayer(sender);
		if (!world.isRemote) {

			File joueurs = new File("Heimnor/Joueurs.dat");

			if (joueurs.exists()) {
				ChatStyle chatStyle = new ChatStyle().setColor(EnumChatFormatting.DARK_GRAY);

				NBTTagCompound compound = NbtCsFile.getData(joueurs).getCompoundTag("aj");
				if (arguments.length == 0) {
					if (compound.hasKey(sender.getCommandSenderName())) {
						long lastWithdraw = compound.getLong(sender.getCommandSenderName());
						long currentTime = System.currentTimeMillis();
						long timeSpend = currentTime - lastWithdraw;
						double timespendDays = (timeSpend / 86400000);
						int nbrAJ = (int) timespendDays;
						if (nbrAJ != 0) {
							compound.setLong(sender.getCommandSenderName(), currentTime - (timeSpend % 86400000));
							NbtCsFile.setNbtTagCompound(joueurs, "aj", compound);
							ItemStack stackAJ = new ItemStack(Heimnor.itemAJ, nbrAJ * 10);
							player.inventory.addItemStackToInventory(stackAJ);
							sender.addChatMessage(new ChatComponentText("Vous avez bien reçu vos actions journalières.").setChatStyle(chatStyle));
						} else {
							this.errors(sender, 2);
						}
					} else {
						this.errors(sender, 3);
					}
				} else if (arguments.length == 1 && arguments[0].equals("set")) {

					System.out.println("AJ mis en place");
					compound.setLong(sender.getCommandSenderName(), System.currentTimeMillis());
					NbtCsFile.setNbtTagCompound(joueurs, "aj", compound);
					IChatComponent text = new ChatComponentText("Compteur d'AJ mis en place.").setChatStyle(chatStyle);
					sender.addChatMessage(text);

				} else {
					this.errors(sender, 1);
				}
			} else {
				this.errors(sender, 0);
			}
		}
	}

	private void errors(ICommandSender sender, int error) {
		ChatStyle errorStyle = new ChatStyle().setColor(EnumChatFormatting.RED);
		String errorString = "";
		switch (error) {
		case 0:
			errorString = "Erreur interne au serveur (fichier Joueur.dat introuvable).";
			break;
		case 1:
			errorString = "Nombre d'argument invalide : '/aj' ou '/aj set' autorisé uniquement.";
			break;
		case 2:
			errorString = "Veuillez attendre un jour minimum pour retirer vos AJ.";
			break;
		case 3:
			errorString = "Veuillez mettre en place votre compteur d'AJ via la commande \"aj set\"";
			break;
		default:
			errorString = "Erreur inconnue, contactez un administrateur/MJ";
		}
		IChatComponent errorText = new ChatComponentText(errorString).setChatStyle(errorStyle);
		sender.addChatMessage(errorText);
	}

}
