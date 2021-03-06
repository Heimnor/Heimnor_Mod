package com.heimnor.common;

import java.io.File;
import java.io.IOException;

import com.heimnor.client.PlayerDataEventHandler;
import com.heimnor.command.player.CommandAJ;
import com.heimnor.command.player.CommandJet;
import com.heimnor.command.staff.HPerm;
import com.heimnor.creativetabs.HeimnorArmorCreativeTabs;
import com.heimnor.creativetabs.HeimnorBlockCreativeTabs;
import com.heimnor.creativetabs.HeimnorBlocksDecoTabs;
import com.heimnor.creativetabs.HeimnorFoodCreativeTabs;
import com.heimnor.creativetabs.HeimnorMiscCreativeTab;
import com.heimnor.creativetabs.HeimnorWeaponCreativeTabs;
import com.heimnor.events.LivingEventHandler;
import com.heimnor.events.PropertiesEvent;
import com.heimnor.events.ServerEvents;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.packet.IMessageCSSyncRep;
import com.heimnor.packet.IMessageChat;
import com.heimnor.packet.IMessageChatClose;
import com.heimnor.packet.IMessageChatCloseReponse;
import com.heimnor.packet.IMessageChatReponse;
import com.heimnor.packet.IMessageDes;
import com.heimnor.packet.IMessageLog;
import com.heimnor.packet.IMessagePropertyRep;
import com.heimnor.packet.IMessagePropertySync;
import com.heimnor.packet.PacketPerm;
import com.heimnor.packet.SyncFood;
import com.heimnor.proxy.CommonProxy;
import com.heimnor.utils.NbtCsFile;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import init.divers.ClochetteMJ;
import init.foods.AlcoolHeimnor;
import init.foods.NourritureMinerale1;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import registry.ArmorRegistry;
import registry.BlockFoodRegistry;
import registry.BlocksDecoRegistry;
import registry.BlocksRegistry;
import registry.MiscRegistry;
import registry.WeaponsRegistry;

/**
 * 
  * @author Joe
  * 25 nov. 2018
  *
 */

@Mod(modid = Heimnor.MODID, name = Heimnor.NAME, version = Heimnor.VERSION)
public class Heimnor {
	public static final String MODID = "heimnormod";
	public static final String VERSION = "1.0.0";
	public static final String NAME = "Heimnor";
	public static SimpleNetworkWrapper network;
	// A modifier pour modifier tout le mod

	public static CreativeTabs HeimnorMiscCreativeTabs = new HeimnorMiscCreativeTab("heimnor_misc_creative_tabs");
	public static CreativeTabs HeimnorArmorCreativeTabs = new HeimnorArmorCreativeTabs("heimnor_armor_creative_tabs");
	public static CreativeTabs HeimnorWeaponCreativeTabs = new HeimnorWeaponCreativeTabs(
			"heimnor_weapon_creative_tabs");
	public static CreativeTabs HeimnorFoodTabs = new HeimnorFoodCreativeTabs("heimnor_food_tabs");
	public static CreativeTabs HeimnorBlockTabs = new HeimnorBlockCreativeTabs("heimnor_block_tabs");
	public static CreativeTabs HeimnorBlockDecoTabs = new HeimnorBlocksDecoTabs("heimnor_blockdeco_tabs");

	public static Item itemclochette;
	// Déclaration des items divers

	public static Item itemchope, itemverre_vin, itemnourritureminerale1;
	// Déclaration des Items Consommables

	@Instance("heimnormod")
	public static Heimnor instance;
	// Instance du Mod d'Heimnor

	@SidedProxy(clientSide = "com.heimnor.proxy.ClientProxy", serverSide = "com.heimnor.proxy.CommonProxy")
	public static CommonProxy proxy;
	// Proxy

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {// Pré Initialisation
		
		proxy.registerRender();

		itemclochette = new ClochetteMJ().setUnlocalizedName("clochette")
				.setTextureName(Heimnor.MODID + ":clochettetext").setCreativeTab(HeimnorMiscCreativeTabs);
		// Items Divers
		itemchope = new AlcoolHeimnor(1, "chope", false, MiscRegistry.chope_vide, 4);
		// paramètres item (class)
		itemverre_vin = new AlcoolHeimnor(1, "verre_vin", false, MiscRegistry.verre_vin_vide, 5);
		itemnourritureminerale1 = new NourritureMinerale1(8, 0.5F, false).setUnlocalizedName("NourritureMinerale1")
				.setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID + ":nourritureminerale1");

		ArmorRegistry.registerArmors();
		WeaponsRegistry.registerWeapons();
		BlockFoodRegistry.registerBlock();

		BlocksDecoRegistry.registerFurnitures();
		BlocksDecoRegistry.registerTileEntities();
		BlockFoodRegistry.registerTileEntity();
		MiscRegistry.registerMiscItems();
		BlocksRegistry.registerBlocks();
		BlocksRegistry.registerTileEntities();

		GameRegistry.registerItem(itemnourritureminerale1, "item_nourritureminerale1");
		GameRegistry.registerItem(itemverre_vin, "item_verre_vin");
		GameRegistry.registerItem(itemchope, "item_chope");

		// GR Consommables et contenants

		GameRegistry.registerItem(itemclochette, "item_clochette");
		// GR Items Divers

		network = NetworkRegistry.INSTANCE.newSimpleChannel("chatChannel");
		network.registerMessage(com.heimnor.packet.IMessageChat.IMessageHandlerChat.class, IMessageChat.class, 1,
				Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageChatReponse.IMessageHandlerChatReponse.class,
				IMessageChatReponse.class, 2, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessageChatClose.IMessageHandlerChatClose.class,
				IMessageChatClose.class, 3, Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageChatCloseReponse.IMessageHandlerChatReponseClose.class,
				IMessageChatCloseReponse.class, 4, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessageDes.IMesageDesHandler.class, IMessageDes.class, 5,
				Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageCSSync.CommonHandler.class, IMessageCSSync.class, 6,
				Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageCSSyncRep.ClientHandler.class, IMessageCSSyncRep.class, 7,
				Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessageLog.Handler.class, IMessageLog.class, 8, Side.SERVER);
		network.registerMessage(com.heimnor.packet.PacketPerm.Handler.class, PacketPerm.class, 9, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.SyncFood.Handler.class, SyncFood.class, 10, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessagePropertySync.CommonHandler.class, IMessagePropertySync.class,
				11, Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessagePropertyRep.ClientHandler.class, IMessagePropertyRep.class,
				12, Side.CLIENT);
		// Network Packets
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {// Initialisation

		FMLCommonHandler.instance().bus().register(new LivingEventHandler());
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
		FMLCommonHandler.instance().bus().register(new PlayerDataEventHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerDataEventHandler());
		MinecraftForge.EVENT_BUS.register(new ServerEvents());
		FMLCommonHandler.instance().bus().register(new ServerEvents());
		MinecraftForge.EVENT_BUS.register(new PropertiesEvent());
		FMLCommonHandler.instance().bus().register(new PropertiesEvent());
		NetworkRegistry.INSTANCE.registerGuiHandler(Heimnor.instance, new CSGuiHandler());
		// Items Render

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {// Post Initialisation

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		// Executez au démarrage du serveur
		event.registerServerCommand(new CommandJet());
		event.registerServerCommand(new HPerm());
		event.registerServerCommand(new CommandAJ());

		File permissions = new File("Heimnor/Permissions.dat");

		if (!permissions.exists()) {
			permissions.getParentFile().mkdirs();
			System.out.println("Permissions.dat crée");
			try {
				permissions.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			NbtCsFile.setNbtTagCompound(permissions, "index", new NBTTagCompound());
		}
	}
}
