package Lab7;

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
}

class Store {
    private String name;
    private Map<Product, Double> products;

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
}

class SearchService {
    private List<Store> stores;

    public SearchService() {
        this.stores = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (Store store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(productName)) {
                    minPrice = Math.min(minPrice, entry.getValue());
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice; // Повертаємо -1, якщо товар не знайдено.
    }

    public List<String> findStoresWithMinimumPrice(String productName) {
        double minPrice = findMinimumPrice(productName);
        List<String> result = new ArrayList<>();
        for (Store store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(productName) && entry.getValue() == minPrice) {
                    result.add(store.getName());
                }
            }
        }
        return result;
    }

    public List<String> findStoresWithAllProductsCheaper() {
        List<String> result = new ArrayList<>();
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
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000);
        Product p2 = new Product("Smartphone", 800);
        Product p3 = new Product("Headphones", 200);

        Store store1 = new Store("TechStore");
        store1.addProduct(p1, 950);
        store1.addProduct(p2, 750);
        store1.addProduct(p3, 180);

        Store store2 = new Store("ElectroShop");
        store2.addProduct(p1, 1000);
        store2.addProduct(p2, 800);
        store2.addProduct(p3, 190);

        SearchService service = new SearchService();
        service.addStore(store1);
        service.addStore(store2);

        System.out.println("Minimum price for Laptop: " + service.findMinimumPrice("Laptop"));
        System.out.println("Stores with minimum price for Laptop: " + service.findStoresWithMinimumPrice("Laptop"));
        System.out.println("Stores with all products cheaper than recommended price: " + service.findStoresWithAllProductsCheaper());
    }
}
