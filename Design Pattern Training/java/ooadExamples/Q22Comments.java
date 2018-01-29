//Improve the code
class Account {
    ...
    //check if the password is complex enough, i.e.,
    //contains letter and digit/symbol.
    boolean isComplexPassword(String password){
        //found a digit or symbol?
        boolean dg_sym_found=false;
        //found a letter?
        boolean letter_found=false;
        for(int i=0; i<password.length(); i++){
            char c=password.charAt(i);
            if(Character.isLowerCase(c)||Character.isUpperCase(c))
                letter_found=true;
            else dg_sym_found=true;
        }
        return (letter_found) && (dg_sym_found);
    }
}