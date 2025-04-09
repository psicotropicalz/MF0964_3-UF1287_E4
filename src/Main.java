import javax.swing.*;
import java.util.ArrayList;

/**
 * Diseñar en Java con POO en donde el Camarero de un Bar pueda  tomar notas de los Menús que se sirven.
 *
 * Tenemos el MENU1 MENU2 MENU3 MENU4 MENU5
 *
 * El camarero en el pedido indicará:
 * La mesa al que se hace referencia el pedido
 * Los menús que piden los clientes
 * El saldo del pedido
 * Y cuando lo soliciten los clientes, la cuenta a pagar.
 *
 * Recomendaciones: ENUM/ArraysList/Arrays para los productos, el que tu prefieras, POO, instanciar la clase Comandas con un Ejemplo. Comenta el código
 *
 * Valoración:
 * 2 puntos POO
 * 2 puntos ENUM- ArrayList-Arrays
 * 2 puntos instanciar correctamente la Clase
 * 1 puntos interfaces visuales (JOPTION )
 * 2 puntos Funciones y modularidad de la aplicación
 * 1 punto documentación
 */

public class Main {
    public static void main(String[] args) {
        navegacion();
    }

    private static void navegacion() {
        String opcionMenu, opcionComanda;
        Mesas mesa = null;
        Menus menu;
        double total = 0;
        boolean mesaAnotada = true;
        int mesasAtendidasT = 0;
        int numeroComanda = 1;
        ArrayList<Comanda> comandasDelServicio = new ArrayList<>();
        String nombre = JOptionPane.showInputDialog(null," *  Bienvenido  *\n\nIndica tu nombre:", "¡Bienvenido!", JOptionPane.INFORMATION_MESSAGE);
        Camarero pda1 = new Camarero(nombre, 0);
        do {
            opcionMenu = JOptionPane.showInputDialog(null,
                    "[1]-> Iniciar una comanda." +
                            "\n[2]-> Revisar comandas." +
                            "\n[3]-> Modificar una comanda." +
                            "\n[4]-> Sacar la cuenta de una comanda." +
                            "\n[5]-> Finalizar el servicio" +
                            "¿Qué quieres hacer?",
                    "Menú Principal", JOptionPane.INFORMATION_MESSAGE);
            switch (opcionMenu) {
                case "1" -> {
                    ArrayList<Menus> menusComanda = new ArrayList<>();
                    do {
                        String mesaOpc = JOptionPane.showInputDialog(null, "¿Qué mesa vas a atender?" +
                                "\n[1]-> Mesa 1" +
                                "\n[2]-> Mesa 2" +
                                "\n[3]-> Mesa 3",
                                "Indica la mesa", JOptionPane.INFORMATION_MESSAGE);
                        switch (mesaOpc) {
                            case "1" -> {
                                JOptionPane.showMessageDialog(null,"Mesa asignada correctamente", "Mesa asignada", JOptionPane.INFORMATION_MESSAGE);
                                mesa = Mesas.MESA1;
                            }
                            case "2" -> {
                                JOptionPane.showMessageDialog(null,"Mesa asignada correctamente", "Mesa asignada", JOptionPane.INFORMATION_MESSAGE);
                                mesa = Mesas.MESA2;
                            }
                            case "3" -> {
                                JOptionPane.showMessageDialog(null,"Mesa asignada correctamente", "Mesa asignada", JOptionPane.INFORMATION_MESSAGE);
                                mesa = Mesas.MESA3;
                            }
                            default -> {
                                mesaAnotada = false;
                                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } while (!mesaAnotada);

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
                            case "1" -> {
                                menu = Menus.MENU1;
                                JOptionPane.showMessageDialog(null, "Menú 1 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                                menusComanda.add(menu);
                                total += Menus.MENU1.getPrecio();
                            }
                            case "2" -> {
                                menu = Menus.MENU2;
                                JOptionPane.showMessageDialog(null, "Menú 2 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                                menusComanda.add(menu);
                                total += Menus.MENU2.getPrecio();
                            }
                            case "3" -> {
                                menu = Menus.MENU3;
                                JOptionPane.showMessageDialog(null, "Menú 3 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                                menusComanda.add(menu);
                                total += Menus.MENU3.getPrecio();
                            }
                            case "4" -> {
                                menu = Menus.MENU4;
                                JOptionPane.showMessageDialog(null, "Menú 4 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                                menusComanda.add(menu);
                                total += Menus.MENU4.getPrecio();
                            }
                            case "5" -> {
                                menu = Menus.MENU5;
                                JOptionPane.showMessageDialog(null, "Menú 5 añadido correctamente", "Oído cocina", JOptionPane.INFORMATION_MESSAGE);
                                menusComanda.add(menu);
                                total += Menus.MENU5.getPrecio();
                            }
                            case "6" -> {
                                JOptionPane.showMessageDialog(null, "Actualmente para la " + mesa + " has añadido la siguiente comanda:\n" + menusComanda.toString(), "Comanda actual", JOptionPane.INFORMATION_MESSAGE);
                            }
                            case "7" -> {
                                JOptionPane.showMessageDialog(null, "Enviando comanda a cocina...", "Enviando comanda", JOptionPane.INFORMATION_MESSAGE);
                                Comanda nuevaComanda = new Comanda(mesa,menusComanda,total,numeroComanda);
                                comandasDelServicio.add(nuevaComanda);
                                mesasAtendidasT++;
                                numeroComanda++;
                            }
                            default -> {
                                JOptionPane.showMessageDialog(null, "Opción no valida", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } while (!opcionComanda.equals("7"));

                }
                case "2" -> {
                    for (Comanda c : comandasDelServicio) {
                        JOptionPane.showMessageDialog(null,"Comanda número: " + c.getNumeroComanda() + "\nMesa: " + mesa + "\n" + c.toString(), "Revisando comandas...", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case "3" -> {
                    boolean comandaModValida = false;
                    int comandaMod = 0;
                    do {
                        String comandaModString = JOptionPane.showInputDialog(null, "¿Qué número de comanda quieres modificar?", "Modificar comanda", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            comandaMod = Integer.parseInt(comandaModString);
                            comandaModValida = true;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error al modificar el comanda. Debes indicar el número de la comanda", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (!comandaModValida);
                    --comandaMod;
                    JOptionPane.showMessageDialog(null, "La comanda es la siguiente: \n" + comandasDelServicio.get(comandaMod));

                }
                case "4" -> {
                    boolean cuentaComandaValida = false;
                    int cuentaComandaIndex = 0;
                    do {
                        String cuentaComandaString = JOptionPane.showInputDialog(null, "¿Quieres sacar la cuenta de la comanda número...?", "Sacar Cuenta", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            cuentaComandaIndex = Integer.parseInt(cuentaComandaString);
                            cuentaComandaValida = true;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error al modificar el comanda. Debes indicar el número de la comanda", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (!cuentaComandaValida);
                    --cuentaComandaIndex;
                    JOptionPane.showMessageDialog(null, "La comanda es la siguiente: " + comandasDelServicio.get(cuentaComandaIndex));
                }
                case "5" -> {
                    pda1.setMesasAtendidas(mesasAtendidasT);
                    JOptionPane.showMessageDialog(null,"***** Servicio finalizado por " + pda1.getNombre() + " *****" +
                            "\nHas atendido con éxito: " + pda1.getMesasAtendidas() + " mesas.", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opción no valida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (!opcionMenu.equals("5"));
    }
}