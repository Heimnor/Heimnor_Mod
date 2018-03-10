package com.heimnor.command.player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CommandJet extends CommandBase {

	private final List aliases;
	private int nbrfaces;
	private int nbrdes;

	public CommandJet() {

		aliases = new ArrayList();
		aliases.add("jet");
		aliases.add("j");
	}

	@Override
	public int compareTo(Object arg0) {

		return 0;
	}

	@Override
	public String getCommandName() {

		return "jet";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {

		return "command.des.usage";
	}
	

	@Override
	public List getCommandAliases() {

		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {

		World world = sender.getEntityWorld();
		int nbrJet = 0;
		int nbrFaces = 0;
		int bonus;
		int malus;
		String username = null;
		String formatResultat;
		int resultatfinal = 0;
		int resultatfinals;

		if (world.isRemote) {
			System.out.println("Commande lancée en solo");
		} else {
			if (arguments.length == 0) {
				sender.addChatMessage(new ChatComponentText(
						"Completez la commande comme ceci /jet [nbr]d[nbr] ou /jet [nbr]d[nbr] +/- [nbr]"));
				return;
			}

			if (arguments.length >= 1) {

				if (!(arguments[0].contains("+")) && !(arguments[0].contains("-"))) {

					String[] parts = arguments[0].split("d");
					Random rand = new Random();
					nbrJet = Integer.parseInt(parts[0]);
					nbrFaces = Integer.parseInt(parts[1]);
					username = sender.getCommandSenderName();

					if (!(nbrJet == 0 || nbrFaces == 0)) {
						for (int i = 1; i <= nbrJet; i++) {

							resultatfinal = resultatfinal + rand.nextInt(nbrFaces) + 1;
						}

						formatResultat = String.format("(%sd%s) %s obtient %s", nbrJet, nbrFaces, username,
								resultatfinal);
						ChatStyle chatstyle = new ChatStyle().setColor(EnumChatFormatting.GRAY);
						IChatComponent resultat = new ChatComponentText(formatResultat).setChatStyle(chatstyle);
						if ( arguments.length == 2 && (arguments[1].equals("local") || arguments[1].equals("l")))
							sender.addChatMessage(resultat);
						else
						MinecraftServer.getServer().getConfigurationManager().sendChatMsg(resultat);
					}

					else {
						sender.addChatMessage(new ChatComponentText("[Erreur] 0 n'est pas un argument valide."));
					}

				} else if (arguments[0].contains("+")) {

					String[] parts = arguments[0].split("d");

					String[] parts2 = parts[1].split("\\+");

					Random rand = new Random();
					nbrJet = Integer.parseInt(parts[0]);
					System.out.println(parts[1]);
					nbrFaces = Integer.parseInt(parts2[0]);
					bonus = Integer.parseInt(parts2[1]);
					username = sender.getCommandSenderName();
					System.out.println(bonus);
					if (!(nbrJet == 0 || nbrFaces == 0)) {

						for (int i = 1; i <= nbrJet; i++) {

							resultatfinal = resultatfinal + rand.nextInt(nbrFaces) + 1;

						}
						resultatfinals = resultatfinal + bonus;

						formatResultat = String.format("(%sd%s+%s = %s+%s) %s obtient %s", nbrJet, nbrFaces, bonus,
								resultatfinal, bonus, username, resultatfinals);
						ChatStyle chatstyle = new ChatStyle().setColor(EnumChatFormatting.GRAY);
						IChatComponent resultat = new ChatComponentText(formatResultat).setChatStyle(chatstyle);
						if ( arguments.length == 2 && (arguments[1].equals("local") || arguments[1].equals("l")))
							sender.addChatMessage(resultat);
						else
						MinecraftServer.getServer().getConfigurationManager().sendChatMsg(resultat);
					} else {
						sender.addChatMessage(new ChatComponentText("[Erreur] 0 n'est pas un argument valide."));
					}

				} else if (arguments[0].contains("-")) {

					String[] parts = arguments[0].split("d");

					String[] parts2 = parts[1].split("\\-");

					Random rand = new Random();
					nbrJet = Integer.parseInt(parts[0]);
					System.out.println(parts[1]);
					nbrFaces = Integer.parseInt(parts2[0]);
					malus = Integer.parseInt(parts2[1]);
					username = sender.getCommandSenderName();
					if (!(nbrJet == 0 || nbrFaces == 0)) {
						for (int i = 1; i <= nbrJet; i++) {

							resultatfinal = resultatfinal + rand.nextInt(nbrFaces) + 1;
						}
						resultatfinals = resultatfinal - malus;

						formatResultat = String.format("(%sd%s-%s = %s-%s) %s obtient %s", nbrJet, nbrFaces, malus,
								resultatfinal, malus, username, resultatfinals);
						ChatStyle chatstyle = new ChatStyle().setColor(EnumChatFormatting.GRAY);
						IChatComponent resultat = new ChatComponentText(formatResultat).setChatStyle(chatstyle);
						System.out.println( " test" + arguments.length);
						
						if ( arguments.length == 2 && (arguments[1].equals("local") || arguments[1].equals("l"))) {
							sender.addChatMessage(resultat);
						}
						else {
							MinecraftServer.getServer().getConfigurationManager().sendChatMsg(resultat);
						}
						
					} else {
						sender.addChatMessage(new ChatComponentText("[Erreur] 0 n'est pas un argument valide."));
					}
				}
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender var1) {

		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {

		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {

		return false;
	}
	
}
