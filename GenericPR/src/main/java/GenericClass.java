import java.util.ArrayList;
import java.util.List;

public class GenericClass<E extends Base> {

    private List<E> list = new ArrayList<E>();

    public void save(E e) {
        list.add(e);
    }

    public E findById(Long id) {
        for (E e : list) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void remove(E e) {
        for (E e1 : list) {
            if (e1.equals(e)) {
                list.remove(e);
            }
        }
    }

    List<E> getAll() {
        return list;
    }

    E update(E e, Long id) {
        Integer index = null;
        for (E e1 : list) {
            if (e1.getId().equals(id)) {
                list.remove(e1);
                index = list.indexOf(e1);
            }
        }
        if (index != null) {
            list.add(index, e);
            return e;
        }
        return null;
    }
}
