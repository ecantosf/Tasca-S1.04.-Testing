package assertj.sp1ta4le2ex4;

import java.util.ArrayList;
import java.util.List;

public class Ordered<T> {
    private List<T> items;

    public Ordered() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public List<T> getItems() {
        return new ArrayList<>(this.items);
    }

    public boolean containsItem(T item) {
        return this.items.contains(item);
    }

    public int getItemCount(T item) {
        int count = 0;
        for (T currentItem : this.items) {
            if (currentItem.equals(item)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Ordered{" + "items=" + items + '}';
    }
}