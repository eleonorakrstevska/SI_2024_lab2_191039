import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {
    private List<Item> createItems(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
    @Test
    void BranchTesting(){

        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 30));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart( createItems(new Item("item1", "7893a", 80, 5)),200));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        assertTrue(SILab2.checkCart( createItems(new Item(null, "1234", 90, 0)),150));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart( createItems(new Item("item2", null, 120,40)),100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertFalse(SILab2.checkCart( createItems(new Item("item3", "04567", 360, 5)),240));
    }

    @Test
    void MCTesting(){
        RuntimeException ex;
        Item TTT=new Item("item1","0123", 420, 5);
        Item TTF=new Item("item2","567", 420, 5);
        Item TFX=new Item("item3","567", 420, -1);
        Item FXX=new Item("item4","0123", 240, -1);

        assertFalse(SILab2.checkCart( createItems(TTT),150));
        assertFalse(SILab2.checkCart( createItems(TTF),150));
        assertFalse(SILab2.checkCart( createItems(TFX),150));
        assertFalse(SILab2.checkCart( createItems(FXX),150));
    }
}
