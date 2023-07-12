package assignment.assignment_prm392.model;

import assignment.assignment_prm392.exception.ProductException;
import assignment.assignment_prm392.model.dto.CartDTO;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    public ArrayList<CartDTO> getListProduct() {
        ArrayList<CartDTO> cartDTOS = new ArrayList<>();

        try {
            //Reading data Object from Back4App
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Cart");
            List<ParseObject> parseObjects = query.find();
            if (parseObjects != null) {
                for (ParseObject object : parseObjects) {
                    cartDTOS.add(new CartDTO(object.getObjectId(), object.getInt("totalProduct"), object.getDouble("totalPrice")));
                }
            }
            else {
                throw new ProductException("Error Query ParseObject", new Throwable("An error occurred cause by parseObject is null"));
            }
        }
        catch (ParseException | ProductException e) {
            e.getMessage();
        }

        return cartDTOS;
    }
}
