import java.sql.Connection

fun prepareTable(coneccion: Connection, tabla: String) {
    val metaData = coneccion.metaData
    val rs = metaData.getTables(null, null, tabla, null)
    if (!rs.next()) {
        createTable(coneccion, tabla)
    } else {
        truncateTable(coneccion, tabla)
    }
}

private fun truncateTable(coneccion: Connection, tabla: String) {
    val sql = "TRUNCATE TABLE $tabla"
    with (coneccion) {
        createStatement().execute(sql)
        commit()
    }
}

private fun createTable(coneccion: Connection, tabla: String) {
    //declaracion de SQL para crear una tabla
    val sql = """
         CREATE TABLE $tabla (
           id INT PRIMARY KEY,
           name VARCHAR(50),
           price FLOAT,
           description VARCHAR(100),
           brand VARCHAR(50),
           category VARCHAR(50))
        """.trimMargin()

    with(coneccion) {
        createStatement().execute(sql)
        commit()
    }
}