public enum Menus {
    MENU1(20.5), MENU2(22.5), MENU3(23.5), MENU4(24.5), MENU5(25);

    private final double precio;

    Menus(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}