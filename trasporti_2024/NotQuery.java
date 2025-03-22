package it.uniud.poo.trasporti_2024;


import it.uniud.poo.compiti.compito_luglio_2023.PaymentKind;

import java.util.function.Predicate;

/**
 * MISSION: implement a NOT query that can be used to filter objects that do not match the predicate.
 * @param <T>
 */
public class NotQuery<T> implements Query<T> {
    private final Predicate<T> query;

    public NotQuery(Predicate<T> q) {
        this.query = q;
    }

    @Override
    public boolean test(T t) {
        return !this.query.test(t);
    }

}

