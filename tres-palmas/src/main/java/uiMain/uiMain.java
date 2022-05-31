package uiMain;

import gestorAplicacion.food.ClimateIngredient;
import gestorAplicacion.food.CoolIngredient;
import gestorAplicacion.food.Ingredient;
import gestorAplicacion.food.TypeIngredient;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Scanner;

public class uiMain implements Config {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(great);

        String menu = "m";
        String option = "";
        boolean loop = true;
        while (loop){

            while (menu.equals("m")){
                System.out.println(Config.menu);
                option = sc.nextLine();
                switch (option){
                    case "2":
                        System.out.println("Opción Seleccionada: " + option);
                        System.out.println("Por favor introduzca el NOMBRE o ID del ingrediente a reemplazar.");
                        String ing = sc.nextLine();
                        Ingredient replace = Ingredient.ingredientReplace(ing);
                        if ( replace == null){
                            System.out.println("El ingrediente ingresado no fue encontrado o es inválido");
                            break;
                        }
                        System.out.println("El ingrediente que reemplazará es " + replace.getName() + "\n" +
                                "Se encuentra ubicado en: " + replace.getStorage().getId());
                        break;
                    case "3":
                    case "4":
                    case "1":
                    case "5":
                        menu = "m" + option;
                        System.out.println("Opción Seleccionada: " + option);
                        break;
                    case "6":
                        loop = false;
                        menu = "Exit";
                        break;
                    default:
                        System.out.println("Opción Inválida.");
                }
            }

            while (menu.equals("m1")){
                System.out.println(menu1);
                option = sc.nextLine();
                switch (option){
                    case "1":
                        System.out.println("Los campos obligatorios van con (*)");
                        System.out.println("(*) Introduzca tipo: \n" +
                                "1) Frio \n" +
                                "2) Clima \nOpción:");
                        String type = sc.nextLine();
                        if (type.equals("1")) {
                            System.out.println("(*) Introduzca el Nombre:\n\tNombre: ");
                            String nombre = sc.nextLine();
                            System.out.println("Tipos comida:\n" +
                                    "1) No identificado\t2) Condimento\n" +
                                    "3) Carne\t4) Verdura\n" +
                                    "5) Fruta\t6) Lácteo");
                            System.out.println("(*) Introduzca el tipo:\n\tTipo: ");
                            int tipo = sc.nextInt();
                            System.out.println("Introduzca la temperatura -20°C a 20°C:\n\tTemperatura: °C");
                            int temperatura = sc.nextInt();
                            if (!(tipo <= 7 && tipo >= 1 && temperatura <= 20 && temperatura >= -20) || nombre == " " || nombre == "" || nombre == null){
                                System.out.println("Datos inválidos");
                                break;
                            }
                            TypeIngredient tipoIngrediente = TypeIngredient.DEFAULT;
                            switch (tipo){
                                case 1:
                                     tipoIngrediente = TypeIngredient.DEFAULT;
                                     break;
                                case 2:
                                    tipoIngrediente = TypeIngredient.CONDIMENTO;
                                    break;
                                case 3:
                                    tipoIngrediente = TypeIngredient.CARNE;
                                    break;
                                case 4:
                                    tipoIngrediente = TypeIngredient.VERDURA;
                                    break;
                                case 5:
                                    tipoIngrediente = TypeIngredient.FRUTA;
                                    break;
                                case 6:
                                    tipoIngrediente = TypeIngredient.LACTEO;
                                    break;
                            }
                            System.out.println("Introduzca la cantidad:\n\tCantidad: ");
                            int cantidad = sc.nextInt();
                            CoolIngredient b = new CoolIngredient(nombre, tipoIngrediente, temperatura, cantidad);
                            System.out.println("Se ha creado un Nuevo Ingrediente:\n\t" +
                                    b);
                        } else if (type.equals("2")) {
                            System.out.println("(*) Introduzca el Nombre:\n\tNombre: ");
                            String nombre = sc.nextLine();
                            System.out.println("Tipos comida:\n" +
                                    "1) No identificado\t2) Condimento\n" +
                                    "3) Carne\t4) Verdura\n" +
                                    "5) Fruta\t6) Lácteo");
                            System.out.println("(*) Introduzca el tipo:\n\tTipo: ");
                            int tipo = sc.nextInt();

                            if (!(tipo <= 7 && tipo >= 1) || nombre == " " || nombre == "" || nombre == null){
                                System.out.println("Datos inválidos");
                                break;
                            }
                            TypeIngredient tipoIngrediente = TypeIngredient.DEFAULT;
                            switch (tipo){
                                case 1:
                                    tipoIngrediente = TypeIngredient.DEFAULT;
                                    break;
                                case 2:
                                    tipoIngrediente = TypeIngredient.CONDIMENTO;
                                    break;
                                case 3:
                                    tipoIngrediente = TypeIngredient.CARNE;
                                    break;
                                case 4:
                                    tipoIngrediente = TypeIngredient.VERDURA;
                                    break;
                                case 5:
                                    tipoIngrediente = TypeIngredient.FRUTA;
                                    break;
                                case 6:
                                    tipoIngrediente = TypeIngredient.LACTEO;
                                    break;
                            }
                            System.out.println("Introduzca la cantidad:\n\tCantidad: ");
                            int cantidad = sc.nextInt();
                            ClimateIngredient b = new ClimateIngredient(nombre, tipoIngrediente, cantidad);
                            System.out.println("Se ha creado un Nuevo Ingrediente:\n\t" +
                                    b);
                        }
                        break;
                    case "2":
                    case "3":
                        menu = "m";
                        break;
                }
            }

        }
    }
}
