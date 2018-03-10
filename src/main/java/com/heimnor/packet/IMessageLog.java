package com.heimnor.packet;

import com.heimnor.client.PlayerDataEventHandler;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class IMessageLog implements IMessage {

	public String senderName;

	public IMessageLog() {
	}

	public IMessageLog(String message) {
		this.senderName = message;

	}

	@Override
	public void fromBytes(ByteBuf buf) {

		this.senderName = ByteBufUtils.readUTF8String(buf);

	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeUTF8String(buf, this.senderName);

	}

	public static class Handler implements IMessageHandler<IMessageLog, IMessage> {

		@Override
		public IMessage onMessage(IMessageLog message, MessageContext ctx) {

			MinecraftServer.getServer().logInfo(message.senderName + "a modifié sa fiche de personnage.");

			return null;
		}

	}
}
