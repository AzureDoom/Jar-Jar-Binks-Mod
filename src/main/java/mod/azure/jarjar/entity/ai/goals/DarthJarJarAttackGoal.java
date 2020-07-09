package mod.azure.jarjar.entity.ai.goals;

import mod.azure.jarjar.entity.DarthJarJarEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DarthJarJarAttackGoal extends MeleeAttackGoal {
	private final DarthJarJarEntity zombie;
	private int raiseArmTicks;

	public DarthJarJarAttackGoal(DarthJarJarEntity zombieIn, double speedIn, boolean longMemoryIn) {
		super(zombieIn, speedIn, longMemoryIn);
		this.zombie = zombieIn;
	}

	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}

	public void resetTask() {
		super.resetTask();
		this.zombie.setAggroed(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
			this.zombie.setAggroed(true);
		} else {
			this.zombie.setAggroed(false);
		}

	}
}