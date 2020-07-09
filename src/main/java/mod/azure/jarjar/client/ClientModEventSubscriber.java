package mod.azure.jarjar.client;

import mod.azure.jarjar.JarJarMod;
import mod.azure.jarjar.client.render.DarthJarJarRender;
import mod.azure.jarjar.client.render.JarJarRender;
import mod.azure.jarjar.util.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = JarJarMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.JARJAR.get(), JarJarRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DARTHJARJAR.get(), DarthJarJarRender::new);
	}
}