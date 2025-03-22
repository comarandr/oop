package it.uniud.poo.trasporti_2024;
import java.util.function.Predicate;

/**
 * MISSION: provide a common interface for all queries. A query is just a predicate, that can be composed into more complex queries with
 * AND, OR and NOT operators.
 * @param <T>
 */
public interface Query<T> extends Predicate<T> {
    /**
     * evaluate the query on the given object
     * @param t
     * @return
     */
    public boolean test(T t);
}

