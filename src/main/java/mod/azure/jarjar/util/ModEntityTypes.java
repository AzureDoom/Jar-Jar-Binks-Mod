package mod.azure.jarjar.util;

import mod.azure.jarjar.JarJarMod;
import mod.azure.jarjar.entity.DarthJarJarEntity;
import mod.azure.jarjar.entity.JarJarEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			JarJarMod.MODID);

	public static final RegistryObject<EntityType<JarJarEntity>> JARJAR = ENTITY_TYPES.register("jarjar",
			() -> EntityType.Builder.create(JarJarEntity::new, EntityClassification.MISC).size(0.6f, 1.95F)
					.build(new ResourceLocation(JarJarMod.MODID, "jarjar").toString()));
	
	public static final RegistryObject<EntityType<DarthJarJarEntity>> DARTHJARJAR = ENTITY_TYPES.register("darthbinks",
			() -> EntityType.Builder.create(DarthJarJarEntity::new, EntityClassification.MISC).size(0.6f, 1.95F)
					.build(new ResourceLocation(JarJarMod.MODID, "darthbinks").toString()));

}