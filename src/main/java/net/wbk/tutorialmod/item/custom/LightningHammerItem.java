package net.wbk.tutorialmod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.entity.LightningEntity;

public class LightningHammerItem extends Item {

    public LightningHammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {
            HitResult hit = user.raycast(2200.0, 0.0f, true);

            if (hit.getType() == HitResult.Type.BLOCK) {

                BlockHitResult blockHit = (BlockHitResult) hit;

                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(
                        blockHit.getBlockPos().getX() + 0.5,
                        blockHit.getBlockPos().getY(),
                        blockHit.getBlockPos().getZ() + 0.5
                );

                world.spawnEntity(lightning);
                world.playSound(null, blockHit.getBlockPos(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}