package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.schemes.model;

/**
 * Created by samveg on 24/8/17.
 */

public class SchemesData {

    String scheme;
    String ministry;
    String objective;
    String id;

    public SchemesData(String scheme, String ministry, String objective, String id) {
        this.scheme = scheme;
        this.ministry = ministry;
        this.objective = objective;
        this.id = id;
    }

    public String getScheme() {
        return scheme;
    }

    public String getMinistry() {
        return ministry;
    }

    public String getObjective() {
        return objective;
    }

    public String getId() {
        return id;
    }
}
