import java.sql.Connection

fun insertItems(connection: Connection, tabla: String) {
    insertRow(connection, tabla, 1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, tabla, 2, "Smartphone", 99.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, tabla, 3, "Smartphone", 799.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, tabla, 4, "Smartphone", 899.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, tabla, 5, "Smartphone", 199.99f, "The latest smartphone model", "Apple", "Electronics")
}

private fun insertRow(connection: Connection, tabla: String, id: Int, name: String, price: Float, description: String, brand: String, category: String) {
    val sql = "INSERT INTO $tabla VALUES ($id, '$name', $price, '$description', '$brand', '$category')"
    with(connection) {
        createStatement().execute(sql)
        commit()
    }
}