package mod.azure.jarjar.util;

import mod.azure.jarjar.entity.DarthJarJarEntity;
import mod.azure.jarjar.entity.JarJarEntity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawn {

	public static void registerEntityWorldSpawns() {

		registerEntityWorldSpawn(ModEntityTypes.JARJAR.get(), 35, 1, 1, Biomes.SWAMP, Biomes.SWAMP_HILLS);
		registerEntityWorldSpawn(ModEntityTypes.DARTHJARJAR.get(), 35, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235252_ay_, Biomes.field_235253_az_, Biomes.field_235254_j_);
	}

	public static void EntitySpawnPlacementRegistry() {

		EntitySpawnPlacementRegistry.register(ModEntityTypes.JARJAR.get(),
				EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				JarJarEntity::spawning);

		EntitySpawnPlacementRegistry.register(ModEntityTypes.DARTHJARJAR.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				DarthJarJarEntity::spawning);
	}

	public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroup, int maxGroup,
			Biome... biomes) {
		for (Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, weight, minGroup, maxGroup));
			}
		}
	}
}