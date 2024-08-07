package com.cpa.ehr.util;

import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
import com.google.gson.Gson;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

public class PaymentServer {
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		port(4242);
		// This is a sample test API key. Sign in to see examples pre-filled with your
		// key.
		Stripe.apiKey = "price_1I2bapFtve7dlO7OsbnfyMIW";
//		staticFiles.externalLocation(Paths.get("").toAbsolutePath().toString());
		post("/create-checkout-session", (request, response) -> {
			response.type("application/json");
			
			String YOUR_DOMAIN = "https://54.162.55.186:8443/ehr/#/";
			
			SessionCreateParams params = SessionCreateParams.builder()
					.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
					.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(YOUR_DOMAIN + "/success")
					.setCancelUrl(YOUR_DOMAIN + "/cancel")
					.addLineItem(SessionCreateParams.LineItem
							.builder().setQuantity(
									1L)
							.setPriceData(SessionCreateParams.LineItem.PriceData.builder().setCurrency("usd")
									.setUnitAmount(2000L)
									.setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
											.setName("Stubborn Attachments").build())
									.build())
							.build())
					.build();
			Session session = Session.create(params);
			HashMap<String, String> responseData = new HashMap<String, String>();
			responseData.put("id", session.getId());
			return gson.toJson(responseData);
		});
	}
}
