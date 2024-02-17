public abstract class Empleado {
    private String nombre;
    private String id;

    public Empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String getTipo();

    public String getId() {
        return id;
    }

    public abstract double calcularSueldo();

    public String getInfo() {
        return "Nombre: " + nombre + "\nID: " + id + "\nTipo: " + getTipo() + "\nSueldo: $" + calcularSueldo();
    }
}

class Diseñador extends Empleado {
    private int cantidadDiseños;
    private double comisionPorDiseño;

    public Diseñador(String nombre, String id, int cantidadDiseños, double comisionPorDiseño) {
        super(nombre, id);
        this.cantidadDiseños = cantidadDiseños;
        this.comisionPorDiseño = comisionPorDiseño;
    }

    public int getCantidadDiseños() {
        return cantidadDiseños;
    }

    public double getComisionPorDiseño() {
        return comisionPorDiseño;
    }

    @Override
    public String getTipo() {
        return "Diseñador";
    }

    @Override
    public double calcularSueldo() {
        // Calcula el sueldo del diseñador: sueldo base + (comisión por diseño * cantidad de diseños)
        return 1000 + (comisionPorDiseño * cantidadDiseños);
    }
}

class Produccion extends Empleado {
    private int cantidadEnsamblajes;
    private double comisionPorEnsamblaje;

    public Produccion(String nombre, String id, int cantidadEnsamblajes, double comisionPorEnsamblaje) {
        super(nombre, id);
        this.cantidadEnsamblajes = cantidadEnsamblajes;
        this.comisionPorEnsamblaje = comisionPorEnsamblaje;
    }

    public int getCantidadEnsamblajes() {
        return cantidadEnsamblajes;
    }

    public double getComisionPorEnsamblaje() {
        return comisionPorEnsamblaje;
    }

    @Override
    public String getTipo() {
        return "Producción";
    }

    @Override
    public double calcularSueldo() {
        // Calcula el sueldo del personal de producción: sueldo base + (comisión por ensamblaje * cantidad de ensamblajes)
        return 800 + (comisionPorEnsamblaje * cantidadEnsamblajes);
    }
}