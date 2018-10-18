package com.cit.checkout.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.cit.checkout.domain.Purchase;
import com.cit.checkout.domain.ShoppingCart;

public class ShoppingCartTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(ShoppingCart.class)
                .addTemplate("shopping cart with one item", new Rule() {
                    {
                        add("username", "carlosz");
                        add("items", has(1).of(Purchase.class, "purchase product 1"));
                    }
                })
                .addTemplate("shopping cart with no item", new Rule() {
                    {
                        add("username", "carlosz");
                        add("items", has(0).of(Purchase.class, "purchase product 1"));
                    }
                })
                .addTemplate("shopping cart with null item", new Rule() {
                    {
                        add("username", "carlosz");
                    }
                })
                .addTemplate("shopping cart with two items", new Rule() {
                    {
                        add("username", "carlosz");
                        add("items", has(2).of(Purchase.class,
                                "purchase product 1", "purchase product 2"));
                    }
                });
    }
}
