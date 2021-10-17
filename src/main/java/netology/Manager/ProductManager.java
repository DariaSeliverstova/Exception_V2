package netology.Manager;

import netology.domain.Book;
import netology.domain.Product;
import netology.domain.Smartphone;
import netology.repository.RepositoryProduct;


import java.util.Objects;

public class ProductManager {
    private RepositoryProduct repository;

    public ProductManager(RepositoryProduct repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public void add(Product item) {
        repository.save(item);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;


    }


    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }


            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getProduction().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }

            return false;
        }


        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductManager that = (ProductManager) o;
        return Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "repository=" + repository +
                '}';
    }
}








