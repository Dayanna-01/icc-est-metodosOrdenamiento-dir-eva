package test;

import models.Car;
import validaciones.Validators;
import org.junit.jupiter.api.Test;

import controller.CartController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class CartControllerTest {

    private CartController controller;

    @BeforeEach
    public void setUp() {
        controller = new CartController();
    }

    public static Car[] makeCarsList() {
        Car[] cars = new Car[20];

        cars[0] = new Car("Toyota", 2020);
        cars[1] = new Car("TOYOTA", 2018);
        cars[2] = new Car("toyota", 2022);
        cars[3] = new Car("Honda", 2019);
        cars[4] = new Car("HONDA", 2021);
        cars[5] = new Car("honda", 2017);
        cars[6] = new Car("Ford", 2023);
        cars[7] = new Car("FORD", 2016);
        cars[8] = new Car("ford", 2020);
        cars[9] = new Car("BMW", 2022);
        cars[10] = new Car("bmw", 2019);
        cars[11] = new Car("Mercedes-Benz", 2021);
        cars[12] = new Car("MERCEDES-BENZ", 2018);
        cars[13] = new Car("mercedes-benz", 2023);
        cars[14] = new Car("Audi", 2020);
        cars[15] = new Car("AUDI", 2017);
        cars[16] = new Car("audi", 2022);
        cars[17] = new Car("Nissan-Sentra", 2019);
        cars[18] = new Car("NISSAN-SENTRA", 2021);
        cars[19] = new Car("nissan-sentra", 2018);

        return cars;
    }

    @Test
    @DisplayName("Prueba ordenamiento básico por nombre")
    public void testOrdenamientoBasico() {
        Car[] original = makeCarsList();
        Car[] paraOrdenar = Validators.copiarArreglo(List.of(original));

        // El estudiante debe implementar este método
        controller.sortByName(paraOrdenar);

        // Validar que el ordenamiento sea correcto
        Validators.validarOrdenamientoPorNombre(original, paraOrdenar);
        Validators.validarCasosEspeciales(paraOrdenar);
    }

    @Test
    @DisplayName("Prueba con nombres con mayúsculas y minúsculas")
    public void testCaseSensitive() {
        Car[] original = makeCarsList();

        Car[] paraOrdenar = Validators.copiarArreglo(List.of(original));

        controller.sortByName(paraOrdenar);

        Validators.validarOrdenamientoPorNombre(original, paraOrdenar);
        Validators.validarCasosEspeciales(paraOrdenar);
    }

    @Test
    @DisplayName("Prueba con nombres con espacios y caracteres especiales")
    public void testNombresEspeciales() {
        Car[] original = makeCarsList();

        Car[] paraOrdenar = Validators.copiarArreglo(List.of(original));

        controller.sortByName(paraOrdenar);

        Validators.validarOrdenamientoPorNombre(original, paraOrdenar);
        Validators.validarCasosEspeciales(paraOrdenar);
    }
}
