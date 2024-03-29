package src.test.java.xux;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.main.java.xux.enums.BooleanEnum;

import java.math.BigDecimal;
import java.util.Locale;



public class PaymentAndSocketManagerXRPLTest {
    private PaymentManager paymentManager;
    private String classicAddress;
    private String privateKey;
    private String publicKey;
    private String xAddress;
    private String seed;

    private BigDecimal allBalanceBefore;
    private BigDecimal allBalanceAfter;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;


    @Before
    public void startPaymentManagerXRP() {
        // Обязательно стоит установить локаль иначе будет падать с ошибкой парсинга даты ******************************
        Locale.setDefault(Locale.ENGLISH);
    }

    @After
    public void stopPaymentManagerXRP() {

    }

    @Test
    public void createNewTestWalletReplenishItAndMakePayment() {
        // Создать новый тестовый кошелек, пополнить его и провести платеж *********************************************
        BooleanEnum.setValue(BooleanEnum.IS_REAL, false);
        BooleanEnum.setValue(BooleanEnum.IS_WALLET_TEST, false);

        createPaymentManager();
        initBeforePay();

        Assert.assertNotNull(allBalanceBefore);
        Assert.assertNotNull(classicAddress);
        Assert.assertNotNull(balanceBefore);
        Assert.assertNotNull(privateKey);
        Assert.assertNotNull(publicKey);
        Assert.assertNotNull(xAddress);
        Assert.assertNotNull(seed);

        Assert.assertNotEquals(seed, "Это не новый кошелек, у вас уже есть востановительная фраза");
        Assert.assertEquals(1, allBalanceBefore.compareTo(balanceBefore));

        printIIfoBefore();
        makePayment();
        initAfterPay();

        Assert.assertNotNull(allBalanceAfter);
        Assert.assertNotNull(balanceAfter);

        Assert.assertEquals(1, allBalanceBefore.compareTo(allBalanceAfter));
        Assert.assertEquals(1, allBalanceAfter.compareTo(balanceAfter));
        Assert.assertEquals(1, balanceBefore.compareTo(balanceAfter));

        printIIfoAfter();
        conclusionAboutPositiveResult();
    }

    @Test
    public void restoreTestWalletFromSeedPhraseAndMakePayment() {
        // Востановить из сид фразы тестовый кошелек и провести платеж *************************************************
        BooleanEnum.setValue(BooleanEnum.IS_REAL, false);
        BooleanEnum.setValue(BooleanEnum.IS_WALLET_TEST, true);

        Assert.assertNotEquals(StringEnum.SEED_TEST.getValue(), "");

        createPaymentManager();
        initBeforePay();

        Assert.assertNotNull(allBalanceBefore);
        Assert.assertNotNull(classicAddress);
        Assert.assertNotNull(balanceBefore);
        Assert.assertNotNull(privateKey);
        Assert.assertNotNull(publicKey);
        Assert.assertNotNull(xAddress);
        Assert.assertNotNull(seed);

        Assert.assertEquals(seed, "Это не новый кошелек, у вас уже есть востановительная фраза");
        Assert.assertEquals(1, allBalanceBefore.compareTo(balanceBefore));

        printIIfoBefore();
        makePayment();
        initAfterPay();

        Assert.assertNotNull(allBalanceAfter);
        Assert.assertNotNull(balanceAfter);

        Assert.assertEquals(1, allBalanceBefore.compareTo(allBalanceAfter));
        Assert.assertEquals(1, allBalanceAfter.compareTo(balanceAfter));
        Assert.assertEquals(1, balanceBefore.compareTo(balanceAfter));

        printIIfoAfter();
        conclusionAboutPositiveResult();
    }


    @Test
    public void createNewtWalletReplenishIt() {
        // Создать новый кошелек, пополнить его ************************************************************************
        BooleanEnum.setValue(BooleanEnum.IS_REAL, true);
        BooleanEnum.setValue(BooleanEnum.IS_WALLET, false);

        createPaymentManager();
        initBeforePay();

        Assert.assertNotNull(allBalanceBefore);
        Assert.assertNotNull(classicAddress);
        Assert.assertNotNull(balanceBefore);
        Assert.assertNotNull(privateKey);
        Assert.assertNotNull(publicKey);
        Assert.assertNotNull(xAddress);
        Assert.assertNotNull(seed);

        Assert.assertNotEquals(seed, "Это не новый кошелек, у вас уже есть востановительная фраза");
        Assert.assertEquals(0, allBalanceBefore.compareTo(balanceBefore));

        printIIfoBefore();
        printIIfoAfter();
        conclusionAboutPositiveResult();
    }

    @Test
    public void restoreWalletFromSeedPhraseAndMakePayment() {
        // Востановить из сид фразы реальный кошелек и провести платеж *************************************************
        BooleanEnum.setValue(BooleanEnum.IS_REAL, true);
        BooleanEnum.setValue(BooleanEnum.IS_WALLET_TEST, true);

        Assert.assertNotEquals(StringEnum.SEED_TEST.getValue(), "");

        createPaymentManager();
        initBeforePay();

        Assert.assertNotNull(allBalanceBefore);
        Assert.assertNotNull(classicAddress);
        Assert.assertNotNull(balanceBefore);
        Assert.assertNotNull(privateKey);
        Assert.assertNotNull(publicKey);
        Assert.assertNotNull(xAddress);
        Assert.assertNotNull(seed);

        Assert.assertEquals(seed, "Это не новый кошелек, у вас уже есть востановительная фраза");
        Assert.assertEquals(1, allBalanceBefore.compareTo(balanceBefore));

        printIIfoBefore();
        makePayment();
        initAfterPay();

        Assert.assertNotNull(allBalanceAfter);
        Assert.assertNotNull(balanceAfter);

        Assert.assertEquals(1, allBalanceAfter.compareTo(balanceAfter));
        Assert.assertEquals(1, balanceBefore.compareTo(balanceAfter));
        Assert.assertEquals(1, balanceBefore.compareTo(balanceAfter));

        printIIfoAfter();
        conclusionAboutPositiveResult();
    }

    private void createPaymentManager() {
        paymentManager = new PaymentAndSocketManagerXRPL();
    }

    private void initBeforePay() {
        classicAddress = paymentManager.getClassicAddress(BooleanEnum.IS_REAL.isB());
        privateKey = paymentManager.getPrivateKey(BooleanEnum.IS_REAL.isB());
        publicKey = paymentManager.getPublicKey(BooleanEnum.IS_REAL.isB());
        xAddress = paymentManager.getXAddress(BooleanEnum.IS_REAL.isB());
        seed = paymentManager.getSeed(BooleanEnum.IS_REAL.isB());

        allBalanceBefore = paymentManager.getAllBalance(BooleanEnum.IS_REAL.isB());
        balanceBefore = paymentManager.getBalance(BooleanEnum.IS_REAL.isB());
    }

    private void initAfterPay() {
        allBalanceAfter = paymentManager.getAllBalance(BooleanEnum.IS_REAL.isB());
        balanceAfter = paymentManager.getBalance(BooleanEnum.IS_REAL.isB());
    }

    private void makePayment() {
        paymentManager.sendPayment(BooleanEnum.IS_REAL.isB()
                        ? StringEnum.ADDRESS_FOR_SEND_REAL.getValue()
                        : StringEnum.ADDRESS_FOR_SEND_TEST.getValue(),
                777,
                BigDecimal.ONE,
                BooleanEnum.IS_REAL.isB());
    }

    private void printIIfoBefore() {
        System.out.println("*****************************************************************************************");
        System.out.println("Classic Address  -- >  " + classicAddress);
        System.out.println("Private Key  -- >  " + privateKey);
        System.out.println("Public Key  -- >  " + publicKey);
        System.out.println("X Address  -- >  " + xAddress);
        System.out.println("Seed  -- >  " + seed);
        System.out.println("*****************************************************************************************");
        System.out.println("All Balance Before -- >  " + allBalanceBefore);
        System.out.println("Balance Before -- >  " + balanceBefore);
        System.out.println("*****************************************************************************************");
    }

    private void printIIfoAfter() {
        System.out.println("*****************************************************************************************");
        System.out.println("All Balance After  -- >  " + allBalanceAfter);
        System.out.println("Balance After  -- >  " + balanceAfter);
        System.out.println("*****************************************************************************************");
    }

    private void conclusionAboutPositiveResult() {
        System.out.println("\n" + "\n"
                + "*********************************************" + "\n"
                + "*********************************************" + "\n"
                + "*******                               *******" + "\n"
                + "*******     TEST PASSED EXCELLENT     *******" + "\n"
                + "*******     ТЕСТ ПРОЙДЕН ОТЛИЧНО!     *******" + "\n"
                + "*******                               *******" + "\n"
                + "*********************************************" + "\n"
                + "*********************************************" + "\n"
                + "\n" + "\n");
    }
}
