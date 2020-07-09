package mod.azure.jarjar.util;

import mod.azure.jarjar.JarJarMod;
import mod.azure.jarjar.entity.DarthJarJarEntity;
import mod.azure.jarjar.entity.JarJarEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = JarJarMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(ModEntityTypes.JARJAR.get(), ModEntityTypes.DARTHJARJAR.get());
		ModEntitySpawn.registerEntityWorldSpawns();
		ModEntitySpawn.EntitySpawnPlacementRegistry();
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void imstuff(final RegistryEvent.Register<EntityType<?>> event) {
		GlobalEntityTypeAttributes.put(ModEntityTypes.DARTHJARJAR.get(),
				DarthJarJarEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.JARJAR.get(), JarJarEntity.func_234200_m_().func_233813_a_());
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(JarJarMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

}