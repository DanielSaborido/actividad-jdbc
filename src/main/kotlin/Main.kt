import java.sql.Connection
import java.sql.DriverManager
import java.util.*


fun main() {
    val tabla = "productos"

    //Open a connection to the database
    DriverManager
        .getConnection("jdbc:derby:actividad;create=true")
        .use { connection ->
            prepareTable(connection, tabla)//crea la tabla (poner en comentarios si la tabla esta creada)
            insertItems(connection, tabla)//inserta los datos de la tabla (estar atento a las primary key y unique key, comentar si no ve va a insertar nada)
            queryRows(connection, tabla)//muestra los datos de la tabla
        }
}



