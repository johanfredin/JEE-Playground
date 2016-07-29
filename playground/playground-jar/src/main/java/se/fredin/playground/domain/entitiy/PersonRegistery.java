package se.fredin.playground.domain.entitiy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import se.fredin.playground.domain.IdHolder;

@Entity
@Table(name="PERSON_REGISTERY")
public class PersonRegistery extends AbstractEntity {

	private static final long serialVersionUID = -6618814214423296662L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSON_REGISTERY_ID")
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="registery")
	@Column(name="PERSONS")
	private List<Person> persons;
	
	public PersonRegistery() {}
	
	public PersonRegistery(List<Person> persons) {
		setPersons(persons);
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	public void addPerson(Person person) {
		getPersons().add(person);
	}
	
	public void removePerson(Person person) {
		getPersons().remove(person);
	}
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	
	@Override
	public void copyDataFromEntity(IdHolder populatedEntity) {
		PersonRegistery populatedRegistery = (PersonRegistery) populatedEntity;
		setId(populatedRegistery.getId());
		setPersons(populatedRegistery.getPersons());
	}

	@Override
	public void setRelations() {
		for(Person person : getPersons()) {
			person.setRegistery(this);
		}
	}

}
