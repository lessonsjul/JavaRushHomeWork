package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        byte[][] b = new byte[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0}
        };

        byte[][] c = new byte[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1}
        };
        int counta = getRectangleCount(a);
        int countb = getRectangleCount(b);
        int countc = getRectangleCount(c);
        System.out.println("count = " + counta + ". Должно быть 1");
        System.out.println("count = " + countb + ". Должно быть 3");
        System.out.println("count = " + countc + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        List<Rectangle> rectangleList = new ArrayList<>();

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                Rectangle rec = new Rectangle();
                rec.setStartPosition(new int[]{i, j});
                if(a[i][j] == 1) {
                    int endX = i;
                    int endY = j;

                    while (endX != a.length && a[endX][j] == 1) ++endX;
                    endX = endX - 1;
                    while (endY != a[endX].length && a[endX][endY] == 1) ++endY;
                    endY = endY - 1;
                    for(int k = i; k <= endX; k++){
                        for(int m = j; m <= endY; m++){
                            a[k][m] = 0;
                        }
                    }

                    rec.setEndPosition(new int[]{endX, endY});
                    rectangleList.add(rec);
                    i = rec.getStartPosition()[0];
                    j = rec.getEndPosition()[1];
                }
            }
        }
        return rectangleList.size();
    }

    public static class Rectangle{
        int[] startPosition;
        int[] endPosition;

        public int[] getStartPosition()
        {
            return startPosition;
        }

        public int[] getEndPosition()
        {
            return endPosition;
        }

        public void setEndPosition(int[] endPosition)
        {
            this.endPosition = endPosition;
        }

        public void setStartPosition(int[] startPosition)
        {
            this.startPosition = startPosition;
        }
    }
}
