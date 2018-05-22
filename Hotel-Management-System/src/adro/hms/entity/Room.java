package adro.hms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "number")
	private int number;

	@Column(name = "standard")
	private String standard;
	
	@Column(name = "is_occupied")
	private boolean isOccupied;
	
	@OneToMany(mappedBy = "room", 
			cascade = {
					CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH
					})
	private List<Guest> occupants;

	public Room() {
		
	}
	
	
	public Room(int number, String standard, boolean isOccupied, List<Guest> occupants) {
		super();
		this.number = number;
		this.standard = standard;
		this.isOccupied = isOccupied;
		this.occupants = occupants;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public List<Guest> getOccupants() {
		return occupants;
	}

	public void setOccupants(List<Guest> occupants) {
		this.occupants = occupants;
	}
	
	public String toString () {
		return standard + " : " + number;
	}
	
}