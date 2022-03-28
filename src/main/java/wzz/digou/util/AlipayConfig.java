package wzz.digou.util;

public class AlipayConfig {

    public static String app_id = "2016092000xxxxxxxx";//在后台获取（必须配置）

    public static String merchant_private_key = "/xxxxxxxxxxxxxxxxxxx+Rtt/DHN4rMBX1NUtS4mk7nipJt0V8OxRE0TC+My8icUEfNQpz+J8DlsmOn6YmEkQytqmv7Nwemj9pwtGnygyrD66aQr1LvMczgDLkwfCLwEfFfq9Cj0ayOG3AgMBAAECggEAM+GsY+k6bhHgn+MV5rOOeweUansBWWxNBeb7VwPoSs1sKt6pzIGGd3UIvKzbCCOTi22JcnXyan2ypOcSavNzocP8v7tUOwTOBQFegywCq7GwqPXrxDkPQHTutNLlpmR+e0MBPHmRATYKz8MAWsx6oNlTUxnacQx15shp/pdzdrODFkk4LpcLzEvLu8Hb0RV2Qprt739ymFPjUsAcC8LeoQCeym0MjpoeMFl7PmsQPgNluCkdDRxstwXU8BfabCWriY/8mpToGpmWZW5lkf7EU7cqFtQicCMX7vQd9ZAiVUfSKpLdeQHuFSTode24pRwE8McH7QtdqFdXLDOykQHFkQKBgQDzMGyIzjPkchpQ7aYicvIdDql2PzUbLTOl7LIpQNj9YXSj1Khki0GQhTLpQc9SyaF8qMX8IGrAAEnOiNo7jPSlCoLenrKG58Wex1NpIrTSjagrLEo61gOlbvWCM+fKJveonFD9m78jX/HbB+ZDP0Y2jimNScaj7X1yCaoIG4UiYwKBgQDFSs+0axXodqkxAasDpaYcSUlcz9PHg05k61RaZOSlCKYr+DDACpG93D/vMX+b/k17ob9rKyS6q9GvGyVjA9fZGzcpmaDn7gNPBiIfM/q0KeSRJO3F6+eiPPQlML8ZeHqBa+RyYzt2osGANMRnPSotdN5HTZrtd728uE1mhDZ5nQKBgGqI3iMYYjdDnS+yzELvJA2CrM42ZmdfZ+7aQDo+RFDL7rMOqC5TqwdKssDoqZBU8D+SGBmZgepWtf6aiS/pUgszDZ3E2+SpiDNEks/N+nT6xZ8UKfiYZMSGVVsSrgorA/eDcx+GqTcwAt23GjJ/d5zSrnVMyo5prbjVbv1aQPqNAoGAE442yEtVAJXCb3ka2mGw9VzOSMTQ2RXKz3YEBnG5uCIDVphjPKXPjGIodC0T2QJ766U8tAKywU4GmrS2H/phisOH1DfGGzccXNjeyPj+AJ2majye1N9tNkeUa5tJVdz7R5jKLAxp+HhpdavFS/ZkF91dqvOmR6N2yx35jg/M1oECgYEA0GcxCW1UQpu4WPS7eydBWDjWDDaavvr3hRIdRcQMdCmHzFUFbi8CYz8rFY0/NnIXuP71uS/95dK1coHvt/kBbSxasPsDn5iSpn9o36emNa71oWKKX2/fPKF7CYCRt875FGKsTdOiS62SA3MMtkTV9G5ViDkZR1glOi8G3h943TY=";//教程查看获取方式（必须配置）

    public static String alipay_public_key = "5A8zcYVmxxxxxxxxxxxxxxxpYKGnaoJtW2Juny/XVMTPvUl0UdWwepqrR/9x4VDJ7H53vDTANSoGpT9NjHQ58ZQUxKYqWDd9g1I46My7d9dvRKV536rcY+TZYQ+boYaf5NhJS/1OR2Hi6No/y7O7+ycbtZFxG4Yb9re/xzRuZy2+Jr8B+KvkbbfwxzeKzAV9TVLUuJpO54qSbdFfDsURNEwvjMvInFBHzUKc/ifA5bJjp+mJhJEMrapr+zcHpo/acLRp8oMqw+umkK9S7zHM4Ay5MHwi8BHxX6vQo9GsjhtwIDAQAB";//教程查看获取方式（必须配置）

    public static String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice.action";

    public static String return_url = "http://localhost:8080/forepayed";

    public static String sign_type = "RSA2";

    public static String charset = "utf-8";

    public static String gatewayUrl = "http://openapi.alipaydev.com/gateway.do";//注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do
}
