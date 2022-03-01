package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
import java.sql.Connection;
 
import org.junit.jupiter.api.Test;
 
class ConnectionTest {
 
    @Test 
    void getConnectionTest() {
        Connection dbConnection = ConnectionManager.getConnection();
        assertNotNull(dbConnection, "connection should be successfull.");
 
    }
}