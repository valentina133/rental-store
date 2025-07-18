package com.actionict.inventory.model;

public class EnumRating {

    public enum Rating {
        G,
        PG,
        PG13,   // sul db è PG-13 ma qui dà errore allora metto PG13
        R,
        NC17       //sul db è NC-17 ma qui dà errore allora metto NC17
    }
}
