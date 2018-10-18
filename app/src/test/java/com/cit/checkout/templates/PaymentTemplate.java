package com.cit.checkout.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.cit.checkout.domain.Payment;
import com.cit.checkout.domain.PaymentType;

public class PaymentTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Payment.class)
                .addTemplate("mastercard", new Rule() {
                    {
                        add("type", PaymentType.CARD);
                        add("creditCard", "1234567898765432");
                    }
                })
                .addTemplate("billet", new Rule() {
                    {
                        add("type", PaymentType.BILLET);
                    }
                });
    }
}
