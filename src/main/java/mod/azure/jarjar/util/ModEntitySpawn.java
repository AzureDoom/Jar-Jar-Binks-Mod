package mod.azure.jarjar.util;

import java.util.List;
import java.util.Set;

import mod.azure.jarjar.JarJarMod;
import mod.azure.jarjar.entity.DarthJarJarEntity;
import mod.azure.jarjar.entity.JarJarEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JarJarMod.MODID)
public class ModEntitySpawn {

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
		List<Spawners> base = event.getSpawns().getSpawner(EntityClassification.MONSTER);
		if (types.contains(BiomeDictionary.Type.NETHER)) {
			base.add(new Spawners(ModEntityTypes.DARTHJARJAR.get(), 35, 1, 1));
		}
		if (types.contains(BiomeDictionary.Type.SWAMP)) {
			base.add(new Spawners(ModEntityTypes.JARJAR.get(), 35, 1, 1));
		}
	}

	public static void EntitySpawnPlacementRegistry() {
		EntitySpawnPlacementRegistry.register(ModEntityTypes.JARJAR.get(),
				EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				JarJarEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.DARTHJARJAR.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				DarthJarJarEntity::spawning);
	}

}