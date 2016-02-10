import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Directory Class.
 * @author yuxiz
 */
public class Directory {
    /**
     * mapId of diretory.
     */
    private Map<String, Student> map1;
    /**
     * mapFirstName of diretory.
     */
    private Map<String, List<Student>> map2;
    /**
     * mapLastName of diretory.
     */
    private Map<String, List<Student>> map3;
    /**
     * Generate the list.
     * @param list
     */
    public Directory() {
        map1 = new HashMap<String, Student>();
        map2 = new HashMap<String, List<Student>>();
        map3 = new HashMap<String, List<Student>>();
    }
    /**
     * Add a new student object into list and maps.
     * @param s
     *            value of Student
     * @throws NullPointerException
     *             nullpointerexception
     */
    public void addStudent(Student s) {
        if (s == null || map1.get(s.getAndrewId()) != null) {
            throw (new IllegalArgumentException("invalid augrment"));
        } else {
            map1.put(s.getAndrewId(), s);
        }
        if (map2.get(s.getFirstName()) != null) {
            map2.get(s.getFirstName()).add(s);
        } else {
            ArrayList<Student> List2 = new ArrayList<Student>();
            List2.add(s);
            map2.put(s.getFirstName(), List2);
        }
        if (map3.get(s.getLastName()) != null) {
            map3.get(s.getLastName()).add(s);
        } else {
            ArrayList<Student> List3 = new ArrayList<Student>();
            List3.add(s);
            map3.put(s.getLastName(), List3);
        }
    }
    /**
     * Delete the student with andrewId.
     * @param andrewId
     *            value of Student
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null || map1.get(andrewId) == null) {
            throw new IllegalArgumentException("invalid augrment");
        } else if (map1.get(andrewId) != null) {
            Student studentDelete = map1.get(andrewId);
            map2.get(studentDelete.getFirstName())
                    .remove(studentDelete);
            map3.get(studentDelete.getLastName()).remove(studentDelete);
            map1.remove(andrewId);
        }
    }
    /**
     * SearchByAndrew Id.
     * @param andrewId
     *            value of Student
     * @return Student
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException("invalid augrment");
        } else if (map1.get(andrewId) == null) {
            return null;
        }
        return map1.get(andrewId);
    }
    /**
     * SearchByFirst Name.
     * @param firstName
     *            value of Student
     * @return listFindByFirstName
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("invalid augrment");
        } else if (map2.get(firstName) == null) {
            return new ArrayList<Student>();
        } else {
            return map2.get(firstName);
        }
    }
    /**
     * SearchByLast Name.
     * @param lastName
     *            value of Student
     * @return listFindByLastName;
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("invalid augrment");
        } else if (map3.get(lastName) == null) {
            return new ArrayList<Student>();
        } else {
            return map3.get(lastName);
        }
    }
    /**
     * Return the number of students.
     * @return the number of students;
     */
    public int size() {
        return map1.size();
    }
}
