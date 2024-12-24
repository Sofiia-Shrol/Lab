import java.util.*;

class Product {
    private String name;
    private double recommendedPrice;

    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() {
        return name;
    }

    public double getRecommendedPrice() {
        return recommendedPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Store {
    private String name;
    private Map<Product, Double> products; // Map для зберігання товарів і їхніх цін

    public Store(String name) {
        this.name = name;
        this.products = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Product, Double> getProducts() {
        return products;
    }

    public void addProduct(Product product, double price) {
        products.put(product, price);
    }

    @Override
    public String toString() {
        return name;
    }
}

class SearchService {
    private Set<Store> stores; // Використовуємо HashSet для зберігання магазинів

    public SearchService() {
        this.stores = new HashSet<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    // Знайти мінімальну ціну для товару
    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (Store store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(productName)) {
                    minPrice = Math.min(minPrice, entry.getValue());
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice;
    }

    // Знайти магазини, де товар має мінімальну ціну
    public Set<String> findStoresWithMinimumPrice(String productName) {
        double minPrice = findMinimumPrice(productName);
        Set<String> result = new HashSet<>();
        for (Store store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(productName) && entry.getValue() == minPrice) {
                    result.add(store.getName());
                }
            }
        }
        return result;
    }

    // Знайти магазини, де всі товари дешевші за рекомендовану ціну
    public Set<String> findStoresWithAllProductsCheaper() {
        Set<String> result = new HashSet<>();
        for (Store store : stores) {
            boolean allCheaper = true;
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getValue() >= entry.getKey().getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }
            if (allCheaper) {
                result.add(store.getName());
            }
        }
        return result;
    }

    // Додаткова функціональність: Статистика кількості товарів у кожному магазині
    public Map<String, Integer> getProductCountPerStore() {
        Map<String, Integer> productCount = new HashMap<>();
        for (Store store : stores) {
            productCount.put(store.getName(), store.getProducts().size());
        }
        return productCount;
    }

    // Додаткова функціональність: Знайти всі унікальні товари
    public Set<Product> getAllUniqueProducts() {
        Set<Product> uniqueProducts = new HashSet<>();
        for (Store store : stores) {
            uniqueProducts.addAll(store.getProducts().keySet());
        }
        return uniqueProducts;
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення товарів
        Product p1 = new Product("Laptop", 1000);
        Product p2 = new Product("Smartphone", 800);
        Product p3 = new Product("Headphones", 200);
        Product p4 = new Product("Tablet", 600);

        // Створення магазинів
        Store store1 = new Store("TechStore");
        store1.addProduct(p1, 950);
        store1.addProduct(p2, 750);
        store1.addProduct(p3, 180);

        Store store2 = new Store("ElectroShop");
        store2.addProduct(p1, 1000);
        store2.addProduct(p2, 800);
        store2.addProduct(p3, 190);
        store2.addProduct(p4, 580);

        Store store3 = new Store("GadgetWorld");
        store3.addProduct(p1, 970);
        store3.addProduct(p4, 590);

        // Ініціалізація сервісу пошуку
        SearchService service = new SearchService();
        service.addStore(store1);
        service.addStore(store2);
        service.addStore(store3);

        // Використання сервісу пошуку
        System.out.println("Minimum price for Laptop: " + service.findMinimumPrice("Laptop"));
        System.out.println("Stores with minimum price for Laptop: " + service.findStoresWithMinimumPrice("Laptop"));
        System.out.println("Stores with all products cheaper than recommended price: " + service.findStoresWithAllProductsCheaper());

        // Використання додаткової функціональності
        System.out.println("Product count per store: " + service.getProductCountPerStore());
        System.out.println("All unique products: " + service.getAllUniqueProducts());
    }
}