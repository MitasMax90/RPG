/*
   Как вы помните, под звездочкой есть условие,
   что игрок может покупать зелье лечения.
   Чтобы его купить, нам нужен торговец.
*/

import com.sun.source.tree.BreakTree;

public class Vendor implements Seller {

    @Override
    public String sell(Goods goods) {
        String res = "";
        if (goods == Goods.POTION) {
            res = "potion";
        }
        return res;
    }

    public enum Goods {
        POTION;
    }

}
