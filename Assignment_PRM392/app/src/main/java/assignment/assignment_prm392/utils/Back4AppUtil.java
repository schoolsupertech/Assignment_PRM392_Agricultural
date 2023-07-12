package assignment.assignment_prm392.utils;

import android.util.Log;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class Back4AppUtil {
    public static class Init {
        public static void initCustomer() {
            // Init class for Back4App
            ParseUser user = new ParseUser();
            user.setUsername("Alex");
            user.setEmail("alexboy@gmail.com");
            user.setPassword("123");
            user.saveInBackground(e -> {
                if(e != null) {
                    Log.d("ERROR", e.getMessage());
                }
                else {
                    Log.d("Info", "Init object \"Customer\" saved");
                }
            });
        }

        public static void initProduct() {
            // Init class for Back4App
            ParseObject product = new ParseObject("Product");
            product.put("name", "Carrot");
            product.put("description", "Vegetable for rabbit");
            product.put("number", 1399);
            product.put("price", 27);
            product.saveInBackground(e -> {
                if(e != null) {
                    Log.d("ERROR", e.getMessage());
                }
                else {
                    Log.d("Info", "Init object \"Product\" saved");
                }
            });
        }

        public static void initOrder() {
            // Init class for Back4App
            ParseObject order = new ParseObject("Order");
            order.put("amount", 2);
            order.put("totalPrice", 78.100);
            order.put("orderAddress", "456 Oak Street, Apartment 7B, Anytown C, Stateville ST 12345, United States");
            order.saveInBackground(e -> {
                if(e != null) {
                    Log.d("ERROR", e.getMessage());
                }
                else {
                    Log.d("Info", "Init object \"Order\" saved");
                }
            });
        }

        public static void initCart() {
            // Init class for Back4App
            ParseObject cart = new ParseObject("Cart");
            cart.put("totalProduct", 3);
            cart.put("totalPrice", 99000);
            cart.saveInBackground(e -> {
                if(e != null) {
                    Log.d("ERROR", e.getMessage());
                }
                else {
                    Log.d("Info", "Init object \"Cart\" saved");
                }
            });
        }

        public static void initStatus() {
            ParseObject status = new ParseObject("Status");
            status.put("name", "Ordering");
            status.put("name", "Ordered");
            status.put("name", "Paid");
            status.put("name", "UnPaid");
            status.saveInBackground(e -> {
                if(e != null) {
                    Log.d("ERROR", e.getMessage());
                }
                else {
                    Log.d("Info", "Init object \"Status\" saved");
                }
            });
        }

        public static void initPayment() {
            ParseObject payment = new ParseObject("Payment");
            payment.put("totalPrice", 78.100);
            payment.saveInBackground(e -> {
                if(e != null) {
                    Log.d("ERROR", e.getMessage());
                }
                else {
                    Log.d("Info", "Init object \"Payment\" saved");
                }
            });
        }
    }
}
