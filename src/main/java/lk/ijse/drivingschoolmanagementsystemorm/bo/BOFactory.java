package lk.ijse.drivingschoolmanagementsystemorm.bo;

import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public <H extends  SuperBO> H getBO(BOTypes boTypes){

        return switch (boTypes){
            case STUDENT -> (H) new StudentBOImpl();
        };
    }



}
