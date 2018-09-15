package wi.business;

import java.util.ArrayList;

public class Inventory {
	ArrayList<String> inventory;
	
	public Inventory() {
		inventory = new ArrayList<>(4);
		inventory.add("wooden staff");
		inventory.add("wizard hat");
		inventory.add("cloth shoes");
	}

	/**
	 * @return the inventory
	 */
	public ArrayList<String> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(ArrayList<String> inventory) {
		this.inventory = inventory;
	}
	
	public void addItem(String item) {
		inventory.add(item);
	}
	
	public void editItem(int index, String item) {
		inventory.set(index, item);
	}
	
	public void deleteItem(int index) {
		inventory.remove(index);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String disp = "";
		for(String item : inventory) {
			disp += (inventory.indexOf(item) + 1) + ". " + item + "\n";
		}
		return disp;
	}	
}
