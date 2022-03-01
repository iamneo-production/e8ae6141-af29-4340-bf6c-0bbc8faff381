package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import model.BlogList;
import service.VegetableDao;
 
class VegetableDaoTest {
     
    private static VegetableDao dao;
     
    @BeforeAll
    static void init() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new VegetableDao(conn);
    }
     
    @AfterAll
    static void teardown() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    void addListTest() {
        Vegetable list = new Vegetable();
        list.setVegetableName("carrot");
        list.setVegetableImageUrl("carrot.png");
		list.setVegetableQuatity(3);
        dao.addVegetable(list);
        Vegetable listFromDb = dao.viewVegetableById(1);
        assertEquals("carrot", listFromDb.getVegetableName(), "Vegetable Name must be equal");
    }
    
    @Test
    void deleteListTest() {
        dao.deleteVegetable(1);
        Vegetable listFromDb = dao.viewVegetableById(1);
        assertNull(listFromDb.getVegetableName(), "Vegetable should be null");
    }
    
    @Test
    void updateListTest() {
        Vegetable list = new Vegetable();
        list.setVegetableName("carrot");
        list.setVegetableImageUrl("carrot.png");
		list.setVegetableQuatity(3);
        dao.addVegetable(list);
        list.setVegetableName("beans");
        dao.updateVegetable(list);
        Vegetable listFromDb = dao.viewVegetableById(1);
        assertEquals("beans", listFromDb.getVegetableName(), "Vegetable Name must be equal");
    }
 
}