import javax.persistence.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child {
private long id;
private String FIO;
private String address;
private int age;
private int schoolNumber;
private Set<Parent> parents = new HashSet<Parent>();
private District districtCh;
private School school;


    public Child() {
    }

    public Child(String FIO, String address, int age) {
        this.FIO = FIO;
        this.address = address;
        this.age = age;
    }

    @ManyToMany
    @JoinTable(name = "parent_child",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))

    public Set<Parent> getParents() {
        return parents;
    }
    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")

    public District getDistrictCh() {
        return districtCh;
    }

    public void setDistrictCh(District districtCh) {
        this.districtCh = districtCh;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")

       public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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

@Column(name = "schoolNumber",nullable = false,insertable = true,updatable = true)

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }
@Column(name = "FIO",nullable = false,insertable = true,updatable = true)

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Column(name = "Address",nullable = false,insertable = true,updatable = true)

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "Age",nullable = false,insertable = true,updatable = true)



    @Override
    public String toString() {
        return "Child{" + "id=" + id +" , FIO= " + FIO + '/'+ ", schoolNumber=" + schoolNumber +
        ", parent= " + parents.toString() + "}";
    }
}
