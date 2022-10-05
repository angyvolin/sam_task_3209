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
    SEED_TEST(""),
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
/*  Вывод:
                        Constructed Payment: Payment
                            {
                                account=rMCcNuTcajgw7YTgBy1sys3b89QqjUrMpH,
                                fee=10,
                                sequence=16449361,
                                lastLedgerSequence=20484790,
                                memos=[],
                                signers=[],
                                signingPublicKey=039543A0D3004CDA0904A09FB3710251C652D69EA338589279BC849D47A7B019A1,
                                flags=2147483648,
                                amount=1000000,
                                destination=rPT1Sjq2YGrBMTttX4GZHjKu9dyfzbpAYe,
                                paths=[]
                             }
*/

// Signed Payment: -->  Payment{
// account=rsG3xqRQSnxfYfF9foHfy7fNEZZctDc3Dx,
// fee=10,
// sequence=111,
// lastLedgerSequence=71315375,
// memos=[],
// signers=[],
// signingPublicKey=0214C42799BD528C17F7B1180036F43E26879461D0CD16520140C60E6FF8D8392A,
// transactionSignature=304402207BF80FE0C96A404F0C59C3B5296D14946EC2E1029FE7EAE1B4EAB8AD362BCB6902201B1917B19B30811349A343F084B686E000A48A31D49DD451341C21E4DC51C7A2,
// flags=2147483648,
// amount=1000000,
// destination=rEKeGo2SHjifCk8b1gP5nptSG9qbWJewqX,
// paths=[]}


// Prelim Result:  -- >  SubmitResult{
// status=success,
// result=tesSUCCESS,
// engineResultMessage=The transaction was applied. Only final in a validated ledger.,
// transactionBlob=1200002280000000240000006F201B04402FAF6140000000000F424068400000000000000A73210214C42799BD528C17F7B1180036F43E26879461D0CD16520140C60E6FF8D8392A7446304402207BF80FE0C96A404F0C59C3B5296D14946EC2E1029FE7EAE1B4EAB8AD362BCB6902201B1917B19B30811349A343F084B686E000A48A31D49DD451341C21E4DC51C7A2811418CD234D2BF34C903A91683E32EAD92A47FD083583149D185C9D28C1D86059F29C2C7B8ACAEFE433DE1B,
// transactionResult=TransactionResult{transaction=Payment{account=rsG3xqRQSnxfYfF9foHfy7fNEZZctDc3Dx,
// fee=10,
// sequence=111,
// lastLedgerSequence=71315375,
// memos=[],
// signers=[],
// signingPublicKey=0214C42799BD528C17F7B1180036F43E26879461D0CD16520140C60E6FF8D8392A,
// transactionSignature=304402207BF80FE0C96A404F0C59C3B5296D14946EC2E1029FE7EAE1B4EAB8AD362BCB6902201B1917B19B30811349A343F084B686E000A48A31D49DD451341C21E4DC51C7A2,
// hash=30209423224D5DB0F44AC08B5C8DB62D2B7A08CA8C19C98D91597D7B4F816F20,
// flags=2147483648,
// amount=1000000,
// destination=rEKeGo2SHjifCk8b1gP5nptSG9qbWJewqX,
// paths=[]},
// validated=false},
// accepted=true,
// accountSequenceAvailable=112,
// accountSequenceNext=112,
// applied=true,
// broadcast=true,
// kept=true,
// queued=false,
// openLedgerCost=10,
// validatedLedgerIndex=71315371}



