package model;

public class ItemRecord {
    private final String id;
    private String name;
    private int quantity;

    public ItemRecord(String id, String name, int quantity) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Record ID is required.");
        }
        this.id = id.trim();
        setName(name);
        setQuantity(quantity);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Record name is required.");
        }
        this.name = name.trim();
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.quantity = quantity;
    }

    public String toDataLine() {
        return id + "|" + name + "|" + quantity;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | Quantity: %d", id, name, quantity);
    }
}
