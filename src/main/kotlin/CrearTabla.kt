import java.sql.Connection

fun prepareTable(connection: Connection, tabla: String) {
    val metaData = connection.metaData
    val rs = metaData.getTables(null, null, tabla, null)

    if (!rs.next()) {
        createTable(connection, tabla)
    } else {
        truncateTable(connection, tabla)
    }
}

private fun truncateTable(connection: Connection, tabla: String) {
    val sql = "TRUNCATE TABLE $tabla"
    with (connection) {
        createStatement().execute(sql)
        commit()
    }
}

private fun createTable(connection: Connection, tabla: String) {
    //SQL statement to create a table
    val sql = """
         CREATE TABLE $tabla (
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