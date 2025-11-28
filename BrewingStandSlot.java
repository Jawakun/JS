package javacraft.slot;

import javacraft.entity.player.JavacraftEntityPlayer;
import javacraft.inventory.JavacraftInventory;
import javacraft.item.JavacraftItemStack;
import javacraft.item.JavacraftItems;
import javacraft.stats.JavacraftAchievementList;
import javax.annotation.Nonnull;

/**
 * Refactored brewing stand slot for Javacraft Engine.
 * Original: aab (deobfuscated brewing stand slot)
 * 
 * PERFORMANCE: Optimized item validation with direct enum comparisons.
 * CONCURRENCY: Single-player container - thread confinement assumed.
 */
public class BrewingStandSlot extends JavacraftSlot {
    
    private final JavacraftInventory brewingStandInventory;
    
    public BrewingStandSlot(JavacraftInventory brewingStandInventory, JavacraftInventory inventory, 
                           int slotIndex, int xPosition, int yPosition) {
        super(inventory, slotIndex, xPosition, yPosition);
        this.brewingStandInventory = brewingStandInventory;
    }
    
    /**
     * Checks if the item is valid for brewing stand (potion or ingredient).
     * Optimized with direct item enum comparisons.
     */
    @Override
    public boolean isItemValid(@Nonnull JavacraftItemStack stack) {
        return isValidBrewingItem(stack);
    }
    
    /**
     * Slot stack limit for brewing ingredients.
     */
    @Override
    public int getSlotStackLimit() {
        return 1; // [PERFORMANCE] Brewing ingredients typically limited to 1
    }
    
    /**
     * Called when player takes item from brewing stand.
     * Awards achievement if potion bottle is taken.
     */
    @Override
    public void onPickupFromSlot(JavacraftEntityPlayer player, JavacraftItemStack stack) {
        // [COMPATIBILITY] Preserved original achievement logic
        if (stack.getItem() == JavacraftItems.POTION && stack.getCount() > 0) {
            player.addStat(JavacraftAchievementList.POTION, 1);
        }
        super.onPickupFromSlot(player, stack);
    }
    
    /**
     * Static validation method for brewing items.
     * Optimized with direct enum comparisons instead of string lookups.
     */
    public static boolean isValidBrewingItem(JavacraftItemStack stack) {
        if (stack == null) return false;
        
        var item = stack.getItem();
        // [PERFORMANCE] Direct enum comparison vs. registry lookup
        return item == JavacraftItems.POTION || item == JavacraftItems.GLASS_BOTTLE;
    }
}