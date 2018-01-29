//Improve the code
class Order {
    ...
    boolean IsSameString(String s1, String s2){
        if(s1==s2) return true;
        if(s1==null) return false;
        return(s1.equals(s2));
    }
}
class Mail {
    ...
    static boolean IsSameString(String s1, String s2) {
        if (s1 == s2)
            return true;
        if (s1 == null)
            return false;
        return (s1.equals(s2));
    }
}