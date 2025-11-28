package javacraft.slot;

import javacraft.inventory.JavacraftContainer;
import javacraft.item.JavacraftItemStack;
import javax.annotation.Nonnull;

public class JavacraftSlot extends JavacraftContainer {
    
    private final JavacraftContainer container; // Original 'zz' reference
    
    public JavacraftSlot(JavacraftContainer container, JavacraftInventory inventory, 
                        int slotIndex, int xPosition, int yPosition) {
        super(inventory, slotIndex, xPosition, yPosition);
        this.container = container;
    }
    
    @Override
    public boolean isItemValid(@Nonnull JavacraftItemStack stack) {
        return stack != null && stack.getItem().isValidForSlot(stack);
    }
    
    @Override
    public int getSlotStackLimit() {
        return 64;
    }
    
}