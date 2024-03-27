## BASE DE DATOS EN JAVA

`GenerateInfoFiles` incluye los siguientes métodos:

- `createSalesMenFile(int randomSalesCount, String name, long id)`: Crea un archivo pseudoaleatorio de ventas de un vendedor con el nombre y el ID especificados.
- `createProductsFile(int productsCount)`: Crea un archivo con información pseudoaleatoria de productos.
- `createSalesManInfoFile(int salesmanCount)`: Crea un archivo con información de vendedores generada de manera pseudoaleatoria.

Además, se utilizan métodos auxiliares para generar nombres, apellidos, tipos de documento, precios y cantidades aleatorios.

El método `main` se encarga de llamar a los métodos de generación de archivos con los parámetros especificados en el enunciado.

Al ejecutar esta clase, se generarán los siguientes archivos:

- Archivos de ventas de vendedores: "Ventas_[NombreVendedor]_[IdVendedor].txt"
- Archivo de productos: "Productos.txt"
- Archivo de información de vendedores: "Vendedores.txt"# proyecto
