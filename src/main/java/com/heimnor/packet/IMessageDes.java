package com.heimnor.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class IMessageDes implements IMessage {

	private String playerJet;
	private int resultatDes;

	public IMessageDes() {

	}

	public IMessageDes(String text, int resultatfinal) {
		this.playerJet = text;
		this.resultatDes = resultatfinal;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.playerJet = ByteBufUtils.readUTF8String(buf);
		this.resultatDes = ByteBufUtils.readVarInt(buf, 1);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeUTF8String(buf, playerJet);
		ByteBufUtils.writeVarInt(buf, resultatDes, 1);

	}

	public static class IMesageDesHandler implements IMessageHandler<IMessageDes, IMessage> {

		@Override
		public IMessage onMessage(IMessageDes message, MessageContext ctx) {

			String stringresultat = String.format("[Dés]" + message.playerJet + " à jeté les dés et obtient un score de " + message.resultatDes + ".",
					message.playerJet, message.resultatDes);
			ChatStyle chatstyle = new ChatStyle().setColor(EnumChatFormatting.GRAY);
			IChatComponent resultat = new ChatComponentText(stringresultat).setChatStyle(chatstyle);
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(resultat);

			return null;
		}

	}
}