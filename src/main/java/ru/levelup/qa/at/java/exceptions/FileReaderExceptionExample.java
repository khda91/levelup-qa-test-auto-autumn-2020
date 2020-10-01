package ru.levelup.qa.at.java.exceptions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderExceptionExample {

    public static void main(String[] args) {
        System.out.println(getFileContent("src/main/resources/sample.txt"));
        System.out.println(getFileContent(""));
        System.out.println(getFileContent(null));

        System.out.println("Everything is going well");
    }

    static List<String> getFileContent(String fileName) {//throws TestDataException {
        if (fileName == null || fileName.isEmpty()) {
            throw new TestDataException(String.format("Имя файла не может быть null или пустым. fileName: %s", fileName));
        }
        BufferedReader br = null;
        List<String> result = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileName));

            String str = null;
            while ((str = br.readLine()) != null) {
                result.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Catch FileNotFoundException");
            System.err.println("Упс, файл не наден");
        } catch (IOException e) {
            System.out.println("Catch IOException");
            e.printStackTrace();
        }
        // Плохое решение для работы с непроверяемыми исключениями
//        catch (NullPointerException e) {
//            System.err.println("Кто-то прислал null!!! Ай-йя-яй! Ай-йя-яй!");
//        }
        finally {
            System.out.println("Finally");
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
