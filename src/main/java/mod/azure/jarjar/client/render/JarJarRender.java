package mod.azure.jarjar.client.render;

import mod.azure.jarjar.JarJarMod;
import mod.azure.jarjar.client.model.JarJarModel;
import mod.azure.jarjar.entity.JarJarEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class JarJarRender extends MobRenderer<JarJarEntity, JarJarModel<JarJarEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(JarJarMod.MODID,
			"textures/entity/jarjarbinks.png");

	public JarJarRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new JarJarModel<JarJarEntity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(JarJarEntity entity) {
		return TEXTURE;
	}

}