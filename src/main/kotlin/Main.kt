import java.sql.DriverManager


fun main() {
    val tabla = "products"
    //abre la coneccion de la base de datos
    DriverManager
        .getConnection("jdbc:derby:actividad;create=true")
        .use { coneccion ->
            prepareTable(coneccion, tabla)//crea la tabla (poner en comentarios si la tabla esta creada)
            insertItems(coneccion, tabla)//inserta los datos de la tabla (estar atento a las primary key y unique key, comentar si no ve va a insertar nada)
            queryRows(coneccion, tabla)//muestra los datos de la tabla
            querySpeceficID(coneccion, tabla, 1)//muestra los datos de la tabla donde la ID sea igual a la ID introducida
        }
}



