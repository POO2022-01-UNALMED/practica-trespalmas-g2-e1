package uiMain;

import gestorAplicacion.food.ClimateIngredient;
import gestorAplicacion.food.CoolIngredient;
import gestorAplicacion.food.Ingredient;
import gestorAplicacion.food.TypeIngredient;
import gestorAplicacion.store.Store;

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
                        Ingredient ingredienteReemplazar = Ingredient.getIngredientById(ing);
                        Ingredient reemplazo = Ingredient.ingredientReplace(ing);
                        if ( reemplazo == null || ingredienteReemplazar == null){
                            System.out.println("El ingrediente ingresado no fue encontrado o es inválido");
                            break;
                        }
                        System.out.println("ID Antiguo\t\tNombre Antiguo\t\tUbicación Antiguo");
                        System.out.println(ingredienteReemplazar.getId() + "\t" + ingredienteReemplazar.getName() + "\t" + ingredienteReemplazar.getStorage().getId());
                        System.out.println("ID Nuevo\t\tNombre Nuevo\t\tUbicación Nuevo");
                        System.out.println(reemplazo.getId() + "\t" + reemplazo.getName() + "\t" + reemplazo.getStorage().getId());
                        break;
                    case "3":
                        System.out.println("Ficha Organizar Bodega:");
                        System.out.println("ID\t\tNombre\t\tAntiguo Almacenamiento\t\t" +
                                "Nuevo Almacenamiento\t\tCantidad");
                        for (Ingredient ingredient:
                             Ingredient.getAllIngredients()) {
                            String antiguaUbicacion = ingredient.getStorage().getId();
                            for (Store store:
                                 Store.getAllStores()) {
                                if (ingredient.isValidStore(store)){
                                    break;
                                }
                            }
                            System.out.println(ingredient.getId() + "\t\t" +
                                    ingredient.getName() + "\t\t" +
                                    antiguaUbicacion + "\t\t" +
                                    ingredient.getStorage().getId() + "\t\t" +
                                    ingredient.getAmount());
                        }
                        break;
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
                        System.out.println("ID\t\tUbicación\t\tIngrediente\t\tCantidad");
                        for (Ingredient ingredient:
                             Ingredient.getAllIngredients()) {
                            System.out.println(ingredient.getId() + "\t\t" +
                                    ingredient.getStorage().getId() + "\t\t"+
                                    ingredient.getName()+ "\t\t"+
                                    ingredient.getAmount());
                        }
                        System.out.println("Por favor introduzca la ID del elemento a añadir.\n\tID: ");
                        String id = sc.nextLine();
                        Ingredient ingrediente = Ingredient.getIngredientById(id);
                        if(ingrediente == null){
                            System.out.println("ID ingresada inválida");
                            break;
                        }
                        System.out.println("Por favor introduzca la cantidad a añadir.\n\tCantidad: ");
                        int cantidad = sc.nextInt();
                        if( !ingrediente.addIngredient(cantidad) ){
                            System.out.println("No se ha añadido la cantidad solicitada, por favor verifique el espacio libre.");
                            break;
                        }
                        System.out.println("Se ha añadido una cantidad de " +
                                cantidad + " " + ingrediente.getName());
                        break;
                    case "3":
                        break;
                    case "5":
                        menu = "m";
                        break;
                }
            }

        }
    }
}
