package netology.repository;

import netology.domain.Product;

import java.util.Arrays;

public class RepositoryProduct {
    private Product[] items = new Product[0];


    public RepositoryProduct(Product[] items) {
        this.items = items;
    }

    public RepositoryProduct() {
    }

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    ;

    public Product[] findById(int id) {

        for (Product item : items) {
            if (item.getId() == id) {
                return items;

            }
        }
        return null;
    }

    public void removeById(int id) {

        Product[] found = findById(id);

        if (found == null) {
            throw new NotFoundException("элемент с номером id" + id + "отсутствует");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryProduct that = (RepositoryProduct) o;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }

    @Override
    public String toString() {
        return "RepositoryProduct{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}





