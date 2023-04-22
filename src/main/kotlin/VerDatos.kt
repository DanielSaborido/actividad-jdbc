import java.sql.Connection

fun queryRows(connection: Connection, tabla: String) {
    val sql = "SELECT * FROM $tabla"
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