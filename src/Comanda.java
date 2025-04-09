import java.util.ArrayList;

public class Comanda {

    // Atributos que va a tener la clase comanda, en este caso la mesa, el precio final (que irá creciendo a medida que añadamos menús y un ArrayList que irá almacenando los menús que pide la mesa)
    private Mesas mesa;
    private ArrayList<Menus> cantidadMenus = new ArrayList();
    private double precioFinal;
    private int numeroComanda;


    // Creamos los métodos constructores
    public Comanda(Mesas mesa, ArrayList<Menus> cantidadMenus, double precioFinal, int numeroComanda) {
        this.mesa = mesa;
        this.cantidadMenus = cantidadMenus;
        this.precioFinal = precioFinal;
        this.numeroComanda = numeroComanda;
    }

    // Creamos los getter y los setter
    public Mesas getMesa() {
        return mesa;
    }

    public void setMesa(Mesas mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Menus> getCantidadMenus() {
        return cantidadMenus;
    }

    public void setCantidadMenus(ArrayList<Menus> cantidadMenus) {
        this.cantidadMenus = cantidadMenus;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    // Creamos el metodo toString
    @Override
    public String toString() {
        return "******* 🗒️Comanda de la mesa: " + mesa + " ********"
                + "\nMenús: \n" + cantidadMenus
                + "\n\nCoste total: " + precioFinal;
    }
}
