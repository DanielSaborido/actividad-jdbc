import java.sql.Connection

//cuando se llama a esta funcion llama a todos datos que se vayan a añadir
fun insertItems(coneccion: Connection, tabla: String) {
    insertRow(coneccion, tabla, 1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(coneccion, tabla, 2, "Smartphone", 99.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(coneccion, tabla, 3, "Smartphone", 799.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(coneccion, tabla, 4, "Smartphone", 899.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(coneccion, tabla, 5, "Smartphone", 199.99f, "The latest smartphone model", "Apple", "Electronics")
}

//funcion para insertar un unico dato
private fun insertRow(coneccion: Connection, tabla: String, id: Int, name: String, price: Float, description: String, brand: String, category: String) {
    val sql = "INSERT INTO $tabla VALUES ($id, '$name', $price, '$description', '$brand', '$category')"
    with(coneccion) {
        createStatement().execute(sql)
        commit()
    }
}