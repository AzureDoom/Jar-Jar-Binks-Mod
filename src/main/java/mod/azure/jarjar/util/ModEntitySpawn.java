package mod.azure.jarjar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import mod.azure.jarjar.entity.DarthJarJarEntity;
import mod.azure.jarjar.entity.JarJarEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawn {

	/* Major fucking thanks to Corgi Taco for figuring this shit out */
	@SuppressWarnings("deprecation")
	public static void addSpawnEntries() {
		for (Biome biome : WorldGenRegistries.field_243657_i) {
			if (biome.getCategory().equals(Biome.Category.SWAMP)) {
				addMobSpawnToBiome(biome, EntityClassification.MONSTER,
						new MobSpawnInfo.Spawners(ModEntityTypes.JARJAR.get(), 35, 1, 1));
			}
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				addMobSpawnToBiome(biome, EntityClassification.MONSTER,
						new MobSpawnInfo.Spawners(ModEntityTypes.DARTHJARJAR.get(), 35, 1, 1));
			}
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

	public static void addMobSpawnToBiome(Biome biome, EntityClassification classification,
			MobSpawnInfo.Spawners... spawnInfos) {
		convertImmutableSpawners(biome);
		List<MobSpawnInfo.Spawners> spawnersList = new ArrayList<>(
				biome.func_242433_b().field_242554_e.get(classification));
		spawnersList.addAll(Arrays.asList(spawnInfos));
		biome.func_242433_b().field_242554_e.put(classification, spawnersList);
	}

	private static void convertImmutableSpawners(Biome biome) {
		if (biome.func_242433_b().field_242554_e instanceof ImmutableMap) {
			biome.func_242433_b().field_242554_e = new HashMap<>(biome.func_242433_b().field_242554_e);
		}
	}
}