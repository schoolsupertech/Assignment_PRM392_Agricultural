package assignment.assignment_prm392.model;

import assignment.assignment_prm392.exception.ProductException;
import assignment.assignment_prm392.model.dto.ProductDTO;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDAO {
    public ArrayList<ProductDTO> getListProduct() {
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();

        try {
            //Reading data Object from Back4App
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Product");
            query.orderByAscending("name");
            List<ParseObject> parseObjects = query.find();
            if (parseObjects != null) {
                for (ParseObject object : parseObjects) {
                    productDTOS.add(new ProductDTO(object.getObjectId(), object.getString("name"),
                            object.getString("description"),
                            (Integer) Objects.requireNonNull(object.getNumber("number")),
                            Double.parseDouble(Objects.requireNonNull(object.getNumber("price")).toString())));
                }
            }
            else {
                throw new ProductException("Error Query ParseObject", new Throwable("An error occurred cause by parseObject is null"));
            }
        }
        catch (ParseException | ProductException e) {
            e.getMessage();
        }

        return productDTOS;
    }
}
