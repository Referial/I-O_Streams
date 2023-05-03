import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Мясо", "Рис"};
        int[] prices = {64, 25, 170, 90};
        System.out.println("Список возможных товаров для покупки");

        Basket basket = new Basket(products,prices);

        int n = 1;
        for (int i = 0; i < products.length; i++) {
            System.out.println(n + " " + products[i] + " " + prices[i] + " руб.");
            n++;
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите 'end'");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
               basket.printCart();
                break;
            }

            try {
                String parts[] = input.split(" ");

                int productNumber = Integer.parseInt(parts[0]) - 1;

                if (parts.length != 2) {
                    System.out.println("Нужно выбрать товар и ввести его количество, вы ввели: " + input);
                    continue;
                }

                int productCount = Integer.parseInt(parts[1]);

                basket.addToCart(productNumber, productCount);

            }catch (NumberFormatException e){
                System.out.println("Ошибка, некоректный ввод.");
                continue;
            }
        }
    }
}