/*
 * Name: Victor Priano
 */

package PhoneBook;

public class ContactList {
	
	private int count;  // number of entries in the list
	private PhoneEntryNode start; // beginning of the list
	private final int NOT_FOUND = -1;
	
	// constructor
	
	// create a null reference which begins the linked list
	// cursor and count will be zero by default
	public ContactList(){
		count = 0;
		start = null;
	}
	
	// accessor methods
	
	// get the entry that matches the name
	public PhoneEntry get (PhoneEntry entry){
		int posOfEntry = search(entry);
		PhoneEntryNode temp = start;
		if(posOfEntry == NOT_FOUND)
			return null;
		else
			for (int node = posOfEntry; node > 0; node--)
				temp = temp.next;
		return temp.info;		
	}
	
	// return number of entries
	public int numberOfEntries () {
		return count;
	}
	
	// print all entries in the array
	public void printAll()
	{
		PhoneEntryNode current = start;
		
		while(current != null)
		{
			System.out.println(current.info);
			
			current = current.next;
		}
	}
	
	// mutator methods
	
	
	
	// inserts the entry if it does not exist in the list already
	// keeps in alphabetical order and increments count
	public void insert (PhoneEntry entry) {
		if(start == null || entry.compareTo(start.info) < 0){
			start = new PhoneEntryNode(entry, start);
			count++;
		}
		else if(search(entry) == NOT_FOUND){
			PhoneEntryNode temp = start;
			PhoneEntryNode follow = null;
			while(temp != null && entry.compareTo(temp.info) >= 0){
				follow = temp;
				temp = temp.next;
			}
			follow.next = new PhoneEntryNode (entry, temp);
			count++;
		}
		
	}
	
	// if the entry is in the list, then deletes it by changing the reference of the
	// previous node and decrements the count
	public void delete (PhoneEntry entry) {	
		if (start != null){
			if (start.info.compareTo(entry) == 0)
				start = start.next;
			else{
				PhoneEntryNode temp = start;
				PhoneEntryNode follow = null;
				while (temp != null && entry.compareTo(temp.info) != 0) {
					follow = temp;
					temp = temp.next;
				}
				if (temp != null && entry.compareTo(temp.info) == 0) 
					follow.next = temp.next;


			}
		}
	}
	
	// support methods
	
	// search through the list to find a match on the PhoneEntry.  If the entry
	// is not found, return NOT_FOUND.
	private int search (PhoneEntry entry) {
		int pos = 0;
		boolean found = false;
		PhoneEntryNode temp = start;
		while (temp != null && !found)
			if (entry.compareTo(temp.info) == 0) 
				found = true;
			else {
				temp = temp.next;
				pos++;
			}
		if (found)
			return pos;
		return NOT_FOUND;
	}

					
	private class PhoneEntryNode {
		
		public PhoneEntry info;
		public PhoneEntryNode next;
		
		PhoneEntryNode (PhoneEntry entry, PhoneEntryNode link) {
			info = entry;
			next = link;
		}
	}
}
