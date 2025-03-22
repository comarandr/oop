package it.uniud.poo.trasporti_2024;

import java.util.function.Predicate;

/**
 * MISSION: implement an OR query that can be used to filter objects that match either the left or the right predicate.
 * @param <T>
 */
public class OrQuery<T> implements Query<T> {
    private final Predicate<T> left;
    private final Predicate<T> right;

    public OrQuery(Predicate<T> left, Predicate<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean test(T t) {
        return left.test(t) || right.test(t);
    }

}
