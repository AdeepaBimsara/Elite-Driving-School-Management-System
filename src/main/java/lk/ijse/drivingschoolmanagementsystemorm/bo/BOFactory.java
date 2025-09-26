package lk.ijse.drivingschoolmanagementsystemorm.bo;

import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public <H extends  SuperBO> H getBO(BOTypes boTypes){

        return switch (boTypes){
            case STUDENT -> (H) new StudentBOImpl();
            case COURSE -> (H) new CourseBOImpl();
            case INSTRUCTOR -> (H) new InstructorBOImpl();
            case LESSON -> (H) new LessonBOImpl();
            case PAYMENT -> (H) new PaymentBOImpl();
        };
    }



}
