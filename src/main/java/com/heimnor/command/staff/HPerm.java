package com.heimnor.command.staff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.PacketPerm;
import com.heimnor.utils.NbtCsFile;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class HPerm extends CommandBase {

	private final List aliases;

	public HPerm() {
		aliases = new ArrayList();
		aliases.add("HPerm");
		aliases.add("hperm");
	}

	@Override
	public String getCommandName() {

		return "HPerm";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {

		return null;
	}

	@Override
	public List getCommandAliases() {

		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {

		if (!sender.getEntityWorld().isRemote) {
			// /hperm add mj <joueur>
			if (arguments.length == 3) {
				NBTTagCompound indexj = NbtCsFile.getData(new File("Heimnor/Permissions.dat")).getCompoundTag("index");
				if (arguments[0].equals("set")) {
					if (indexj.hasKey(arguments[2])) {

						if (arguments[1].equals("Visiteur") || arguments[1].equals("Joueur")
								|| arguments[1].equals("Builder") || arguments[1].equals("Dev")
								|| arguments[1].equals("MJ")) {

							indexj.setString(arguments[2], arguments[1]);
							NbtCsFile.setNbtTagCompound(new File("Heimnor/Permissions.dat"), "index", indexj);
							// log
							System.out.println(arguments[2] + " est maintenant " + arguments[1] + " " + indexj);

							ChatStyle style = new ChatStyle().setColor(EnumChatFormatting.RED);
							IChatComponent component = new ChatComponentText(
									arguments[2] + " est maintenant " + arguments[1] + ".").setChatStyle(style);
							sender.addChatMessage(component);

						} else {
							this.commandExcepetion(sender, 0);
						}

					} else {
						this.commandExcepetion(sender, 1);
					}
				}
			} else {
				this.commandExcepetion(sender, 2);
			}
		}

	}

	private void commandExcepetion(ICommandSender sender, int errorType) {
		ChatStyle style = new ChatStyle().setColor(EnumChatFormatting.RED);

		if (errorType == 0) {
			IChatComponent component = new ChatComponentText("[Erreur] Roles possibles : Visiteur, Joueur, MJ, Builder, Dev").setChatStyle(style);
			sender.addChatMessage(component);
		} else if (errorType == 1) {
			IChatComponent component = new ChatComponentText("[Erreur] Joueur non trouvé.").setChatStyle(style);
			sender.addChatMessage(component);
		} else if (errorType == 2) {
			IChatComponent component = new ChatComponentText("[Erreur] Arguments invalides : /hperm <set> <role> <joueur>").setChatStyle(style);
			sender.addChatMessage(component);
		}

	}

}
