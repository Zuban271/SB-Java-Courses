import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "district")
public class District {
    private long id;
    private String address;


    public District() {
    }

    public District(String address) {
        this.address = address;
    }



    private Set<Parent> parents = new HashSet<>();
    @OneToMany(mappedBy = "districtP",cascade = CascadeType.ALL,orphanRemoval = true)


    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    private Set<Child> child = new HashSet<>();
    @OneToMany(mappedBy = "districtCh",cascade = CascadeType.ALL,orphanRemoval = true)


    public Set<Child> getChild() {
        return child;
    }

    public void setChild(Set<Child> child) {
        this.child = child;
    }

    private Set<School> schools = new HashSet<>();
    @OneToMany(mappedBy = "districtSch",cascade = CascadeType.ALL,orphanRemoval = true)

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }


    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)


   @Column(name = "id",nullable = false,insertable = true,updatable = true)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Address",nullable = false,insertable = true,updatable = true)

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}

