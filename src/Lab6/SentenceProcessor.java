package Lab6;

public class SentenceProcessor {
    // Метод для обробки речення
    public static String processSentence(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Input sentence cannot be null");
        }

        // Розбиваємо речення на слова за допомогою регулярного виразу
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Перевіряємо, чи слово є повністю літерним
            if (word.matches("[a-zA-Z]+")) {
                result.append(word.toLowerCase());
            } else {
                // Якщо слово містить цифри чи інші символи, залишаємо його без змін
                result.append(word);
            }
            result.append(" "); // Додаємо пробіл між словами
        }

        // Видаляємо останній зайвий пробіл
        return result.toString().trim();
    }

    // Точка входу
    public static void main(String[] args) {
        // Приклади речень для тестування
        String[] testSentences = {
                "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago",
                "This Sentence Contains MIXED123 Letters and NUMBERS123",
                "Another Test123 with ALLCAPS"
        };

        for (String sentence : testSentences) {
            try {
                System.out.println("Original: " + sentence);
                String processed = processSentence(sentence);
                System.out.println("Processed: " + processed);
                System.out.println();
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
