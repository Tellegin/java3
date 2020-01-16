package com.tsystems.javaschool.tasks.subsequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        //Создаем итераторы для наших списков
        checkForNull(x);
        checkForNull(y);
        Iterator firstIterator = x.iterator();
        Iterator secondIterator = y.iterator();
        //Создаем переменные хранящие первые значения из наших итераторов
        Object fNext = new Object();
        if (firstIterator.hasNext()) {
            fNext = firstIterator.next();
        }
        Object sNext = new Object();
        if (secondIterator.hasNext()) {
            sNext = secondIterator.next();
        }
        int counter = 0;
        //Пока наш второй итератор имеет следующее значение продолжай цикл
        while (secondIterator.hasNext()) {
            if (sNext.equals(fNext)) {
                if (firstIterator.hasNext()) {
                    fNext = firstIterator.next();
                } else {
                    sNext = secondIterator.next();
                }
                counter++;
                //Иначе
            } else {
                //Переменная sNext хранит следующее значение
                sNext = secondIterator.next();
            }

        }

        //Так как наш итератор secondIterator достиг предела придется проверить последнее сохраненное значение
        if (sNext.equals(fNext)) {
            //И добавить в список если условие выполняется
            counter++;
        }
        //Если списки совпадают, то возвращаем true
        return x.size() == counter;
    }

    private void checkForNull(List checkedList) {
        if (checkedList == null) {
            throw new IllegalArgumentException();
        }
    }
}
