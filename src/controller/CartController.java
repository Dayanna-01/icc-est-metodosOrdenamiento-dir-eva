package controller;

import models.Car;

public class CartController {

    public void sortByName(Car[] cars) {
        if (cars == null || cars.length <= 1) {
            return;
        }

        int n = cars.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compareTo(cars[j], cars[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Car minCar = cars[minIndex];
            while (minIndex > i) {
                cars[minIndex] = cars[minIndex - 1];
                minIndex--;
            }
            cars[i] = minCar;
        }
    }

    private int compareTo (Car car1, Car car2) {
        if (car1 == null && car2 == null) return 0;
        if (car1 == null) return 1;  
        if (car2 == null) return -1;

        String marca1 = car1.getBrand();
        String marca2 = car2.getBrand();

        if (marca1 == null && marca2 == null) return 0;
        if (marca1 == null) return 1;
        if (marca2 == null) return -1;

        int result = marca1.compareToIgnoreCase(marca2);

        return result;
    }
}
