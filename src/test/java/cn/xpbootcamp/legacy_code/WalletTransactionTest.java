package cn.xpbootcamp.legacy_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

public class WalletTransactionTest {
    @Test
    void id_should_be_preAssignedId_if_it_not_null_and_empty() {
        WalletTransaction walletTransaction = new WalletTransaction("rig",anyLong(),anyLong(),anyLong(),anyString());
        assertEquals("t_rig", walletTransaction.getId());
    }
}
