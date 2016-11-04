package mocks;

import monopoly.GameMaster;
import monopoly.TradeDeal;
import monopoly.TradeDialog;

public class MockTradeDialog implements TradeDialog {

    @Override
    public TradeDeal getTradeDeal() {
        TradeDeal deal = new TradeDeal();
        deal.setAmount(200);
        deal.setSeller(GameMaster.instance().getPlayer(0));
        deal.setPropertyName(GameMaster.instance().getGameBoard().getCell(1).toString());
        return deal;
    }
}