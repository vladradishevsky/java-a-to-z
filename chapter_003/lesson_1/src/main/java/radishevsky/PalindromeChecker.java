package radishevsky;

/**
 * PalindromeChecker предназначен для сортировки файлов по возрастанию
 * длины строки. Используется внешняя сортировка слиянием
 * @author vladradishevsky
 * @since 29.12.2016
 * @version 1.0
 */
public class PalindromeChecker {
    /**
     * Разрешенное количестсво букв в слове
     */
    private final int ALLOWED_LENGTH_OF_THE_WORD;

    /**
     * Конструкторы
     */
    public PalindromeChecker() {
        this.ALLOWED_LENGTH_OF_THE_WORD = 5;
    }
    public PalindromeChecker(int allowed_length_of_the_word) {
        this.ALLOWED_LENGTH_OF_THE_WORD = allowed_length_of_the_word;
    }
    /**
     * Проверяет, является ли слово из пяти букв, введённое пользователем, палиндромом
     * @param word слово для проверки
     * @return true, если слово палиндром, иначе false
     * @throws Exception если введено слово не из 5-ти (по умолчанию) букв
     */
    public boolean checkPalindrome(String word) throws Exception {

        if (word.length() != ALLOWED_LENGTH_OF_THE_WORD) throw new Exception(
                String.format("Word must consist of %s letters", this.ALLOWED_LENGTH_OF_THE_WORD)
        );

        boolean result = true;
        char[] charWord = word.toLowerCase().toCharArray();

        for (int index = 0; index < word.length() / 2; index++) {
            if (charWord[index] != charWord[charWord.length - 1 - index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
