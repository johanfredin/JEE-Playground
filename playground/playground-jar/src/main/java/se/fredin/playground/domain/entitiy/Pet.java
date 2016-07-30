package se.fredin.playground.domain.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import se.fredin.playground.domain.IdHolder;

@Entity
@Table(name="PERSON_REGISTERY")
public class Pet extends AbstractEntity {

	private static final long serialVersionUID = -6618814214423296662L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PET_ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@Column(name="Type")
	private PetType type;
	
	private String name;
	
	public Pet() {}
	
	public Pet(PetType type, String name) {
		setType(type);
		setName(name);
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setType(PetType type) {
		this.type = type;
	}
	
	public PetType getType() {
		return type;
	}
	
	
	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		Pet populatedPet = (Pet) populatedEntity;
		setId(populatedPet.getId());
		setName(populatedPet.getName());
		setType(populatedPet.getType());
		setPerson(populatedPet.getPerson());
	}

	@Override
	public void setRelations() {
	}

}
