package mod.azure.jarjar;

import mod.azure.jarjar.util.ModEntityTypes;
import mod.azure.jarjar.util.ModSoundEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("azurejarjar")
public class JarJarMod {

	public static final String MODID = "azurejarjar";

	public JarJarMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
	}
}
