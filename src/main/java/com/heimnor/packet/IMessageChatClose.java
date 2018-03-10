package com.heimnor.packet;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;

public class IMessageChatClose implements IMessage {

	private boolean ChatGui;

	public IMessageChatClose() {
	}


	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	public static class IMessageHandlerChatClose implements IMessageHandler<IMessageChatClose, IMessage> {

		@Override
		public IMessage onMessage(IMessageChatClose message, MessageContext ctx) {

			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			Heimnor.network.sendToAll(new IMessageChatCloseReponse(player.getDisplayName()));

			return null;
		}

	}

}
