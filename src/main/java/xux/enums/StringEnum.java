package src.main.java.xux.enums;



public enum StringEnum {
    ADDRESS_FOR_SEND_REAL("rEKeGo2SHjifCgP5nptSGfhfjytWJewqX"),

    SEED_REAL(""),
    ADDRESS_FOR_SUBSCRIBE_AND_MONITOR("rsG3xqRQSnxfYfF9foHfy7fNEZZctDc3Dx"),

    NET_REAL_GET_URL("https://data.ripple.com"),
    NET_REAL_POST_URL_ONE("https://s1.ripple.com:51234/"),
    NET_REAL_POST_URL_TWO("https://s2.ripple.com:51234/"),
    WSS_REAL("wss://xrplcluster.com"),

    FAUCET_CLIENT_HTTP_URL_TEST("https://faucet.altnet.rippletest.net"),
    ADDRESS_FOR_SEND_TEST("rPT1Sjq2YGrBMTttX4GZHjKu9dyfzbpAYe"),
    NET_TEST("https://s.altnet.rippletest.net:51234/"),
    WSS_TEST("wss://s.altnet.rippletest.net:51233"),
    SEED_TEST("sn3nxiW7v8KXzPzAqzyHXbSSKNuN9"),
    WSS_PORT_TEST("51233"),

    ACTIVATION_PAYMENT("10.000000"),

    WALLET_NOT_ACTIVATED("Wallet not activated.")
    ;

    private String value;

    StringEnum(String value) {
        this.value = value;
    }

    private void setValue(String value) {
        this.value = value;
    }
    public String getValue() { return value; }

    public static void setValue(StringEnum enums, String value) {
        for (StringEnum e : StringEnum.values()) {
            if (e.equals(enums)) {
                e.setValue(value);
                break;
            }
        }
    }
}