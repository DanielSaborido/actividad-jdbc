import java.sql.Connection

//funcion para seleccionar todos los datos de una tabla y mostrarla
fun querySpeceficID(coneccion: Connection, tabla: String, ID: Int) {
    val sql = "SELECT * FROM $tabla WHERE ID = $ID"
    val rs = coneccion.createStatement().executeQuery(sql)
    while (rs.next()) {
        println("ID: ${rs.getInt("ID")}\t" +
                "Nombre: ${rs.getString("NAME")}\t" +
                "Precio: ${rs.getFloat("PRICE")}€\t" +
                "Descripcion: ${rs.getString("DESCRIPTION")}\t" +
                "Brand: ${rs.getString("BRAND")}\t" +
                "Categoria: ${rs.getString("CATEGORY")}\t")
    }
}