package netology.domain;

import java.util.Objects;

public class Smartphone extends Product {

    private String production;


    public Smartphone(String name, int id, int price, String production) {
        super(name, id, price);
        this.production = production;

    }

    public Smartphone(String production, String tittle) {
        this.production = production;

    }

    public Smartphone() {
        super();
    }


    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(production, that.production);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), production);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "production='" + production + '\'' +
                '}';
    }
}

