package mod.azure.jarjar.util;

import mod.azure.jarjar.JarJarMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

	public static final DeferredRegister<SoundEvent> MOD_SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			JarJarMod.MODID);

	public static final RegistryObject<SoundEvent> JARDEATH = MOD_SOUNDS.register("jarjar.howwude",
			() -> new SoundEvent(new ResourceLocation("azurejarjar", "jarjar.howwude")));
	public static final RegistryObject<SoundEvent> JARNORMAL = MOD_SOUNDS.register("jarjar.jarjarluvsyou",
			() -> new SoundEvent(new ResourceLocation("azurejarjar", "jarjar.jarjarluvsyou")));
	public static final RegistryObject<SoundEvent> JARHURT = MOD_SOUNDS.register("jarjar.meesadoanuthin",
			() -> new SoundEvent(new ResourceLocation("azurejarjar", "jarjar.meesadoanuthin")));

	public static final RegistryObject<SoundEvent> DARTHDEATH = MOD_SOUNDS.register("jarjar.yousamaystrike",
			() -> new SoundEvent(new ResourceLocation("azurejarjar", "jarjar.yousamaystrike")));
	public static final RegistryObject<SoundEvent> DARTHNORMAL = MOD_SOUNDS.register("jarjar.yousagonnadie",
			() -> new SoundEvent(new ResourceLocation("azurejarjar", "jarjar.yousagonnadie")));
	public static final RegistryObject<SoundEvent> DARTHHURT = MOD_SOUNDS.register("jarjar.uhohyousadidafuckywucky",
			() -> new SoundEvent(new ResourceLocation("azurejarjar", "jarjar.uhohyousadidafuckywucky")));

}