package netology;

import netology.Manager.ProductManager;
import netology.domain.Book;
import netology.domain.Product;
import netology.domain.Smartphone;
import netology.repository.NotFoundException;
import netology.repository.RepositoryProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {


    private RepositoryProduct repo = new RepositoryProduct();

    private Book first = new Book("Moi Dodir", 2, 300, "Chukovskii");
    private Book second = new Book("Fly Tsikotuha", 1, 250, "Chukovskii");
    private Book third = new Book("Green Apply", 0, 450, "Matie");
    private Book fourth = new Book("100 polet", 15, 250, "Kulich");
    private Smartphone three = new Smartphone("100", 8, 10101, "Hawai");
    private Smartphone one = new Smartphone("223", 1, 12364, "Apply");
    private Smartphone two = new Smartphone("222", 2, 11111, "Sumsung");
    private Product fife = new Product("Taburet", 100, 230);


    @BeforeEach
    public void setUp() {


        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(one);
        repo.save(two);
        repo.save(fourth);
        repo.save(three);
        repo.save(fife);


    }

    @Test
    public void shouldException() {
        assertThrows(NotFoundException.class, () -> {

            repo.removeById(6);
        });
    }

    @Test
    public void shouldRemoveById() {

        repo.removeById(2);
        System.out.println(repo.findAll().length);


    }

    @Test
    public void shouldFindId() {
        repo.findById(2);
        System.out.println(repo.findById(2));

    }
}

















