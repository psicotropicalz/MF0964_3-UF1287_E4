public class Camarero {
    // Creamos una clase camarero que tendrá como atributos el nombre del camarero (que se solicitará al iniciar el programa) y la cantidad de mesas que ha atendido durante el servicio.
    private String nombre;
    private int mesasAtendidas;

    // Declaramos el constructor del objeto camarero
    public Camarero(String nombre, int mesasAtendidas) {
        this.nombre = nombre;
        this.mesasAtendidas = mesasAtendidas;
    }

    // getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesasAtendidas() {
        return mesasAtendidas;
    }

    public void setMesasAtendidas(int mesasAtendidas) {
        this.mesasAtendidas = mesasAtendidas;
    }

    @Override
    public String toString() {
        return "🚶‍♂️Camarero:" +
                "\nNombre: " + nombre +
                "Mesas Atendidas:" + mesasAtendidas;
    }
}
