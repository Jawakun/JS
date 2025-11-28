package javacraft.container;

import javacraft.item.JavacraftItemStack;
import java.util.List;

/**
 * Refactored container listener interface for Javacraft Engine.
 * Original: aac (deobfuscated IContainerListener equivalent)
 * 
 * PERFORMANCE: Critical for UI updates. Will be called frequently.
 * CONCURRENCY: Must be thread-safe for 10,000 concurrent player updates.
 */
public interface JavacraftContainerListener {
    
    /**
     * Sends entire container contents to listener.
     * Optimized for batch updates to reduce packet overhead.
     * 
     * @param container The container being updated
     * @param items List of all items in container (optimized as unmodifiable)
     */
    void sendContainerContents(JavacraftContainer container, List<JavacraftItemStack> items);
    
    /**
     * Sends slot update to listener.
     * Used for individual slot changes - high frequency method.
     * 
     * @param container The container being updated
     * @param slotIndex Index of the changed slot
     * @param stack New item stack in the slot (may be empty)
     */
    void sendSlotUpdate(JavacraftContainer container, int slotIndex, JavacraftItemStack stack);
    
    /**
     * Sends window property update.
     * Used for progress bars, brewing times, etc.
     * 
     * @param container The container being updated
     * @param propertyId The property ID to update
     * @param propertyValue The new property value
     */
    void sendWindowProperty(JavacraftContainer container, int propertyId, int propertyValue);
    
    // [PERFORMANCE] Default method for bulk updates to reduce network overhead
    /**
     * Bulk update multiple slots at once.
     * Reduces packet count for large container updates.
     * 
     * @param container The container being updated
     * @param slotUpdates Array of slot indices that changed
     * @param stacks Array of new item stacks for changed slots
     */
    default void sendBulkSlotUpdates(JavacraftContainer container, int[] slotUpdates, JavacraftItemStack[] stacks) {
        for (int i = 0; i < slotUpdates.length; i++) {
            sendSlotUpdate(container, slotUpdates[i], stacks[i]);
        }
    }
    
    // [CONCURRENCY] TODO: Implement asynchronous update queuing for high player counts
    // This will be crucial for 10,000 concurrent players to prevent main thread blocking
}