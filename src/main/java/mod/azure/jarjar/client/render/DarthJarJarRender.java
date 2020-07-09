package mod.azure.jarjar.client.render;

import mod.azure.jarjar.JarJarMod;
import mod.azure.jarjar.client.model.JarJarModel;
import mod.azure.jarjar.entity.DarthJarJarEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DarthJarJarRender extends MobRenderer<DarthJarJarEntity, JarJarModel<DarthJarJarEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(JarJarMod.MODID,
			"textures/entity/darthjarjar.png");

	public DarthJarJarRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new JarJarModel<DarthJarJarEntity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(DarthJarJarEntity entity) {
		return TEXTURE;
	}

}