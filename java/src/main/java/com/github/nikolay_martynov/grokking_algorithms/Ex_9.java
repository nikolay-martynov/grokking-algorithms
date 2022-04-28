package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import java.util.*;

public class Ex_9 {

    /**
     * Optimizes bag content.
     * <p>
     * Uses dynamic programming implementation.
     *
     * @param inventory Map that represents items that can be added where key is the item
     *                  and value is the characteristics of that item.
     * @param bagSize   Maximum bag size.
     * @return A set of items with maximum cost that can be added to the bag without exceeding its size.
     */
    @Nonnull
    public <T> Set<T> optimizeBagDynamic(@Nonnull Map<T, ItemInfo> inventory, int bagSize) {
        int minItemSize = Integer.MAX_VALUE;
        for (ItemInfo itemInfo : inventory.values()) {
            minItemSize = Integer.min(minItemSize, itemInfo.size());
        }
        if (bagSize < minItemSize) {
            return Collections.emptySet();
        }
        int sizesCount = bagSize - minItemSize + 1;
        record BagContent<T>(Set<T> items, double totalValue) {
        }
        List<BagContent<T>> lastOptions = null;
        int itemIndex = 0;
        for (T item : inventory.keySet()) {
            List<BagContent<T>> newOptions = new ArrayList<>(sizesCount);
            double itemValue = inventory.get(item).value();
            int itemSize = inventory.get(item).size();
            if (itemIndex == 0) {
                for (int sizeIndex = 0; sizeIndex < sizesCount; sizeIndex++) {
                    int bagSizeToConsider = sizeIndex + minItemSize;
                    boolean itemTooBig = itemSize > bagSizeToConsider;
                    newOptions.add(itemTooBig ?
                            new BagContent<>(Collections.emptySet(), 0.0)
                            : new BagContent<>(Collections.singleton(item), itemValue));
                }
            } else {
                for (int sizeIndex = 0; sizeIndex < sizesCount; sizeIndex++) {
                    int bagSizeToConsider = sizeIndex + minItemSize;
                    BagContent<T> lastContent = lastOptions.get(sizeIndex);
                    boolean itemTooBig = itemSize > bagSizeToConsider;
                    if (itemTooBig) {
                        newOptions.add(lastContent);
                    } else {
                        BagContent<T> newContent;
                        boolean bagHasSpaceForOtherItems = itemSize + minItemSize <= bagSizeToConsider;
                        if (bagHasSpaceForOtherItems) {
                            BagContent<T> bestFreeSpaceContent = lastOptions.get(sizeIndex - itemSize);
                            Set<T> newItems = new HashSet<>(bestFreeSpaceContent.items());
                            newItems.add(item);
                            newContent = new BagContent<>(newItems,
                                    bestFreeSpaceContent.totalValue() + itemValue);
                        } else {
                            newContent = new BagContent<>(Collections.singleton(item), itemValue);
                        }
                        newOptions.add(newContent.totalValue() > lastContent.totalValue() ? newContent : lastContent);
                    }
                }
            }
            lastOptions = newOptions;
            itemIndex++;
        }
        return lastOptions == null ? Collections.emptySet() : lastOptions.get(sizesCount - 1).items();
    }

    /**
     * Information about an item.
     *
     * @param value Value of the item.
     * @param size  Size of the item.
     */
    public record ItemInfo(double value, int size) {
    }

}
