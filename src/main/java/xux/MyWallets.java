package src.main.java.xux.wallets.interfaces;

import java.math.BigDecimal;
import java.util.Map;

public interface MyWallets {
    Map<String, String> createNewWallet();
    BigDecimal getBalance();
    String getSeed();
}
