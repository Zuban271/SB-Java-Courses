import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ParentDAO parentDAO = new ParentDAO();

        Parent parent = new Parent();
        School school1 = new School("ул.Ленина,10", 4);
        School school2 = new School("ул.Маяковского,20", 3);
        Child child1 = new Child("Ваня", "ул.Маяковского,20", 10);
        Child child2 = new Child("Саша", "ул.Маяковского,20", 12);
        District district1 = new District("ул.Маяковского,20");
        District district2 = new District("ул. Ленина,10");
        // Добавление родителей
        Set<Parent> parentSet = addParent(parent);
        Set<School> schools = new HashSet<>(Arrays.asList(school1, school2));
        // Добавление детей
        parent.addChild(child1, schools);
        parent.addChild(child2, schools);

        // Создание связей таблиц  ManyToOne
        parent.setDistrictP(district1);
        child1.setDistrictCh(district1);
        child2.setDistrictCh(district1);
        if (child1.getSchoolNumber() == school1.getNumber()) {
            child1.setSchool(school1);
        } else {
            child1.setSchool(school2);
        }
        if (child2.getSchoolNumber() == school1.getNumber()) {
            child2.setSchool(school1);
        } else {
            child2.setSchool(school2);
        }


        school1.setDistrictSch(district2);
        school1.setChildSet(parent.getChildren());
        school2.setDistrictSch(district1);
        school2.setChildSet(parent.getChildren());
        district1.setParents(parentSet);
        district1.setChild(parent.getChildren());
        district1.setSchools(schools);
        district2.setSchools(schools);

        System.out.println("Созданы объекты:");
        System.out.println(parent);
        System.out.println(child1);
        System.out.println(child2);
        // Сохранение объекта parent в базе данных
        parentDAO.save(parent);
        // Смена учебного учреждения
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сменить учебное учреждение у ребенка: Yes/No");
        String answer = scanner.nextLine();
        if (answer.equals("Yes")) {
            changeSchool(parent,schools,parentDAO);
        }
        // Смена адреса проживания
        System.out.println("Сменить адрес проживания у ребенка: Yes/No");
        answer = scanner.nextLine();
        if (answer.equals("Yes")) {
            changeAddress(parent,new HashSet<>(Arrays.asList(district1, district2)),parentDAO);
        }
    }


    // Метод добавления родителей
    public static Set<Parent> addParent(Parent parent){
        Set<Parent> parentSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО родителя:");
        String fio = scanner.nextLine();
        System.out.println("Введите адрес проживания:");
        String address = scanner.nextLine();
        parent.setFio(fio);
        parent.setAddress(address);
        parentSet.add(parent);
        return parentSet;
    }
    // Метод смены учебного учреждения
    public static void changeSchool(Parent parent,Set<School> schools,ParentDAO parentDAO){
        Child child = null;
        School school = null;
        Scanner scanner = new Scanner(System.in);
        long school_id = 0;
        long id = 0;
        for (Child ch : parent.getChildren()) {
            System.out.println("Ребенок:" + ch.getFIO() + "ID:" + ch.getId());
        }

        System.out.println("Выберите ребенка у которого требуется сменить школу");

        try {
            id = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        for (Child ch : parent.getChildren()) {
            if (id == ch.getId()) {
                child = ch;
                break;
            }

        }

        if (child != null) {
            System.out.println("Выберите школу для " + child.getFIO() + " :");
            for (School s : schools) {
                System.out.println(s.toString());
            }

            try {
                school_id  =  Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }

            for (School s : schools) {
                if (school_id == s.getId()){
                    school = s;
                    break;
                }

            }
            if (school != null) {
                child.setSchoolNumber(school.getNumber());
                child.setSchool(school);
                System.out.println(parent);
                parentDAO.update(parent);
            }
            else {
                System.out.println("Выбран неверный ID");
            }
        }
        else {
            System.out.println("Выбран неверный ID");
        }
    }
    // Метод смены адреса проживания
    private static void changeAddress(Parent parent, Set<District> districts, ParentDAO parentDAO) {
        Child child = null;
        District district = null;
        long id = 0;
        long district_id = 0;
        Scanner scanner = new Scanner(System.in);
        for (Child ch : parent.getChildren()) {
            System.out.println("Ребенок:" + ch.getFIO() + "ID:" + ch.getId());
        }

        System.out.println("Выберите ребенка у которого требуется сменить адрес");

        try {
             id = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

        for (Child ch : parent.getChildren()) {
            if (id == ch.getId()) {
                child = ch;
                break;
            }

        }

        if (child != null) {
            System.out.println("Выберите адрес для " + child.getFIO() + " :");
            for (District s : districts) {
                System.out.println(s.toString());
            }
            try {
                district_id  =  Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }

            for (District s : districts) {
                if (district_id == s.getId()){
                    district = s;
                    break;
                }

            }
            if (district != null) {
                child.setAddress(district.getAddress());
                child.setDistrictCh(district);
                System.out.println(parent);
                parentDAO.update(parent);
            }
            else {
                System.out.println("Выбран неверный ID");
            }
        }
        else {
            System.out.println("Выбран неверный ID");
        }
    }
}
