package com.tms.Homework_11_TMS;
import java.io.*;
import java.util.Scanner;
public class SortingFile {
    public static void main(String[] args)  {
        //Вводим с консоли путь ввода.
        System.out.println("Введите путь потока ввода: ");
        Scanner scanner= new Scanner(System.in);
        String path= scanner.nextLine();
        //Объявляем обекты классов BufferedWriter и  BufferedReader.
        try(BufferedReader fr=new BufferedReader(new FileReader(path));
        BufferedWriter outValid= new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\TMS_11_ HOMEWORK\\ValidDocumentNumbers.txt"));
        BufferedWriter outNotValid= new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\TMS_11_ HOMEWORK\\InvalidDocumentNumbers.txt"))) {
            String line;
            //Проверка номера документа на валидность.
            while ((line= fr.readLine()) != null) {
                if (line.length() == 15 && line.startsWith("docnum")) {

                    outValid.write(" Номер документа  - " + line);
                    outValid.write("\n");

                } else {
                    outNotValid.write(line+" Номер документа не валиден так не начинается с последовательности символов (docnum) или его длина (>) или (<) 15 символов - ");
                    outNotValid.write("\n");

                }

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

