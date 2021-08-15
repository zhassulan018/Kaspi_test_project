package utility;

public class DataValidation {
    public static boolean isNull(String str){
        if(str == null || str.trim().length() == 0){
            return true;
        }else {
            return false;
        }
    }
}
