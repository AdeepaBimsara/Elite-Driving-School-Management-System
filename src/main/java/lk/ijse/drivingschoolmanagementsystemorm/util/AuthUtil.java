package lk.ijse.drivingschoolmanagementsystemorm.util;

import lk.ijse.drivingschoolmanagementsystemorm.dto.Roles;
import lk.ijse.drivingschoolmanagementsystemorm.dto.UserDTO;

public class AuthUtil {
    private static UserDTO userDTO;


    public static void setUserDTO(UserDTO userDTO) {
        AuthUtil.userDTO = userDTO;
    }

    public static UserDTO getUserDTO() {
        return userDTO;
    }

    public static boolean isAdmin(){

        if (userDTO != null){
            return userDTO.getRole().equals(Roles.ADMIN);

        }
        return false;
    }
}
