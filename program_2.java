import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class program_2 {

    public static void Sort(int[] sortArr) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            for (int i = 0; i < sortArr.length - 1; i++) {
                for (int j = 0; j < sortArr.length - i - 1; j++) {
                    if (sortArr[j + 1] < sortArr[j]) {
                        int replace = sortArr[j];
                        sortArr[j] = sortArr[j + 1];
                        sortArr[j + 1] = replace;
                    }
                }

                writer.write((i + 1) + ": ");
                for (int k = 0; k < sortArr.length; k++) {
                    writer.write(sortArr[k] + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

    }



    public static void main(String[] args) {
        int[] arr = new int[] {8, 3, 9, 2, 1, 7, 4};
        Sort(arr);
    }
}
        
