package mod.azure.jarjar.entity;

import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.jarjar.entity.ai.goals.JarJarAttackGoal;
import mod.azure.jarjar.util.ModSoundEvents;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class JarJarEntity extends MonsterEntity {

	public JarJarEntity(EntityType<JarJarEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233819_b_, 50.0D)
				.func_233815_a_(Attributes.field_233818_a_, 15.0D).func_233815_a_(Attributes.field_233821_d_, 0.1D)
				.func_233815_a_(Attributes.field_233823_f_, 1.0D);
	}

	public static boolean spawning(EntityType<JarJarEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new JarJarAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, CodEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PufferfishEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SquidEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, DolphinEntity.class, true));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.74F;
	}

	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.JARNORMAL.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.JARHURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.JARDEATH.get();
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_ZOMBIE_STEP;
	}

	protected boolean shouldDrown() {
		return false;
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(Items.PUFFERFISH);
		if (itementity != null) {
			itementity.setNoDespawn();
		}
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.WATER;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

}