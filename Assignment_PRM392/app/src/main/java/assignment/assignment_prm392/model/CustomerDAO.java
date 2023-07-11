package assignment.assignment_prm392.model;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import assignment.assignment_prm392.model.dto.CustomerDTO;


public class CustomerDAO {
    public boolean checkLogin(String email, String password){
        boolean flag = false;

        try {
            //Reading data Object from Back4App
            ParseQuery<ParseUser> query = ParseQuery.getQuery("User");

            query.whereEqualTo("email", email);
            query.whereEqualTo("password", password);

            ParseUser user = (ParseUser) query.getFirst();
            Log.d("Info", user.toString());
//                // Đăng nhập thành công
            flag = true;
        } catch (ParseException e) {
            flag = false;
            System.out.printf("Loi neeee: %d" ,e.toString());
//                // Đăng nhập thất bại hoặc xảy ra lỗi
        }

            return flag;
        }
        public CustomerDTO findUserByEmail(String email){
            ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
            query.whereEqualTo("email", email);

            CustomerDTO customerDTO = new CustomerDTO();
            try {
                ParseUser user = (ParseUser) query.getFirst();
                customerDTO.setEmail(user.getString("email"));
                customerDTO.setAddress(user.getString("address"));
                customerDTO.setId(user.getString("objectId"));
                customerDTO.setRole(user.getString("role"));
                customerDTO.setPassword(user.getString("password"));
                customerDTO.setFullName(user.getString("fullname"));
                customerDTO.setPhone(user.getString("phone"));
                customerDTO.setGender(user.getString("gender"));
                return customerDTO;

            } catch (ParseException e) {
                // Đăng nhập thất bại hoặc xảy ra lỗi
                return null;
            }
            // trả về user
        }
    }


