package registry;

import com.heimnor.renders.ArmeBatonRender;
import com.heimnor.renders.ArmeHast;
import com.heimnor.renders.ArmesPoingRender;
import com.heimnor.renders.BalaisRender;
import com.heimnor.renders.EpeeLonguesRender;
import com.heimnor.renders.EpeeRender;
import com.heimnor.renders.HacheRender;
import com.heimnor.renders.KhirveRender;
import com.heimnor.renders.PiqueDeRocRender;
import com.heimnor.renders.SceptreRender;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class EquipmentRender {

	
	public static void registerEquipmentRender() {
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.epeeClaymore, (IItemRenderer) new EpeeLonguesRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.epeebatarde, (IItemRenderer) new EpeeLonguesRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.espadon, (IItemRenderer) new EpeeLonguesRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.espadondebraz, (IItemRenderer) new EpeeLonguesRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.espadondorion, (IItemRenderer) new EpeeLonguesRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.deuxmains, (IItemRenderer) new EpeeLonguesRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.patteDours, (IItemRenderer) new ArmesPoingRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.gantsdeguerre, (IItemRenderer) new ArmesPoingRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.katar, (IItemRenderer) new ArmesPoingRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.griffesdefer, (IItemRenderer) new ArmesPoingRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.bodan, (IItemRenderer) new ArmeBatonRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.bidentdebraz, (IItemRenderer) new ArmeBatonRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.baton, (IItemRenderer) new ArmeBatonRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.brazure, (IItemRenderer) new HacheRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hachebenie, (IItemRenderer) new HacheRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hachedebataille, (IItemRenderer) new HacheRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.brigande, (IItemRenderer) new HacheRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.khirve, (IItemRenderer) new KhirveRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.piquederoc, (IItemRenderer) new PiqueDeRocRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.maillet, (IItemRenderer) new PiqueDeRocRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.piquard, (IItemRenderer) new PiqueDeRocRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.pontinne, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.faux, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.lancedebraz, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.marteaulourddebraz, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hallante, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hallebarde, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hallebardebenie, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.marteaudeguerre, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.bipenne, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hallebardeailee, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.lancedefaille, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.vangarde, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.planche, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.zhang, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hallebardebarbue, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.lance, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.sceptredefer, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.massedeguerre, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.zenjia, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.lancederoc, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.pieu, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.torchere, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.lanceenbois, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.piquetier, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.yishi, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.guisarme, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.hachepahinne, (IItemRenderer) new ArmeHast());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.canne, (IItemRenderer) new SceptreRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.sceptreoronne, (IItemRenderer) new ArmeHast());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.sceptre, (IItemRenderer) new SceptreRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.chapelier, (IItemRenderer) new SceptreRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.sceptredefer, (IItemRenderer) new SceptreRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.balais, (IItemRenderer) new BalaisRender());

		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.epeedebraz, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.qian, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.epeebenie, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.lamedefjil, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.quadree, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.katana, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.sakran, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.epeeailee, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.rapiere, (IItemRenderer) new EpeeRender());
		MinecraftForgeClient.registerItemRenderer(WeaponsRegistry.gourdin, (IItemRenderer) new EpeeRender());
	}
}
