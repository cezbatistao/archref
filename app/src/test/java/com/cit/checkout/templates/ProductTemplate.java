package com.cit.checkout.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.cit.checkout.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Product.class)
                .addTemplate("moto x 4", new Rule() {
                    {
                        add("id", UUID.fromString("2833dc40-b5c4-11e8-96f8-529269fb1459"));
                        add("name", "Moto X 4º");
                        add("value", new BigDecimal("999.99"));
                    }
                })
                .addTemplate("cellphone case moto x 4", new Rule() {
                    {
                        add("id", UUID.fromString("4a12bd2c-b5c4-11e8-96f8-529269fb1459"));
                        add("name", "Capa Moto X4");
                        add("value", new BigDecimal("10.90"));
                    }
                });
    }
}
