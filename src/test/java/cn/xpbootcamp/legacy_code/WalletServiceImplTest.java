package cn.xpbootcamp.legacy_code;

import cn.xpbootcamp.legacy_code.entity.User;
import cn.xpbootcamp.legacy_code.repository.UserRepository;
import cn.xpbootcamp.legacy_code.service.WalletServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WalletServiceImplTest {

    private User user = new User();

    @BeforeEach
    void setUp() {
        user.setBalance(1.0);
    }

    @Test
    void should_return_null_if_buyer_balance_greater_than_amount() {
        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.find(0)).thenReturn(user);
        WalletServiceImpl walletService = new WalletServiceImpl(userRepositoryMock);
        String actual = walletService.moveMoney(anyString(),0,0,1.1);
        assertNull(actual);
    }

    @Test
    void should_contain_id_in_uuid() {
        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.find(0)).thenReturn(user);
        WalletServiceImpl walletService = new WalletServiceImpl(userRepositoryMock);
        String actual = walletService.moveMoney("special_id",0,0,1.0);
        assertTrue(actual.contains("special_id"));
    }
}
