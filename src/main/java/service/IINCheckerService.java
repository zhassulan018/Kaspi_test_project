package service;

public class IINCheckerService {

    public static boolean checkIinCorrectness(String iin, String birthday, String sex){
        StringBuilder str = new StringBuilder();
        str.append(birthday.charAt(2)).append(birthday.charAt(3))
                .append(birthday.charAt(5)).append(birthday.charAt(6))
                .append(birthday.charAt(8)).append(birthday.charAt(9));

        if(!iin.startsWith(str.toString())) return false;

        int year = Integer.parseInt(birthday.substring(0,4));
        if(year < 2000){
            if((sex.equals("male") && (iin.charAt(6) -'0') != 3)){
                return false;
            }else if(sex.equals("female") && (iin.charAt(6) -'0') != 4){
                return false;
            }
        }else{
            if((sex.equals("male") && (iin.charAt(6) -'0') != 5)){
                return false;
            }else if(sex.equals("female") && (iin.charAt(6) -'0') != 6){
                return false;
            }
        }

        int sum = 0;
        for(int i = 0; i < 11; i++){
            sum += (iin.charAt(i) - '0') *(i+1);
        }

        if(sum % 11 != iin.charAt(11) -'0') return false;

        return true;
    }
}
