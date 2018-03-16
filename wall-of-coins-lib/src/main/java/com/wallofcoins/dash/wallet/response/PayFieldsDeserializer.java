package com.wallofcoins.dash.wallet.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import com.wallofcoins.dash.wallet.response.GetReceivingOptionsResp.JsonPayFieldsBeanX;
import com.wallofcoins.dash.wallet.response.GetReceivingOptionsResp.PayFieldsBeanX;

public class PayFieldsDeserializer implements JsonDeserializer<PayFieldsBeanX> {

    private static final String TAG = PayFieldsDeserializer.class.getSimpleName();

    @Override
    public PayFieldsBeanX deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (jsonElement.isJsonPrimitive()) {
            PayFieldsBeanX payFieldsBeanX = new PayFieldsBeanX();
            payFieldsBeanX.payFieldsB = jsonElement.getAsBoolean();
            return payFieldsBeanX;
        }

        return context.deserialize(jsonElement, JsonPayFieldsBeanX.class);
    }
}
