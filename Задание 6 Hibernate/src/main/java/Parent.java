import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Entity
@Table(name="parents")
public class Parent implements Serializable {


    private  long id;

    private String fio;

    private String address;
    private District districtP;
    private Set<Child> children = new HashSet<Child>();

    public Parent() {
    }

    public Parent(String fio, String address) {
        this.fio = fio;
        this.address = address;

    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "parent_child",
    joinColumns = @JoinColumn(name = "parent_id"),
    inverseJoinColumns = @JoinColumn(name = "child_id"))


    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")


    public District getDistrictP() {
        return districtP;
    }

    public void setDistrictP(District districtP) {
        this.districtP = districtP;
    }

@Id
@GeneratedValue(strategy = GenerationType.AUTO)



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

@Column(name = "FIO")

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

@Column(name = "Address")

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addChild(Child child,Set<School> schools){
        Scanner scanner = new Scanner(System.in);
        int schoolNumber = 0;

        System.out.println("Выберите школу для " + child.getFIO() + ":");
        showSchools(schools);
        try {
            schoolNumber = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        child.setSchoolNumber(schoolNumber);
        children.add(child);
    }

    private void showSchools(Set<School> schools) {
        for (School s:schools) {
            System.out.println(s.toString());
        }

    }


    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
