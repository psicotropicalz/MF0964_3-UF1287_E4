import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Iniciamos el flujo principal de navegación del programa
        navegacion();
    }

    /**
     * Metodo que gestiona el menú principal de la aplicación y permite al camarero realizar diversas acciones como crear comandas, revisarlas, sacar cuentas y finalizar el servicio.
     */
    private static void navegacion() {
        String opcionMenu, opcionComanda;
        Mesas mesa = null; // Mesa actual a la que atiende
        Menus menu;
        double total = 0; // Total de la cuenta por comanda
        boolean mesaAnotada = true; // Control para validar la selección de la mesa
        int mesasAtendidasT = 0; // Contador de mesas atendidas
        int numeroComanda = 1; // Identificador único para cada comanda
        ArrayList<Comanda> comandasDelServicio = new ArrayList<>(); // Lista de comandas realizadas

        // Se solicita el nombre del camarero
        String nombre = JOptionPane.showInputDialog(null, " *  Bienvenido  *\n\nIndica tu nombre:", "¡Bienvenido!", JOptionPane.INFORMATION_MESSAGE);
        Camarero pda1 = new Camarero(nombre, 0); // Se crea una instancia del camarero

        // Bucle principal del menú
        do {
            // Menú principal de opciones
            opcionMenu = JOptionPane.showInputDialog(null,
                    "[1]-> Iniciar una comanda." +
                            "\n[2]-> Revisar comandas." +
                            "\n[3]-> Sacar la cuenta de una comanda." +
                            "\n[4]-> Finalizar el servicio" +
                            "\n¿Qué quieres hacer?",
                    "Menú Principal", JOptionPane.INFORMATION_MESSAGE);

            // Procesamos la opción seleccionada
            switch (opcionMenu) {
                case "1" -> {
                    // Lista temporal para guardar los menús de esta comanda
                    ArrayList<Menus> menusComanda = new ArrayList<>();

                    // Selección de mesa
                    do {
                        String mesaOpc = JOptionPane.showInputDialog(null, "¿Qué mesa vas a atender?" +
                                "\n[1]-> Mesa 1" +
                                "\n[2]-> Mesa 2" +
                                "\n[3]-> Mesa 3", "Indica la mesa", JOptionPane.INFORMATION_MESSAGE);
                        switch (mesaOpc) {
                            case "1" -> {
                                mesaAnotada = true;
                                mesa = Mesas.MESA1;
                                JOptionPane.showMessageDialog(null,"Mesa asignada correctamente", "Mesa asignada", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "2" -> {
                                mesaAnotada = true;
                                mesa = Mesas.MESA2;
                                JOptionPane.showMessageDialog(null,"Mesa asignada correctamente", "Mesa asignada", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "3" -> {
                                mesaAnotada = true;
                                mesa = Mesas.MESA3;
                                JOptionPane.showMessageDialog(null,"Mesa asignada correctamente", "Mesa asignada", JOptionPane.INFORMATION_MESSAGE);
                            }
                            default -> {
                                mesaAnotada = false;
                                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } while (!mesaAnotada);

                    // Selección de menús para la comanda de esta mesa
                    do {
                        opcionComanda = JOptionPane.showInputDialog(null, "¿Qué menús van a tomar?" +
                                "\n[1]-> Menú 1" +
                                "\n[2]-> Menú 2" +
                                "\n[3]-> Menú 3" +
                                "\n[4]-> Menú 4" +
                                "\n[5]-> Menú 5" +
                                "\n[6]-> Revisar comanda" +
                                "\n[7]-> Enviar comanda", "Indica la comanda", JOptionPane.INFORMATION_MESSAGE);
                        switch (opcionComanda) {
                            // Cada opción añade un menú y actualiza el total
                            case "1" -> {
                                menu = Menus.MENU1;
                                menusComanda.add(menu);
                                total += menu.getPrecio();
                                JOptionPane.showMessageDialog(null, "Menú 1 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "2" -> {
                                menu = Menus.MENU2;
                                menusComanda.add(menu);
                                total += menu.getPrecio();
                                JOptionPane.showMessageDialog(null, "Menú 2 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "3" -> {
                                menu = Menus.MENU3;
                                menusComanda.add(menu);
                                total += menu.getPrecio();
                                JOptionPane.showMessageDialog(null, "Menú 3 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "4" -> {
                                menu = Menus.MENU4;
                                menusComanda.add(menu);
                                total += menu.getPrecio();
                                JOptionPane.showMessageDialog(null, "Menú 4 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "5" -> {
                                menu = Menus.MENU5;
                                menusComanda.add(menu);
                                total += menu.getPrecio();
                                JOptionPane.showMessageDialog(null, "Menú 5 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "6" -> {
                                // Muestra la lista de menús agregados hasta el momento
                                JOptionPane.showMessageDialog(null, "Actualmente para la " + mesa + " has añadido la siguiente comanda:\n" + menusComanda.toString(), "Comanda actual", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "7" -> {
                                // Finaliza y guarda la comanda
                                Comanda nuevaComanda = new Comanda(mesa, menusComanda, total, numeroComanda);
                                comandasDelServicio.add(nuevaComanda);
                                JOptionPane.showMessageDialog(null, "Enviando comanda a cocina...", "Enviando comanda", JOptionPane.INFORMATION_MESSAGE);
                                mesasAtendidasT++;
                                numeroComanda++;
                            }
                            default -> {
                                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } while (!opcionComanda.equals("7"));
                }
                case "2" -> {
                    // Revisar todas las comandas registradas
                    for (Comanda c : comandasDelServicio) {
                        JOptionPane.showMessageDialog(null,"Comanda número: " + c.getNumeroComanda() + "\nMesa: " + mesa + "\n" + c.toString(), "Revisando comandas...", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case "3" -> {
                    // Sacar la cuenta de una comanda en específico
                    boolean cuentaComandaValida = false;
                    int cuentaComandaIndex = 0;
                    do {
                        String cuentaComandaString = JOptionPane.showInputDialog(null, "¿Quieres sacar la cuenta de la comanda número...?", "Sacar Cuenta", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            cuentaComandaIndex = Integer.parseInt(cuentaComandaString);
                            cuentaComandaValida = true;
                        } catch (Exception e) {
                            cuentaComandaValida = false;
                            JOptionPane.showMessageDialog(null, "Error al modificar el comanda. Debes indicar el número de la comanda", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (!cuentaComandaValida);
                        --cuentaComandaIndex;
                        JOptionPane.showMessageDialog(null, "La comanda es la siguiente: \n" + comandasDelServicio.get(cuentaComandaIndex));
                }
                case "4" -> {
                    // Finalizar servicio y mostrar resumen del mismo
                    pda1.setMesasAtendidas(mesasAtendidasT);
                    JOptionPane.showMessageDialog(null,"***** Servicio finalizado por " + pda1.getNombre() + " *****" +
                            "\nHas atendido con éxito: " + pda1.getMesasAtendidas() + " mesas.", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (!opcionMenu.equals("4"));
    }
}
