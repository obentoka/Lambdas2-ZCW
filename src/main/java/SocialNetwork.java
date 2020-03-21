import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SocialNetwork<T> implements Iterable<T> {
    List<T> network;

    public SocialNetwork(Person... people){
        network = new LinkedList(Arrays.asList(people));
    }

    @Override
    public Iterator<T> iterator() {
        return network.iterator();
    }
}