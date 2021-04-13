import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school")
public class School {
    private long id;
    private String address;
    private int number;
    private District districtSch;

    public School() {
    }

    public School(String address, int number) {
        this.address = address;
        this.number = number;
    }




@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "district_id")

    public District getDistrictSch() {
        return districtSch;
    }

    public void setDistrictSch(District districtSch) {
        this.districtSch = districtSch;
    }

    private Set<Child> childSet = new HashSet<>();
    @OneToMany(mappedBy = "school",cascade = CascadeType.ALL,orphanRemoval = true)

    public Set<Child> getChildSet() {
        return childSet;
    }

    public void setChildSet(Set<Child> childSet) {
        this.childSet = childSet;
    }







@Id
@GeneratedValue(strategy = GenerationType.AUTO)



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
@Column(name = "Number",nullable = false,insertable = true,updatable = true)

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
