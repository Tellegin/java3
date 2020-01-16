package com.tsystems.javaschool.tasks.pyramid;

import java.util.*;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        try {
            checkForNull(inputNumbers);
            //Сортируем массив по возрастанию
            Collections.sort(inputNumbers);
            //Вычисляем колличество строк нашей пирамиды
            //---------------------------------
            int n = inputNumbers.size();
            int idx = 0;
            int numRows = 0;

            while (idx < n) {
                numRows++;
                for (int numInRow = 0; numInRow < numRows; numInRow++) {
                    idx++;
                }
            }
            //---------------------------------
            //Создаем список для хранения линий
            int[][] array = new int[numRows][numRows * 2 - 1];
            //Счетчик номера строки
            int rowCount = 0;
            //Счетчик аргумента нашего массива
            int arrCounter = 0;


            //Запускаем цикл чтобы заполнить список для каждой линии
            for (int i = numRows; i > 0; i--) {
                int counter = 0;
                //Создаем список для хранения данных на нашей линии
                //Заполняем нулями "до"
                for (int j = 1; j < i; j++) {
                    array[rowCount][counter] = 0;
                    counter++;
                }
                //Заполняем список числами из списка arr, добавляем нули и увеличиваем счетчик
                for (int j = 0; j <= rowCount; j++) {
                    array[rowCount][counter] = inputNumbers.get(arrCounter);
                    counter = counter + 2;
                    arrCounter++;
                }
                //Инкрементируем счетчик номера строки
                rowCount++;
            }
            return array;
            //Если мы вышли за пределы массива и не можем построить пирамиду выбрасываем ошибку
        } catch (Throwable e) {
            throw new CannotBuildPyramidException();
        }
    }

    private void checkForNull(List<Integer> checkedList) {
        if (checkedList.stream().anyMatch(Objects::isNull)) {
            throw new CannotBuildPyramidException();
        }
    }
}
