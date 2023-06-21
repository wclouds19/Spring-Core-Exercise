package bootcamp.spring.core.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import bootcamp.spring.core.client.PaymentGatewayClient;

@Component("paymentGatewayClient")
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient>{

    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndPoint("https://www.test.com");
        client.setPrivateKey("aabbccddee");
        client.setPublicKey("eeddccbbaa");
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
    
}
