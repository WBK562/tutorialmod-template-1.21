package net.wbk.tutorialmod;
import net.fabricmc.api.ClientModInitializer;
import net.wbk.tutorialmod.item.ModItems;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        ModItems.registerModItems();
    }
}
