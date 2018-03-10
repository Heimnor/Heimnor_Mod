package com.heimnor.client;

import java.awt.event.KeyListener;

import org.lwjgl.input.Keyboard;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageChatClose;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import scala.swing.event.KeyTyped;

public class ChatGui extends GuiChat {

	@Override
	public void onGuiClosed() {

		Heimnor.network.sendToServer(new IMessageChatClose());
	}
}
