import java.sql.Connection
import java.sql.DriverManager
import java.util.*

private const val TABLE = "products"

fun main() {

    //Open a connection to the database
    DriverManager
        .getConnection("jdbc:derby:actividad;create=true")
        .use { connection ->
            prepareTable(connection)//crea la tabla (poner en comentarios si la tabla esta creada)
            insertItems(connection)//inserta los datos de la tabla (estar atento a las primary key y unique key, comentar si no ve va a insertar nada)
            queryRows(connection)//muestra los datos de la tabla
        }
}

private fun queryRows(connection: Connection) {
    val sql = "SELECT * FROM $TABLE"
    val rs = connection.createStatement().executeQuery(sql)
    while (rs.next()) {
        println("ID: ${rs.getInt("ID")}\t" +
                "NAME: ${rs.getString("NAME")}\t" +
                "PRICE: ${rs.getFloat("PRICE")}€\t" +
                "DESCRIPTION: ${rs.getString("DESCRIPTION")}\t" +
                "BRAND: ${rs.getString("BRAND")}\t" +
                "CATEGORY: ${rs.getString("CATEGORY")}\t")
    }
}

private fun insertItems(connection: Connection) {
    insertRow(connection, 1, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, 2, "Smartphone", 99.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, 3, "Smartphone", 799.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, 4, "Smartphone", 899.99f, "The latest smartphone model", "Apple", "Electronics")
    insertRow(connection, 5, "Smartphone", 199.99f, "The latest smartphone model", "Apple", "Electronics")
}

private fun insertRow(connection: Connection, id: Int, name: String, price: Float, description: String, brand: String, category: String) {
    val sql = "INSERT INTO $TABLE VALUES ($id, '$name', $price, '$description', '$brand', '$category')"
    with(connection) {
        createStatement().execute(sql)
        commit()
    }
}

private fun prepareTable(connection: Connection) {
    val metaData = connection.metaData
    val rs = metaData.getTables(null, null, TABLE, null)

    if (!rs.next()) {
        createTable(connection)
    } else {
        truncateTable(connection)
    }
}

private fun truncateTable(connection: Connection) {
    val sql = "TRUNCATE TABLE $TABLE"
    with (connection) {
        createStatement().execute(sql)
        commit()
    }
}

private fun createTable(connection: Connection) {
    //SQL statement to create a table
    val sql = """
         CREATE TABLE $TABLE (
           id INT PRIMARY KEY,
           name VARCHAR(50),
           price FLOAT,
           description VARCHAR(100),
           brand VARCHAR(50),
           category VARCHAR(50))
        """.trimMargin()

    with(connection) {
        //Get and instance of statement from the connection and use
        //the execute() method to execute the sql
        createStatement().execute(sql)

        //Commit the change to the database
        commit()
    }
}