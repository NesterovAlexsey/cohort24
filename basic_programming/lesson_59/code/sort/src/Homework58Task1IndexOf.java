import java.util.ArrayList;

public class Homework58Task1IndexOf {

  // Перепишите алгоритм бинарного поиска элемента в отсортированном по возрастанию списке
  // целых чисел (см. [урок 56, задача 2])) с использованием рекурсии.
  /**
   * Поиск числа target в списке numbers
   * @param numbers отсортированный по возрастанию список различных целых чисел
   * @param target число, которое необходимо найти
   * @return индекс числа target в списке numbers или -1, если число не найдено
   */
  public static int indexOf(ArrayList<Integer> numbers, int target) {
    // индексы left и right сделаем "как везде" - left включая, right - не включая
    return indexOf(numbers, target, 0, numbers.size());
  }

  private static int indexOf(ArrayList<Integer> numbers, int target, int left, int right) {
    if (left >= right - 1) { // условие выхода из рекурсии противоположно условию продолжения цикла
      // после окончания рекурсии right - left = 0 или 1, и проверяем мы numbers[left]
      if (left < numbers.size() && numbers.get(left) == target) {
        return left;
      }
      return -1; // сужение области поиска не дало нам target - его нет в списке
    }

    int mid = (left + right) / 2;
    if (numbers.get(mid) == target) {
      return mid;
    }
    if (numbers.get(mid) < target) {
      left = mid + 1;
    } else { // не = и не <
      right = mid; // потому что right - не включая
    }
    return indexOf(numbers, target, left, right);
  }
}
