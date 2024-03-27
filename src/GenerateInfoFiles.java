import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {
    private static final String[] NOMBRES = {"Juan", "María", "Pedro", "Luisa", "Carlos", "Ana", "Luis", "Laura", "Diego", "Marta"};
    private static final String[] APELLIDOS = {"González", "Rodríguez", "López", "Martínez", "Hernández", "Pérez", "Sánchez", "Ramírez", "Díaz", "Fernández"};
    private static final String[] PRODUCTOS = {"Producto1", "Producto2", "Producto3", "Producto4", "Producto5", "Producto6", "Producto7", "Producto8", "Producto9", "Producto10"};
    private static final String[] TIPOS_DOCUMENTO = {"CC", "TI", "CE", "PP"};
    private static final int MIN_PRECIO = 1000;
    private static final int MAX_PRECIO = 10000;
    private static final int MIN_CANTIDAD = 1;
    private static final int MAX_CANTIDAD = 10;

    public static void main(String[] args) {
        int randomSalesCount = 5;
        int productsCount = 10;
        int salesmanCount = 5;

        try {
            for (int i = 1; i <= salesmanCount; i++) {
                String name = generateRandomName();
                long id = generateRandomId();
                createSalesMenFile(randomSalesCount, name, id);
            }

            createProductsFile(productsCount);
            createSalesManInfoFile(salesmanCount);

            System.out.println("Archivos generados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar los archivos: " + e.getMessage());
        }
    }

    private static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        String filename = "Ventas_" + name + "_" + id + ".txt";
        FileWriter writer = new FileWriter(filename);

        String tipoDocumento = getRandomTipoDocumento();
        writer.write(tipoDocumento + ";" + id + "\n");

        for (int i = 0; i < randomSalesCount; i++) {
            String idProducto = "Producto" + (i + 1);
            int cantidad = getRandomCantidad();
            writer.write(idProducto + ";" + cantidad + ";\n");
        }

        writer.close();
    }

    private static void createProductsFile(int productsCount) throws IOException {
        FileWriter writer = new FileWriter("Productos.txt");

        for (int i = 0; i < productsCount; i++) {
            String idProducto = "Producto" + (i + 1);
            String nombreProducto = PRODUCTOS[i];
            int precioProducto = getRandomPrecio();
            writer.write(idProducto + ";" + nombreProducto + ";" + precioProducto + "\n");
        }

        writer.close();
    }

    private static void createSalesManInfoFile(int salesmanCount) throws IOException {
        FileWriter writer = new FileWriter("Vendedores.txt");

        for (int i = 0; i < salesmanCount; i++) {
            String tipoDocumento = getRandomTipoDocumento();
            long numeroDocumento = generateRandomId();
            String nombres = generateRandomName();
            String apellidos = generateRandomLastName();
            writer.write(tipoDocumento + ";" + numeroDocumento + ";" + nombres + ";" + apellidos + "\n");
        }

        writer.close();
    }

    private static String generateRandomName() {
        Random random = new Random();
        return NOMBRES[random.nextInt(NOMBRES.length)];
    }

    private static String generateRandomLastName() {
        Random random = new Random();
        return APELLIDOS[random.nextInt(APELLIDOS.length)];
    }

    private static long generateRandomId() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }

    private static String getRandomTipoDocumento() {
        Random random = new Random();
        return TIPOS_DOCUMENTO[random.nextInt(TIPOS_DOCUMENTO.length)];
    }

    private static int getRandomPrecio() {
        Random random = new Random();
        return random.nextInt(MAX_PRECIO - MIN_PRECIO + 1) + MIN_PRECIO;
    }

    private static int getRandomCantidad() {
        Random random = new Random();
        return random.nextInt(MAX_CANTIDAD - MIN_CANTIDAD + 1) + MIN_CANTIDAD;
    }
}
