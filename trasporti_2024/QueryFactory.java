package it.uniud.poo.trasporti_2024;

import java.util.function.Predicate;

public class QueryFactory<T> {
    /**
     * create a new AND query
     * @param left
     * @param right
     * @return
     */
    public Query<T> createAndQuery(Predicate<T> left, Predicate<T> right) {
        return new AndQuery<>(left, right);
    }
    /**
     * create a new OR query
     * @param left
     * @param right
     * @return
     */
    public Query<T> createOrQuery(Predicate<T> left, Predicate<T> right) {
        return new OrQuery<>(left, right);
    }
    /**
     * create a new NOT query
     * @param predicate
     * @return
     */
    public Query<T> createNotQuery(Predicate<T> predicate) {
        return new NotQuery<>(predicate);
    }
    /**
     * create a new query from a predicate
     * @param predicate
     * @return
     */
    public Query<T> createQuery(Predicate<T> predicate) {
        return (Query<T>) predicate;
    }

}
