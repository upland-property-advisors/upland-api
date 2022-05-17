package api.upland.me.fetcher;

import api.upland.me.UplandApi;
import api.upland.me.world.UplandProperty;
import com.google.gson.JsonObject;

public final class PropertyApiFetcher extends UplandApiFetcher<UplandProperty> {
    public PropertyApiFetcher(UplandApi api) {
        super(api, "https://api.upland.me/properties/81402400702690");
    }

    @Override
    public UplandProperty handle(JsonObject object) {
       // {"prop_id":81402400702690,"full_address":"3271 44TH ST","centerlat":"40.755599077597886","centerlng":"-73.916994795558679","boundaries":"{\"type\":\"Polygon\",\"coordinates\":[[[-73.916812910607248,40.755557147870853],[-73.917127290071846,40.755701789199925],[-73.917176680672256,40.755641008043938],[-73.916862302598375,40.755496366013013],[-73.916812910607248,40.755557147870853]]]}","area":29,"status":"Owned","locked_until":null,"locked_user_id":null,"transaction_id":"82d92db5cea8b41776512aee4ddcfe995afde536f473e6a569210e3cadd7dde4","last_transaction_id":"1bd715d4a84d91bcc5b7021472eac07958d8eaab2ebd2b8d9b7a17da1a3f5c08","last_purchased_price":17550,"terminal_id":null,"feature":null,"labels":{"fsa_allow":false},"on_market":null,"offers_made_by_you":null,"offers_with_property":null,"offers_to_property":null,"fiat_price":null,"is_offering":false,"is_blocked":false,"owner":"dqaiankghiqu","owner_username":"unruly_cj","yield_per_hour":0.34688639724627124,"price":17550,"can_make_offer":true,"collection_boost":1,"street":{"id":56641,"name":"44TH"},"city":{"id":4,"name":"Queens"},"teleport_price":40,"buyer_transaction_fee":0.05,"seller_transaction_fee":0.05,"is_construction_forbidden":false,"ownership_changed_at":"2022-05-17T09:08:00.463Z","building":null,"is_owner_in_jail":false,"state":{"id":2,"name":"NY"}}
        return null;
    }
}
