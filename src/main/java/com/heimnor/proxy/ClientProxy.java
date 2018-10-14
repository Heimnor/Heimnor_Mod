package com.heimnor.proxy;

import java.io.File;
import java.util.ArrayList;

import com.heimnor.client.FichesGui;
import com.heimnor.common.Heimnor;
import com.heimnor.models.OneBlockRenderer;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.tileentity.TileEntityDirection;
import com.heimnor.utils.NbtCsFile;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import registry.EquipmentRender;

public class ClientProxy extends CommonProxy {

	public static ArrayList<String> CHATTING_PLAYERS_USERNAME = new ArrayList<String>();
	public static int renderID;
	
	public ClientProxy() {

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void registerRender() {

		EquipmentRender.registerEquipmentRender();
		renderID = RenderingRegistry.getNextAvailableRenderId();
		
        RenderingRegistry.registerBlockHandler(new TESRInventoryRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDirection.class, new OneBlockRenderer());
	}

	@SubscribeEvent
	public void onInitGuiEvent(InitGuiEvent.Post event) {

		if (event.gui instanceof GuiInventory) {

			event.buttonList.add(new GuiButton(30, event.gui.width / 2 - 60, 0, 120, 20, "Fiche de personnage"));
		}

		if (event.gui instanceof GuiContainerCreative) {

			event.buttonList.add(new GuiButton(31, event.gui.width / 2 - 60, 220, 120, 20, "Fiche de personnage"));
		}

		if (event.gui instanceof FichesGui) {
			File permissions = new File("Heimnor/Permissions.dat");
			Heimnor.network.sendToServer(new IMessageCSSync(new NBTTagCompound(), "perm",
					Minecraft.getMinecraft().thePlayer.getDisplayName(), "false"));
			NBTTagCompound index = NbtCsFile.getNbtTagCompound(permissions, "index");
			if (index.getString(Minecraft.getMinecraft().thePlayer.getDisplayName()).equals("MJ")) {

				event.buttonList.add(
						new GuiButton(32, event.gui.width / 2 + 61, event.gui.height / 2 - 125, 60, 20, "Importer"));
			}

		}
	}

	@SubscribeEvent
	public void onActionPerformed(ActionPerformedEvent.Pre event) {

		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		World world = Minecraft.getMinecraft().theWorld;

		if (event.gui instanceof GuiInventory && event.button.id == 30) {

			player.openGui(Heimnor.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}

		if (event.gui instanceof GuiContainerCreative && event.button.id == 31)

			player.openGui(Heimnor.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);

		if (event.gui instanceof FichesGui && event.button.id == 32)

			player.openGui(Heimnor.instance, 2, world, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
}
